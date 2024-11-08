package elm.cars4us.repository;

import elm.cars4us.dto.ReturnedCarDTO;
import elm.cars4us.entity.Car;
import elm.cars4us.entity.CarShowroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    @Query("SELECT new elm.cars4us.dto.ReturnedCarDTO(c.vin, c.maker, c.model, c.modelYear, c.price, c.carShowroom.name, c.carShowroom.contactNumber) " +
            "FROM Car c " +
            "WHERE (:vin IS NULL OR c.vin LIKE %:vin%) " +
            "AND (:maker IS NULL OR c.maker LIKE %:maker% ) " +
            "AND (:model IS NULL OR c.model LIKE %:model%) " +
            "AND (:modelYear IS NULL OR c.modelYear = :modelYear) " +
            "AND (:price IS NULL OR c.price = :price) " +
            "AND (:carShowroomName IS NULL OR c.carShowroom.name LIKE %:carShowroomName%) " +
            "AND (:contactNumber IS NULL OR c.carShowroom.contactNumber LIKE %:contactNumber%)")
    Page<ReturnedCarDTO> getCarsWithFilters(Pageable pageable,
                                            @Param("vin") String vin,
                                            @Param("maker") String maker,
                                            @Param("model") String model,
                                            @Param("modelYear") Integer modelYear,
                                            @Param("price") BigDecimal price,
                                            @Param("carShowroomName") String carShowroomName,
                                            @Param("contactNumber") String contactNumber);
}
