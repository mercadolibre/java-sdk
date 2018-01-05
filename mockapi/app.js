var express = require('express');
var fs = require('fs');
var _ = require('underscore');

var app = express.createServer();

app.configure(function () {
    app.use(express.methodOverride());
    app.use(express.bodyParser());
});

/* oAuth example:
*
* For more information, check the docs:
* http://developers.mercadolibre.com/authentication-and-authorization/
* */
app.post('/oauth/token', function (req, res) {
    if (req.query["grant_type"] == "authorization_code") {
        if (req.query["code"] == "bad code") {
            res.send({
                "message": "Error validando el parámetro code",
                "error": "invalid_grant",
                "status": 400,
                "cause": []
            }, 400);
        } else if (req.query["code"] == "valid code without refresh token") {
            res.send({
                "access_token": "valid token",
                "token_type": "bearer",
                "expires_in": 10800,
                "scope": "write read"
            });
        } else if (req.query["code"] == "valid code with refresh token") {
            res.send({
                "access_token": "valid token",
                "token_type": "bearer",
                "expires_in": 10800,
                "refresh_token": "valid refresh token",
                "scope": "write read"
            });
        } else {
            res.send(404);
        }
    } else if (req.query['grant_type'] == 'refresh_token') {
        if (req.query['refresh_token'] == 'valid refresh token') {
            res.send({
                "access_token": "valid token",
                "token_type": "bearer",
                "expires_in": 10800,
                "scope": "write read"
            });
        }
    }
});

/* Simple GET to Sites resource */
app.get('/sites', function (req, res) {
    res.send([{"id": "MLA", "name": "Argentina"}, {"id": "MLB", "name": "Brasil"}, {
        "id": "MCO",
        "name": "Colombia"
    }, {"id": "MCR", "name": "Costa Rica"}, {"id": "MEC", "name": "Ecuador"}, {
        "id": "MLC",
        "name": "Chile"
    }, {"id": "MLM", "name": "Mexico"}, {"id": "MLU", "name": "Uruguay"}, {
        "id": "MLV",
        "name": "Venezuela"
    }, {"id": "MPA", "name": "Panamá"}, {"id": "MPE", "name": "Perú"}, {"id": "MPT", "name": "Portugal"}, {
        "id": "MRD",
        "name": "Dominicana"
    }]);
});


/* Simple GET to User's with private information
 *
 * For more information, check the docs:
 * http://developers.mercadolibre.com/products-manage-users/
 * */
app.get('/users/me', function (req, res) {
    if (req.query['access_token'] == 'token') {
        res.send({"id": 123456, "nickname": "foobar"});
    } else if (req.query['access_token'] == 'expired token') {
        res.send(404);
    } else {
        res.send({
            "message": "The User ID must match the consultant's",
            "error": "forbidden",
            "status": 403,
            "cause": []
        }, 403);
    }
});

/* Simple GET to Categorie's attributes
 *
 * For more information, check the docs:
 * developers.mercadolibre.com/attributes/
 *
 * */

app.get('/categories/MLA123/attributes', function (req, res) {
    */
    res.send([{
        "id": "SELLER_SKU",
        "name": "SKU ",
        "tags": {
            "variation_attribute": true
        },
        "hierarchy": "PRODUCT_IDENTIFIER",
        "relevance": null,
        "type": "product_identifier",
        "value_type": "string",
        "value_max_length": 255,
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "GTIN",
        "name": "Código universal de producto",
        "tags": {
            "multivalued": true,
            "variation_attribute": true
        },
        "hierarchy": "PRODUCT_IDENTIFIER",
        "relevance": null,
        "type": "product_identifier",
        "value_type": "string",
        "value_max_length": 255,
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "BRAND",
        "name": "Marca",
        "tags": {},
        "hierarchy": "PARENT_PK",
        "relevance": null,
        "value_type": "string",
        "value_max_length": 255,
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "MODEL",
        "name": "Modelo",
        "tags": {},
        "hierarchy": "PARENT_PK",
        "relevance": null,
        "value_type": "string",
        "value_max_length": 255,
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "EAN",
        "name": "EAN",
        "tags": {
            "hidden": true,
            "multivalued": true,
            "variation_attribute": true
        },
        "hierarchy": "PRODUCT_IDENTIFIER",
        "relevance": null,
        "type": "product_identifier",
        "value_type": "string",
        "value_max_length": 255,
        "tooltip": "Este es el número de 8, 13 o 14 dígitos que está en el código de barras de tu producto.",
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "GTIN14",
        "name": "GTIN-14",
        "tags": {
            "hidden": true,
            "multivalued": true,
            "variation_attribute": true
        },
        "hierarchy": "PRODUCT_IDENTIFIER",
        "relevance": null,
        "type": "product_identifier",
        "value_type": "string",
        "value_max_length": 255,
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "JAN",
        "name": "JAN",
        "tags": {
            "hidden": true,
            "multivalued": true,
            "variation_attribute": true
        },
        "hierarchy": "PRODUCT_IDENTIFIER",
        "relevance": null,
        "type": "product_identifier",
        "value_type": "string",
        "value_max_length": 255,
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "MPN",
        "name": "MPN",
        "tags": {
            "hidden": true,
            "multivalued": true,
            "variation_attribute": true
        },
        "hierarchy": "PRODUCT_IDENTIFIER",
        "relevance": null,
        "type": "product_identifier",
        "value_type": "string",
        "value_max_length": 255,
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "UPC",
        "name": "UPC",
        "tags": {
            "hidden": true,
            "multivalued": true,
            "variation_attribute": true
        },
        "hierarchy": "PRODUCT_IDENTIFIER",
        "relevance": null,
        "type": "product_identifier",
        "value_type": "string",
        "value_max_length": 255,
        "tooltip": "Este es el número de 12 dígitos que está en el código de barras de tu producto.",
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "PACKAGE_HEIGHT",
        "name": "Altura del paquete",
        "tags": {
            "hidden": true,
            "read_only": true,
            "variation_attribute": true
        },
        "hierarchy": "ITEM",
        "relevance": null,
        "value_type": "number_unit",
        "value_max_length": 255,
        "allowed_units": [{
            "id": "\"",
            "name": "\""
        }, {
            "id": "cm",
            "name": "cm"
        }, {
            "id": "ft",
            "name": "ft"
        }, {
            "id": "in",
            "name": "in"
        }, {
            "id": "km",
            "name": "km"
        }, {
            "id": "m",
            "name": "m"
        }, {
            "id": "mm",
            "name": "mm"
        }, {
            "id": "pulgadas",
            "name": "pulgadas"
        }],
        "default_unit": "\"",
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "PACKAGE_WIDTH",
        "name": "Ancho del paquete",
        "tags": {
            "hidden": true,
            "read_only": true,
            "variation_attribute": true
        },
        "hierarchy": "ITEM",
        "relevance": null,
        "value_type": "number_unit",
        "value_max_length": 255,
        "allowed_units": [{
            "id": "\"",
            "name": "\""
        }, {
            "id": "cm",
            "name": "cm"
        }, {
            "id": "ft",
            "name": "ft"
        }, {
            "id": "in",
            "name": "in"
        }, {
            "id": "km",
            "name": "km"
        }, {
            "id": "m",
            "name": "m"
        }, {
            "id": "mm",
            "name": "mm"
        }, {
            "id": "pulgadas",
            "name": "pulgadas"
        }],
        "default_unit": "\"",
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "PACKAGE_LENGTH",
        "name": "Longitud del paquete",
        "tags": {
            "hidden": true,
            "read_only": true,
            "variation_attribute": true
        },
        "hierarchy": "ITEM",
        "relevance": null,
        "value_type": "number_unit",
        "value_max_length": 255,
        "allowed_units": [{
            "id": "\"",
            "name": "\""
        }, {
            "id": "cm",
            "name": "cm"
        }, {
            "id": "ft",
            "name": "ft"
        }, {
            "id": "in",
            "name": "in"
        }, {
            "id": "km",
            "name": "km"
        }, {
            "id": "m",
            "name": "m"
        }, {
            "id": "mm",
            "name": "mm"
        }, {
            "id": "pulgadas",
            "name": "pulgadas"
        }],
        "default_unit": "\"",
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "PACKAGE_WEIGHT",
        "name": "Peso del paquete",
        "tags": {
            "hidden": true,
            "read_only": true,
            "variation_attribute": true
        },
        "hierarchy": "ITEM",
        "relevance": null,
        "value_type": "number_unit",
        "value_max_length": 255,
        "allowed_units": [{
            "id": "g",
            "name": "g"
        }, {
            "id": "kg",
            "name": "kg"
        }, {
            "id": "lb",
            "name": "lb"
        }, {
            "id": "mcg",
            "name": "mcg"
        }, {
            "id": "mg",
            "name": "mg"
        }, {
            "id": "oz",
            "name": "oz"
        }],
        "default_unit": "g",
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }, {
        "id": "DESCRIPTIVE_TAGS",
        "name": "Tags descriptivos",
        "tags": {
            "hidden": true,
            "multivalued": true,
            "read_only": true
        },
        "hierarchy": "ITEM",
        "relevance": null,
        "value_type": "string",
        "value_max_length": 255,
        "attribute_group_id": "DFLT",
        "attribute_group_name": "Otros"
    }]);
});

/* Uncomment this example to see how a simple POST with a "bar" : "foo" JSON body will work:
 *
 app.post('/items', function (req, res) {
 if (req.query['access_token'] == 'valid_token') {
 if (req.body && req.body.foo == "bar") {
 res.send(201);
 } else {
 res.send(400);
 }
 } else if (req.query['access_token'] == 'expired token') {
 res.send(404);
 } else {
 res.send(403);
 }
 })
 */


/* This is a POST example of an item with all required fields, plus attributes:
 *  We encourage you to always list items with it's attributes.
 *
 *  For more information, check the docs:
 * http://developers.mercadolibre.com/attributes/
 *
 */

app.post('/items', function (req, res) {

    /* This is an example of how to create the body of the item */
    body = new Object()
    body.site_id = "MLA"
    body.title = "Item de testeo, por favor no contactar --kc:off"
    body.category_id = "MLA125703"
    body.price = 4000,
        body.currency_id = "ARS"
    body.buying_mode = "buy_it_now"
    body.listing_type_id = "gold_special"
    body.condition = "new"
    body.available_quantity = 10
    body.attributes = [
        {
            "id": "MODEL",
            "value_name": "B228D"
        },
        {
            "id": "VOLUME_CAPACITY",
            "value_name": "28 L"
        }
    ]
    body

    if (req.query['access_token'] == 'token') {
        if (req.body && _.isEqual(req.body, body) == true) {
            res.send({
                "id": "MLA123",
                "site_id": "MLA",
                "title": "Item De Testeo, Por Favor No Contactar --kc:off",
                "subtitle": null,
                "seller_id": 285621066,
                "category_id": "MLA125703",
                "official_store_id": null,
                "price": 4000,
                "base_price": 4000,
                "original_price": null,
                "currency_id": "ARS",
                "initial_quantity": 10,
                "available_quantity": 10,
                "sold_quantity": 0,
                "sale_terms": [],
                "buying_mode": "buy_it_now",
                "listing_type_id": "gold_special",
                "start_time": "2017-12-28T12:29:21.086Z",
                "stop_time": "2037-12-23T12:29:21.086Z",
                "end_time": "2037-12-23T12:29:21.086Z",
                "expiration_time": "2018-03-18T12:29:21.170Z",
                "condition": "new",
                "permalink": "http://articulo.mercadolibre.com.ar/MLA-123-item-de-testeo-por-favor-no-contactar-kcoff-_JM",
                "thumbnail": "",
                "secure_thumbnail": "",
                "pictures": [],
                "video_id": null,
                "descriptions": [],
                "accepts_mercadopago": true,
                "non_mercado_pago_payment_methods": [],
                "shipping": {
                    "mode": "not_specified",
                    "local_pick_up": false,
                    "free_shipping": false,
                    "methods": [],
                    "dimensions": null,
                    "tags": [],
                    "logistic_type": "not_specified",
                    "store_pick_up": false
                },
                "international_delivery_mode": "none",
                "seller_address": {
                    "id": 365176485,
                    "comment": "",
                    "address_line": "Test Address 123",
                    "zip_code": "1414",
                    "city": {"id": "", "name": "Palermo"},
                    "state": {"id": "AR-C", "name": "Capital Federal"},
                    "country": {"id": "AR", "name": "Argentina"},
                    "latitude": "",
                    "longitude": "",
                    "search_location": {
                        "neighborhood": {"id": "TUxBQlBBTDI1MTVa", "name": "Palermo"},
                        "city": {"id": "TUxBQ0NBUGZlZG1sYQ", "name": "Capital Federal"},
                        "state": {"id": "TUxBUENBUGw3M2E1", "name": "Capital Federal"}
                    }
                },
                "seller_contact": null,
                "location": {},
                "geolocation": {"latitude": "", "longitude": ""},
                "coverage_areas": [],
                "attributes": [{
                    "id": "BRAND",
                    "name": "Marca",
                    "value_id": "5601",
                    "value_name": "BGH",
                    "value_struct": null,
                    "attribute_group_id": "DFLT",
                    "attribute_group_name": "Otros"
                }, {
                    "id": "MODEL",
                    "name": "Modelo",
                    "value_id": null,
                    "value_name": "B228D",
                    "value_struct": null,
                    "attribute_group_id": "DFLT",
                    "attribute_group_name": "Otros"
                }, {
                    "id": "VOLUME_CAPACITY",
                    "name": "Capacidad",
                    "value_id": null,
                    "value_name": "28 L",
                    "value_struct": {"number": 28, "unit": "L"},
                    "attribute_group_id": "DFLT",
                    "attribute_group_name": "Otros"
                }],
                "warnings": [],
                "listing_source": "",
                "variations": [],
                "status": "active",
                "sub_status": [],
                "tags": ["test_item", "immediate_payment"],
                "warranty": null,
                "catalog_product_id": null,
                "url_catalog_product_id": null,
                "domain_id": "MLA-MICROWAVES",
                "url_domain_id": "https://api.mercadolibre.com/catalog_domains/MLA-MICROWAVES",
                "seller_custom_field": null,
                "parent_item_id": null,
                "differential_pricing": null,
                "deal_ids": [],
                "automatic_relist": false,
                "date_created": "2017-12-28T12:29:21.246Z",
                "last_updated": "2017-12-28T12:29:21.246Z"
            });
        } else {
            res.send(400);
        }
    } else if (req.query['access_token'] == 'expired token') {
        res.send(404);
    } else {
        res.send(403);
    }
});


/* This is example shows you how to update an item:
 *
 * For more information, check the docs:
 * http://developers.mercadolibre.com/services-sync-listings/
 * */
app.put('/items/123', function (req, res) {

    /* In this example we're updating the Product Identifier attribute of the item
     *
     * For more information, check the docs:
     * http://developers.mercadolibre.com/product-identifiers/
     *  */
    body = new Object()
    body.attributes = [
        {
            "id": "EAN",
            "value_name": "12312321321"
        }
    ]
    body

    if (req.query['access_token'] == 'token') {
        if (req.body && _.isEqual(req.body, body)) {
            res.send(200);
        } else {
            res.send(400);
        }
    } else if (req.query['access_token'] == 'expired token') {
        res.send(404);
    } else {
        res.send(403);
    }
});

/* This is how you delete an item:
 *
 * For more information, check the docs:
 * http://developers.mercadolibre.com/services-sync-listings/
 * */
app.delete('/items/123', function (wreq, res) {
    if (req.query['access_token'] == 'token') {
        res.send(200);
    } else if (req.query['access_token'] == 'expired token') {
        res.send(404);
    } else {
        res.send(403);
    }
});


/* GET user-agent information: */
app.get('/echo/user_agent', function (req, res) {
    if (req.headers['user-agent'].match(/MELI-JAVA-SDK-.*/))
        res.send(200);
    else
        res.send(400);
});

app.listen(3000, function () {
    console.log('Example app listening on port 3000!');
});

fs.writeFileSync('/tmp/mockapi.pid', process.pid);
