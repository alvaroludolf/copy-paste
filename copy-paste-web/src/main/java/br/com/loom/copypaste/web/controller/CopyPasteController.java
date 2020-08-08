package br.com.loom.copypaste.web.controller;

import java.awt.image.DataBuffer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/receive")
public class CopyPasteController {

	@RequestMapping(value = "**")
	public Mono<ServerResponse> getAnythingelse(ServerRequest request) {
		
		Mono<DataBuffer> body = request.bodyToMono(DataBuffer.class);
		body.subscribe(System.out::println);
		return ServerResponse.ok().build();
	}

}
