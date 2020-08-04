# ItemsApi

All URIs are relative to *https://api.mercadolibre.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**itemsIdGet**](ItemsApi.md#itemsIdGet) | **GET** /items/{id} | Return a Item.
[**itemsIdPut**](ItemsApi.md#itemsIdPut) | **PUT** /items/{id} | Update a Item.
[**itemsPost**](ItemsApi.md#itemsPost) | **POST** /items | Create a Item.


<a name="itemsIdGet"></a>
# **itemsIdGet**
> itemsIdGet(id)

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
      apiInstance.itemsIdGet(id);
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

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Ok |  -  |

<a name="itemsIdPut"></a>
# **itemsIdPut**
> itemsIdPut(id, accessToken, item)

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
      apiInstance.itemsIdPut(id, accessToken, item);
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

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Ok |  -  |

<a name="itemsPost"></a>
# **itemsPost**
> itemsPost(accessToken, item)

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
      apiInstance.itemsPost(accessToken, item);
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

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Ok |  -  |

