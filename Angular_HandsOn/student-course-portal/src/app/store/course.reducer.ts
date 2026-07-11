import { createReducer, on } from '@ngrx/store';
import { Course } from '../models/course.model';
import * as CourseActions from './course.actions';

export interface CourseState {
  courses: Course[];
  isLoading: boolean;
  error: string | null;
}

export const initialCourseState: CourseState = {
  courses: [],
  isLoading: false,
  error: null,
};

export const courseReducer = createReducer(
  initialCourseState,
  on(CourseActions.loadCourses, (state) => ({
    ...state,
    isLoading: true,
    error: null,
  })),
  on(CourseActions.loadCoursesSuccess, (state, { courses }) => ({
    ...state,
    courses,
    isLoading: false,
  })),
  on(CourseActions.loadCoursesFailure, (state, { error }) => ({
    ...state,
    error,
    isLoading: false,
  })),
  on(CourseActions.toggleEnrollment, (state, { courseId }) => {
    const updatedCourses = state.courses.map((course) => {
      if (course.id === courseId) {
        return { ...course, enrolled: !course.enrolled };
      }
      return course;
    });
    return {
      ...state,
      courses: updatedCourses,
    };
  })
);
