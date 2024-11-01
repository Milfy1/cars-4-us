package elm.cars4us.service;

import elm.cars4us.dto.CarShowroomDTO;
import elm.cars4us.dto.CarShowroomSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarShowroomService {


    CarShowroomDTO createCarShowroom(CarShowroomDTO carShowroomDTO);

    Page<CarShowroomSummaryDTO> findAllCarShowrooms(Pageable pageable);
}
