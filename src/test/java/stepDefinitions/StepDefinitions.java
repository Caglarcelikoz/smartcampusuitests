package stepDefinitions;

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
    WebElement menuButton;
    WebElement header;
    // GENERAL
    @Given("I launch Chrome browser")
    public void i_Launch_Chrome_Browser(){
       System.setProperty("webdriver.chrome.driver","C:\\Users\\caglarcelikoz\\Downloads\\chromedriver.exe");

        webDriver = new ChromeDriver();
    }
    @When("I Open localhost")
    public void i_Open_Local_Host(){
        webDriver.get("http://35.241.249.44");
    }

    // BUILDING
    @Then("I look for the BuildingButton")
            public void i_Look_For_The_BuildingButton(){
        menuButton = webDriver.findElement(By.xpath("//*[@id=\"navbarMenu\"]/ul/li[3]/a"));
    }

    @Then("I Click The BuildingsButton")
            public void i_Click_the_BuildingsButton(){
        menuButton.click();
    }
    @Then("I verify there is a buildingsHeader")
            public void i_Verify_There_Is_A_BuildingsHeader(){
        header = webDriver.findElement(By.id("buildingsHeader"));
    }
    @Then("I check that the buildingsHeader has the correct text")
            public void i_Check_That_The_BuildingsHeader_Has_The_Correct_Text(){
        Assert.assertEquals("Buildings", header.getText());

    }

    // EMPLOYEES
    @Then("I look for the EmployeesButton")
    public void i_Look_For_The_EmployeesButton(){
        menuButton = webDriver.findElement(By.xpath("//*[@id=\"navbarMenu\"]/ul/li[2]/a"));
    }
    @Then("I Click The EmployeesButton")
    public void i_Click_the_EmployeesButton(){
        menuButton.click();
    }
    @Then("I verify there is a employeesHeader")
    public void i_Verify_There_Is_A_EmployeesHeader(){
        header = webDriver.findElement(By.id("employeesHeader"));
    }
    @Then("I check that the employeesHeader has the correct text")
    public void i_Check_That_The_employeesHeader_Has_The_Correct_Text(){
        Assert.assertEquals("Employees", header.getText());

    }

    // COMPANIES
    @Then("I look for the CompaniesButton")
    public void i_Look_For_The_CompaniesButton(){
        menuButton = webDriver.findElement(By.xpath("//*[@id=\"navbarMenu\"]/ul/li[1]/a"));
    }
    @Then("I Click The CompaniesButton")
    public void i_Click_the_CompaniesButton(){
        menuButton.click();
    }
    @Then("I verify there is a CompaniesHeader")
    public void i_Verify_There_Is_A_CompaniesHeader(){
        header = webDriver.findElement(By.id("companiesHeader"));
    }
    @Then("I check that the CompaniesHeader has the correct text")
    public void i_Check_That_The_companiesHeader_Has_The_Correct_Text(){
        Assert.assertEquals("Companies", header.getText());

    }
}
