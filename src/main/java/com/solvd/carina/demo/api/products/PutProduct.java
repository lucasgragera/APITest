package com.solvd.carina.demo.api.products;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

import java.io.ObjectInputFilter;

@Endpoint(url = "${base_url}/products/${index}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/products/_put/rq.json")
@ResponseTemplatePath(path = "api/products/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class PutProduct extends AbstractApiMethodV2 {
    public PutProduct(){
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
    public void setIndex(){
        int index = 2;
        replaceUrlPlaceholder("index", String.valueOf(index));
    }
}
