// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli_marketplace_lib.RestClientApi;

public class restClientGet {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    RestClientApi apiInstance = new RestClientApi(defaultClient);
    String resource = "sites/MLA/categories"; // A resource example like items, search, category, etc
    String accessToken = "access_token_example"; // Your access token 
    
    try {
      Object result = apiInstance.resourceGet(resource, accessToken);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RestClientApi#resourceGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
	}
}