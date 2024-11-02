package elm.cars4us.service;

import elm.cars4us.dto.CarDTO;
import elm.cars4us.dto.ReturnedCarDTO;
import elm.cars4us.entity.Car;
import elm.cars4us.entity.CarShowroom;
import elm.cars4us.exceptions.NotFoundException;
import elm.cars4us.mapper.CarMapper;
import elm.cars4us.repository.CarRepository;
import elm.cars4us.repository.CarShowroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static elm.cars4us.constants.Constants.Exceptions.*;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

private final CarRepository carRepository;
private final CarShowroomRepository carShowroomRepository;
private final CarMapper carMapper;
    @Override
    public CarDTO createCar(CarDTO carDTO) {
       carShowroomRepository.findByActiveAndId(true,carDTO.getCarShowroomId())
               .orElseThrow(() -> new NotFoundException(CAR_SHOWROOM_WITH_ID + carDTO.getCarShowroomId() + NOT_FOUND));

        Car car = carMapper.map(carDTO);
        return carMapper.map(carRepository.save(car));
    }

    @Override
    public Page<ReturnedCarDTO> findAllCars(Pageable pageable, String vin, String maker, String model, Integer modelYear, BigDecimal price, String carShowroomName, String contactNumber) {
        return carRepository.getCarsWithFilters(pageable,vin,maker,model,modelYear,price,carShowroomName,contactNumber);
    }




}