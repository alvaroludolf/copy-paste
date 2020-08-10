package br.com.loom.copypaste.web;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class Route extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("netty-http")
                .bindingMode(RestBindingMode.json)
                // and output using pretty print
                .dataFormatProperty("prettyPrint", "true")
                .contextPath("/")
                .port(8080);

        from("rest:post:message")
                .tracing()
                .log("Mensagem")
                .transform().simple("XXX");

        from("rest:get:message")
                .to("rest:post:message?host=localhost:8080")
                .transform().body();

    }

}