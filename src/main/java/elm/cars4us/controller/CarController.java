package elm.cars4us.controller;

import elm.cars4us.dto.CarDTO;
import elm.cars4us.dto.ReturnedCarDTO;
import elm.cars4us.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static elm.cars4us.constants.Constants.URL.*;

@RestController
@RequestMapping(BASE_URL+CAR_CONTROLLER)
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping(CREATE)
    public ResponseEntity<CarDTO> createCarShowroom(@Validated @RequestBody CarDTO carDTO){
        CarDTO createdCar = carService.createCar(carDTO);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<Page<ReturnedCarDTO>> findAllCars(@RequestParam int offset,
                                                            @RequestParam int pageSize,
                                                            @RequestParam(required = false) String vin,
                                                            @RequestParam(required = false) String maker,
                                                            @RequestParam(required = false) String model,
                                                            @RequestParam(required = false) Integer modelYear,
                                                            @RequestParam(required = false) BigDecimal price,
                                                            @RequestParam(required = false) String carShowroomName,
                                                            @RequestParam(required = false) String contactNumber

    ){
        Pageable pageable =  PageRequest.of(offset,pageSize);
        Page<ReturnedCarDTO> allCars = carService.findAllCars(pageable,vin,maker,model,modelYear,price,carShowroomName,contactNumber);
        return new ResponseEntity<>(allCars, HttpStatus.OK);
    }

}
