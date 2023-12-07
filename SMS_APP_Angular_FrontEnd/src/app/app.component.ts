import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import HeaderComponent from './header/header.component';
import FooterComponent from './footer/footer.component';
import StudentComponent from './student/student.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { RegisterComponent } from './register/register.component';
import { ContactusComponent } from './contactus/contactus.component';
import { SortComponent } from './sort/sort.component';
import { MenuComponent } from './menu/menu.component';
import { MatToolbarModule} from '@angular/material/toolbar'
import { MatIconModule } from '@angular/material/icon';
import { MatSidenav, MatSidenavModule } from '@angular/material/sidenav';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, HeaderComponent, FooterComponent, StudentComponent,
    LoginComponent, FormsModule, HomeComponent,AboutusComponent,RegisterComponent,
  ContactusComponent,SortComponent, MenuComponent, MatToolbarModule, MatIconModule, MatSidenavModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'helloWorld';
  @ViewChild('s') sidenav!: MatSidenav;;

  toggleSidebar() {
    this.sidenav.toggle();
  }
}
