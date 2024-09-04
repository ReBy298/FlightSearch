import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { Container, Typography, Grid, Paper, Button } from '@mui/material';

const Results: React.FC = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const flightData = location.state?.flights || [];

    const handleDetails = (flightId: string) => {
        navigate(`/details/${flightId}`, { state: { flights: flightData } });
    };

    const formatTime = (dateTime: string) => {
        const date = new Date(dateTime);
        return date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
    };

    return (
        <Container maxWidth="md" sx={{ mt: 4 }}>
            <Button onClick={() => navigate('/')} variant="outlined" sx={{ mb: 2 }}>
                « Return to Search
            </Button>
            {flightData.map((flight: any) => (
                <Paper key={flight.id} elevation={3} sx={{ mb: 2, p: 2 }}>
                    <Grid container spacing={2}>
                        <Grid item xs={12} sm={4}>
                            <Typography variant="h6">{`${formatTime(flight.initialDepartureDateTime)} - ${formatTime(flight.finalArrivalDateTime)}`}</Typography>
                            <Typography variant="body2">{`${flight.departureAirportName} (${flight.departureAirportCode}) - ${flight.arrivalAirportName} (${flight.arrivalAirportCode})`}</Typography>
                        </Grid>
                        <Grid item xs={12} sm={4}>
                            <Typography variant="body1">{flight.totalFlightTime}</Typography>
                            <Typography variant="body2">{flight.stops.length > 0 ? `${flight.stops.length} stop(s)` : 'Nonstop'}</Typography>
                            {flight.stops.map((stop: any, index: number) => (
                                <Typography key={index} variant="body2">{`${stop.layoverTime} in ${stop.airportName} (${stop.airportCode})`}</Typography>
                            ))}
                        </Grid>
                        <Grid item xs={12} sm={2}>
                            <Typography variant="body1">{`${flight.airlineName} (${flight.airlineCode})`}</Typography>
                        </Grid>
                        <Grid item xs={12} sm={2} sx={{ textAlign: 'right' }}>
                            <Typography variant="h6">{`$${flight.totalPrice} ${flight.currency}`}</Typography>
                            <Typography variant="body2">total</Typography>
                            <Typography variant="body2">{`$${flight.pricePerTraveler} ${flight.currency}`}</Typography>
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
