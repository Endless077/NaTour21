package com.natour.Server.Utils;

import org.springframework.http.HttpHeaders;

public class Headers {
	
	public HttpHeaders headers;

	//Constructor
	public Headers() {
		super();
		this.headers = new HttpHeaders();
		headers.add("Information-Service", "Personal Header");
		headers.add("Server", "SpringBoot v2.6.3/JDK 17");
		headers.add("Application", "NaTour21");
		headers.add("Content-Language", "en");

	}

	public Headers(String message) {
		super();
		this.headers = new HttpHeaders();
		headers.add("Information-Service", message);
		headers.add("Server", "SpringBoot 2.6.3/JDK 17");
		headers.add("Application", "NaTour21");
		headers.add("Content-Language", "en");
	}
	
	
	public void addHeader(String key, String Value) {
		this.headers.add(key, Value);
	}
	
	public void removeHeader(String key, String value) {
		this.headers.remove(key);
	}
	
	//Getter e Setter
	public HttpHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
	
}
