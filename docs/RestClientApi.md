# RestClientApi

All URIs are relative to *https://api.mercadolibre.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**resourceDelete**](RestClientApi.md#resourceDelete) | **DELETE** /{resource} | Resource path DELETE
[**resourceGet**](RestClientApi.md#resourceGet) | **GET** /{resource} | Resource path GET
[**resourcePost**](RestClientApi.md#resourcePost) | **POST** /{resource} | Resourse path POST
[**resourcePut**](RestClientApi.md#resourcePut) | **PUT** /{resource} | Resourse path PUT


<a name="resourceDelete"></a>
# **resourceDelete**
> Object resourceDelete(resource, accessToken)

Resource path DELETE

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
      Object result = apiInstance.resourceDelete(resource, accessToken);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RestClientApi#resourceDelete");
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

<a name="resourceGet"></a>
# **resourceGet**
> Object resourceGet(resource, accessToken)

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | **String**|  |
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

<a name="resourcePost"></a>
# **resourcePost**
> Object resourcePost(resource, accessToken, body)

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
      Object result = apiInstance.resourcePost(resource, accessToken, body);
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

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | **String**|  |
 **accessToken** | **String**|  |
 **body** | **Object**|  |

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

<a name="resourcePut"></a>
# **resourcePut**
> Object resourcePut(resource, accessToken, body)

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
      Object result = apiInstance.resourcePut(resource, accessToken, body);
      System.out.println(result);
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

