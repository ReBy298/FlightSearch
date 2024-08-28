import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import FlightSearch from './FlightSearch'; 

const mockNavigate = jest.fn();

jest.mock('react-router-dom', () => ({
    ...jest.requireActual('react-router-dom'),
    useNavigate: () => mockNavigate,
}));

describe('FlightSearch Component', () => {
    beforeEach(() => {
        render(
            <MemoryRouter>
                <FlightSearch />
            </MemoryRouter>
        );
    });

    test('renders flight search form', () => {
        expect(screen.getByText('Flight Search')).toBeInTheDocument();
        expect(screen.getByLabelText('Departure Airport')).toBeInTheDocument();
        expect(screen.getByLabelText('Arrival Airport')).toBeInTheDocument();
        expect(screen.getByLabelText('Departure Date')).toBeInTheDocument();
        expect(screen.getByLabelText('Return Date')).toBeInTheDocument();
        expect(screen.getByLabelText('Non-stop')).toBeInTheDocument();
        expect(screen.getByText('Search')).toBeInTheDocument();
    });

    test('allows user to input flight details', () => {
        fireEvent.change(screen.getByLabelText('Departure Airport'), { target: { value: 'SFO' } });
        fireEvent.change(screen.getByLabelText('Arrival Airport'), { target: { value: 'JFK' } });
        fireEvent.click(screen.getByLabelText('Non-stop'));

        expect(screen.getByLabelText('Departure Airport')).toHaveValue('SFO');
        expect(screen.getByLabelText('Arrival Airport')).toHaveValue('JFK');
        expect(screen.getByLabelText('Non-stop')).toBeChecked();
    });

    test('navigates to results on search', () => {
        fireEvent.click(screen.getByText('Search'));
        expect(mockNavigate).toHaveBeenCalledWith('/results');
    });
});
