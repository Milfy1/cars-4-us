package elm.cars4us.utility;

import org.webjars.NotFoundException;

import java.util.Optional;

public final class Utility {
    private Utility() {
    }

    public static <T> T checkIfAvailable(Optional<T> optional, String entityName, Object identifier) {
        return optional.orElseThrow(() ->
                new NotFoundException(STR."\{entityName} with ID \{identifier} not found"));
    }
}