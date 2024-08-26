import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Container, TextField, Button, Checkbox, FormControlLabel, Typography, Grid, Box } from '@mui/material';
import { LocalizationProvider, DatePicker } from '@mui/x-date-pickers';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';

const FlightSearch: React.FC = () => {
    const [departure, setDeparture] = useState('');
    const [arrival, setArrival] = useState('');
    const [departureDate, setDepartureDate] = useState<Date | null>(null);
    const [returnDate, setReturnDate] = useState<Date | null>(null);
    const [nonStop, setNonStop] = useState(false);
    const navigate = useNavigate();

    const handleSearch = () => {
        // Perform validation and API call here
        navigate('/results');
    };

    return (
        <Container maxWidth="sm" sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh' }}>
            <Box sx={{ mt: 4 }}>
                <Typography variant="h4" gutterBottom>
                    Flight Search
                </Typography>
                <Grid container spacing={2}>
                    <Grid item xs={12}>
                        <TextField
                            fullWidth
                            label="Departure Airport"
                            value={departure}
                            onChange={(e) => setDeparture(e.target.value)}
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField
                            fullWidth
                            label="Arrival Airport"
                            value={arrival}
                            onChange={(e) => setArrival(e.target.value)}
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <LocalizationProvider dateAdapter={AdapterDateFns}>
                            <DatePicker
                                label="Departure Date"
                                value={departureDate}
                                onChange={(newValue) => setDepartureDate(newValue)}
                            //renderInput={(params) => <TextField {...params} fullWidth />}
                            />
                        </LocalizationProvider>
                    </Grid>
                    <Grid item xs={12}>
                        <LocalizationProvider dateAdapter={AdapterDateFns}>
                            <DatePicker
                                label="Return Date"
                                value={returnDate}
                                onChange={(newValue) => setReturnDate(newValue)}
                            //renderInput={(params) => <TextField {...params} fullWidth />}
                            />
                        </LocalizationProvider>
                    </Grid>
                    <Grid item xs={12}>
                        <FormControlLabel
                            control={
                                <Checkbox
                                    checked={nonStop}
                                    onChange={(e) => setNonStop(e.target.checked)}
                                />
                            }
                            label="Non-stop"
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <Button variant="contained" color="primary" fullWidth onClick={handleSearch}>
                            Search
                        </Button>
                    </Grid>
                </Grid>
            </Box>
        </Container>
    );
};

export default FlightSearch;