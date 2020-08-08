package br.com.loom.copypaste.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("br.com.loom.copypaste.web")
public class CopyPasteWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CopyPasteWebApplication.class, args);
	}

}
