package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import java.io.IOException;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(
		path = "/test/request-param",
		consumes = {MediaType.MULTIPART_MIXED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public void testMultipartMixedWithRequestParam(
		@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
		@RequestParam(value = "file", required = false) MultipartFile file,
		@RequestParam(value = "json", required = false) String json) {

		System.out.printf("%s: %s using @RequestParam; file: %s; json: %s%n",
				HttpHeaders.CONTENT_TYPE, contentType, file, json);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(
			path = "/test/request-part",
			consumes = {MediaType.MULTIPART_MIXED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public void testMultipartMixedWithRequestPart(
			@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
			@RequestPart(value = "file", required = false) MultipartFile file,
			@RequestPart(value = "json", required = false) String json) {

		System.out.printf("%s: %s using @RequestPart; file: %s; json: %s%n",
				HttpHeaders.CONTENT_TYPE, contentType, file, json);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(
			path = "/test/multipart-servlet-request",
			consumes = {MediaType.MULTIPART_MIXED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public void testMultipartMixedWithMultipartServletRequest(
			@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
			MultipartHttpServletRequest request) throws ServletException, IOException {

		System.out.printf("%s: %s using MultipartHttpServletRequest; amount of parts on request: %d%n",
				HttpHeaders.CONTENT_TYPE, contentType, request.getParts().size());
	}

}
