import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourseCard } from './course-card.component';
import { EnrollmentService } from '../../services/enrollment.service';
import { provideMockStore } from '@ngrx/store/testing';
import { SimpleChange } from '@angular/core';

describe('CourseCard', () => {
  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;
  let enrollmentServiceSpy: jasmine.SpyObj<EnrollmentService>;

  const mockCourse = {
    id: 1,
    name: 'Introduction to Angular',
    code: 'CS101',
    credits: 3,
    gradeStatus: 'passed',
    enrolled: false
  };

  beforeEach(async () => {
    const spy = jasmine.createSpyObj('EnrollmentService', ['enroll', 'unenroll', 'isEnrolled']);
    spy.isEnrolled.and.returnValue(false);

    await TestBed.configureTestingModule({
      imports: [CourseCard],
      providers: [
        { provide: EnrollmentService, useValue: spy },
        provideMockStore({
          initialState: {
            courses: {
              courses: [],
              isLoading: false,
              error: null
            }
          }
        })
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCard);
    component = fixture.componentInstance;
    component.course = mockCourse;
    enrollmentServiceSpy = TestBed.inject(EnrollmentService) as jasmine.SpyObj<EnrollmentService>;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should show course code', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('p')?.textContent).toContain('CS101');
  });

  it('should toggle enrollment on click', () => {
    spyOn(component.enrollRequested, 'emit');
    component.onEnrollToggle();
    expect(enrollmentServiceSpy.enroll).toHaveBeenCalledWith(1);
    expect(component.enrollRequested.emit).toHaveBeenCalledWith(1);
  });

  it('should detect ngOnChanges lifecycle changes', () => {
    spyOn(console, 'log');
    component.ngOnChanges({
      course: new SimpleChange(null, mockCourse, true)
    });
    expect(console.log).toHaveBeenCalled();
  });
});

