import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogModule, MatDialog } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { StudentRestService } from '../service/student-rest.service';

@Component({
  selector: 'app-confirm-dialog',
  standalone: true,
  imports: [CommonModule, MatDialogModule, MatButtonModule],
  templateUrl: './confirm-dialog.component.html',
  styleUrl: './confirm-dialog.component.css'
})
export class ConfirmDialogComponent {
  rno:number;

  constructor(public dialogRef: MatDialogRef<ConfirmDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: { rollNo: number }, private service: StudentRestService) {
    this.rno = data.rollNo;
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onYesClick(rollNo:number): void {
    this.service.deleteByRollNo(rollNo).subscribe(
    )
    this.dialogRef.close();
  }
}