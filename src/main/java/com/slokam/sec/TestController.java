package com.slokam.sec;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// hi babli reddy ?
@RestController
public class TestController {

	
	// Iagtegrgyrcvubi
	@GetMapping("hi")
	@PreAuthorize("hasRole('ADMIN')")
	public String hi() {
		
		return "Hiii Hello";
	}
	
	@GetMapping("hello")
	@PreAuthorize("hasRole('USER')")
	public String hello() {
		
		return "Hello Hiii";
	}
	@GetMapping("/api/data")
	public String dataEithoutSecurity() {
		return "dataEithoutSecurity";
	}
}
