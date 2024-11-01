package elm.cars4us.service;

import elm.cars4us.dto.CarShowroomDTO;
import elm.cars4us.dto.CarShowroomSummaryDTO;
import elm.cars4us.entity.CarShowroom;
import elm.cars4us.mapper.CarShowroomMapper;
import elm.cars4us.repository.CarShowroomRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarShowroomServiceImpl implements CarShowroomService {

    private final CarShowroomRepository carShowroomRepository;
    private final CarShowroomMapper carShowroomMapper;

    @Override
    public CarShowroomDTO createCarShowroom(CarShowroomDTO carShowroomDTO) {
        CarShowroom carShowroom = carShowroomMapper.map(carShowroomDTO);
        carShowroom = carShowroomRepository.save(carShowroom);
        return carShowroomMapper.map(carShowroom);
    }

    @Override
    public Page<CarShowroomSummaryDTO> findAllCarShowrooms(Pageable pageable) {
        Page<CarShowroom> carShowrooms = carShowroomRepository.findAll(pageable);
        return carShowrooms.map(carShowroomMapper::mapToSummaryDto);
    }

}
