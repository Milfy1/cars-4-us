package elm.cars4us.dto;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnedCarDTO {

    private String vin;

    private String maker;

    private String model;

    private Integer modelYear;

    private BigDecimal price;

    private String carShowroomName;

    private String contactNumber;


}
