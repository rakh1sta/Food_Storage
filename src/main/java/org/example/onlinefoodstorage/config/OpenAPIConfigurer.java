package org.example.onlinefoodstorage.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.example.onlinefoodstorage.properties.OpenAPIProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", havingValue = "true", matchIfMissing = true)
public class OpenAPIConfigurer {
    private static final String SCHEMA = "Bearer";
    private static final String BEARER_FORMAT = "JWT";
    private static final String SECURITY_SCHEMA_NAME = "Food Store security schema";

    private final OpenAPIProperties properties;

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .schemaRequirement(SECURITY_SCHEMA_NAME, getSecurityScheme())
                .security(getSecurityRequirement())
                .info(info());
//                .servers(getServices());
    }

    private List<Server> getServices() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Server URL in Development environment");
        return List.of(devServer);
    }

    private SecurityScheme getSecurityScheme() {
        SecurityScheme scheme = new SecurityScheme();
        scheme.bearerFormat(BEARER_FORMAT);
        scheme.type(SecurityScheme.Type.HTTP);
        scheme.in(SecurityScheme.In.HEADER);
        scheme.scheme(SCHEMA);
        return scheme;
    }

    private List<SecurityRequirement> getSecurityRequirement() {
        SecurityRequirement requirement = new SecurityRequirement();
        requirement.addList(SECURITY_SCHEMA_NAME);
        return List.of(requirement);
    }

    private Info info() {
        return new Info()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .version(properties.getVersion())
                .contact(new Contact()
                        .name(properties.getContactName())
                        .email(properties.getContactEmail())
                        .url(properties.getContactUrl()))
                .license(new License()
                        .name(properties.getLicenseName())
                        .url(properties.getLicenseUrl()));
    }
}
