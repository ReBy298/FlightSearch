import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { Container, Typography, Grid, Paper, Button } from '@mui/material';

const Results: React.FC = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const flightData = location.state?.flights || [];
    

    const handleDetails = (flightId: string) => {
        navigate(`/details/${flightId}`);
    };

    return (
        <Container maxWidth="md" sx={{ mt: 4 }}>
            <Button onClick={() => navigate('/')} variant="outlined" sx={{ mb: 2 }}>
                « Return to Search
            </Button>
            {flightData.map((flight: any, index: number) => (
                <Paper key={index} elevation={3} sx={{ mb: 2, p: 2 }}>
                    <Grid container spacing={2}>
                        <Grid item xs={12} sm={4}>
                            <Typography variant="h6">{`${new Date(flight.departureDate).toLocaleTimeString()} - ${new Date(flight.arrivalDate).toLocaleTimeString()}`}</Typography>
                            <Typography variant="body2">{`${flight.departureAirport} - ${flight.arrivalAirport}`}</Typography>
                        </Grid>
                        <Grid item xs={12} sm={4}>
                            <Typography variant="body1">{flight.totalTime}</Typography>
                            <Typography variant="body2">{flight.segments[0].stops === 0 ? 'Nonstop' : `${flight.segments[0].stops} stop(s)`}</Typography>
                        </Grid>
                        <Grid item xs={12} sm={2}>
                            <Typography variant="body1">{flight.airline}</Typography>
                        </Grid>
                        <Grid item xs={12} sm={2} sx={{ textAlign: 'right' }}>
                            <Typography variant="h6">{`$${flight.price} ${flight.currency}`}</Typography>
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
