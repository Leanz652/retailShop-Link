package ar.edu.redLink.retailShop.app.apiDolar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/APIDOLAR")
public class DolarApiController {
	
	@GetMapping("")
	public Double getDolar(){
		return DolarAPISingleton.getDolarApi().getPrecioDolar();
	}

}
