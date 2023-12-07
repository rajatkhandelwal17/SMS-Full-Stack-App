import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { Student } from '../../model/Student';
import { StudentService } from '../service/student.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  registrationForm: FormGroup;
  registrationSuccess: boolean = false;
  
  resetForm() {
    this.registrationForm.reset({
      name: '',
      percentage: null,
      numberOfAttempts: null,
      subjectsLearning: '',
      dateOfBirth: '',
      username: '',
      password: ''
    });
  }
  
  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.registrationForm = this.fb.group({

      name: ['', Validators.required],
      percentage: [null, [Validators.required, Validators.min(0), Validators.max(100)]],
      numberOfAttempts: [null, Validators.required],
      subjectsLearning: [['']],
      dateOfBirth: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
      const formData = this.registrationForm.value;
      formData['userCredentials'] = {
        'username':formData.username,
        'password':formData.password
      }
      formData['subjectsLearning'] = formData.subjectsLearning.toString().split(',')

      this.http.post<any>('http://localhost:8080/api/student', formData).subscribe(
        (response) => {
          this.resetForm(); 
          this.registrationSuccess = true;
        },
        (error) => {
          this.registrationSuccess = false;
        }
      );
    }
}
