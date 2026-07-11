import { CreditLabelPipe } from './credit-label.pipe';

describe('CreditLabelPipe', () => {
  let pipe: CreditLabelPipe;

  beforeEach(() => {
    pipe = new CreditLabelPipe();
  });

  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });

  it('should format credits greater than or equal to 4 with (Full Semester)', () => {
    expect(pipe.transform(4)).toBe('4 Credits (Full Semester)');
    expect(pipe.transform(5)).toBe('5 Credits (Full Semester)');
  });

  it('should format credits less than 4 without extra tag', () => {
    expect(pipe.transform(3)).toBe('3 Credits');
    expect(pipe.transform(2)).toBe('2 Credits');
  });
});

