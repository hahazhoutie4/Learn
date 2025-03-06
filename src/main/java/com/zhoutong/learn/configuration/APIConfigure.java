package com.zhoutong.learn.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

public class APIConfigure {


    public OpenAPI createRestApi() {
        return new OpenAPI().info(new Info().description("description").title("Learn TEst").version("1.0")).
                externalDocs(new ExternalDocumentation().url("https:").description("description"));
    }

}
