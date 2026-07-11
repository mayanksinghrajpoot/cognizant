import { Component } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Highlight } from './highlight.directive';
import { By } from '@angular/platform-browser';

@Component({
  template: `<div [appHighlight]="'yellow'">Test Directive</div>`,
  imports: [Highlight]
})
class TestComponent {}

describe('HighlightDirective', () => {
  let fixture: ComponentFixture<TestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [Highlight, TestComponent]
    });
    fixture = TestBed.createComponent(TestComponent);
    fixture.detectChanges();
  });

  it('should apply highlight color on mouseenter', () => {
    const debugEl = fixture.debugElement.query(By.css('div'));
    const div = debugEl.nativeElement as HTMLElement;

    // Simulate mouseenter
    debugEl.triggerEventHandler('mouseenter', null);
    fixture.detectChanges();
    expect(div.style.backgroundColor).toBe('yellow');

    // Simulate mouseleave
    debugEl.triggerEventHandler('mouseleave', null);
    fixture.detectChanges();
    expect(div.style.backgroundColor).toBe('');
  });
});

