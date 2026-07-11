import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../services/course.service';
import { EnrollmentService } from '../../services/enrollment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [FormsModule, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class Home implements OnInit, OnDestroy {
  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  searchTerm = '';

  constructor(
    private courseService: CourseService,
    private enrollmentService: EnrollmentService,
    private router: Router
  ) {}

  get coursesCount(): number {
    return this.courseService.getCourses().length;
  }

  get enrolledCount(): number {
    return this.enrollmentService.getEnrolledCourses().length;
  }

  onSearch(): void {
    if (this.searchTerm.trim()) {
      this.router.navigate(['/courses'], { queryParams: { search: this.searchTerm } });
    }
  }




  // Difference between [property] and [(ngModel)]:
  // - [property] is one-way data binding: it flows from the component (TypeScript) to the DOM (HTML).
  // - [(ngModel)] is two-way data binding: updates in the DOM (e.g. typing in an input) update the component property,
  //   and changes in the component property also update the DOM.

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }

  ngOnInit(): void {
    console.log('HomeComponent initialised — courses loaded');
  }

  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }
}

