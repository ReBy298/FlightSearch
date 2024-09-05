import React, { useEffect, useState } from 'react';
import { Container, Box, Typography, Grid, TextField, FormControlLabel, Checkbox, Button, MenuItem, Select, InputLabel, FormControl, Autocomplete } from '@mui/material';
import { LocalizationProvider, DatePicker } from '@mui/x-date-pickers';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { useNavigate } from 'react-router-dom';

const FlightSearch: React.FC = () => {
    const [departure, setDeparture] = useState('');
    const [arrival, setArrival] = useState('');
    const [departureDate, setDepartureDate] = useState<Date | null>(new Date());
    const [options, setOptions] = useState<string[]>([]);
    const [returnDate, setReturnDate] = useState<Date | null>(null);
    const [nonStop, setNonStop] = useState(false);
    const [currency, setCurrency] = useState('USD');
    const [iataCodes, setIataCodes] = useState<any[]>([]);
    const [keyword, setKeyword] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        if (keyword) {
            handleIataCodeSearch(keyword);
        }
    }, [keyword]);

    useEffect(() => {
        // Map `iataCodes` to a list of `iataCode` strings for options
        const newOptions = iataCodes.map((option: any) => option.iataCode);
        setOptions(newOptions);
    }, [iataCodes]);


    const handleIataCodeSearch = async (keyword: any) => {
        const url = `http://localhost:9090/api/flights/iata-codes?keyword=${keyword}`;

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
            setIataCodes(data);
        } catch (error) {
            console.error('Error fetching IATA codes:', error);
        }
    };

    const handleSearch = async () => {

        if (!departure || !arrival || !departureDate || !currency) {
            alert('Please fill in all required fields.');
            return;
        }
        const formattedDepartureDate = departureDate ? departureDate.toISOString().split('T')[0] : '';
        const formattedReturnDate = returnDate ? returnDate.toISOString().split('T')[0] : '';

        const url = `http://localhost:9090/api/flights/search?origin=${departure}&destination=${arrival}&departureDate=${formattedDepartureDate}&returnDate=${formattedReturnDate}&adults=1&nonStop=${nonStop}&max=3&currency=${currency}`;

        try {
            const response = await fetch(url,
                {
                    credentials: 'include',
                    mode: 'cors',
                    method: 'GET',
                    headers: {
                        "Content-Type": "application/json",
                        'Access-Control-Allow-Origin': 'http://localhost:3000',
                        "Access-Control-Allow-Methods": "DELETE, POST, GET, OPTIONS",
                        "Access-Control-Allow-Headers": "Content-Type, Authorization, X-Requested-With"
                    }
                }

            );
            const data = await response.json();

            // Añadir el campo currency a cada vuelo
            const flightsWithCurrency = data.map((flight: any) => ({
                ...flight,
                currency: currency
            }));

            console.log(flightsWithCurrency);
            // Navegar a la página de resultados con los datos obtenidos
            navigate('/results', {
                state: {
                    flights: flightsWithCurrency,
                    departure,
                    arrival,
                    departureDate: formattedDepartureDate,
                    returnDate: formattedReturnDate,
                    nonStop,
                    currency
                }
            });
        } catch (error) {
            console.error('Error fetching flight data:', error);
        }
    };

    return (
        <Container maxWidth="sm" sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh' }}>
            <Box sx={{ mt: 4 }}>
                <Typography variant="h4" gutterBottom>
                    Flight Search
                </Typography>
                <Grid container spacing={2}>
                    <Grid item xs={12}>
                        <Autocomplete
                            freeSolo
                            options={options} // Use the mapped options here
                            value={departure}
                            onInputChange={(event, newInputValue) => {
                                setDeparture(newInputValue);
                                setKeyword(newInputValue);
                            }}
                            renderInput={(params) => (
                                <TextField
                                    {...params}
                                    label="Departure Airport"
                                    variant="standard"
                                    fullWidth
                                />
                            )}
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <Autocomplete
                            freeSolo
                            options={options} // Use the mapped options here
                            value={arrival}
                            onInputChange={(event, newInputValue) => {
                                setArrival(newInputValue);
                                setKeyword(newInputValue);
                            }}
                            renderInput={(params) => (
                                <TextField
                                    {...params}
                                    label="Arrival Airport"
                                    variant="standard"
                                    fullWidth
                                />
                            )}
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <LocalizationProvider dateAdapter={AdapterDateFns}>
                            <DatePicker
                                label="Departure Date"
                                value={departureDate}
                                onChange={(newValue: Date | null) => setDepartureDate(newValue)}
                                minDate={new Date()}
                            />
                        </LocalizationProvider>
                    </Grid>
                    <Grid item xs={12}>
                        <LocalizationProvider dateAdapter={AdapterDateFns}>
                            <DatePicker
                                label="Return Date"
                                value={returnDate}
                                onChange={(newValue: Date | null) => setReturnDate(newValue)}
                                shouldDisableDate={(date) => {
                                    if (!departureDate) return false;
                                    return date < departureDate;
                                }}
                            />
                        </LocalizationProvider>
                    </Grid>
                    <Grid item xs={12}>
                        <FormControl fullWidth>
                            <InputLabel id="currency-label">Currency</InputLabel>
                            <Select
                                labelId="currency-label"
                                value={currency}
                                onChange={(e) => setCurrency(e.target.value)}
                                label="Currency"
                            >
                                <MenuItem value="USD">USD</MenuItem>
                                <MenuItem value="MXN">MXN</MenuItem>
                                <MenuItem value="EUR">EUR</MenuItem>

                            </Select>
                        </FormControl>
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