import React from 'react';

import { render, screen } from '@testing-library/react';
import App from './App';

test('renders flight search', () => {
  render(<App />);
  const headingElement = screen.getByText(/Flight Search/i);
  expect(headingElement).toBeInTheDocument();
});


