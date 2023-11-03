package StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;


import java.util.List;
import java.util.Set;

public class StepDefinition {
	
	WebDriver driver;
    private String parentHandle;
    JavascriptExecutor js;
    Actions ac;
    
    
    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ec65f\\OneDrive\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/index.html");
        parentHandle = driver.getWindowHandle();
    }
    
    @When("I click on the IFRAME link")
    public void i_click_on_the_IFRAME_link() throws InterruptedException {
    	Thread.sleep(2000);
    	ac=new Actions(driver);
    	ac.scrollByAmount(0, 300);
    	ac.moveToElement(driver.findElement(By.id("iframe")));
        WebElement iframeLink = driver.findElement(By.xpath("//*[@id=\"iframe\"]"));
        iframeLink.click();
    }
    
    @Then("a new tab should open and I switch to it")
    public void a_new_tab_should_open_and_I_switch_to_it() throws InterruptedException {
    	Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
            }
        }
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame']")));
        
    }
    
    @Then("I verify the presence of the image and navigate through images")
    public void i_verify_the_presence_of_the_image_and_navigate_through_images() throws InterruptedException {   
        driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/ol/li[1]")).click();
    	List<WebElement> images = driver.findElements(By.xpath("//*[@id=\"slide-image-1\"]"));
		Thread.sleep(1000);
        Assert.assertTrue(images.get(0).isDisplayed(),"Image1 is displayed");
    	WebElement rightArrowButton = driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/a[2]"));
		rightArrowButton.click();
		Thread.sleep(1000);
        Assert.assertTrue(images.get(1).isDisplayed(),"Image2 is displayed");
		rightArrowButton.click();
		Thread.sleep(1000);
        WebElement image3 = driver.findElement(By.xpath("//*[@id=\"slide-image-3\"]"));
        Assert.assertTrue(image3.isDisplayed(),"Image3 is displayed");
        driver.quit();
    }
}
