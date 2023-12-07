import { Component, EventEmitter, Input, Output, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Student } from '../../model/Student';
import { FormsModule } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-student-update',
  standalone: true,
  imports: [CommonModule, FormsModule, MatFormFieldModule, MatButtonModule],
  templateUrl: './student-update.component.html',
  styleUrl: './student-update.component.css'
})
export class StudentUpdateComponent {

  constructor(public dialogRef: MatDialogRef<StudentUpdateComponent>, @Inject(MAT_DIALOG_DATA) public data: { s: Student }, private http: HttpClient
  ) {}

  onUpdateClick(): void {
    this.data.s.subjectsLearning = this.data.s.subjectsLearning.toString().split(',')
    const updateUrl = `http://localhost:8080/api/student/${this.data.s.rollno}`;

    this.http.put(updateUrl, this.data.s)
      .subscribe(response => {
        console.log('Update successful', response);
        this.dialogRef.close();
      }, error => {
        console.error('Update failed', error);
      });
  }

  onCancelClick(): void {
    this.dialogRef.close();
  }

}