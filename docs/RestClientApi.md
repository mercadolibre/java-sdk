# RestClientApi

All URIs are relative to *https://api.mercadolibre.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**resourceGet**](RestClientApi.md#resourceGet) | **GET** /{resource} | Resource path GET
[**resourcePost**](RestClientApi.md#resourcePost) | **POST** /{resource} | Resourse path POST
[**resourcePut**](RestClientApi.md#resourcePut) | **PUT** /{resource} | Resourse path PUT


<a name="resourceGet"></a>
# **resourceGet**
> resourceGet(resource, accessToken)

Resource path GET

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.RestClientApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    RestClientApi apiInstance = new RestClientApi(defaultClient);
    String resource = "resource_example"; // String | 
    String accessToken = "accessToken_example"; // String | 
    try {
      apiInstance.resourceGet(resource, accessToken);
    } catch (ApiException e) {
      System.err.println("Exception when calling RestClientApi#resourceGet");
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
 **resource** | **String**|  |
 **accessToken** | **String**|  |

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

<a name="resourcePost"></a>
# **resourcePost**
> resourcePost(resource, accessToken, body)

Resourse path POST

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.RestClientApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    RestClientApi apiInstance = new RestClientApi(defaultClient);
    String resource = "resource_example"; // String | 
    String accessToken = "accessToken_example"; // String | 
    Object body = null; // Object | 
    try {
      apiInstance.resourcePost(resource, accessToken, body);
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

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | **String**|  |
 **accessToken** | **String**|  |
 **body** | **Object**|  |

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
**200** | Ok |  -  |

<a name="resourcePut"></a>
# **resourcePut**
> resourcePut(resource, accessToken, body)

Resourse path PUT

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.RestClientApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    RestClientApi apiInstance = new RestClientApi(defaultClient);
    String resource = "resource_example"; // String | 
    String accessToken = "accessToken_example"; // String | 
    Object body = null; // Object | 
    try {
      apiInstance.resourcePut(resource, accessToken, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling RestClientApi#resourcePut");
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
 **resource** | **String**|  |
 **accessToken** | **String**|  |
 **body** | **Object**|  |

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
**200** | Ok |  -  |

