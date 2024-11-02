package elm.cars4us.constants;

public final class Constants {
    private Constants() {
    }

    public static class URL {
        public static final String BASE_URL = "/api/v1/cars4us";

        public static final String CAR_SHOWROOM = "/car-showroom";
        public static final String CREATE = "/create";
        public static final String GET_ALL = "/get-all";
        public static final String COMMERCIAL_REGISTRATION_NUMBER = "/{commercialRegistrationNumber}";
        public static final String UPDATE = "/update";
        public static final String GET = "/get";
        public static final String DELETE = "/delete";
    }
    public static class Name {
        public static final String SPRING = "spring";
        public static final String DESC = "desc";
        public static final String SWAGGER_TITLE = "Cars4us";
        public static final String SWAGGER_VERSION = "1.0";
        public static final String SWAGGER_DESCRIPTION = "Cars for us Apis.";
    }
    public static class Exceptions {
        public static final String CAR_SHOWROOM_WITH_ID = "CarShowroom with Commercial Registration Number ";
        public static final String NOT_FOUND = " not found";
    }




    }
