import React from 'react';
import { useNavigate } from 'react-router-dom';
import { Container, Typography, Grid, Paper, Button } from '@mui/material';

const flightData = [
    {
        id: '1',
        departureTime: '1:40pm',
        arrivalTime: '10:37pm',
        duration: '5h 57m',
        stops: 'Nonstop',
        departureAirport: 'San Francisco (SFO)',
        arrivalAirport: 'New York (JFK)',
        airline: 'Delta (DL)',
        price: 1500,
        currency: 'MXN',
    },
    {
        id: '2',
        departureTime: '11:12am',
        arrivalTime: '10:29pm',
        duration: '8h 17m',
        stops: '1 stop',
        layover: '1h 3m in Los Angeles (LAX)',
        departureAirport: 'San Francisco (SFO)',
        arrivalAirport: 'New York (JFK)',
        airline: 'Aeromexico (AM)',
        price: 1500,
        currency: 'MXN',
    },
    // Add more flight data as needed
];

const Results: React.FC = () => {
    const navigate = useNavigate();

    const handleDetails = (flightId: string) => {
        navigate(`/details/${flightId}`);
    };

    return (
        <Container maxWidth="md" sx={{ mt: 4 }}>
            <Button onClick={() => navigate('/')} variant="outlined" sx={{ mb: 2 }}>
                « Return to Search
            </Button>
            {flightData.map((flight) => (
                <Paper key={flight.id} elevation={3} sx={{ mb: 2, p: 2 }}>
                    <Grid container spacing={2}>
                        <Grid item xs={12} sm={4}>
                            <Typography variant="h6">{`${flight.departureTime} - ${flight.arrivalTime}`}</Typography>
                            <Typography variant="body2">{`${flight.departureAirport} - ${flight.arrivalAirport}`}</Typography>
                        </Grid>
                        <Grid item xs={12} sm={4}>
                            <Typography variant="body1">{flight.duration}</Typography>
                            <Typography variant="body2">{flight.stops}</Typography>
                            {flight.layover && <Typography variant="body2">{flight.layover}</Typography>}
                        </Grid>
                        <Grid item xs={12} sm={2}>
                            <Typography variant="body1">{flight.airline}</Typography>
                        </Grid>
                        <Grid item xs={12} sm={2} sx={{ textAlign: 'right' }}>
                            <Typography variant="h6">{`$${flight.price} ${flight.currency}`}</Typography>
                            <Typography variant="body2">total</Typography>
                            <Typography variant="body2">{`$${flight.price / 3} ${flight.currency}`}</Typography>
                            <Typography variant="body2">per Traveler</Typography>
                        </Grid>
                    </Grid>
                    <Button variant="contained" color="primary" fullWidth sx={{ mt: 2 }} onClick={() => handleDetails(flight.id)}>
                        View Details
                    </Button>
                </Paper>
            ))}
        </Container>
    );
};

export default Results;