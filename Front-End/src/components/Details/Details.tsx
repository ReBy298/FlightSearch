import React from 'react';
import { useNavigate, useParams, useLocation } from 'react-router-dom';
import { Container, Typography, Grid, Paper, Button } from '@mui/material';

const Details: React.FC = () => {
    const navigate = useNavigate();
    const { flightId } = useParams<{ flightId: string }>();
    const location = useLocation();
    const flightData = location.state?.flights || [];
    const flight = flightData.find((f: any) => f.id === flightId);

    if (!flight) {
        return <Typography variant="h6">Flight not found</Typography>;
    }

    return (
        <Container maxWidth="md" sx={{ mt: 4 }}>
            <Button onClick={() => navigate('/results', { state: { flights: flightData } })} variant="outlined" sx={{ mb: 2 }}>
                « Return to Results
            </Button>
            <Typography variant="h4" gutterBottom>Flight Details</Typography>
            {flight.segments.map((segment: any) => (
                <Paper key={segment.flightNumber} elevation={3} sx={{ mb: 2, p: 2 }}>
                    <Typography variant="h6">Segment</Typography>
                    <Typography variant="body2">{`${segment.departureAirportName} (${segment.departureAirportCode}) - ${segment.arrivalAirportName} (${segment.arrivalAirportCode})`}</Typography>
                    <Typography variant="body2">{`${segment.departureTime} - ${segment.arrivalTime}`}</Typography>
                    <Typography variant="body2">{`${segment.carrierName} (${segment.carrierCode}) ${segment.flightNumber}`}</Typography>
                    {segment.operatingCarrierName && (
                        <Typography variant="body2">{`Operated by: ${segment.operatingCarrierName} (${segment.operatingCarrierCode})`}</Typography>
                    )}
                    <Typography variant="body2">{`Aircraft: ${segment.aircraftType}`}</Typography>
                    <Typography variant="body2">{`Cabin: ${segment.cabin}`}</Typography>
                    <Typography variant="body2">{`Class: ${segment.class}`}</Typography>
                    <Typography variant="body2">Amenities:</Typography>
                    <ul>
                        {segment.amenities.length > 0 ? (
                            segment.amenities.map((amenity: any) => (
                                <li key={amenity.name}>{`${amenity.name} ${amenity.chargeable ? '(Chargeable)' : '(Free)'}`}</li>
                            ))
                        ) : (
                            <li>No amenities</li>
                        )}
                    </ul>
                    <Typography variant="body2">{`Layover Time: ${segment.layoverTime}`}</Typography>
                </Paper>
            ))}
            <Typography variant="h5" gutterBottom>Price Breakdown</Typography>
            <Paper elevation={3} sx={{ mb: 2, p: 2 }}>
                <Typography variant="body2">{`Base: $${flight.priceBreakdown.basePrice} ${flight.currency}`}</Typography>
                <Typography variant="body2">Fees:</Typography>
                <ul>
                    {flight.priceBreakdown.fees.length > 0 ? (
                        flight.priceBreakdown.fees.map((fee: any) => (
                            <li key={fee.type}>{`${fee.type}: $${fee.amount} ${flight.currency}`}</li>
                        ))
                    ) : (
                        <li>No fees</li>
                    )}
                </ul>
                <Typography variant="body2">{`Total: $${flight.priceBreakdown.totalPrice} ${flight.currency}`}</Typography>
                <Typography variant="body2">{`Price per Traveler: $${flight.priceBreakdown.pricePerTraveler} ${flight.currency}`}</Typography>
            </Paper>
        </Container>
    );
};

export default Details;
