
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

* `target/openapi-java-client-0.1.7.jar`
* `target/lib/*.jar`


## Usage

```java

// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.CategoriesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    CategoriesApi apiInstance = new CategoriesApi(defaultClient);
    String categoryId = "categoryId_example"; // String | 
    try {
      apiInstance.categoriesCategoryIdGet(categoryId);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoriesApi#categoriesCategoryIdGet");
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


#####  All docs for the library are located [here](https://github.com/mercadolibre/java-sdk/tree/master/docs)

#####  Check out our examples codes in the folder [examples](https://github.com/mercadolibre/java-sdk/tree/master/examples)

##### Don’t forget to check out our [developer site](https://developers.mercadolibre.com/)
