package com.nextgen.test.bookShop.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.nextgen.test.bookShop.restController"))
            .paths(PathSelectors.regex("/api.*"))
            .build().apiInfo(apiEndPointsInfo())
    }

    private fun apiEndPointsInfo(): ApiInfo? {
        return ApiInfoBuilder().title("BOOK SHOP REST API")
            .description("API de gestion de livres")
            .contact(Contact("Wilfried BOBIONGONO", "", "wilfriedbobi1@gmail.com"))
            .license("Copyright BMW.F 2023, all rights reserved")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("0.0.1")
            .build()
    }
}