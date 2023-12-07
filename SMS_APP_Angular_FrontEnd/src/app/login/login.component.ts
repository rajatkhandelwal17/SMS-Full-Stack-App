import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, MatFormFieldModule, MatInputModule, MatButtonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username:string='';
  password:string='';
  errorMessage:string='';
  constructor(private user:UserService,private r:Router){}

performlogin() {
  
  this.user.performLogin(this.username, this.password).subscribe((resultData : any)=>{
    if(resultData.message == "Username Doesn't Exist"){
      alert("Username doesnot exist");
    } 
    else if(resultData.message=="Login Success"){
      this.user.createSessionAndStoreValue(this.username, true)
      this.r.navigateByUrl('/students');
    }
    else{
      alert("Incorrect Username and Password not match")
      this.user.createSessionAndStoreValue('guest', false)
    }
  })
  }
}