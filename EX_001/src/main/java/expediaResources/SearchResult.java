package expediaResources;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchResult {

	public SearchResult(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public WebElement getEscalaUno() {
		return driver.findElement(escalaUno);
	}
	
	public WebElement getOrdenar() {
		return driver.findElement(ordenar);
	}
	
	public void setOrdenado(String ordenado) {
		
		Select s = new Select(driver.findElement(ordenar));
		s.selectByVisibleText(ordenado);
		
	}
	
	public void setVueloSeleccionado(int numeroVuelo) {
			
			driver.findElements(By.cssSelector("button[data-test-id='select-button']")).get(numeroVuelo-1).click();
			
	}
	
	public String getTitulo() {
		
		return driver.getTitle();
		
	}
	
	public void assertCategorias() {
		
		String[] categoriasEsperadas = {"Categoría del establecimiento",
										"Precio por noche",
										"Evaluación de los huéspedes",
										"Forma de pago",
										"Servicios",
										"Tipo de establecimiento",
										"Atracciones populares"};
		
		String[] categoriasReales = {driver.findElement(estrellas).getText(),
									driver.findElement(precio).getText(),
									driver.findElement(evaluacion).getText(),
									driver.findElement(formaPago).getText(),
									driver.findElement(servicios).getText(),
									driver.findElement(tipoEstablecimiento).getText(),
									driver.findElement(atracciones).getText()};
		
		assertArrayEquals(categoriasEsperadas, categoriasReales);
		
		
		
	}
	
	public WebElement getBuscarHotel() {
		return driver.findElement(buscarHotel);
	}
	
	public WebElement getBuscarHotelBoton() {
		return driver.findElement(buscarHotelBoton);
	}
	
	public WebElement getHotel(String numero) {
		
		int numeroHotel = Integer.parseInt(numero);
		
		return driver.findElements(hoteles).get(numeroHotel-1);

	}
	
	public WebElement getPreciosHotel(String numero) {
		
		int precio = Integer.parseInt(numero);
		
		return driver.findElements(preciosHotel).get(precio-1);
		
	}
	
	WebDriver driver;
	
	private static final By escalaUno = By.cssSelector("#stopFilter_stops-1");
	private static final By ordenar = By.cssSelector("#sortDropdown");
	private static final By estrellas = By.cssSelector("#star-legend");
	private static final By precio = By.cssSelector("#price-legend");
	private static final By evaluacion = By.cssSelector("#guestRating-legend");
	private static final By formaPago = By.cssSelector("#cancellable-legend");
	private static final By servicios = By.cssSelector("#amenities-legend");
	private static final By tipoEstablecimiento = By.cssSelector("#lodgingType-legend");
	private static final By atracciones = By.cssSelector("#poiFilter-legend");
	private static final By buscarHotel = By.cssSelector("#inpHotelNameMirror");
	private static final By buscarHotelBoton = By.cssSelector("#hotelNameGoBtn");
	private static final By hoteles = By.cssSelector("article");
	private static final By preciosHotel = By.cssSelector("[class='priceTextLabel']");
	
}
