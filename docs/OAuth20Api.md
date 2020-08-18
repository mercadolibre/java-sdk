# OAuth20Api

All URIs are relative to *https://api.mercadolibre.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**auth**](OAuth20Api.md#auth) | **GET** /authorization | Authentication Endpoint
[**getToken**](OAuth20Api.md#getToken) | **POST** /oauth/token | Request Access Token


<a name="auth"></a>
# **auth**
> auth(responseType, clientId, redirectUri)

Authentication Endpoint

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.OAuth20Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    OAuth20Api apiInstance = new OAuth20Api(defaultClient);
    String responseType = "code"; // String | 
    String clientId = "clientId_example"; // String | 
    String redirectUri = "redirectUri_example"; // String | 
    try {
      apiInstance.auth(responseType, clientId, redirectUri);
    } catch (ApiException e) {
      System.err.println("Exception when calling OAuth20Api#auth");
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
 **responseType** | **String**|  | [default to code] [enum: code]
 **clientId** | **String**|  |
 **redirectUri** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**302** | Successful operation |  -  |

<a name="getToken"></a>
# **getToken**
> Object getToken(grantType, clientId, clientSecret, redirectUri, code, refreshToken)

Request Access Token

Partner makes a request to the token endpoint by adding the following parameters described below

### Example
```java
// Import classes:
import meli.ApiClient;
import meli.ApiException;
import meli.Configuration;
import meli.models.*;
import meli_marketplace_lib.OAuth20Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mercadolibre.com");

    OAuth20Api apiInstance = new OAuth20Api(defaultClient);
    String grantType = "grantType_example"; // String | 
    String clientId = "clientId_example"; // String | 
    String clientSecret = "clientSecret_example"; // String | 
    String redirectUri = "redirectUri_example"; // String | 
    String code = "code_example"; // String | 
    String refreshToken = "refreshToken_example"; // String | 
    try {
      Object result = apiInstance.getToken(grantType, clientId, clientSecret, redirectUri, code, refreshToken);
      System.out.println(result);
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

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **grantType** | **String**|  | [optional]
 **clientId** | **String**|  | [optional]
 **clientSecret** | **String**|  | [optional]
 **redirectUri** | **String**|  | [optional]
 **code** | **String**|  | [optional]
 **refreshToken** | **String**|  | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A User object |  -  |

