package ar.edu.redLink.retailShop.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"","/home"})
public class HomeController {
	
	@GetMapping("/hola")
	public String hola() {
		return "hola";
	}
	
	
	

}
