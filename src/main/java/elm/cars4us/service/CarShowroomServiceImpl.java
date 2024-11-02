package elm.cars4us.service;

import elm.cars4us.dto.CarShowroomDTO;
import elm.cars4us.dto.CarShowroomSummaryDTO;
import elm.cars4us.dto.CarShowroomUpdateDTO;
import elm.cars4us.entity.CarShowroom;
import elm.cars4us.exceptions.NotFoundException;
import elm.cars4us.mapper.CarShowroomMapper;
import elm.cars4us.repository.CarShowroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static elm.cars4us.constants.Constants.Exceptions.*;

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
        Page<CarShowroom> carShowrooms = carShowroomRepository.findAllByActive(true,pageable);
        return carShowrooms.map(carShowroomMapper::mapToSummaryDto);
    }

    @Override
    public CarShowroomDTO updateCarShowroom(String commercialRegistrationNumber, CarShowroomUpdateDTO carShowroomUpdateDTO) {
        CarShowroom carShowroom = carShowroomRepository.findByActiveAndCommercialRegistrationNumber(true,commercialRegistrationNumber)
                .orElseThrow(() -> new NotFoundException(CAR_SHOWROOM_WITH_COMMERCIAL_REGISTRATION_NUMBER + commercialRegistrationNumber + NOT_FOUND));

        carShowroom.setManagerName(Objects.nonNull(carShowroomUpdateDTO.getManagerName())? carShowroomUpdateDTO.getManagerName() : carShowroom.getManagerName());
        carShowroom.setAddress(Objects.nonNull(carShowroomUpdateDTO.getAddress())? carShowroomUpdateDTO.getAddress() : carShowroom.getAddress());
        carShowroom.setContactNumber(Objects.nonNull(carShowroomUpdateDTO.getContactNumber())? carShowroomUpdateDTO.getContactNumber() : carShowroom.getContactNumber());


         return carShowroomMapper.map(carShowroomRepository.save(carShowroom));
    }

    @Override
    public CarShowroomDTO findByCommercialRegistrationNumber(String commercialRegistrationNumber) {
        CarShowroom carShowroom = carShowroomRepository.findByActiveAndCommercialRegistrationNumber(true,commercialRegistrationNumber)
                 .orElseThrow(() -> new NotFoundException(CAR_SHOWROOM_WITH_COMMERCIAL_REGISTRATION_NUMBER + commercialRegistrationNumber + NOT_FOUND));
        return carShowroomMapper.map(carShowroom);
    }

    @Override
    public String deleteCarShowroomByCommercialRegistrationNumber(String commercialRegistrationNumber) {
        CarShowroom carShowroom = carShowroomRepository.findByCommercialRegistrationNumber(commercialRegistrationNumber)
                .orElseThrow(() -> new NotFoundException(CAR_SHOWROOM_WITH_COMMERCIAL_REGISTRATION_NUMBER + commercialRegistrationNumber + NOT_FOUND));
        // Check if CarShowroom is already inactive
        if (!carShowroom.isActive()) {
            return "CarShowroom with commercial registration number " + commercialRegistrationNumber + " is already inactive";
        }
        // Set active to false for soft delete
        carShowroom.setActive(false);
        carShowroomRepository.save(carShowroom);
        return "CarShowroom with commercial registration number " + commercialRegistrationNumber + " has been successfully deactivated"; }
    }


