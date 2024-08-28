import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import Results from './Results';

const renderWithRouter = (ui: React.ReactElement) => {
    return render(ui, { wrapper: BrowserRouter });
};

describe('Results Component', () => {
    test('renders flight data correctly', () => {
        renderWithRouter(<Results />);

        
    });

    test('navigates to details page on button click', () => {
        const { container } = renderWithRouter(<Results />);
        const buttons = container.querySelectorAll('button');

        // Click the first "View Details" button
        fireEvent.click(buttons[1]);

        // Check if navigate function is called with the correct argument
        expect(window.location.pathname).toBe('/details/1');
    });

    
});
