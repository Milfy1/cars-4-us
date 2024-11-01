package elm.cars4us;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static elm.cars4us.constants.Constants.Name.*;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = SWAGGER_TITLE, version = SWAGGER_VERSION, description = SWAGGER_DESCRIPTION))
public class Cars4usApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cars4usApplication.class, args);
	}

}
