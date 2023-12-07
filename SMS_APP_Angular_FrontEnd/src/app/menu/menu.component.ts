import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { RouterOutlet } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [ CommonModule, RouterModule, RouterOutlet],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {

  constructor(public service: UserService) {}

  @Output() linkClicked = new EventEmitter<void>();
}