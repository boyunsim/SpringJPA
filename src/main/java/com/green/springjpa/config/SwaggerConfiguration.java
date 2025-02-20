package com.green.springjpa.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "${constants.swagger.info.title}"
                , description = "${constants.swagger.info.description}"
                , version = "${constants.swagger.info.version}"
        )
)
public class SwaggerConfiguration {

}



