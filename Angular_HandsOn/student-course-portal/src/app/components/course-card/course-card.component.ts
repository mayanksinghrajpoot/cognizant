import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Highlight } from '../../directives/highlight.directive';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, Highlight, CreditLabelPipe],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css',
})
export class CourseCard implements OnChanges {
  @Input() course!: { id: number; name: string; code: string; credits: number; gradeStatus?: string; enrolled?: boolean };
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      const prevValue = changes['course'].previousValue;
      const currentValue = changes['course'].currentValue;
      console.log('Course input changed:', {
        previous: prevValue,
        current: currentValue
      });
    }
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  // cardClasses getter:
  // Using getters keeps templates clean and readable. Instead of writing complex conditional objects
  // directly in HTML (e.g. [ngClass]="{ 'card--enrolled': course.enrolled, ... }"), we encapsulate
  // this logic inside the TypeScript class, making the template simpler and easier to maintain.
  get cardClasses(): { [key: string]: boolean | undefined } {
    return {
      'card--enrolled': this.course.enrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  getBorderColor(): string {
    switch (this.course.gradeStatus) {
      case 'passed': return 'green';
      case 'failed': return 'red';
      case 'pending':
      default: return 'grey';
    }
  }
}

