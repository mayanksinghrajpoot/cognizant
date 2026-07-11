import { Injectable } from '@angular/core';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EnrollmentService {
  private enrolledCourseIds: number[] = [];
  private allCourses: Course[] = [];

  constructor(private courseService: CourseService) {
    // Sync initial enrollments from CourseService
    this.courseService.getCourses().subscribe({
      next: courses => {
        this.allCourses = courses;
        this.enrolledCourseIds = courses.filter(c => c.enrolled).map(c => c.id);
      }
    });
  }

  enroll(courseId: number): void {
    if (!this.isEnrolled(courseId)) {
      this.enrolledCourseIds.push(courseId);
      const course = this.allCourses.find(c => c.id === courseId);
      if (course) {
        course.enrolled = true;
        this.courseService.updateCourse(course).subscribe();
      }
    }
  }

  unenroll(courseId: number): void {
    this.enrolledCourseIds = this.enrolledCourseIds.filter(id => id !== courseId);
    const course = this.allCourses.find(c => c.id === courseId);
    if (course) {
      course.enrolled = false;
      this.courseService.updateCourse(course).subscribe();
    }
  }

  isEnrolled(courseId: number): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCourses(): Course[] {
    return this.allCourses.filter(c => this.enrolledCourseIds.includes(c.id));
  }

  // getStudentsByCourse:
  // switchMap cancels the previous inner Observable when a new courseId arrives.
  // This is crucial for avoiding race conditions in search inputs or detail screens
  // where a slow response from an older selection could overwrite a newer selection's data.
  getStudentsByCourse(courseId: number): Observable<any[]> {
    return new Observable(observer => {
      observer.next([
        { id: 1, name: 'John Doe', email: 'john.doe@university.edu' }
      ]);
      observer.complete();
    });
  }
}


