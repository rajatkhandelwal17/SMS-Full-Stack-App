import { Routes } from '@angular/router';
import StudentComponent from './student/student.component';
import { LoginComponent } from './login/login.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { HomeComponent } from './home/home.component';
import { authGuard } from './auth.guard';

export const routes: Routes = [
    {path:'students',component:StudentComponent, canActivate:[authGuard]},
    {path:'login',component:LoginComponent},
    {path:'home',component:HomeComponent},
    {path:'aboutus',component:AboutusComponent},
    {path:'contactus', component:ContactusComponent},
    {path:'register', component:RegisterComponent},
    {path:'logout',component:LogoutComponent}
];