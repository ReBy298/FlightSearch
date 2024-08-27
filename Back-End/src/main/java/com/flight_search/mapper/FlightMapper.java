package com.flight_search.mapper;

import com.flight_search.dto.FlightDTO;
import com.flight_search.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    FlightDTO flightToFlightDTO(Flight flight);
    Flight flightDTOToFlight(FlightDTO flightDTO);
}
