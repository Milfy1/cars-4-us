package elm.cars4us.mapper;

import elm.cars4us.constants.Constants;
import elm.cars4us.dto.CarShowroomDTO;
import elm.cars4us.dto.CarShowroomSummaryDTO;
import elm.cars4us.dto.CarShowroomUpdateDTO;
import elm.cars4us.entity.CarShowroom;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

import static elm.cars4us.constants.Constants.Name.SPRING;


@Mapper(componentModel = SPRING)
public interface CarShowroomMapper {
    CarShowroomMapper mapper = Mappers.getMapper(CarShowroomMapper.class);
     CarShowroom map(CarShowroomDTO carShowroomDTO);
     CarShowroomSummaryDTO mapToSummaryDto(CarShowroom carShowroom);
     CarShowroomDTO map(CarShowroom carShowroom);
     List<CarShowroomDTO> map(Page<CarShowroom> carShowroom);
}
