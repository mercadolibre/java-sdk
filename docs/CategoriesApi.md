# CategoriesApi

All URIs are relative to *https://api.mercadolibre.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**categoriesCategoryIdGet**](CategoriesApi.md#categoriesCategoryIdGet) | **GET** /categories/{category_id} | Return by category.
[**sitesSiteIdCategoriesGet**](CategoriesApi.md#sitesSiteIdCategoriesGet) | **GET** /sites/{site_id}/categories | Return a categories by site.
[**sitesSiteIdDomainDiscoverySearchGet**](CategoriesApi.md#sitesSiteIdDomainDiscoverySearchGet) | **GET** /sites/{site_id}/domain_discovery/search | Predictor


<a name="categoriesCategoryIdGet"></a>
# **categoriesCategoryIdGet**
> categoriesCategoryIdGet(categoryId)

Return by category.

### Example
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

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **categoryId** | **String**|  |

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

<a name="sitesSiteIdCategoriesGet"></a>
# **sitesSiteIdCategoriesGet**
> sitesSiteIdCategoriesGet(siteId)

Return a categories by site.

### Example
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
    String siteId = "siteId_example"; // String | 
    try {
      apiInstance.sitesSiteIdCategoriesGet(siteId);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoriesApi#sitesSiteIdCategoriesGet");
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

<a name="sitesSiteIdDomainDiscoverySearchGet"></a>
# **sitesSiteIdDomainDiscoverySearchGet**
> sitesSiteIdDomainDiscoverySearchGet(siteId, q, limit)

Predictor

### Example
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
    String siteId = "siteId_example"; // String | 
    String q = "q_example"; // String | 
    String limit = "limit_example"; // String | 
    try {
      apiInstance.sitesSiteIdDomainDiscoverySearchGet(siteId, q, limit);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoriesApi#sitesSiteIdDomainDiscoverySearchGet");
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
 **q** | **String**|  |
 **limit** | **String**|  |

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

