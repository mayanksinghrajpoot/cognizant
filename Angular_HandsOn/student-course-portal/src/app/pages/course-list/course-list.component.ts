import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card.component';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css',
})
export class CourseList implements OnInit {
  isLoading = true;
  selectedCourseId: number | null = null;

  courses = [
    { id: 1, name: 'Introduction to Angular', code: 'CS101', credits: 3, gradeStatus: 'passed', enrolled: false },
    { id: 2, name: 'Advanced TypeScript', code: 'CS102', credits: 4, gradeStatus: 'pending', enrolled: false },
    { id: 3, name: 'Web Development Basics', code: 'CS103', credits: 2, gradeStatus: 'passed', enrolled: true },
    { id: 4, name: 'Enterprise Architecture', code: 'CS104', credits: 4, gradeStatus: 'failed', enrolled: false },
    { id: 5, name: 'Database Management Systems', code: 'CS105', credits: 3, gradeStatus: 'pending', enrolled: true }
  ];

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
    
    // Toggle enrollment status for demonstration
    const course = this.courses.find(c => c.id === courseId);
    if (course) {
      course.enrolled = !course.enrolled;
    }
  }

  // trackByCourseId:
  // trackBy improves performance by helping Angular identify which items in a list have changed, been added, or removed.
  // Instead of re-rendering the entire DOM list upon any change, Angular only re-renders the DOM elements that actually changed.
  trackByCourseId(index: number, course: any): number {
    return course.id;
  }
}


