package elm.cars4us.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarShowroomUpdateDTO {

    @Size(max = 100, message = "Manager name must be at most 100 characters")
    private String managerName;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "\\d{1,15}", message = "Contact number must contain only digits and be up to 15 digits long")
    private String contactNumber;

    @Size(max = 255, message = "Address must be at most 255 characters")
    private String address;

}
