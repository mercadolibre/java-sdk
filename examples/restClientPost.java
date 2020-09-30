import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.model.*;
import meli_marketplace_lib.RestClientApi;

import java.util.ArrayList;
import java.util.List;

public class restClientPost {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    RestClientApi apiInstance = new RestClientApi(defaultClient);
    String resource = "items"; //  resource like items, search, category etc
    String accessToken = "access_token_example"; // Your access token 
    
    // Example to post an item in Argentina
    List<ItemPictures> pictures = new ArrayList<ItemPictures>();
    String source =	"https://http2.mlstatic.com/storage/developers-site-cms-admin/openapi/319968615067-mp3.jpg";
    pictures.add(new ItemPictures().source(source));

      List<AttributesValues> attrValues = new ArrayList<AttributesValues>();
      attrValues.add(new AttributesValues().name("8 GB"));
      List<Attributes> attributes = new ArrayList<Attributes>();
      attributes.add(new Attributes()
          .id("DATA_STORAGE_CAPACITY")
          .name("Capacidad de almacenamiento de datos")
          .valueName("8 GB")
          .values(attrValues)
          .attributeGroupName("Otros")
          .attributeGroupId("OTHERS"));
      
    Item item = new Item();
    item.title("Item de test - No Ofertar");
    item.categoryId("MLA5991");
    item.price(350);
    item.currencyId("ARS");
    item.availableQuantity("12");
    item.buyingMode("buy_it_now");
    item.listingTypeId("bronze");
    item.condition("new");
    item.description("Item de Teste. Mercado Livre SDK");
    item.videoId("RXWn6kftTHY");
    item.pictures(pictures);
    item.attributes(attributes);
    try {
      Object result = apiInstance.resourcePost(resource, accessToken, item);
      System.out.println(result);
      } catch (ApiException e) {
        System.err.println("Exception when calling RestClientApi#resourcePost");
        System.err.println("Status code: " + e.getCode());
        System.err.println("Reason: " + e.getResponseBody());
        System.err.println("Response headers: " + e.getResponseHeaders());
        e.printStackTrace();
      }
	}
}