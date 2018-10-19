package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.model.*;

import javax.ws.rs.core.GenericType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-06T14:21:46.668-03:00")
public class DefaultApi {

    private ApiClient apiClient;
    private String accessToken;
    private String refreshToken;
    private Long clientId;
    private String clientSecret;
    private Long expiresIn;
    private String scope;
    private String userId;
    private String tokenType;

    public DefaultApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public DefaultApi(ApiClient apiClient, Long clientId, String clientSecret) {
        this.apiClient = apiClient;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public Long getExpiresIn() {
        return this.expiresIn;
    }

    public String getScope() {
        return this.scope;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getTokenType() {
        return this.tokenType;
    }


    /**
     * @param callback: The callback URL. Must be the applications redirect URI
     * @param authUrl:  The authorization URL. Get from Meli.AuthUrls
     * @return the authorization URL
     */
    public String getAuthUrl(String redirectUri, Configuration.AuthUrls authUrl) throws ApiException {

        // verify the required parameter 'redirectUri' is set
        if (redirectUri == null) {
            throw new ApiException(400, "Missing the required parameter 'redirectUri' when calling getAuthUrl");
        }

        // verify the required parameter 'authUrl' is set
        if (authUrl == null) {
            throw new ApiException(400, "Missing the required parameter 'authUrl' when calling getAuthUrl");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(authUrl.getValue());
        sb.append("/authorization?response_type=code&client_id=");
        sb.append(clientId);
        sb.append("&redirect_uri=");
        try {
            sb.append(URLEncoder.encode(redirectUri, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            sb.append(redirectUri);
        }
        return sb.toString();
    }

    /**
     * Returns access token.
     *
     * @param code        The code obtained from getAuthUrl step. (required)
     * @param redirectUri The Uri you redirect the user after auth. (required)
     * @return AccessToken
     * @throws ApiException if fails to make API call
     */

/**/
    public AccessToken authorize(String code, String redirectUri) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'accessToken' is set
        if (code == null) {
            throw new ApiException(400, "Missing the required parameter 'code' when calling authorize");
        }

        // verify the required parameter 'accessToken' is set
        if (redirectUri == null) {
            throw new ApiException(400, "Missing the required parameter 'redirectUri' when calling authorize");
        }

        // create path and map variables
        String localVarPath = "/oauth/token";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();


        localVarQueryParams.addAll(apiClient.parameterToPairs("", "grant_type", "authorization_code"));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "client_id", String.valueOf(clientId)));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "client_secret", clientSecret));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "code", code));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "redirect_uri", redirectUri));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        GenericType<AccessToken> localVarReturnType = new GenericType<AccessToken>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }


    /**
     * Returns refresh token.
     *
     * @return AccessToken
     * @throws ApiException if fails to make API call
     */
    public RefreshToken refreshAccessToken(String refreshToken) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/oauth/token";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "grant_type", "refresh_token"));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "client_id", String.valueOf(clientId)));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "client_secret", clientSecret));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "refresh_token", refreshToken));

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        String[] localVarAuthNames = new String[]{};

        GenericType<RefreshToken> localVarReturnType = new GenericType<RefreshToken>() {
        };

        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Returns response for any specified resource.
     *
     * @param resource The resource to make a request. (required)
     * @return Object
     * @throws ApiException if fails to make API call
     */
    public Object defaultGet(String resource) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'resource' is set
        if (resource == null) {
            throw new ApiException(400, "Missing the required parameter 'resource' when calling defaultGet");
        }

        // create path and map variables
        String localVarPath = "/" + resource;

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        GenericType<Object> localVarReturnType = new GenericType<Object>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Make a POST to any resource.
     *
     * @param resource    The resource you want to make a POST to. (required)
     * @param accessToken Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. (required)
     * @param body        (required)
     * @return Object
     * @throws ApiException if fails to make API call
     */

    public Object defaultPost(String accessToken, String resource, Object body) throws ApiException {
        Object localVarPostBody = body;

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling defaultPost");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(400, "Missing the required parameter 'body' when calling defaultPost");
        }

        // verify the required parameter 'resource' is set
        if (resource == null) {
            throw new ApiException(400, "Missing the required parameter 'resource' when calling defaultPost");
        }

        // create path and map variables
        String localVarPath = "/" + resource;

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<ItemResponse> localVarReturnType = new GenericType<ItemResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update any object.
     *
     * @param resource    The resource where the object belongs. (required)
     * @param id          The id of the object you want to update. (required)
     * @param accessToken Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. (required)
     * @param body        (required)
     * @return Object
     * @throws ApiException if fails to make API call
     */
    public Object defaultPut(String resource, String id, String accessToken, Object body) throws ApiException {
        Object localVarPostBody = body;

        // verify the required parameter 'body' is set
        if (resource == null) {
            throw new ApiException(400, "Missing the required parameter 'resource' when calling defaultPut");
        }

        // verify the required parameter 'itemId' is set
        if (id == null) {
            throw new ApiException(400, "Missing the required parameter 'id' when calling defaultPut");
        }

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling defaultPut");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(400, "Missing the required parameter 'body' when calling defaultPut");
        }

        // create path and map variables
        String localVarPath = "/" + resource + "/" + id;

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<ItemResponse> localVarReturnType = new GenericType<ItemResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }


    /**
     * Delete an object.
     *
     * @param resource    The resource where the object belongs. (required)
     * @param id          The id of the object you want to delete. (required)
     * @param accessToken Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. (required)
     * @return Object
     * @throws ApiException if fails to make API call
     */
    public Object defaultDelete(String resource, String id, String accessToken) throws ApiException {
        Object localVarPostBody = null;
        // verify the required parameter 'body' is set
        if (resource == null) {
            throw new ApiException(400, "Missing the required parameter 'resource' when calling defaultPut");
        }

        // verify the required parameter 'itemId' is set
        if (id == null) {
            throw new ApiException(400, "Missing the required parameter 'id' when calling defaultPut");
        }

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling defaultPut");
        }
        // create path and map variables
        String localVarPath = "/" + resource + "/" + id;

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<ItemResponse> localVarReturnType = new GenericType<ItemResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    public Object categoriesCategoryIdAttributesGet(String categoryId) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'categoryId' is set
        if (categoryId == null) {
            throw new ApiException(400, "Missing the required parameter 'categoryId' when calling categoriesCategoryIdAttributesGet");
        }

        // create path and map variables
        String localVarPath = "/categories/{category_id}/attributes"
                .replaceAll("\\{" + "category_id" + "\\}", apiClient.escapeString(categoryId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        GenericType<Object> localVarReturnType = new GenericType<Object>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Returns information about a category.
     *
     * @param categoryId The category ID. (required)
     * @return CategoryResponse
     * @throws ApiException if fails to make API call
     */
    public CategoryResponse categoriesCategoryIdGet(String categoryId) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'categoryId' is set
        if (categoryId == null) {
            throw new ApiException(400, "Missing the required parameter 'categoryId' when calling categoriesCategoryIdGet");
        }

        // create path and map variables
        String localVarPath = "/categories/{category_id}"
                .replaceAll("\\{" + "category_id" + "\\}", apiClient.escapeString(categoryId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        GenericType<CategoryResponse> localVarReturnType = new GenericType<CategoryResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Return item infromation.
     *
     * @param itemId      The item ID. (required)
     * @param accessToken Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. (optional)
     * @return ItemResponse
     * @throws ApiException if fails to make API call
     */
    public ItemResponse itemsItemIdGet(String itemId, String accessToken) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException(400, "Missing the required parameter 'itemId' when calling itemsItemIdGet");
        }

        // create path and map variables
        String localVarPath = "/items/{item_id}"
                .replaceAll("\\{" + "item_id" + "\\}", apiClient.escapeString(itemId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        GenericType<ItemResponse> localVarReturnType = new GenericType<ItemResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update an item.
     *
     * @param itemId      The item ID. (required)
     * @param accessToken Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. (required)
     * @param body        (required)
     * @return ItemResponse
     * @throws ApiException if fails to make API call
     */
    public ItemResponse itemsItemIdPut(String itemId, String accessToken, Object body) throws ApiException {
        Object localVarPostBody = body;

        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException(400, "Missing the required parameter 'itemId' when calling itemsItemIdPut");
        }

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling itemsItemIdPut");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(400, "Missing the required parameter 'body' when calling itemsItemIdPut");
        }

        // create path and map variables
        String localVarPath = "/items/{item_id}"
                .replaceAll("\\{" + "item_id" + "\\}", apiClient.escapeString(itemId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<ItemResponse> localVarReturnType = new GenericType<ItemResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List an item.
     *
     * @param accessToken Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. (required)
     * @param body        (required)
     * @return ItemResponse
     * @throws ApiException if fails to make API call
     */
    public ItemResponse itemsPost(String accessToken, ItemJson body) throws ApiException {
        Object localVarPostBody = body;

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling itemsPost");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(400, "Missing the required parameter 'body' when calling itemsPost");
        }

        // create path and map variables
        String localVarPath = "/items";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<ItemResponse> localVarReturnType = new GenericType<ItemResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Validate the JSON before listing an item.
     *
     * @param accessToken (required)
     * @param body        (required)
     * @return Object
     * @throws ApiException if fails to make API call
     */
    public Object itemsValidatePost(String accessToken, ItemJson body) throws ApiException {
        Object localVarPostBody = body;

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling itemsValidatePost");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(400, "Missing the required parameter 'body' when calling itemsValidatePost");
        }

        // create path and map variables
        String localVarPath = "/items/validate";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<Object> localVarReturnType = new GenericType<Object>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a message by ID.
     *
     * @param accessToken (required)
     * @param messageId   The message ID. (required)
     * @return Message
     * @throws ApiException if fails to make API call
     */
    public Message messagesMessageIdGet(String accessToken, String messageId) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling messagesMessageIdGet");
        }

        // verify the required parameter 'messageId' is set
        if (messageId == null) {
            throw new ApiException(400, "Missing the required parameter 'messageId' when calling messagesMessageIdGet");
        }

        // create path and map variables
        String localVarPath = "/messages/{message_id}"
                .replaceAll("\\{" + "message_id" + "\\}", apiClient.escapeString(messageId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<Message> localVarReturnType = new GenericType<Message>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Return all messages from a order.
     *
     * @param accessToken (required)
     * @param orderId     The order ID. (required)
     * @return MessageSearchResults
     * @throws ApiException if fails to make API call
     */
    public MessageSearchResults messagesOrdersOrderIdGet(String accessToken, Integer orderId) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling messagesOrdersOrderIdGet");
        }

        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException(400, "Missing the required parameter 'orderId' when calling messagesOrdersOrderIdGet");
        }

        // create path and map variables
        String localVarPath = "/messages/orders/{order_id}"
                .replaceAll("\\{" + "order_id" + "\\}", apiClient.escapeString(orderId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<MessageSearchResults> localVarReturnType = new GenericType<MessageSearchResults>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Send a message.
     *
     * @param accessToken (required)
     * @param body        (required)
     * @return MessageCreated
     * @throws ApiException if fails to make API call
     */
    public MessageCreated messagesPost(String accessToken, MessageJSON body) throws ApiException {
        Object localVarPostBody = body;

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling messagesPost");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(400, "Missing the required parameter 'body' when calling messagesPost");
        }

        // create path and map variables
        String localVarPath = "/messages";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<MessageCreated> localVarReturnType = new GenericType<MessageCreated>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get an order by ID.
     *
     * @param accessToken (required)
     * @param orderId     The order ID. (required)
     * @return Object
     * @throws ApiException if fails to make API call
     */
    public Object ordersOrderIdGet(String accessToken, Integer orderId) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling ordersOrderIdGet");
        }

        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new ApiException(400, "Missing the required parameter 'orderId' when calling ordersOrderIdGet");
        }

        // create path and map variables
        String localVarPath = "/orders/{order_id}"
                .replaceAll("\\{" + "order_id" + "\\}", apiClient.escapeString(orderId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<Object> localVarReturnType = new GenericType<Object>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Search orders by seller or buyer.
     *
     * @param accessToken (required)
     * @param buyer       (optional)
     * @param seller      (optional)
     * @param offset      The number of results to skip before starting to collect the result set. (optional, default to 0)
     * @param limit       The numbers of restuls to return. (optional, default to 50)
     * @return Object
     * @throws ApiException if fails to make API call
     */
    public Object ordersSearchGet(String accessToken, Integer buyer, Integer seller, Integer offset, Integer limit) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling ordersSearchGet");
        }

        // create path and map variables
        String localVarPath = "/orders/search";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "buyer", buyer));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "seller", seller));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<Object> localVarReturnType = new GenericType<Object>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieves all data to make a delivery.
     *
     * @param accessToken (required)
     * @param shipmentId  The shipment ID. (required)
     * @return Shipment
     * @throws ApiException if fails to make API call
     */
    public Shipment shipmentsShipmentIdGet(String accessToken, Long shipmentId) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling shipmentsShipmentIdGet");
        }

        // verify the required parameter 'shipmentId' is set
        if (shipmentId == null) {
            throw new ApiException(400, "Missing the required parameter 'shipmentId' when calling shipmentsShipmentIdGet");
        }

        // create path and map variables
        String localVarPath = "/shipments/{shipment_id}"
                .replaceAll("\\{" + "shipment_id" + "\\}", apiClient.escapeString(shipmentId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<Shipment> localVarReturnType = new GenericType<Shipment>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Return all sites where MercadoLibre operates.
     *
     * @return Sites
     * @throws ApiException if fails to make API call
     */
    public Sites sitesGet() throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/sites";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        GenericType<Sites> localVarReturnType = new GenericType<Sites>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Predict category by title.
     *
     * @param siteId (required)
     * @param title  (required)
     * @return CategoryPrediction
     * @throws ApiException if fails to make API call
     */
    public CategoryPrediction sitesSiteIdCategoryPredictorPredictGet(String siteId, String title) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'siteId' is set
        if (siteId == null) {
            throw new ApiException(400, "Missing the required parameter 'siteId' when calling sitesSiteIdCategoryPredictorPredictGet");
        }

        // verify the required parameter 'title' is set
        if (title == null) {
            throw new ApiException(400, "Missing the required parameter 'title' when calling sitesSiteIdCategoryPredictorPredictGet");
        }

        // create path and map variables
        String localVarPath = "/sites/{site_id}/category_predictor/predict"
                .replaceAll("\\{" + "site_id" + "\\}", apiClient.escapeString(siteId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "title", title));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        GenericType<CategoryPrediction> localVarReturnType = new GenericType<CategoryPrediction>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Return information about a site.
     *
     * @param siteId The site Id. (required)
     * @return Site
     * @throws ApiException if fails to make API call
     */
    public Site sitesSiteIdGet(String siteId) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'siteId' is set
        if (siteId == null) {
            throw new ApiException(400, "Missing the required parameter 'siteId' when calling sitesSiteIdGet");
        }

        // create path and map variables
        String localVarPath = "/sites/{site_id}"
                .replaceAll("\\{" + "site_id" + "\\}", apiClient.escapeString(siteId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        GenericType<Site> localVarReturnType = new GenericType<Site>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Return account information about the authenticated user.
     *
     * @param accessToken Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. (required)
     * @return UserResponse
     * @throws ApiException if fails to make API call
     */
    public UserResponse usersMeGet(String accessToken) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException(400, "Missing the required parameter 'accessToken' when calling usersMeGet");
        }

        // create path and map variables
        String localVarPath = "/users/me";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<UserResponse> localVarReturnType = new GenericType<UserResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Return user account information.
     *
     * @param userId      The user Id. (required)
     * @param accessToken Go to http://developers.mercadolibre.com/products-authentication-authorization/ to get a valid access_token for testing purposes. (optional)
     * @return UserResponse
     * @throws ApiException if fails to make API call
     */
    public UserResponse usersUserIdGet(Integer userId, String accessToken) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException(400, "Missing the required parameter 'userId' when calling usersUserIdGet");
        }

        // create path and map variables
        String localVarPath = "/users/{user_id}"
                .replaceAll("\\{" + "user_id" + "\\}", apiClient.escapeString(userId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));


        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{"oAuth2"};

        GenericType<UserResponse> localVarReturnType = new GenericType<UserResponse>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
