package elm.cars4us.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarShowroomSummaryDTO {
    private String name;
    private String commercialRegistrationNumber;
    private String contactNumber;
}
