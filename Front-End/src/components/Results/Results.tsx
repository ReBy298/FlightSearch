import React, { useEffect, useState } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { Container, Typography, Grid, Paper, Button } from '@mui/material';

const Results: React.FC = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const flightData = location.state?.flights || [];
    const [departure, setDeparture] = useState('');
    const [arrival, setArrival] = useState('');
    const [departureDate, setDepartureDate] = useState<Date | null>(new Date());
    const [returnDate, setReturnDate] = useState<Date | null>(null);
    const [nonStop, setNonStop] = useState(false);
    const [currency, setCurrency] = useState('USD');

    const [sortedData, setSortedData] = useState(flightData);
    const [priceSort, setPriceSort] = useState('asc');
    const [durationSort, setDurationSort] = useState('asc');

    useEffect(() => {
        setSortedData(flightData);
        handleSort();
        setDeparture(location.state.departure);
        setArrival(location.state.arrival);
        setDepartureDate(location.state.departureDate);
        setReturnDate(location.state.returnDate);
        setNonStop(location.state.nonStop);
        setCurrency(location.state.currency);
    }, [flightData, departure,arrival,departureDate,returnDate,nonStop,currency]);


    const handleDetails = (flightId: string) => {
        navigate(`/details/${flightId}`, { state: { flights: flightData,
            id : flightId,
            departure,
            arrival,
            departureDate,
            returnDate,
            nonStop,
            currency 
        } });
    };

    const formatTime = (dateTime: string) => {
        const date = new Date(dateTime);
        return date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
    };

    const changeVariablePrice =() => {
        if (priceSort == 'asc') {
            setPriceSort('desc')
        }else{
            setPriceSort('asc')
        }
        handleSort();
    }
    const changeVariableDuration =() => {
        if (durationSort == 'asc') {
            setDurationSort('desc')
        }else{
            setDurationSort('asc')
        }
        handleSort();
    }
    const handleSort = async () => {

        const url = `http://localhost:9090/api/flights/search?origin=${location.state.departure}&destination=${location.state.arrival}&departureDate=${location.state.departureDate}&returnDate=${location.state.returnDate}&adults=1&nonStop=${location.state.nonStop}&max=3&currency=${location.state.currency}&orderPrice=${priceSort}&orderDuration=${durationSort}`;

        try {
            const response = await fetch(url, {
                credentials: 'include',
                mode: 'cors',
                method: 'GET',
                headers: {
                    "Content-Type": "application/json",
                    'Access-Control-Allow-Origin': 'http://localhost:3000',
                    "Access-Control-Allow-Methods": "DELETE, POST, GET, OPTIONS",
                    "Access-Control-Allow-Headers": "Content-Type, Authorization, X-Requested-With"
                }
            });
            const data = await response.json();
            setSortedData(data);
        } catch (error) {
            console.error('Error fetching sorted flight data:', error);
        }
    };

    return (
        <Container maxWidth="md" sx={{ mt: 4 }} >
            <Button onClick={() => navigate('/')} variant="outlined" sx={{ mb: 2}}>
                « Return to Search
            </Button>
            <Button onClick={() => changeVariablePrice()} variant="outlined" sx={{ mb: 2, ml: 20 }}>
                Sort by Price
            </Button>
            <Button onClick={() => changeVariableDuration()} variant="outlined" sx={{ mb: 2, ml: 2 }}>
                Sort by Duration
            </Button>
            {sortedData.map((flight: any) => (
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
