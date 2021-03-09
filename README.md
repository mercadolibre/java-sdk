![No longer maintained](https://img.shields.io/badge/Maintenance-OFF-red.svg)

### [DEPRECATED] This repository is no longer maintained

> From the first week of April 2021 we will stop maintaining our SDKs.
>
> This project is not functional, the dependencies will not be updated to latest ones.
>
> We recommend you read our [documentation](https://developers.mercadolibre.com).

  <a href="https://developers.mercadolibre.com">
    <img src="https://user-images.githubusercontent.com/1153516/73021269-043c2d80-3e06-11ea-8d0e-6e91441c2900.png" alt="Mercado Libre Developers" width="200"></a>
  </a>

---

<br>
<h1 align="center">
  <a href="https://developers.mercadolibre.com">
    <img src="https://user-images.githubusercontent.com/1153516/29861072-689ec57e-8d3e-11e7-8368-dd923543258f.jpg" alt="Mercado Libre Developers" width="230"></a>
  </a>
  <br><br>
  MercadoLibre's JAVA SDK
  <br>
</h1>

<h4 align="center">This is the official JAVA SDK for MercadoLibre's Platform.</h4>

## Requirements

Building the API client library requires:

1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>0.1.7</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-java-client:0.1.7"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/openapi-java-client-0.1.7.jar`
- `target/lib/*.jar`

## Usage

```java
// Auth URLs Options by country

// 1:  "https://auth.mercadolibre.com.ar"
// 2:  "https://auth.mercadolivre.com.br"
// 3:  "https://auth.mercadolibre.com.co"
// 4:  "https://auth.mercadolibre.com.mx"
// 5:  "https://auth.mercadolibre.com.uy"
// 6:  "https://auth.mercadolibre.cl"
// 7:  "https://auth.mercadolibre.com.cr"
// 8:  "https://auth.mercadolibre.com.ec"
// 9:  "https://auth.mercadolibre.com.ve"
// 10: "https://auth.mercadolibre.com.pa"
// 11: "https://auth.mercadolibre.com.pe"
// 12: "https://auth.mercadolibre.com.do"
// 13: "https://auth.mercadolibre.com.bo"
// 14: "https://auth.mercadolibre.com.py"

// For example in your app, you can make some like this to get de auth
String clientId = "Your client_id"
String redirectUri = "Your redirect uri"
String url = "https://auth.mercadolibre.com.ar/authorization?response_type=code&client_id=" + clientId + "&redirect_uri=" + redirectUri + "";
System.out.println(url);

```

his will give you the url to redirect the user. You need to specify a callback url which will be the one that the user will redirected after a successfull authrization process.

Once the user is redirected to your callback url, you'll receive in the query string, a parameter named code. You'll need this for the second part of the process

## Examples for OAuth - get token

```java

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

```

## Example using the RestClient with a POST Item

```java

// Import classes:
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
    item.title("Item de test - No Ofertar java");
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

```

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Documentation & Important notes

##### The URIs are relative to https://api.mercadolibre.com

##### The Authorization URLs (set the correct country domain): https://auth.mercadolibre.{country_domain}

##### All docs for the library are located [here](https://github.com/mercadolibre/java-sdk/tree/master/docs)

##### Check out our examples codes in the folder [examples](https://github.com/mercadolibre/java-sdk/tree/master/examples)

##### Don’t forget to check out our [developer site](https://developers.mercadolibre.com/)
