package com.solvd.carina.demo;

import com.fasterxml.jackson.core.JsonToken;
import com.jayway.jsonpath.JsonPath;
import com.solvd.carina.demo.api.products.DeleteProduct;
import com.solvd.carina.demo.api.products.GetProduct;
import com.solvd.carina.demo.api.products.PostProduct;
import com.solvd.carina.demo.api.products.PutProduct;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APIHWTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "Lucas")
    public void getProducts(){
        GetProduct getProduct = new GetProduct();
        getProduct.setIndex();
        getProduct.callAPIExpectSuccess();
        getProduct.validateResponseAgainstSchema("api/products/_get/rs.schema");
    }
    @Test
    @MethodOwner(owner = "Lucas")
    public void postProducts(){
        PostProduct postProduct = new PostProduct();
        postProduct.setProperties("api/products/product.properties");
        postProduct.callAPIExpectSuccess();
        postProduct.validateResponse();
    }
    @Test
    @MethodOwner(owner = "Lucas")
    public void putProducts(){
        PutProduct putProduct = new PutProduct();
        putProduct.setIndex();
        putProduct.setProperties("api/products/product.properties");
        putProduct.callAPIExpectSuccess();
        //putProduct.validateResponse();
    }
    @Test
    @MethodOwner(owner = "Lucas")
    public void deleteProducts(){
        DeleteProduct deleteProduct = new DeleteProduct();
        deleteProduct.setIndex();
        deleteProduct.callAPIExpectSuccess();
        deleteProduct.validateResponse();
    }

}