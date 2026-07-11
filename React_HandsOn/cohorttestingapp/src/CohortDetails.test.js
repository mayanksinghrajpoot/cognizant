import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import CohortDetails from './CohortDetails';

describe('Cohort Details Component', () => {
  const mockCohort = {
    code: 'COH001',
    name: 'FSE Java FullStack',
    status: 'ongoing'
  };

  test('should create the component', () => {
    const { container } = render(<CohortDetails cohort={mockCohort} />);
    expect(container).toBeTruthy();
  });

  test('should initialize the props', () => {
    render(<CohortDetails cohort={mockCohort} />);
    expect(screen.getByText('FSE Java FullStack')).toBeInTheDocument();
  });

  test('should display cohort code in h3', () => {
    render(<CohortDetails cohort={mockCohort} />);
    const headingEl = screen.getByRole('heading', { level: 3 });
    expect(headingEl.textContent).toBe('COH001');
  });

  test('should always render same html (snapshot)', () => {
    const { asFragment } = render(<CohortDetails cohort={mockCohort} />);
    expect(asFragment()).toMatchSnapshot();
  });
});
