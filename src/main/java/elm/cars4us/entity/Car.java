package elm.cars4us.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car {

    @Id
    @Column(nullable = false, updatable = false)
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    protected UUID id;

    @Column(length = 25, nullable = false)
    private String vin;

    @Column(length = 25, nullable = false)
    private String maker;

    @Column(length = 25, nullable = false)
    private String model;

    @Column(length = 4, nullable = false)
    private Integer modelYear;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "car_showroom_id", nullable = false)
    private CarShowroom carShowroom;

}
