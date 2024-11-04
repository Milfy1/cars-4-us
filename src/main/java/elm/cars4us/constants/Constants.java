package elm.cars4us.constants;

public final class Constants {
    private Constants() {
    }

    public static class URL {
        public static final String BASE_URL = "/api/v1";
        public static final String CAR_CONTROLLER = "/cars";
        public static final String CAR_SHOWROOM_CONTROLLER = "/car-showrooms";
        public static final String COMMERCIAL_REGISTRATION_NUMBER = "/{commercialRegistrationNumber}";
    }
    public static class Name {
        public static final String SPRING = "spring";
        public static final String DESC = "desc";
        public static final String SWAGGER_TITLE = "Cars4us";
        public static final String SWAGGER_VERSION = "1.0";
        public static final String SWAGGER_DESCRIPTION = "Cars for us Apis.";
    }
    public static class Exceptions {
        public static final String CAR_SHOWROOM_WITH_COMMERCIAL_REGISTRATION_NUMBER = "CarShowroom with Commercial Registration Number ";
        public static final String CAR_SHOWROOM_WITH_ID = "CarShowroom with ID ";
        public static final String NOT_FOUND = " not found";
    }




    }
