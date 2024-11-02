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
            "WHERE (:vin IS NULL OR LOWER(c.vin) LIKE LOWER(CONCAT('%', :vin, '%'))) " +
            "AND (:maker IS NULL OR LOWER(c.maker) LIKE LOWER(CONCAT('%', :maker, '%'))) " +
            "AND (:model IS NULL OR LOWER(c.model) LIKE LOWER(CONCAT('%', :model, '%'))) " +
            "AND (:modelYear IS NULL OR c.modelYear = :modelYear) " +
            "AND (:price IS NULL OR c.price = :price) " +
            "AND (:carShowroomName IS NULL OR LOWER(c.carShowroom.name) LIKE LOWER(CONCAT('%', :carShowroomName, '%'))) " +
            "AND (:contactNumber IS NULL OR LOWER(c.carShowroom.contactNumber) LIKE LOWER(CONCAT('%', :contactNumber, '%')))")
    Page<ReturnedCarDTO> getCarsWithFilters(Pageable pageable,
                                            @Param("vin") String vin,
                                            @Param("maker") String maker,
                                            @Param("model") String model,
                                            @Param("modelYear") Integer modelYear,
                                            @Param("price") BigDecimal price,
                                            @Param("carShowroomName") String carShowroomName,
                                            @Param("contactNumber") String contactNumber);
}
