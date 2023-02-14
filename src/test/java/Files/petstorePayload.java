package Files;

public class petstorePayload {

    public static String createAddNewPetBody() {
        return "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 4,\n" +
                "    \"name\": \"Pig\"\n" +
                "  },\n" +
                "  \"name\": \"Pinky\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"sold\"\n" +
                "}";
    }

    public static String createUserBody(){
        return "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"Pera\",\n" +
                "  \"firstName\": \"Petar\",\n" +
                "  \"lastName\": \"Petrovic\",\n" +
                "  \"email\": \"ppetrovic@gmail.com\",\n" +
                "  \"password\": \"Petrovic1@\",\n" +
                "  \"phone\": \"676819\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
    }

    public static String updateUserBody(){
        return "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"Pera\",\n" +
                "  \"firstName\": \"Petar.D\",\n" +
                "  \"lastName\": \"Petrovic\",\n" +
                "  \"email\": \"ppetrovic@gmail.com\",\n" +
                "  \"password\": \"Petrovic1@\",\n" +
                "  \"phone\": \"1779484\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
    }

}
