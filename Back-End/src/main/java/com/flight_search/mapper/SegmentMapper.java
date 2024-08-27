package com.flight_search.mapper;

import com.flight_search.dto.SegmentDTO;
import com.flight_search.model.Flight.Segment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SegmentMapper {
    SegmentMapper INSTANCE = Mappers.getMapper(SegmentMapper.class);

    SegmentDTO segmentToSegmentDTO(Segment segment);
    Segment segmentDTOToSegment(SegmentDTO segmentDTO);
}
