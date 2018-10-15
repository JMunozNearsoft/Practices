package expediaResources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public WebElement getOpcionVuelos() {
		return driver.findElement(opcionVuelos);
	}
	
	public WebElement getOpcionViajeSencillo() {
		return driver.findElement(opcionViajeSencillo);
	}
	
	public WebElement getVueloOrgien() {
		return driver.findElement(vueloOrigen);
	}
	
	public WebElement getVueloDestino() {
		return driver.findElement(vueloDestino);
	}
	
	public WebElement getSalida() {
		return driver.findElement(salida);
	}
	
	public WebElement getRegreso() {
		return driver.findElement(regreso);
	}
	
	public WebElement getVuelosAdultos() {
		return driver.findElement(vuelosAdultos);
	}
	
	public WebElement getBuscarVuelo() {
		return driver.findElement(buscarVuelo);
	}
	
	public WebElement getVuelosNinios() {
		return driver.findElement(vuelosNinios);
	}
	
	public WebElement getFocus() {
		return driver.findElement(focus);
	}
	
	public WebElement getOpcionHotel() {
		return driver.findElement(opcionHotel);
	}
	
	public WebElement getHotelDestino() {
		return driver.findElement(hotelDestino);
	}
	
	public WebElement getHabitaciones() {
		return driver.findElement(habitaciones);
	}
	
	public WebElement getCheckIn() {
		return driver.findElement(checkIn);
	}
	
	public WebElement getCheckOut() {
		return driver.findElement(checkOut);
	}
	
	public WebElement getBuscarHotel() {
		return driver.findElement(buscarHotel);
	}
	
	public void setHotelAdultos(int habitaciones, String numAdultos) {
		
		for (int x=0; x<habitaciones; x++) {
			driver.findElements(hotelAdultos).get(x).click();
			driver.findElement(By.cssSelector("#hotel-"+(x+1)+"-adults-hp-hotel > option:nth-child("+numAdultos+")")).click();
			driver.findElement(focus).click();
		}
		
	}
	
	public void setHotelNinios(int habitaciones, String numNinios) {
		int numNiniosInt = Integer.parseInt(numNinios)+1;
		for (int x=0; x<habitaciones; x++) {
			driver.findElements(hotelNinios).get(x).click();
			driver.findElement(By.cssSelector("#hotel-"+(x+1)+"-children-hp-hotel > option:nth-child("+numNiniosInt+")")).click();
			driver.findElement(focus).click();
		}
		
	}
	
	WebDriver driver;
	
	private static final By opcionVuelos = By.cssSelector("#tab-flight-tab-hp");
	private static final By opcionViajeSencillo = By.cssSelector("#flight-type-one-way-label-hp-flight");
	private static final By vueloOrigen = By.cssSelector("#flight-origin-hp-flight");
	private static final By vueloDestino = By.cssSelector("#flight-destination-hp-flight");
	private static final By salida = By.id("flight-departing-single-hp-flight");
	private static final By regreso = By.cssSelector("#flight-returning-hp-flight");
	private static final By vuelosAdultos = By.cssSelector("#flight-adults-hp-flight");
	private static final By vuelosNinios = By.cssSelector("#flight-children-hp-flight");
	private static final By buscarVuelo = By.cssSelector("#gcw-flights-form-hp-flight > div.cols-nested.ab25184-submit > label > button");
	private static final By focus = By.cssSelector("#wizard-tabs");
	private static final By opcionHotel = By.cssSelector("#tab-hotel-tab-hp");
	private static final By hotelDestino = By.cssSelector("#hotel-destination-hp-hotel");
	private static final By habitaciones = By.cssSelector("#hotel-rooms-hp-hotel");
	private static final By checkIn = By.cssSelector("#hotel-checkin-hp-hotel");//("#hotel-rooms-hp-hotel");
	private static final By checkOut = By.cssSelector("#hotel-checkout-hp-hotel");//("#hotel-rooms-hp-hotel");
	private static final By hotelAdultos = By.cssSelector("select[class='num-adults gcw-storeable gcw-guests-field'][id*='adults-hp-hotel']");
	private static final By hotelNinios = By.cssSelector("select[class='  num-children gcw-storeable gcw-toggles-fields gcw-toggles-field-by-value gcw-guests-field seat-children']");
	private static final By buscarHotel = By.cssSelector("#gcw-hotel-form-hp-hotel > div.cols-nested.ab25184-submit > label > button");
}
