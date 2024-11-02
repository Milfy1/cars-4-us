package elm.cars4us.controller;

import elm.cars4us.dto.CarShowroomDTO;
import elm.cars4us.dto.CarShowroomSummaryDTO;
import elm.cars4us.dto.CarShowroomUpdateDTO;
import elm.cars4us.service.CarShowroomService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static elm.cars4us.constants.Constants.Name.DESC;
import static elm.cars4us.constants.Constants.URL.*;

@RestController
@RequestMapping(BASE_URL+ CAR_SHOWROOM_CONTROLLER)
@Slf4j
@AllArgsConstructor
public class CarShowroomController {

    private final CarShowroomService carShowroomService;


    @PostMapping(CREATE)
    public ResponseEntity<CarShowroomDTO> createCarShowroom(@Validated @RequestBody CarShowroomDTO carShowroomDTO){
       CarShowroomDTO createdCarShowroom = carShowroomService.createCarShowroom(carShowroomDTO);
        return new ResponseEntity<>(createdCarShowroom, HttpStatus.CREATED);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<Page<CarShowroomSummaryDTO>> findAllCarShowrooms(@RequestParam int offset,
                                                                           @RequestParam int pageSize,
                                                                           @Parameter(description = "Field to sort by", example = "name",
                                                                            schema = @io.swagger.v3.oas.annotations.media.Schema(allowableValues = {"name", "commercialRegistrationNumber", "managerName"}))
                                                                        @RequestParam(defaultValue = "name") String sortField,
                                                                           @Parameter(description = "Sort direction", example = "asc",
                                                                            schema = @io.swagger.v3.oas.annotations.media.Schema(allowableValues = {"asc", "desc"}))
                                                                        @RequestParam(defaultValue = "asc") String sortDirection){
        Sort.Direction direction = sortDirection.equalsIgnoreCase(DESC) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable =  PageRequest.of(offset,pageSize,Sort.by(direction,sortField));
        Page<CarShowroomSummaryDTO> allCarShowrooms = carShowroomService.findAllCarShowrooms(pageable);
        return new ResponseEntity<>(allCarShowrooms, HttpStatus.OK);
    }

    //get by Commercial Registration Number
    @GetMapping(GET+COMMERCIAL_REGISTRATION_NUMBER)
    public ResponseEntity<CarShowroomDTO> updateCarShowroomByCommercialRegistrationNumber(@PathVariable String commercialRegistrationNumber){
        CarShowroomDTO carShowroom = carShowroomService.findByCommercialRegistrationNumber(commercialRegistrationNumber);
        return new ResponseEntity<>(carShowroom, HttpStatus.OK);
    }

    @PutMapping(UPDATE+COMMERCIAL_REGISTRATION_NUMBER)
    public ResponseEntity<CarShowroomDTO> findCarShowroomByCommercialRegistrationNumber(@PathVariable String commercialRegistrationNumber,@Validated @RequestBody CarShowroomUpdateDTO carShowroomUpdateDTO){
        CarShowroomDTO carShowroom = carShowroomService.updateCarShowroom(commercialRegistrationNumber,carShowroomUpdateDTO);
        return new ResponseEntity<>(carShowroom, HttpStatus.OK);
    }

    @DeleteMapping(DELETE+COMMERCIAL_REGISTRATION_NUMBER)
    public ResponseEntity<String> deleteCarShowroomByCommercialRegistrationNumber(@PathVariable String commercialRegistrationNumber){
       String response = carShowroomService.deleteCarShowroomByCommercialRegistrationNumber(commercialRegistrationNumber);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
