package ar.edu.redLink.retailShop.app.apiDolar;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class dolarSchedule {


	
	@Scheduled(fixedRate = 30*60000)  // 30'. 
	public void actualizarPrecioDolar() {
		DolarAPISingleton.getDolarApi().getDolar();
		System.out.println("task ejecutada" + DolarAPISingleton.getDolarApi().getPrecioDolar());
	}
	
}