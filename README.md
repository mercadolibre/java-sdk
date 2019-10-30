# Java Client SDK

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/java-client-sdk-master.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.*;


public class DefaultApiExample {

/*Replace with your application Client Id, Client Secret and RedirectUri*/

    Long ClientId = 0;  
    String SecretKey = "abc123";
    String redirectUri = "https://your_url.com";
    
    private final DefaultApi api = new DefaultApi();
    
    private static void getAuthUrl() throws UnsupportedEncodingException {
           DefaultApi api = new DefaultApi(new ApiClient(), clientId, clientSecret);
           String response = api.getAuthUrl(redirectUri, Configuration.AuthUrls.{your_site_id});
    }
    
    private static void getAccessToken() throws UnsupportedEncodingException {
               DefaultApi api = new DefaultApi(new ApiClient(), clientId, clientSecret);
               String code = "{your_code}";
               AccessToken response = api.authorize(code, redirectUri);
    }
     
    private static void refreshToken() throws UnsupportedEncodingException {
                    DefaultApi api = new DefaultApi(new ApiClient(), clientId, clientSecret);
                    String refreshToken = "{your_refresh_token}";
                    RefreshToken response = api.refreshAccessToken(refreshToken);
    }
    
    private static void GET() throws ApiException {
            String resource = "{api_resource}";
            Object response = api.defaultGet(resource);
    }
    
    public void POST() throws ApiException {
            String resource = "{api_resource}";
            Object body = new Object();
            body.field("{some_value}");
            Object response = api.defaultPost(accessToken, resource, body);
    }
        
    public void PUT() throws ApiException {
                String id = "{object_id}";
                String resource = "{api_resource}";
                Object body = new Object();
                body.field("{some_value}");
                Object response = api.defaultPut(resource, id, accessToken, body);
    }
    
    public void DELETE() throws ApiException {
                 String id = "{object_id}";
                 String resource = "{api_resource}";
                 Object response = api.defaultDelete(resource, id, accessToken);
    }

}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.mercadolibre.com*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | **defaultGet** | **GET** /{resource}/{id} | Returns details about an object.
*DefaultApi* | **defaultPut** | **PUT** /{resource}/{id}/attributes | Updates an object.
*DefaultApi* | **defaultPost** | **POST** /{resource}/ | Creates an object.
*DefaultApi* | **defaultDelete** | **DELETE** /{resource}/{id} | Deletes an object.
*DefaultApi* | [**categoriesCategoryIdAttributesGet**](docs/DefaultApi.md#categoriesCategoryIdAttributesGet) | **GET** /categories/{category_id}/attributes | Returns all attributes from a category.
*DefaultApi* | [**categoriesCategoryIdGet**](docs/DefaultApi.md#categoriesCategoryIdGet) | **GET** /categories/{category_id} | Returns information about a category.
*DefaultApi* | [**itemsItemIdGet**](docs/DefaultApi.md#itemsItemIdGet) | **GET** /items/{item_id} | Return item infromation.
*DefaultApi* | [**itemsItemIdPut**](docs/DefaultApi.md#itemsItemIdPut) | **PUT** /items/{item_id} | Update an item.
*DefaultApi* | [**itemsPost**](docs/DefaultApi.md#itemsPost) | **POST** /items | List an item.
*DefaultApi* | [**itemsValidatePost**](docs/DefaultApi.md#itemsValidatePost) | **POST** /items/validate | Validate the JSON before listing an item.
*DefaultApi* | [**ordersOrderIdGet**](docs/DefaultApi.md#ordersOrderIdGet) | **GET** /orders/{order_id} | Get an order by ID.
*DefaultApi* | [**ordersSearchGet**](docs/DefaultApi.md#ordersSearchGet) | **GET** /orders/search | Search orders by seller or buyer.
*DefaultApi* | [**shipmentsShipmentIdGet**](docs/DefaultApi.md#shipmentsShipmentIdGet) | **GET** /shipments/{shipment_id} | Retrieves all data to make a delivery.
*DefaultApi* | [**sitesGet**](docs/DefaultApi.md#sitesGet) | **GET** /sites | Return all sites where MercadoLibre operates.
*DefaultApi* | [**sitesSiteIdCategoryPredictorPredictGet**](docs/DefaultApi.md#sitesSiteIdCategoryPredictorPredictGet) | **GET** /sites/{site_id}/category_predictor/predict | Predict category by title.
*DefaultApi* | [**sitesSiteIdGet**](docs/DefaultApi.md#sitesSiteIdGet) | **GET** /sites/{site_id} | Return information about a site.
*DefaultApi* | [**usersMeGet**](docs/DefaultApi.md#usersMeGet) | **GET** /users/me | Return account information about the authenticated user.
*DefaultApi* | [**usersUserIdGet**](docs/DefaultApi.md#usersUserIdGet) | **GET** /users/{user_id} | Return user account information.


## Documentation for Models

 - [Address](docs/Address.md)
 - [AlternativePhone](docs/AlternativePhone.md)
 - [AttributeCombinations](docs/AttributeCombinations.md)
 - [Attributes](docs/Attributes.md)
 - [BillData](docs/BillData.md)
 - [Billing](docs/Billing.md)
 - [Buy](docs/Buy.md)
 - [BuyerReputation](docs/BuyerReputation.md)
 - [BuyerReputationTransactions](docs/BuyerReputationTransactions.md)
 - [Canceled](docs/Canceled.md)
 - [Categories](docs/Categories.md)
 - [CategoryPrediction](docs/CategoryPrediction.md)
 - [CategoryResponse](docs/CategoryResponse.md)
 - [CategorySettings](docs/CategorySettings.md)
 - [City](docs/City.md)
 - [Claims](docs/Claims.md)
 - [Context](docs/Context.md)
 - [Conversation](docs/Conversation.md)
 - [CostComponents](docs/CostComponents.md)
 - [Country](docs/Country.md)
 - [Credit](docs/Credit.md)
 - [Currencies](docs/Currencies.md)
 - [DelayedHandlingTime](docs/DelayedHandlingTime.md)
 - [Descriptions](docs/Descriptions.md)
 - [Error](docs/Error.md)
 - [EstimatedDeliveryExtended](docs/EstimatedDeliveryExtended.md)
 - [EstimatedDeliveryFinal](docs/EstimatedDeliveryFinal.md)
 - [EstimatedDeliveryLimit](docs/EstimatedDeliveryLimit.md)
 - [EstimatedDeliveryTime](docs/EstimatedDeliveryTime.md)
 - [EstimatedHandlingLimit](docs/EstimatedHandlingLimit.md)
 - [EstimatedScheduleLimit](docs/EstimatedScheduleLimit.md)
 - [From](docs/From.md)
 - [Geolocation](docs/Geolocation.md)
 - [Identification](docs/Identification.md)
 - [IdentificationTypesRules](docs/IdentificationTypesRules.md)
 - [ImmediatePayment](docs/ImmediatePayment.md)
 - [ItemJson](docs/ItemJson.md)
 - [ItemResponse](docs/ItemResponse.md)
 - [ItemResponseAttributes](docs/ItemResponseAttributes.md)
 - [ItemResponsePictures](docs/ItemResponsePictures.md)
 - [ListImmediatePayment](docs/ListImmediatePayment.md)
 - [Location](docs/Location.md)
 - [Message](docs/Message.md)
 - [MessageAttachmentsValidations](docs/MessageAttachmentsValidations.md)
 - [MessageCreated](docs/MessageCreated.md)
 - [MessageFrom](docs/MessageFrom.md)
 - [MessageJSON](docs/MessageJSON.md)
 - [MessageModeration](docs/MessageModeration.md)
 - [MessageSearchResults](docs/MessageSearchResults.md)
 - [MessageText](docs/MessageText.md)
 - [MessageTo](docs/MessageTo.md)
 - [Metrics](docs/Metrics.md)
 - [Moderation](docs/Moderation.md)
 - [Municipality](docs/Municipality.md)
 - [Neighborhood](docs/Neighborhood.md)
 - [NotYetRated](docs/NotYetRated.md)
 - [Offset](docs/Offset.md)
 - [Paging](docs/Paging.md)
 - [PathFromRoot](docs/PathFromRoot.md)
 - [Phone](docs/Phone.md)
 - [Pictures](docs/Pictures.md)
 - [PredictionPathFromRoot](docs/PredictionPathFromRoot.md)
 - [Ratings](docs/Ratings.md)
 - [ReceiverAddress](docs/ReceiverAddress.md)
 - [ReceiverAddressCity](docs/ReceiverAddressCity.md)
 - [ReceiverAddressCountry](docs/ReceiverAddressCountry.md)
 - [ReceiverAddressMunicipality](docs/ReceiverAddressMunicipality.md)
 - [ReceiverAddressNeighborhood](docs/ReceiverAddressNeighborhood.md)
 - [ReceiverAddressState](docs/ReceiverAddressState.md)
 - [Results](docs/Results.md)
 - [ResultsFrom](docs/ResultsFrom.md)
 - [ResultsText](docs/ResultsText.md)
 - [ResultsTo](docs/ResultsTo.md)
 - [Rules](docs/Rules.md)
 - [SaleTerms](docs/SaleTerms.md)
 - [Sales](docs/Sales.md)
 - [SearchLocation](docs/SearchLocation.md)
 - [SearchLocationCity](docs/SearchLocationCity.md)
 - [SearchLocationState](docs/SearchLocationState.md)
 - [Sell](docs/Sell.md)
 - [SellImmediatePayment](docs/SellImmediatePayment.md)
 - [SellerAddress](docs/SellerAddress.md)
 - [SellerReputation](docs/SellerReputation.md)
 - [SenderAddress](docs/SenderAddress.md)
 - [Shipment](docs/Shipment.md)
 - [Shipping](docs/Shipping.md)
 - [ShippingItems](docs/ShippingItems.md)
 - [ShippingOption](docs/ShippingOption.md)
 - [ShoppingCart](docs/ShoppingCart.md)
 - [Site](docs/Site.md)
 - [SiteSettings](docs/SiteSettings.md)
 - [Sites](docs/Sites.md)
 - [SitesSite](docs/SitesSite.md)
 - [State](docs/State.md)
 - [Status](docs/Status.md)
 - [StatusHistory](docs/StatusHistory.md)
 - [Text](docs/Text.md)
 - [TimeFrame](docs/TimeFrame.md)
 - [To](docs/To.md)
 - [Transactions](docs/Transactions.md)
 - [Unrated](docs/Unrated.md)
 - [UserResponse](docs/UserResponse.md)
 - [Variations](docs/Variations.md)
 - [Warnings](docs/Warnings.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### oAuth2

- **Type**: OAuth
- **Flow**: accessCode
- **Authorization URL**: https://auth.mercadolibre.com.ar/authorization [Check AuthURL values by Site](/src/main/java/io/swagger/client/Configuration.java)
- **Token URL**: https://api.mercadolibre.com/oauth/token
- **Scopes**: 
  - read: Grants read access
  - write: Grants write access
  - offline_access: Grants read and write access, and adds the possibility to get a refresh token and stay authenticated as the user.


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author
Florencia Solari (fsolari)

Most code was auto generated by [swagger code generator](https://github.com/swagger-api/swagger-codegen.git)

## Old version
If you are looking for the older java-sdk, please refer to [here](https://github.com/mercadolibre/java-sdk/tree/old-java-sdk)
