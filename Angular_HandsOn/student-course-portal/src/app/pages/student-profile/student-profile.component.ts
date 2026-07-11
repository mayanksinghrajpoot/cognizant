import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EnrollmentService } from '../../services/enrollment.service';
import { Notification } from '../../components/notification/notification.component';

@Component({
  selector: 'app-student-profile',
  imports: [CommonModule, Notification],
  templateUrl: './student-profile.component.html',
  styleUrl: './student-profile.component.css',
})
export class StudentProfile {

  studentName = 'John Doe';
  studentEmail = 'john.doe@university.edu';

  constructor(private enrollmentService: EnrollmentService) {}

  get enrolledCourses() {
    return this.enrollmentService.getEnrolledCourses();
  }
}

