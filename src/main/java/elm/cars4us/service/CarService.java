package elm.cars4us.service;

import elm.cars4us.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface CarService {

    CarDTO createCar(CarDTO carDTO);

    Page<ReturnedCarDTO> findAllCars(Pageable pageable, String vin, String maker, String model, Integer modelYear, BigDecimal price, String carShowroomName, String contactNumber);


}
