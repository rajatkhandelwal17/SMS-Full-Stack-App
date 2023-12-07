import { Injectable } from '@angular/core';
import { Student } from '../../model/Student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  students:Student[] = [];
  constructor() { 
      let s1 = new Student(1,"Amit",2,80,["Java","Python"]);
      let s2 = new Student(2,"Sumit",5,63,["C#","Python"]);
      let s3 = new Student(3,"Virat",1,99,["Block Chain","C++"]);
      let s4 = new Student(4,"Rahul",2,95,["Java","Python"]);
      let s5 = new Student(5,"Hardik",4,89,["Java","Python","IoT"]);

      this.students.push(s1);
      this.students.push(s2);
      this.students.push(s3);
      this.students.push(s4);
      this.students.push(s5);
  }
  findAllStudents(){
    return this.students;
  }
}
