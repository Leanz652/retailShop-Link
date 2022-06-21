package ar.edu.redLink.retailShop.app.apiDolar;
	
import org.springframework.web.client.RestTemplate;


public final class DolarAPISingleton {
	
	public Double precioDolar;
	private static DolarAPISingleton dolarAPISingleton;
	
	public Double getPrecioDolar() {
		return precioDolar;
	}

	public void setPrecioDolar(Double precioDolar) {
		this.precioDolar = precioDolar;
	}

	public  static DolarAPISingleton getDolarApi() {
		 
		 if (dolarAPISingleton==null) {
		  dolarAPISingleton=new DolarAPISingleton();
		 }
		 
		 return dolarAPISingleton;
		 }
		 
		 private DolarAPISingleton(){
		 }
	
	public void getDolar(){
		String url = "http://api-dolar-argentina.herokuapp.com/api/dolaroficial";
		RestTemplate restTemplate = new RestTemplate();
		Dolar dolar = restTemplate.getForObject(url, Dolar.class);
		precioDolar =  Double.parseDouble(dolar.getVenta());
	}
}