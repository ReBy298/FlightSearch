package com.flight_search.controller;

import com.flight_search.dto.FlightDTO;
import com.flight_search.dto.IataCodeDTO;
import com.flight_search.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

public class FlightControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
    }

    @Test
    public void testSearchFlights() throws Exception {
        FlightDTO flight1 = new FlightDTO();
        FlightDTO flight2 = new FlightDTO();
        List<FlightDTO> flights = Arrays.asList(flight1, flight2);

        when(flightService.getFlights("NYC", "LAX", "2024-09-10", "2024-09-20", 1, 10, "USD", true, null, null))
                .thenReturn(flights);

        mockMvc.perform(get("/api/flights/search")
                .param("origin", "NYC")
                .param("destination", "LAX")
                .param("departureDate", "2024-09-10")
                .param("returnDate", "2024-09-20")
                .param("adults", "1")
                .param("nonStop", "true")
                .param("max", "10")
                .param("currency", "USD"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testSearchIataCodes() throws Exception {
        IataCodeDTO code1 = new IataCodeDTO();
        IataCodeDTO code2 = new IataCodeDTO();
        List<IataCodeDTO> codes = Arrays.asList(code1, code2);

        when(flightService.getIataCodes("keyword")).thenReturn(codes);

        mockMvc.perform(get("/api/flights/iata-codes")
                .param("keyword", "keyword"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}
