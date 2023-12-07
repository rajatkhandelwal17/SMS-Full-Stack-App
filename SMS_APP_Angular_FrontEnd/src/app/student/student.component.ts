import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Student } from '../../model/Student';
import { SortComponent } from '../sort/sort.component';
import { StudentUpdateComponent } from '../student-update/student-update.component';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule,MatDialog} from '@angular/material/dialog';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { StudentService } from '../service/student.service';
import { StudentRestService } from '../service/student-rest.service';

  @Component({
    selector: 'app-student',
    standalone: true,
    imports: [CommonModule,SortComponent, StudentUpdateComponent, MatButtonModule, MatDialogModule],
    templateUrl: './student.component.html',
    styleUrl: './student.component.css'
  })
  class StudentComponent {
    students:Student[] = [];
    message:string=''
    colorClass:string=''

    selectedStudent!:Student
    isUpdateFormVisible:boolean = false
    
    constructor(private service:StudentRestService, private d: MatDialog){
      this.showStudent();
    }

    showStudent(){
      this.service.findAllStudents().subscribe(
        response => this.students = response
      )
    }
    
    deleteStudent(rollNo:number){
      let dref =  this.d.open(ConfirmDialogComponent, {
        data: { rollNo : rollNo }
      })
      dref.afterClosed().subscribe(
        response => {
          console.log(response)
          this.service.deleteByRollNo(response).subscribe(
            success=>this.showStudent()

          )
        }
      )
    }

  //   deleteStudent(rollno:number){
  //     const result = confirm('Do you want to delete student with roll number '+ rollno);
  //     if(result){
  //     this.service.deleteByRollNo(rollno).subscribe(
  //     Response=>{
  //       this.students=this.students.filter(s => s.rollno != rollno);
  //       this.message = 'Record Deleted!!'
  //       this.colorClass = 'success'
  //   })
  // }
  //     else{
  //       this.message = 'Deletion Cancelled'
  //       this.colorClass = 'error'
  //     }
  //   }
    
    updateStudent(s: Student){
      this.d.open(StudentUpdateComponent, {
        data: { s : s }
      })
    }

  doUpdate(updatedStudent:Student){
      // Map is built in function of JavaScript that transform every element of the array which is exactly similiar to lambda function abd return new array.

      let mofifiedStudent = this.students.map(s=>{
        if(s.rollno == updatedStudent.rollno){
          return {...s,numberOfAttempts:updatedStudent.numberOfAttempts} 
        }
        else return s
      })
      this.students = mofifiedStudent
      this.isUpdateFormVisible = false;
    }
  
  sortStudents(criteria: string) {
    switch (criteria) {
      case 'percentage':
        this.students.sort((a, b) => b.percentage - a.percentage);
        break;
      case 'attempts':
        this.students.sort((a, b) => a.numberOfAttempts - b.numberOfAttempts);
        break;
      case 'subjects':
        this.students.sort((a, b) => b.subjectsLearning.length - a.subjectsLearning.length);
        break;
      default:
        break;
    }
  }
}

export default StudentComponent;