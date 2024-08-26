import React from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { Container, Typography, Box, Grid, Paper, Button, Divider } from '@mui/material';

const flightDetails = {
    id: '1',
    segments: [
        {
            id: '1',
            departureTime: 'YYYY-MM-DD HH:mm',
            arrivalTime: 'YYYY-MM-DD HH:mm',
            departureAirport: 'San Francisco (SFO)',
            arrivalAirport: 'New York (JFK)',
            airline: 'Aeromexico (AM)',
            flightNumber: '65AM',
            aircraft: 'Boeing 737',
            cabin: 'Economy',
            class: 'Y',
            amenities: [
                { name: 'WiFi', chargeable: true },
                { name: 'In-flight entertainment', chargeable: false },
            ],
        },
        {
            id: '2',
            departureTime: 'YYYY-MM-DD HH:mm',
            arrivalTime: 'YYYY-MM-DD HH:mm',
            departureAirport: 'New York (JFK)',
            arrivalAirport: 'San Francisco (SFO)',
            airline: 'Aeromexico (AM)',
            flightNumber: '65AM',
            aircraft: 'Boeing 737',
            cabin: 'Economy',
            class: 'Y',
            amenities: [
                { name: 'WiFi', chargeable: true },
                { name: 'In-flight entertainment', chargeable: false },
            ],
        },
    ],
    priceBreakdown: {
        base: 1200,
        fees: 300,
        total: 1500,
        currency: 'MXN',
    },
};

const Details: React.FC = () => {
    const { flightId } = useParams<{ flightId: string }>();
    const navigate = useNavigate();

    return (
        <Container maxWidth="md" sx={{ mt: 4 }}>
            <Button onClick={() => navigate('/results')} variant="outlined" sx={{ mb: 2 }}>
                « Return to Results
            </Button>
            <Paper elevation={3} sx={{ p: 4 }}>
                <Typography variant="h4" gutterBottom>
                    Flight Details
                </Typography>
                {flightDetails.segments.map((segment) => (
                    <Box key={segment.id} sx={{ mb: 4 }}>
                        <Typography variant="h6" gutterBottom>
                            Segment {segment.id}
                        </Typography>
                        <Typography variant="body1">{`${segment.departureTime} - ${segment.arrivalTime}`}</Typography>
                        <Typography variant="body2">{`${segment.departureAirport} - ${segment.arrivalAirport}`}</Typography>
                        <Typography variant="body2">{`${segment.airline} ${segment.flightNumber}`}</Typography>
                        <Typography variant="body2">{`Aircraft: ${segment.aircraft}`}</Typography>
                        <Typography variant="body2">{`Cabin: ${segment.cabin}, Class: ${segment.class}`}</Typography>
                        <Typography variant="body2">Amenities:</Typography>
                        <ul>
                            {segment.amenities.map((amenity, index) => (
                                <li key={index}>
                                    {amenity.name} {amenity.chargeable ? '(Chargeable)' : '(Free)'}
                                </li>
                            ))}
                        </ul>
                        <Divider sx={{ my: 2 }} />
                    </Box>
                ))}
                <Box sx={{ mt: 4 }}>
                    <Typography variant="h6" gutterBottom>
                        Price Breakdown
                    </Typography>
                    <Grid container spacing={2}>
                        <Grid item xs={6}>
                            <Typography variant="body1">Base</Typography>
                            <Typography variant="body1">Fees</Typography>
                            <Typography variant="body1">Total</Typography>
                        </Grid>
                        <Grid item xs={6} sx={{ textAlign: 'right' }}>
                            <Typography variant="body1">{`$${flightDetails.priceBreakdown.base} ${flightDetails.priceBreakdown.currency}`}</Typography>
                            <Typography variant="body1">{`$${flightDetails.priceBreakdown.fees} ${flightDetails.priceBreakdown.currency}`}</Typography>
                            <Typography variant="body1">{`$${flightDetails.priceBreakdown.total} ${flightDetails.priceBreakdown.currency}`}</Typography>
                        </Grid>
                    </Grid>
                </Box>
            </Paper>
        </Container>
    );
};

export default Details;