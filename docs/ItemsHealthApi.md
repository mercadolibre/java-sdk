# ItemsHealthApi

All URIs are relative to *https://api.mercadolibre.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**itemsIdHealthActionsGet**](ItemsHealthApi.md#itemsIdHealthActionsGet) | **GET** /items/{id}/health/actions | Return item health actions by id.
[**itemsIdHealthGet**](ItemsHealthApi.md#itemsIdHealthGet) | **GET** /items/{id}/health | Return health by id.
[**sitesSiteIdHealthLevelsGet**](ItemsHealthApi.md#sitesSiteIdHealthLevelsGet) | **GET** /sites/{site_id}/health_levels | Return health levels.


<a name="itemsIdHealthActionsGet"></a>
# **itemsIdHealthActionsGet**
> Object itemsIdHealthActionsGet(id, accessToken)

Return item health actions by id.

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.ItemsHealthApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    ItemsHealthApi apiInstance = new ItemsHealthApi(defaultClient);
    String id = "id_example"; // String | 
    String accessToken = "accessToken_example"; // String | 
    try {
      Object result = apiInstance.itemsIdHealthActionsGet(id, accessToken);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ItemsHealthApi#itemsIdHealthActionsGet");
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

<a name="itemsIdHealthGet"></a>
# **itemsIdHealthGet**
> Object itemsIdHealthGet(id, accessToken)

Return health by id.

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.ItemsHealthApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    ItemsHealthApi apiInstance = new ItemsHealthApi(defaultClient);
    String id = "id_example"; // String | 
    String accessToken = "accessToken_example"; // String | 
    try {
      Object result = apiInstance.itemsIdHealthGet(id, accessToken);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ItemsHealthApi#itemsIdHealthGet");
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

<a name="sitesSiteIdHealthLevelsGet"></a>
# **sitesSiteIdHealthLevelsGet**
> Object sitesSiteIdHealthLevelsGet(siteId)

Return health levels.

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.ItemsHealthApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    ItemsHealthApi apiInstance = new ItemsHealthApi(defaultClient);
    String siteId = "siteId_example"; // String | 
    try {
      Object result = apiInstance.sitesSiteIdHealthLevelsGet(siteId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ItemsHealthApi#sitesSiteIdHealthLevelsGet");
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
 **siteId** | **String**|  |

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

