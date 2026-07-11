import { Routes } from '@angular/router';
import { Home } from './pages/home/home.component';
import { CourseList } from './pages/course-list/course-list.component';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'courses', component: CourseList }
];

