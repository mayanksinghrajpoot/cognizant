import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, FormArray, FormControl, Validators, AbstractControl, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.component.html',
  styleUrl: './reactive-enrollment-form.component.css',
})
export class ReactiveEnrollmentForm implements OnInit {
  enrollForm!: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: ['', [Validators.required, Validators.email], [this.simulateEmailCheck.bind(this)]],
      courseId: ['', [Validators.required, this.noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  // Custom synchronous validator
  noCourseCode(control: AbstractControl): ValidationErrors | null {
    const value = String(control.value || '');
    if (value.toUpperCase().startsWith('XX')) {
      return { noCourseCode: true };
    }
    return null;
  }

  // Custom asynchronous validator
  simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {
    return new Promise((resolve) => {
      setTimeout(() => {
        const email = String(control.value || '');
        if (email.includes('test@')) {
          resolve({ emailTaken: true });
        } else {
          resolve(null);
        }
      }, 800);
    });
  }

  // FormArray getter:
  // Defining a typed getter in the component class is superior to casting in the template because:
  // 1. It keeps the HTML template clean and free from logic or type assertion expressions.
  // 2. It enables TypeScript compile-time type checking and IDE autocompletion for the controls.
  get additionalCourses(): FormArray {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  addCourse(): void {
    this.additionalCourses.push(this.fb.control('', Validators.required));
  }

  removeCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  getAsFormControl(control: AbstractControl): FormControl {
    return control as FormControl;
  }


  // Difference between enrollForm.value and enrollForm.getRawValue():
  // - value: Returns only the values of controls that are NOT disabled.
  // - getRawValue(): Returns the values of all controls, regardless of their enabled or disabled state.
  onSubmit(): void {
    console.log('enrollForm.value:', this.enrollForm.value);
    console.log('enrollForm.getRawValue():', this.enrollForm.getRawValue());
    if (this.enrollForm.valid) {
      this.submitted = true;
    }
  }
}

