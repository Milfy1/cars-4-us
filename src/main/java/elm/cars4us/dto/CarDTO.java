package elm.cars4us.dto;


import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {


    @NotBlank(message = "VIN is required")
    @Size(max = 25, message = "VIN must be at most 25 characters")
    private String vin;

    @NotBlank(message = "Maker is required")
    @Size(max = 25, message = "Maker must be at most 25 characters")
    private String maker;

    @NotBlank(message = "Model is required")
    @Size(max = 25, message = "Model must be at most 25 characters")
    private String model;

    @NotNull(message = "Model year is required")
    @Digits(integer = 4, fraction = 0, message = "Model year must be a 4-digit number")
    private Integer modelYear;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", message = "Price must be a positive value")
    private BigDecimal price;

    @NotNull(message = "Car showroom ID is required")
    private UUID carShowroomId;


}
