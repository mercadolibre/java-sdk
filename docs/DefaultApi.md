# DefaultApi

All URIs are relative to *https://api.mercadolibre.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**categoriesCategoryIdAttributesGet**](DefaultApi.md#categoriesCategoryIdAttributesGet) | **GET** /categories/{category_id}/attributes | Returns all attributes from a category.
[**categoriesCategoryIdGet**](DefaultApi.md#categoriesCategoryIdGet) | **GET** /categories/{category_id} | Returns information about a category.
[**itemsItemIdGet**](DefaultApi.md#itemsItemIdGet) | **GET** /items/{item_id} | Return item infromation.
[**itemsItemIdPut**](DefaultApi.md#itemsItemIdPut) | **PUT** /items/{item_id} | Update an item.
[**itemsPost**](DefaultApi.md#itemsPost) | **POST** /items | List an item.
[**itemsValidatePost**](DefaultApi.md#itemsValidatePost) | **POST** /items/validate | Validate the JSON before listing an item.
[**ordersOrderIdGet**](DefaultApi.md#ordersOrderIdGet) | **GET** /orders/{order_id} | Get an order by ID.
[**ordersSearchGet**](DefaultApi.md#ordersSearchGet) | **GET** /orders/search | Search orders by seller or buyer.
[**shipmentsShipmentIdGet**](DefaultApi.md#shipmentsShipmentIdGet) | **GET** /shipments/{shipment_id} | Retrieves all data to make a delivery.
[**sitesGet**](DefaultApi.md#sitesGet) | **GET** /sites | Return all sites where MercadoLibre operates.
[**sitesSiteIdCategoryPredictorPredictGet**](DefaultApi.md#sitesSiteIdCategoryPredictorPredictGet) | **GET** /sites/{site_id}/category_predictor/predict | Predict category by title.
[**sitesSiteIdGet**](DefaultApi.md#sitesSiteIdGet) | **GET** /sites/{site_id} | Return information about a site.
[**usersMeGet**](DefaultApi.md#usersMeGet) | **GET** /users/me | Return account information about the authenticated user.
[**usersUserIdGet**](DefaultApi.md#usersUserIdGet) | **GET** /users/{user_id} | Return user account information.


<a name="categoriesCategoryIdAttributesGet"></a>
# **categoriesCategoryIdAttributesGet**
> Object categoriesCategoryIdAttributesGet(categoryId)

Returns all attributes from a category.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
String categoryId = "categoryId_example"; // String | The category ID.
try {
    Object result = apiInstance.categoriesCategoryIdAttributesGet(categoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#categoriesCategoryIdAttributesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **categoryId** | **String**| The category ID. |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="categoriesCategoryIdGet"></a>
# **categoriesCategoryIdGet**
> CategoryResponse categoriesCategoryIdGet(categoryId)

Returns information about a category.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
String categoryId = "categoryId_example"; // String | The category ID.
try {
    CategoryResponse result = apiInstance.categoriesCategoryIdGet(categoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#categoriesCategoryIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **categoryId** | **String**| The category ID. |

### Return type

[**CategoryResponse**](CategoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="itemsItemIdGet"></a>
# **itemsItemIdGet**
> ItemResponse itemsItemIdGet(itemId, accessToken)

Return item infromation.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String itemId = "itemId_example"; // String | The item ID.
String accessToken = "\"APP_USR-23432432-070308-c79195c77c4587e48dd9f7a3f2a5ea78-332112\""; // String | Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes.
try {
    ItemResponse result = apiInstance.itemsItemIdGet(itemId, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#itemsItemIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **itemId** | **String**| The item ID. |
 **accessToken** | **String**| Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. | [optional]

### Return type

[**ItemResponse**](ItemResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="itemsItemIdPut"></a>
# **itemsItemIdPut**
> ItemResponse itemsItemIdPut(itemId, accessToken, body)

Update an item.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.api.DefaultApi;



DefaultApi apiInstance = new DefaultApi();
String itemId = "itemId_example"; // String | The item ID.
String accessToken = "\"APP_USR-123213213213123-070308-c79195c77c4587e48eeff7a3f2a5ea78-12321321312\""; // String | Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes.
Object body = null; // Object | 
try {
    ItemResponse result = apiInstance.itemsItemIdPut(itemId, accessToken, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#itemsItemIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **itemId** | **String**| The item ID. |
 **accessToken** | **String**| Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. |
 **body** | **Object**|  |

### Return type

[**ItemResponse**](ItemResponse.md)

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="itemsPost"></a>
# **itemsPost**
> ItemResponse itemsPost(accessToken, body)

List an item.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.api.DefaultApi;



DefaultApi apiInstance = new DefaultApi();
String accessToken = "\"APP_USR-123213212-070308-c79195c77c4587e48dd9f7a3f2a5ea78-1232311\""; // String | Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes.
ItemJson body = new ItemJson(); // ItemJson | 
try {
    ItemResponse result = apiInstance.itemsPost(accessToken, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#itemsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. |
 **body** | [**ItemJson**](ItemJson.md)|  |

### Return type

[**ItemResponse**](ItemResponse.md)

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="itemsValidatePost"></a>
# **itemsValidatePost**
> Object itemsValidatePost(accessToken, body)

Validate the JSON before listing an item.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.api.DefaultApi;







DefaultApi apiInstance = new DefaultApi();
String accessToken = "\":APP_USR-12312312-072610-cbfbdd1cde9cef0174637f94561ed43e-1231231\""; // String | 
ItemJson body = new ItemJson(); // ItemJson | 
try {
    Object result = apiInstance.itemsValidatePost(accessToken, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#itemsValidatePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**|  |
 **body** | [**ItemJson**](ItemJson.md)|  |

### Return type

**Object**

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

Get a message by ID.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;

//import io.swagger.client.api.DefaultApi;

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**|  |
 **messageId** | **String**| The message ID. |

### Return type

[**Message**](Message.md)

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

Return all messages from a order.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;

//import io.swagger.client.api.DefaultApi;



### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**|  |
 **orderId** | **Integer**| The order ID. |

### Return type

[**MessageSearchResults**](MessageSearchResults.md)

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

Send a message.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;

//import io.swagger.client.api.DefaultApi;


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**|  |
 **body** | [**MessageJSON**](MessageJSON.md)|  |

### Return type

[**MessageCreated**](MessageCreated.md)

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="ordersOrderIdGet"></a>
# **ordersOrderIdGet**
> Object ordersOrderIdGet(accessToken, orderId)

Get an order by ID.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;

//import io.swagger.client.api.DefaultApi;







DefaultApi apiInstance = new DefaultApi();
String accessToken = "\"APP_USR-1232311211-072613-cabb235ea80bb70b9312c2aade38ec3d-1233211\""; // String | 
Integer orderId = 56; // Integer | The order ID.
try {
    Object result = apiInstance.ordersOrderIdGet(accessToken, orderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#ordersOrderIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**|  |
 **orderId** | **Integer**| The order ID. |

### Return type

**Object**

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="ordersSearchGet"></a>
# **ordersSearchGet**
> Object ordersSearchGet(accessToken, buyer, seller, offset, limit)

Search orders by seller or buyer.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;

//import io.swagger.client.api.DefaultApi;







DefaultApi apiInstance = new DefaultApi();
String accessToken = "\"APP_USR-2132133211-072613-cabb235ea80bb70b9312c2aade38ec3d-1232121\""; // String | 
Integer buyer = "213222112"; // Integer | 
Integer seller = "123212122"; // Integer | 
Integer offset = 0; // Integer | The number of results to skip before starting to collect the result set.
Integer limit = 50; // Integer | The numbers of restuls to return.
try {
    Object result = apiInstance.ordersSearchGet(accessToken, buyer, seller, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#ordersSearchGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**|  |
 **buyer** | **Integer**|  | [optional]
 **seller** | **Integer**|  | [optional]
 **offset** | **Integer**| The number of results to skip before starting to collect the result set. | [optional] [default to 0]
 **limit** | **Integer**| The numbers of restuls to return. | [optional] [default to 50]

### Return type

**Object**

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="shipmentsShipmentIdGet"></a>
# **shipmentsShipmentIdGet**
> Shipment shipmentsShipmentIdGet(accessToken, shipmentId)

Retrieves all data to make a delivery.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;

//import io.swagger.client.api.DefaultApi;







DefaultApi apiInstance = new DefaultApi();
String accessToken = "\"APP_USR-1232132112-072613-cabb235ea80bb70b9312c2aade38ec3d-3213211\""; // String | 
BigDecimal shipmentId = new BigDecimal(); // BigDecimal | The shipment ID.
try {
    Shipment result = apiInstance.shipmentsShipmentIdGet(accessToken, shipmentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#shipmentsShipmentIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**|  |
 **shipmentId** | **BigDecimal**| The shipment ID. |

### Return type

[**Shipment**](Shipment.md)

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sitesGet"></a>
# **sitesGet**
> Sites sitesGet()

Return all sites where MercadoLibre operates.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    Sites result = apiInstance.sitesGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#sitesGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Sites**](Sites.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sitesSiteIdCategoryPredictorPredictGet"></a>
# **sitesSiteIdCategoryPredictorPredictGet**
> CategoryPrediction sitesSiteIdCategoryPredictorPredictGet(siteId, title)

Predict category by title.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String siteId = "\"MLA\""; // String | 
String title = "\"Ipod Touch Apple 16gb\""; // String | 
try {
    CategoryPrediction result = apiInstance.sitesSiteIdCategoryPredictorPredictGet(siteId, title);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#sitesSiteIdCategoryPredictorPredictGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siteId** | **String**|  |
 **title** | **String**|  |

### Return type

[**CategoryPrediction**](CategoryPrediction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sitesSiteIdGet"></a>
# **sitesSiteIdGet**
> Site sitesSiteIdGet(siteId)

Return information about a site.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String siteId = "siteId_example"; // String | The site Id.
try {
    Site result = apiInstance.sitesSiteIdGet(siteId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#sitesSiteIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siteId** | **String**| The site Id. |

### Return type

[**Site**](Site.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="usersMeGet"></a>
# **usersMeGet**
> UserResponse usersMeGet(accessToken)

Return account information about the authenticated user.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
String accessToken = "\"APP_USR-123213-071213-c9a1a708e215161df21d0d89de2e5147-12312312\""; // String | Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes.
try {
    UserResponse result = apiInstance.usersMeGet(accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#usersMeGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. |

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="usersUserIdGet"></a>
# **usersUserIdGet**
> UserResponse usersUserIdGet(userId, accessToken)

Return user account information.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer userId = 56; // Integer | The user Id.
String accessToken = "\"APP_USR-123213-071213-c9a1a708e215161df21d0d89de2e5147-12312312\""; // String | Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes.
try {
    UserResponse result = apiInstance.usersUserIdGet(userId, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#usersUserIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The user Id. |
 **accessToken** | **String**| Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. | [optional]

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

[oAuth2](../README.md#oAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json



