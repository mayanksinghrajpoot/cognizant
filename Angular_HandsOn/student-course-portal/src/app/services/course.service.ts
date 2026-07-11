import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, tap, retry } from 'rxjs/operators';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private apiUrl = 'http://localhost:3000/courses';

  constructor(private http: HttpClient) {}

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl).pipe(
      retry(2),
      map(courses => courses.filter(c => c.credits > 0)),
      tap(courses => console.log('Courses loaded:', courses.length)),
      catchError(err => {
        console.error(err);
        return throwError(() => new Error('Failed to load courses. Please try again.'));
      })
    );
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.apiUrl}/${id}`).pipe(
      catchError(err => {
        console.error(err);
        return throwError(() => new Error(`Failed to load course details for ID ${id}.`));
      })
    );
  }

  createCourse(course: Omit<Course, 'id' | 'gradeStatus'>): Observable<Course> {
    const newCourse = { ...course, gradeStatus: 'pending' as const, enrolled: false };
    return this.http.post<Course>(this.apiUrl, newCourse).pipe(
      catchError(err => {
        console.error(err);
        return throwError(() => new Error('Failed to add new course.'));
      })
    );
  }

  updateCourse(course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.apiUrl}/${course.id}`, course).pipe(
      catchError(err => {
        console.error(err);
        return throwError(() => new Error(`Failed to update course ID ${course.id}.`));
      })
    );
  }

  deleteCourse(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`).pipe(
      catchError(err => {
        console.error(err);
        return throwError(() => new Error(`Failed to delete course ID ${id}.`));
      })
    );
  }
}


