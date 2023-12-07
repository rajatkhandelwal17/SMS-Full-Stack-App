import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  isUserLoggedIn: boolean = false;
  message: string = '';
  
  readonly BASE_URL='http://localhost:8080/api/user'
  constructor(private http:HttpClient) {
    this.isValidSession()
  }

  performLogin(username: string, password: string): Observable<any> {
    const user = { username, password };

    return this.http.post<any>(`${this.BASE_URL}/login`, user).pipe(
      tap((resultData)=>{
        if (resultData.message === 'Login Success') {
          this.isUserLoggedIn = true;
        }

      }),
      catchError((error)=>{
        console.error('Error during login',error);
        throw error;
      })
    );
  }
  
  // Following methods are for maintaining the session of the user

  public createSessionAndStoreValue(username: string, isUserLoggedIn: boolean){
    sessionStorage.setItem('isUserLoggedIn', isUserLoggedIn + '')
    sessionStorage.setItem('username', username)
  }

  // public isValidSession(){
  //   let username = sessionStorage.getItem('isUserLoggedIn')
  //   if (username == 'guest'){
  //     this.isUserLoggedIn = false
  //   }
  //   else {
  //     this.isUserLoggedIn = true
  //   }
  // }

  public isValidSession(){
    let isUserLoggedIn = sessionStorage.getItem('isUserLoggedIn');
    if(isUserLoggedIn && isUserLoggedIn == 'true'){
      this.isUserLoggedIn = true;
    } else {
      this.isUserLoggedIn = false;
    }
  }

  public logout(){
    sessionStorage.removeItem('username')
    sessionStorage.removeItem('isUserLoggedIn')
  }

  // isUserLoggedIn:boolean =false;
  // message:string='';

  // constructor() {}
  // performlogin(username:string,password:string){
  //   if(username=='admin' && password=='admin'){
  //       this.isUserLoggedIn = true;
  //   }
  //   else{
  //       this.isUserLoggedIn = false;
  //   }
  //   return this.isUserLoggedIn;
  
  // }
}