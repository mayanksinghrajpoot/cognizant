import { Injectable } from '@angular/core';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private courses: Course[] = [
    { id: 1, name: 'Introduction to Angular', code: 'CS101', credits: 3, gradeStatus: 'passed', enrolled: false },
    { id: 2, name: 'Advanced TypeScript', code: 'CS102', credits: 4, gradeStatus: 'pending', enrolled: false },
    { id: 3, name: 'Web Development Basics', code: 'CS103', credits: 2, gradeStatus: 'passed', enrolled: true },
    { id: 4, name: 'Enterprise Architecture', code: 'CS104', credits: 4, gradeStatus: 'failed', enrolled: false },
    { id: 5, name: 'Database Management Systems', code: 'CS105', credits: 3, gradeStatus: 'pending', enrolled: true }
  ];

  getCourses(): Course[] {
    return this.courses;
  }

  getCourseById(id: number): Course | undefined {
    return this.courses.find(c => c.id === id);
  }

  addCourse(course: Course): void {
    this.courses.push(course);
  }
}

