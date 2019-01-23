package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class StepDefinitions {
    //webdrivers
    WebDriver webDriver;
    WebElement menuButton;
    WebElement header;
    WebElement searchBox;
    WebElement table;
    WebElement employeeFirstname;
    WebElement companyName;
    WebElement smartCampusLogo;
    WebElement restartButton;
    int error;
    // GENERAL
    @Given("I launch Chrome browser")
    public void i_Launch_Chrome_Browser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\caglarcelikoz\\Downloads\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Windows\\Downloads\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    @Then("I close the browser window")
    public void i_close_the_browser_window(){
        webDriver.close();
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
        if (header.getText().equals("Buildings")){
            error=1;
        }
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
    @Then("save to testrail")
    public void save() throws IOException, APIException {
        APIClient client = new APIClient("https://pxl.testrail.com/");
        client.setUser("caglar.celikoz@student.pxl.be");
        client.setPassword("mlyA4v8xVPsMKUc/Fo.R-x9jBlbG02evy98aezcAy"); // api key testrail ipv persoonlijke wachtwoord

        JSONObject c = (JSONObject) client.sendGet("get_case/3640");
        System.out.println("Test voor: " + c.get("title"));

        System.out.println();

        c = (JSONObject) client.sendGet("get_user_by_email&email=caglar.celikoz@student.pxl.be");
        System.out.println("Test uitgevord als: " + c.get("name"));
        System.out.println(c.get("email"));
        System.out.println(c.get("id"));

        JSONObject obj = new JSONObject();

        if(error == 0) {
            // Er is geen error
            obj.put("status_id", "1");
            obj.put("defects", "/");
        } else {
            // Er is een error
            obj.put("status_id", "5");

        }

        obj.put("version", "0.1");
        obj.put("elapsed", "1s");
        obj.put("assignedto_id", "13");
        obj.put("comment", "Automatisch testen door selenium door caglar");

        client.sendPost("add_result/6885", obj);


    }

    @Then("^I verify there is a employeesSearchBox$")
    public void iVerifyThereIsAEmployeesSearchBox() {
        searchBox = webDriver.findElement(By.id("searchBarEmployees"));
    }

    @Then("^I give in firstname:(.*)")
    public void iGiveInFirstnameJaakie(String firstname) {
        searchBox.sendKeys(firstname);
    }

    @Then("I verify given firstname:(.*) is in table")
    public void iVerifyGivenFirstnameIsInTable(String firstname) {

        table = webDriver.findElement(By.id("employeeTable"));
        employeeFirstname =table.findElement(By.id("1_First_Name"));
        Assert.assertEquals(firstname,employeeFirstname.getText());
    }

    @Then("^I verify there is a companiesSearchBox$")
    public void iVerifyThereIsACompaniesSearchBox(){
        searchBox = webDriver.findElement(By.id("searchBarCompanies"));
    }

    @Then("^I give in companyName (.*)$")
    public void iGiveInCompanyNameCompanyName(String companyName){
        searchBox.sendKeys(companyName);
    }

    @Then("^I verify given companyName (.*) is in table$")
    public void iVerifyGivenCompanyNameCompanyNameIsInTable(String companyName){
        table = webDriver.findElement(By.id("companyTable"));
        this.companyName =table.findElement(By.id("1_Name"));
        Assert.assertEquals(companyName,this.companyName.getText());
    }

    @Then("^I look for the Smart Campus logo$")
    public void iLookForTheSmartCampusLogo() {
        smartCampusLogo = webDriver.findElement(By.id("smartCordaLogo"));
    }

    @Then("^I Click The Smart Campus logo$")
    public void iClickTheSmartCampusLogo(){
       smartCampusLogo.click();
    }

    @Then("^I verify that I'm redirected to the home page$")
    public void iVerifyThatIMRedirectedToTheHomePage(){
        String URL = webDriver.getCurrentUrl();
        Assert.assertEquals(URL, "http://35.241.249.44/chatbot" );
    }

    @Then("^I look for the restart button$")
    public void iLookForTheRestartButton(){
        restartButton = webDriver.findElement(By.id("restartButton"));
    }

    @Then("^I Click The restart button$")
    public void iClickTheRestartButton() throws InterruptedException {
        restartButton.click();
    }

    @Then("^I Verify That The CUI Shows A Welcome Message$")
    public void iVerifyThatTheCUIShowsAWelcomeMessage() throws InterruptedException {
        Thread.sleep(5000);
        WebElement welcomeMessage = webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/div/div[2]/div[1]/p"));
        Assert.assertEquals("Hi there, I'm Charlie and I can help you get to your destination!",welcomeMessage.getText());
    }
}
