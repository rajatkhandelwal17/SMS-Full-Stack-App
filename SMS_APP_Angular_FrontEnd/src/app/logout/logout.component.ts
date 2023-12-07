import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-logout',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './logout.component.html',
  styleUrl: './logout.component.css'
})
export class LogoutComponent {
  constructor(private r: Router, private service:UserService) {
    this.logout();
  }

  logout() {
    this.service.isUserLoggedIn = false
    this.service.logout()
    this.r.navigate(['/login']);
  }

}
