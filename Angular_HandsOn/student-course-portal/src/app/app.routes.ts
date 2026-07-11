import { Routes } from '@angular/router';
import { Home } from './pages/home/home.component';
import { CourseList } from './pages/course-list/course-list.component';
import { EnrollmentForm } from './pages/enrollment-form/enrollment-form.component';
import { ReactiveEnrollmentForm } from './pages/reactive-enrollment-form/reactive-enrollment-form.component';
import { StudentProfile } from './pages/student-profile/student-profile.component';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'courses', component: CourseList },
  { path: 'enroll', component: EnrollmentForm },
  { path: 'enroll-reactive', component: ReactiveEnrollmentForm },
  { path: 'profile', component: StudentProfile }
];




