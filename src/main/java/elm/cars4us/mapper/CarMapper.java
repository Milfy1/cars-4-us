package elm.cars4us.mapper;

import elm.cars4us.dto.CarDTO;
import elm.cars4us.dto.CarShowroomDTO;
import elm.cars4us.dto.CarShowroomSummaryDTO;
import elm.cars4us.entity.Car;
import elm.cars4us.entity.CarShowroom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

import static elm.cars4us.constants.Constants.Name.SPRING;


@Mapper(componentModel = SPRING)
public interface CarMapper {
    CarMapper mapper = Mappers.getMapper(CarMapper.class);

    CarDTO map(Car car);

    @Mapping(source = "carShowroomId", target = "carShowroom", qualifiedByName = "mapCarShowroomIdToCarShowroom")
    Car map(CarDTO car);

    @Named("mapCarShowroomIdToCarShowroom")
    default CarShowroom mapCarShowroomIdToCarShowroom(UUID carShowroomId) {
        CarShowroom carShowroom = new CarShowroom();
        carShowroom.setId(carShowroomId);
        return carShowroom;
    }
}
