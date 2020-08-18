# ItemsApi

All URIs are relative to *https://api.mercadolibre.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**itemsIdGet**](ItemsApi.md#itemsIdGet) | **GET** /items/{id} | Return a Item.
[**itemsIdPut**](ItemsApi.md#itemsIdPut) | **PUT** /items/{id} | Update a Item.
[**itemsPost**](ItemsApi.md#itemsPost) | **POST** /items | Create a Item.


<a name="itemsIdGet"></a>
# **itemsIdGet**
> Object itemsIdGet(id)

Return a Item.

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.ItemsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    ItemsApi apiInstance = new ItemsApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      Object result = apiInstance.itemsIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ItemsApi#itemsIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |

<a name="itemsIdPut"></a>
# **itemsIdPut**
> Object itemsIdPut(id, accessToken, item)

Update a Item.

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.ItemsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    ItemsApi apiInstance = new ItemsApi(defaultClient);
    String id = "id_example"; // String | 
    String accessToken = "accessToken_example"; // String | 
    Item item = new Item(); // Item | 
    try {
      Object result = apiInstance.itemsIdPut(id, accessToken, item);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ItemsApi#itemsIdPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **accessToken** | **String**|  |
 **item** | [**Item**](Item.md)|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |

<a name="itemsPost"></a>
# **itemsPost**
> Object itemsPost(accessToken, item)

Create a Item.

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.ItemsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    ItemsApi apiInstance = new ItemsApi(defaultClient);
    String accessToken = "accessToken_example"; // String | 
    Item item = new Item(); // Item | 
    try {
      Object result = apiInstance.itemsPost(accessToken, item);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ItemsApi#itemsPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**|  |
 **item** | [**Item**](Item.md)|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |

