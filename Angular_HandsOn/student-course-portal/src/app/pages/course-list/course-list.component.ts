import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card.component';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css',
})
export class CourseList {
  courses = [
    { id: 1, name: 'Introduction to Angular', code: 'CS101', credits: 3 },
    { id: 2, name: 'Advanced TypeScript', code: 'CS102', credits: 4 },
    { id: 3, name: 'Web Development Basics', code: 'CS103', credits: 2 },
    { id: 4, name: 'Enterprise Architecture', code: 'CS104', credits: 4 },
    { id: 5, name: 'Database Management Systems', code: 'CS105', credits: 3 }
  ];

  selectedCourseId: number | null = null;

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}

