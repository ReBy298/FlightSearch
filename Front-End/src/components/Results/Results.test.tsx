import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import Results from './Results';
import { MemoryRouter, Routes, Route } from 'react-router-dom';

// Mock de useNavigate y useLocation
const mockedNavigate = jest.fn();
const mockFlights = [
  {
    id: '1',
    initialDepartureDateTime: '2024-10-10T08:00:00',
    finalArrivalDateTime: '2024-10-10T12:00:00',
    departureAirportName: 'John F. Kennedy International Airport',
    departureAirportCode: 'JFK',
    arrivalAirportName: 'Los Angeles International Airport',
    arrivalAirportCode: 'LAX',
    totalFlightTime: '6h',
    stops: [],
    airlineName: 'Delta Airlines',
    airlineCode: 'DL',
    totalPrice: 500,
    pricePerTraveler: 500,
    currency: 'USD',
  },
];

jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: () => mockedNavigate,
  useLocation: () => ({
    state: {
      flights: mockFlights,
      departure: 'JFK',
      arrival: 'LAX',
      departureDate: '2024-10-10',
      returnDate: '2024-10-20',
      nonStop: false,
      currency: 'USD',
    },
  }),
}));

// Mock de fetch
global.fetch = jest.fn(() =>
  Promise.resolve({
    json: () => Promise.resolve(mockFlights),
  })
) as jest.Mock;

describe('Results Component', () => {
  beforeEach(() => {
    jest.clearAllMocks();
  });

  test('navigates to flight details page on "View Details" click', async () => {
    render(
      <MemoryRouter initialEntries={['/results']}>
        <Routes>
          <Route path="/results" element={<Results />} />
        </Routes>
      </MemoryRouter>
    );

    fireEvent.click(screen.getByText('View Details'));

    await waitFor(() => {
      expect(mockedNavigate).toHaveBeenCalledWith('/details/1', expect.anything());
    });
  });


  test('navigates back to search on "Return to Search" click', () => {
    render(
      <MemoryRouter initialEntries={['/results']}>
        <Routes>
          <Route path="/results" element={<Results />} />
        </Routes>
      </MemoryRouter>
    );

    fireEvent.click(screen.getByText('« Return to Search'));

    expect(mockedNavigate).toHaveBeenCalledWith('/');
  });

});
