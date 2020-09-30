//Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli_marketplace_lib.OAuth20Api;

public class getToken {
  public static void main(String[] args) {
  ApiClient defaultClient = Configuration.getDefaultApiClient();
  defaultClient.setBasePath("https://api.mercadolibre.com");

  OAuth20Api apiInstance = new OAuth20Api(defaultClient);
  String grantType = "authorization_code"; // or 'refresh_token' if you need get one new token
  String clientId = "client_id_example"; // Your client_id
  String clientSecret = "client_secret_example"; // Your client_secret 
  String redirectUri = "redirect_uri_example"; // Your redirect_uri
  String code = "code_example"; // The parameter CODE, empty if your send a refresh_token 
  String refreshToken = ""; // Your refresh_token 
    try {
      Object response = apiInstance.getToken(grantType, clientId, clientSecret, redirectUri, code, refreshToken);
      System.out.println(response);
    } catch (ApiException e) {
      System.err.println("Exception when calling OAuth20Api#getToken");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}