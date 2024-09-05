import React from 'react';
import { render, screen } from '@testing-library/react';
import { MemoryRouter, Route, Routes } from 'react-router-dom';
import Details from './Details';
import { act } from 'react';


const mockLocationState = {
  state: {
    flights: [
      {
        id: 'ec0e3334-7057-4f9a-9e2f-2339f90523ce',
        segments: [
          {
            departureTime: '2024-10-20T06:00:00',
            arrivalTime: '2024-10-20T07:23:00',
            departureAirportName: 'Unknown Airport',
            departureAirportCode: 'BOS',
            arrivalAirportName: 'Unknown Airport',
            arrivalAirportCode: 'EWR',
            carrierCode: 'UA',
            carrierName: 'Unknown Airline',
            flightNumber: '1833',
            operatingCarrierCode: 'UA',
            operatingCarrierName: 'Unknown Airline',
            aircraftType: '7M9',
            cabin: 'ECONOMY',
            fareBasis: 'GAA4PFDN',
            amenities: [
              { name: 'CHECKED BAG FIRST', chargeable: false },
              { name: 'SECOND BAG', chargeable: false },
              { name: 'PRE RESERVED SEAT ASSIGNMENT', chargeable: false },
              { name: 'PRIORITY BOARDING', chargeable: false },
              { name: 'ECONOMY TO ECONOMY PLUS', chargeable: false },
              { name: 'MILEAGE ACCRUAL', chargeable: false },
            ],
            layoverTime: 'PT1H23M',
            class: 'G',
          },
        ],
        priceBreakdown: {
          basePrice: '127.22',
          totalPrice: '167.02',
          fees: [
            { amount: '0.00', type: 'SUPPLIER' },
            { amount: '0.00', type: 'TICKETING' },
          ],
          pricePerTraveler: '167.02',
        },
        currency: 'USD',
      },
    ],
    departure: 'City A',
    arrival: 'City B',
    departureDate: new Date('2024-10-20T06:00:00'),
    returnDate: new Date('2024-10-20T07:23:00'),
    nonStop: true,
    currency: 'USD',
  },
};


  

test('renders "Flight not found" when flight is missing', () => {
  render(
    <MemoryRouter initialEntries={[{ pathname: '/details/invalid-id', state: mockLocationState }]}>
      <Routes>
        <Route path="/details/:flightId" element={<Details />} />
      </Routes>
    </MemoryRouter>
  );

  expect(screen.getByText('Flight not found')).toBeInTheDocument();
});
