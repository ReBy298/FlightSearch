import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import { MemoryRouter, Route, Routes } from 'react-router-dom';
import Details from './Details'; 
import { act } from 'react';

const mockNavigate = jest.fn();

jest.mock('react-router-dom', () => ({
    ...jest.requireActual('react-router-dom'),
    useNavigate: () => mockNavigate,
    useParams: () => ({ flightId: '1' }),
}));

describe('Details Component', () => {
    beforeEach(() => {
        act(() => {
            render(
                <MemoryRouter initialEntries={['/details/1']}>
                    <Routes>
                        <Route path="/details/:flightId" element={<Details />} />
                    </Routes>
                </MemoryRouter>
            );
        });
    });

    test('renders flight details', () => {
        expect(screen.getByText('Flight Details')).toBeInTheDocument();
        expect(screen.getByText('Segment 1')).toBeInTheDocument();
        expect(screen.getByText('San Francisco (SFO) - New York (JFK)')).toBeInTheDocument();
        const flightNumbers = screen.getAllByText('Aeromexico (AM) 65AM');
        expect(flightNumbers).toHaveLength(2); 
    });

    test('renders price breakdown', () => {
        expect(screen.getByText('Price Breakdown')).toBeInTheDocument();
        expect(screen.getByText('Base')).toBeInTheDocument();
        expect(screen.getByText('Fees')).toBeInTheDocument();
        expect(screen.getByText('Total')).toBeInTheDocument();
        expect(screen.getByText('$1200 MXN')).toBeInTheDocument();
        expect(screen.getByText('$300 MXN')).toBeInTheDocument();
        expect(screen.getByText('$1500 MXN')).toBeInTheDocument();
    });

    test('navigates back to results', () => {
        const button = screen.getByText('« Return to Results');
        fireEvent.click(button);
        expect(mockNavigate).toHaveBeenCalledWith('/results');
    });
});
