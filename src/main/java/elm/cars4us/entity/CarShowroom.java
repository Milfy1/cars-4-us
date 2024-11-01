package elm.cars4us.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_showroom")
public class CarShowroom {

    @Id
    @Column(nullable = false, updatable = false)
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    protected UUID id;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(unique = true, nullable = false, length = 10)
    @Pattern(regexp = "\\d{10}", message = "Commercial registration number must be exactly 10 digits")
    private String commercialRegistrationNumber;

    @Column(length = 100)
    private String managerName;

    @Column(nullable = false, length = 15)
    private String contactNumber;

    @Column(length = 255) // this is the default length
    private String address;

    @Column(nullable = false)
    private boolean active = true;
}
