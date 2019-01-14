package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    WebDriver webDriver;
    WebElement webElement;
    WebElement webElement2;

    @Given("I launch Chrome browser")
    public void i_Launch_Chrome_Browser(){
        webDriver = new ChromeDriver();
    }
    @When("I Open localhost")
    public void i_Open_Local_Host(){
        webDriver.get("http://localhost:8081");
    }
    @Then("I look for the BuildingButton")
            public void i_Look_For_The_BuildingButton(){
        webElement = webDriver.findElement(By.xpath("//*[@id=\"navbarMenu\"]/ul/li[3]/a"));
    }

    @Then("I Click The BuildingsButton")
            public void i_Click_the_BuildingsButton(){
        webElement.click();
    }
    @Then("I verify there is a buildingsHeader")
            public void i_Verify_There_Is_A_BuildingsHeader(){
        webElement2 = webDriver.findElement(By.id("buildingsHeader"));
    }
    @Then("I check that the buildingsHeader has the correct text")
            public void i_Check_That_The_BuildingsHeader_Has_The_Correct_Text(){
        Assert.assertEquals("Buildings",webElement2.getText());

    }
}
