import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import FlightSearch from './FlightSearch';
import { MemoryRouter, Routes, Route } from 'react-router-dom';


const mockedNavigate = jest.fn();

jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: () => mockedNavigate,
}));

global.fetch = jest.fn(() =>
  Promise.resolve({
    json: () => Promise.resolve([{ iataCode: 'JFK' }, { iataCode: 'LAX' }]),
  })
) as jest.Mock;

describe('FlightSearch Component', () => {
  beforeEach(() => {
    jest.clearAllMocks();
  });

  test('renders all input fields', () => {
    render(
      <MemoryRouter>
        <FlightSearch />
      </MemoryRouter>
    );

    expect(screen.getByLabelText(/Departure Airport/i)).toBeInTheDocument();
    expect(screen.getByLabelText(/Arrival Airport/i)).toBeInTheDocument();
    expect(screen.getByLabelText(/Departure Date/i)).toBeInTheDocument();
    expect(screen.getByLabelText(/Return Date/i)).toBeInTheDocument();
    expect(screen.getByLabelText(/Currency/i)).toBeInTheDocument();
    expect(screen.getByLabelText(/Non-stop/i)).toBeInTheDocument();
    expect(screen.getByRole('button', { name: /Search/i })).toBeInTheDocument();
  });

  test('calls IATA API when typing in departure or arrival fields', async () => {
    render(
      <MemoryRouter>
        <FlightSearch />
      </MemoryRouter>
    );


    fireEvent.change(screen.getByLabelText(/Departure Airport/i), { target: { value: 'JFK' } });

    await waitFor(() => {
      expect(global.fetch).toHaveBeenCalledWith('http://localhost:9090/api/flights/iata-codes?keyword=JFK', expect.any(Object));
    });


    fireEvent.change(screen.getByLabelText(/Arrival Airport/i), { target: { value: 'LAX' } });

    await waitFor(() => {
      expect(global.fetch).toHaveBeenCalledWith('http://localhost:9090/api/flights/iata-codes?keyword=LAX', expect.any(Object));
    });
  });

  test('disables invalid return date selection', async () => {
    render(
      <MemoryRouter>
        <FlightSearch />
      </MemoryRouter>
    );

  
    const departureDateInput = screen.getByLabelText(/Departure Date/i);
    fireEvent.change(departureDateInput, { target: { value: '2024-10-10' } });


    const returnDateInput = screen.getByLabelText(/Return Date/i);
    fireEvent.change(returnDateInput, { target: { value: '2024-10-05' } });

    await waitFor(() => {
      expect(returnDateInput).toHaveValue(''); 
    });
  });

  
});
