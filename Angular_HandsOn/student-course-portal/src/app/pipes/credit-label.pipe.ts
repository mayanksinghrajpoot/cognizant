import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'creditLabel',
})
export class CreditLabelPipe implements PipeTransform {
  transform(value: number | null | undefined): string {
    if (value === null || value === undefined || value === 0) {
      return 'No Credits';
    }
    if (value === 1) {
      return '1 Credit';
    }
    if (value >= 4) {
      return `${value} Credits (Full Semester)`;
    }
    return `${value} Credits`;
  }
}

