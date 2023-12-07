import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatRadioModule } from '@angular/material/radio';

@Component({
  selector: 'app-sort',
  standalone: true,
  imports: [CommonModule, MatButtonModule, MatRadioModule],
  templateUrl: './sort.component.html',
  styleUrl: './sort.component.css'
})
export class SortComponent {
  @Output() sortSelected = new EventEmitter<string>();

  onSortChange(criteria: string) {
    this.sortSelected.emit(criteria);
  }
}
