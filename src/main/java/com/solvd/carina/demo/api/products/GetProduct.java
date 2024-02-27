package com.solvd.carina.demo.api.products;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "https://dummyjson.com/products/${index}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetProduct extends AbstractApiMethodV2 {
    public GetProduct() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
    public void setIndex(){
        int index = 2;
        replaceUrlPlaceholder("index", String.valueOf(index));
    }
}
