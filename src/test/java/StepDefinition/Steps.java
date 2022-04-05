package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Steps {
    private WebDriver driver;

    @Given("^Open the browser and launch the application$")
    public void open_the_browser_and_launch_the_application() {
        System.setProperty("webdriver.chrome.driver", "/home/alex/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/elements");
    }

    @When("^select textbox element$")
    public void select_textbox_element() {
        final WebElement webElement = driver.findElement(By.id("item-0"));
        webElement.click();
    }

    @Then("^show data$")
    public void show_data() {
        assertTrue(driver.findElement(By.id("output")).isDisplayed(), "Not displayed data");
    }

    @And("^Enter the (.+) and (.+) and (.+) and (.+)$")
    public void enter_the_and_and_and(final String fullname,
                                      final String email,
                                      final String currentaddress,
                                      final String permanentaddress) {
        final WebElement userName = driver.findElement(By.id("userName"));
        final WebElement userEmail = driver.findElement(By.id("userEmail"));
        final WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        final WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        userName.sendKeys(fullname);
        userEmail.sendKeys(email);
        currentAddress.sendKeys(currentaddress);
        permanentAddress.sendKeys(permanentaddress);
    }

    @And("^Click in submit$")
    public void click_in_submit() {
        final WebElement webElement = driver.findElement(By.id("submit"));
        webElement.click();
    }
}
