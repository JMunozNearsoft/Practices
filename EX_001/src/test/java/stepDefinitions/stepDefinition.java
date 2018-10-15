package stepDefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import expediaResources.HomePage;
import expediaResources.SearchResult;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Cucumber.class)
public class stepDefinition{
	
	public stepDefinition() {
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		homePage = new HomePage(driver);
		searchResult = new SearchResult(driver);

	}
	
	public void oneSecond() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Given("^User is on web page$")
    public void user_is_on_web_page() throws Throwable {
        driver.get("https://www.expedia.mx/");
    }

    @When("^User select flight option$")
    public void user_select_flight_option() throws Throwable {
    	oneSecond();
    	homePage.getOpcionVuelos().click();
    }

    @And("^User filter for 1 stop$")
    public void user_filter_for_1_stop() throws Throwable {
    	oneSecond();
    	oneSecond();
    	oneSecond();
    	searchResult.getEscalaUno().click();
    }

    @Then("^The page shows the results table for flights$")
    public void page_shows_results_table() throws Throwable {
    	oneSecond();
    	
    	String winHandleBefore = driver.getWindowHandle();

    	driver.findElement(By.cssSelector("#titleBar > div > p > small")).click();
    	for(String winHandle : driver.getWindowHandles()){
    	    driver.switchTo().window(winHandle);
    	}

    	driver.close();

    	driver.switchTo().window(winHandleBefore);
    }

    @Then("^Summary trip page is displayed$")
    public void summary_trip_page_is_displayed() throws Throwable {
    	oneSecond();
    	System.out.println("Se muestra resumen");
    }

    @And("^User select one way travel option$")
    public void user_select_one_way_travel_option() throws Throwable {
    	oneSecond();
    	homePage.getOpcionViajeSencillo().click();
    }

    @And("^User select origin city for a flight \"([^\"]*)\"$")
    public void user_select_origin_city_flight_something(String strArg1) throws Throwable {
    	oneSecond();
    	homePage.getVueloOrgien().sendKeys(strArg1);
    	homePage.getFocus().click();
    }

    @And("^User select destination city for a flight \"([^\"]*)\"$")
    public void user_select_destination_city_flight_something(String strArg1) throws Throwable {
    	oneSecond();
    	homePage.getVueloDestino().sendKeys(strArg1);
    	homePage.getFocus().click();
    }

    @And("^User select departure date \"([^\"]*)\"$")
    public void user_select_departure_date_something(String strArg1) throws Throwable {
    	oneSecond();
    	homePage.getSalida().click();
    	homePage.getSalida().sendKeys(strArg1);
    	homePage.getFocus().click();
    }

    @And("^User select returning date \"([^\"]*)\"$")
    public void user_select_returning_date_something(String strArg1) throws Throwable {
    	oneSecond();
    	homePage.getRegreso().click();
    	homePage.getRegreso().sendKeys(strArg1);
    	homePage.getFocus().click();
    }

    @And("^User select adults for flight \"([^\"]*)\"$")
    public void user_select_adults_for_flight_something(String strArg1) throws Throwable {
    	oneSecond();
    	homePage.getVuelosAdultos().click();
    	homePage.getVuelosAdultos().sendKeys(strArg1);
    	homePage.getFocus().click();
    }

    @And("^User select children for flight \"([^\"]*)\"$")
    public void user_select_children_for_flight_something(String strArg1) throws Throwable {
    	oneSecond();
    	homePage.getVuelosNinios().click();
    	homePage.getVuelosNinios().sendKeys(strArg1);
    	homePage.getFocus().click();
    }

    @And("^User clicks Search button \"([^\"]*)\"$")
    public void user_clicks_search_button(String strArg1) throws Throwable {
    	oneSecond();
    	if (strArg1.equals("flight")) {
    		homePage.getBuscarVuelo().click();
    	}
    	else if (strArg1.endsWith("hotel")) {
    		homePage.getBuscarHotel().click();
    	}
    }

    @And("^User order flight \"([^\"]*)\"$")
    public void user_order_flight_something(String strArg1) throws Throwable {
        searchResult.getOrdenar().click();
    	searchResult.setOrdenado(strArg1);
    }

    @And("^User select third flight$")
    public void user_select_third_flight() throws Throwable {
    	oneSecond();
    	searchResult.setVueloSeleccionado(3);
    }
    
    @When("^User select hotel option$")
    public void user_select_hotel_option() throws Throwable {
        homePage.getOpcionHotel().click();
    }

    @And("^User select destination city for an hotel \"([^\"]*)\"$")
    public void user_select_destination_city_hotel_something(String strArg1) throws Throwable {
        homePage.getHotelDestino().sendKeys(strArg1);
        driver.findElement(By.cssSelector("#wizard-tabs")).click();
        oneSecond();
    }

    @And("^User select check-in \"([^\"]*)\"$")
    public void user_select_checkin_something(String strArg1) throws Throwable {
    	homePage.getCheckIn().sendKeys(strArg1);
    	driver.findElement(By.cssSelector("#wizard-tabs")).click();
        oneSecond();
    }

    @And("^User select check-out \"([^\"]*)\"$")
    public void user_select_checkout_something(String strArg1) throws Throwable {
    	homePage.getCheckOut().sendKeys(strArg1);
    	driver.findElement(By.cssSelector("#wizard-tabs")).click();
        oneSecond();
    }

    @And("^User select rooms \"([^\"]*)\"$")
    public void user_select_rooms_something(String strArg1) throws Throwable {
    	rooms = Integer.parseInt(strArg1);
        homePage.getHabitaciones().click();
        oneSecond();
        homePage.getHabitaciones().sendKeys(strArg1);
        oneSecond();
    }

    @And("^User select adults for hotel \"([^\"]*)\"$")
    public void user_select_adults_hotel_something(String strArg1) throws Throwable {
        homePage.setHotelAdultos(rooms, strArg1);
        oneSecond();
    }

    @And("^User select children for hotel \"([^\"]*)\"$")
    public void user_select_children_hotel_something(String strArg1) throws Throwable {
        homePage.setHotelNinios(rooms, strArg1);
        oneSecond();
    }
    
    @Then("^Page shows Results table for hotel searchs$")
    public void page_shows_results_table_for_hotel_searchs() throws Throwable {
        searchResult.assertCategorias();
    }
    
    @Then("^Page shows Hotel result$")
    public void page_shows_hotel_result() throws Throwable {
        
    }

    @And("^User sort by price \"([^\"]*)\"$")
    public void user_sort_by_price_something(String strArg1) throws Throwable {
        searchResult.getPreciosHotel(strArg1).click();
        oneSecond();
    }

    @And("^User search an hotel \"([^\"]*)\"$")
    public void user_search_an_hotel_something(String strArg1) throws Throwable {
    	searchResult.getBuscarHotel().click();
        oneSecond();
    	searchResult.getBuscarHotel().sendKeys(strArg1);
        oneSecond();
        
        String winHandleBefore = driver.getWindowHandle();

        searchResult.getBuscarHotelBoton().click();
    	for(String winHandle : driver.getWindowHandles()){
    	    driver.switchTo().window(winHandle);
    	}

    	driver.close();

    	driver.switchTo().window(winHandleBefore);
    	oneSecond();
        
    }

    @And("^User select hotel No \"([^\"]*)\"$")
    public void user_select_hotel_no_something(String strArg1) throws Throwable {
        searchResult.getHotel(strArg1).click();
    }
    
    @Then("^Explorer is closed$")
    public void explorer_is_closed() throws Throwable {
        driver.quit();
    }

    static WebDriver driver;
	static HomePage homePage;
	static SearchResult searchResult;
	static int rooms = 1;
}
