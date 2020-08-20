package br.com.loom.copypaste.web;

import br.com.loom.copypaste.CopyPaste;
import br.com.loom.copypaste.CopyPasteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CopyPasteWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CopyPasteWebApplication.class, args);
    }

    @Bean
    public CopyPaste copyPaste() {
        return CopyPasteBuilder.create().build();
    }

}
