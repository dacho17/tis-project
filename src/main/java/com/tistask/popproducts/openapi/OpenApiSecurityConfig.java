package com.tistask.popproducts.openapi;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
  info =@Info(
    title = "PopProduct API",
    version = "${api.version}",
    contact = @Contact(
      name = "David", email = "david@tis.com", url = ""
    ),
    description = "${api.description}"
  ),
  servers = @Server(
    url = "${api.server.url}",
    description = "Development"
  )
)

public class OpenApiSecurityConfig {

}
