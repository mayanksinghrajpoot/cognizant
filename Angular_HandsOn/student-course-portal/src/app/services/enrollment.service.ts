import { Injectable } from '@angular/core';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root',
})
export class EnrollmentService {
  private enrolledCourseIds: number[] = [];

  constructor(private courseService: CourseService) {
    // Sync initial enrollments from CourseService
    this.courseService.getCourses().forEach(c => {
      if (c.enrolled) {
        this.enrolledCourseIds.push(c.id);
      }
    });
  }

  enroll(courseId: number): void {
    if (!this.isEnrolled(courseId)) {
      this.enrolledCourseIds.push(courseId);
      const course = this.courseService.getCourseById(courseId);
      if (course) {
        course.enrolled = true;
      }
    }
  }

  unenroll(courseId: number): void {
    this.enrolledCourseIds = this.enrolledCourseIds.filter(id => id !== courseId);
    const course = this.courseService.getCourseById(courseId);
    if (course) {
      course.enrolled = false;
    }
  }

  isEnrolled(courseId: number): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCourses(): Course[] {
    return this.enrolledCourseIds
      .map(id => this.courseService.getCourseById(id))
      .filter((c): c is Course => c !== undefined);
  }
}

