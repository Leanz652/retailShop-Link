package ar.edu.redLink.retailShop.app.apiDolar;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/APIDOLAR")
public class DolarApiController {
	
	@GetMapping("")
	public Double getDolar(){
		String url = "http://api-dolar-argentina.herokuapp.com/api/dolaroficial";
		RestTemplate restTemplate = new RestTemplate();
		Dolar dolar = restTemplate.getForObject(url, Dolar.class);
		return Double.parseDouble(dolar.getVenta());
	}

}
