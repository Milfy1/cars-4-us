package elm.cars4us.repository;

import elm.cars4us.entity.CarShowroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarShowroomRepository extends JpaRepository<CarShowroom, UUID> {

}
