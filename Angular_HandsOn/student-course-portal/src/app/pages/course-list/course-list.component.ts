import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card.component';
import { Course } from '../../models/course.model';
import { Router, ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import * as CourseActions from '../../store/course.actions';
import { selectAllCourses, selectCoursesLoading, selectCoursesError } from '../../store/course.selectors';

@Component({
  selector: 'app-app-course-list',
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css',
})
export class CourseList implements OnInit {
  isLoading = true;
  selectedCourseId: number | null = null;
  courses: Course[] = [];
  errorMessage = '';

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private store: Store
  ) {}


  ngOnInit(): void {
    // Dispatch action to load courses via Effects
    this.store.dispatch(CourseActions.loadCourses());

    // Select course list from store
    this.store.select(selectAllCourses).subscribe({
      next: (courses) => {
        const search = this.route.snapshot.queryParamMap.get('search');
        if (search) {
          this.courses = courses.filter(c => 
            c.name.toLowerCase().includes(search.toLowerCase()) || 
            c.code.toLowerCase().includes(search.toLowerCase())
          );
        } else {
          this.courses = courses;
        }
      }
    });

    // Select loading status from store
    this.store.select(selectCoursesLoading).subscribe((loading) => {
      this.isLoading = loading;
    });

    // Select error message from store
    this.store.select(selectCoursesError).subscribe((error) => {
      if (error) {
        this.errorMessage = error;
      }
    });
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


