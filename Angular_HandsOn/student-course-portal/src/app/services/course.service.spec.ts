import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  const mockCourses: Course[] = [
    { id: 1, name: 'Angular 20', code: 'CS101', credits: 3, gradeStatus: 'passed', enrolled: false },
    { id: 2, name: 'RxJS Basics', code: 'CS102', credits: 4, gradeStatus: 'pending', enrolled: true }
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });
    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should retrieve courses via GET', () => {
    service.getCourses().subscribe(courses => {
      expect(courses.length).toBe(2);
      expect(courses).toEqual(mockCourses);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses);
  });

  it('should retrieve course by ID via GET', () => {
    service.getCourseById(1).subscribe(course => {
      expect(course.name).toBe('Angular 20');
    });

    const req = httpMock.expectOne('http://localhost:3000/courses/1');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses[0]);
  });

  it('should create course via POST', () => {
    const newCourse = { name: 'New Course', code: 'CS103', credits: 2 };
    service.createCourse(newCourse).subscribe(course => {
      expect(course.id).toBe(3);
      expect(course.name).toBe('New Course');
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('POST');
    req.flush({ ...newCourse, id: 3, gradeStatus: 'pending', enrolled: false });
  });
});

