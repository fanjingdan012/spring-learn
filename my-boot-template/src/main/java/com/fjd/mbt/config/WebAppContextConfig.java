package com.fjd.mbt.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Activates Web MVC and its @Controller classes via
 * RequestMappingHandlerMapping. Defines Spring beans for the application
 * context and triggers via @ComponentScan the search and the registration of
 * Beans. Beans are detected within @Configuration, @Component and @Controller
 * annotated classes.
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = "com.fjd.mbt") // includes sub packages
@PropertySources(value = { @PropertySource("classpath:application.properties") })
public class WebAppContextConfig {
    // initialize when tomcat starts, not when first request comes in
    private static final int LOAD_ON_STARTUP = 1;



    @Bean
    @Profile("cloud")
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        // make environment variables available for Spring's @Value annotation
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.sap.grc.archimedes.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Jd", "", "fanjingdan@sina.com");
        return new ApiInfoBuilder().title("mbt").description("mbt service api doc")
                .termsOfServiceUrl("http://127.0.0.1:8080/swagger-ui.html").contact(contact).version("1.0").build();
    }

    @Bean
    public WebMvcConfigurer Configurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
                registry.addResourceHandler("/webjars/**")
                        .addResourceLocations("classpath:/META-INF/resources/webjars/");
            }
        };
    }

    @Bean
    public ServletContextInitializer registerServlet() {
        return new ServletContextInitializer() {

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {

            }
        };
    }
}