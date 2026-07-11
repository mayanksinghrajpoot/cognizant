import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card.component';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css',
})
export class CourseList implements OnInit {
  isLoading = true;
  selectedCourseId: number | null = null;
  courses: Course[] = [];

  constructor(
    private courseService: CourseService,
    private router: Router,
    private route: ActivatedRoute
  ) {}


  ngOnInit(): void {
    const rawCourses = this.courseService.getCourses();
    const search = this.route.snapshot.queryParamMap.get('search');
    if (search) {
      this.courses = rawCourses.filter(c => 
        c.name.toLowerCase().includes(search.toLowerCase()) || 
        c.code.toLowerCase().includes(search.toLowerCase())
      );
    } else {
      this.courses = rawCourses;
    }
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }


  onEnroll(courseId: number): void {
    console.log('Course list received enrollment request for ID: ' + courseId);
    this.selectedCourseId = courseId;
  }

  onCardClick(courseId: number): void {
    this.router.navigate(['/courses', courseId]);
  }

  // trackByCourseId:
  // trackBy improves performance by helping Angular identify which items in a list have changed, been added, or removed.
  // Instead of re-rendering the entire DOM list upon any change, Angular only re-renders the DOM elements that actually changed.
  trackByCourseId(index: number, course: any): number {
    return course.id;
  }
}


