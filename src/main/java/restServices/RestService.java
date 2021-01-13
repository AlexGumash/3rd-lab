package restServices;

public class RestService {
    protected boolean isUserAuthenticated(String authString){

        String decodedAuth = "";

        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];

        //Base64 encoded login and password
        return authInfo.equals("YWRtaW46cGFzc3dvcmQ=");
    }
}
