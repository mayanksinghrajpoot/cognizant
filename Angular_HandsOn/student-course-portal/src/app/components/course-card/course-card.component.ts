import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Highlight } from '../../directives/highlight.directive';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';
import { EnrollmentService } from '../../services/enrollment.service';
import { Store } from '@ngrx/store';
import { toggleEnrollment } from '../../store/course.actions';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, Highlight, CreditLabelPipe],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css',
})
export class CourseCard implements OnChanges {
  @Input() course!: { id: number; name: string; code: string; credits: number; gradeStatus?: string; enrolled?: boolean };
  @Output() enrollRequested = new EventEmitter<number>();
  @Output() cardClicked = new EventEmitter<number>();

  isExpanded = false;

  constructor(
    private enrollmentService: EnrollmentService,
    private store: Store
  ) {}

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      const prevValue = changes['course'].previousValue;
      const currentValue = changes['course'].currentValue;
      console.log('Course input changed:', {
        previous: prevValue,
        current: currentValue
      });
      // Sync initial enrollment status to EnrollmentService if the input course property is set to enrolled
      if (this.course && this.course.enrolled) {
        this.enrollmentService.enroll(this.course.id);
      }
    }
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  isEnrolled(): boolean {
    return this.enrollmentService.isEnrolled(this.course.id);
  }

  onEnrollToggle(): void {
    if (this.isEnrolled()) {
      this.enrollmentService.unenroll(this.course.id);
    } else {
      this.enrollmentService.enroll(this.course.id);
    }
    this.store.dispatch(toggleEnrollment({ courseId: this.course.id }));
    this.enrollRequested.emit(this.course.id);
  }

  get cardClasses(): { [key: string]: boolean | undefined } {
    return {
      'card--enrolled': this.isEnrolled(),
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

