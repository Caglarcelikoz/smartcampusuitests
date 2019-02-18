package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    WebElement employeesButtonCUI;
    WebElement buildingsButtonCUI;
    WebElement companiesButtonCUI;
    WebElement categoryMessageCUI;
    WebElement noButtonBuildings;
    WebElement noButtonEmployees;
    WebElement noButtonCompanies;
    WebElement finalMessageBuildings;
    WebElement finalMessageEmployees;
    WebElement finalMessageCompanies;
    WebElement companyTableName;
    WebElement companyTableBuilding;
    WebElement companyTableNameColumn;
    WebElement companyTableBuildingColumn;
    WebElement questionMessage;
    WebElement inputFieldCUI;
    WebElement sendButton;
    WebElement foundBuildingMessage;
    WebElement foundEmployeeMessage;
    WebElement buttonToTable;
    String inputText;
    final String WELCOME_MESSAGE="Hi there, I'm Charlie and I can help you get to your destination!";
    final String QUESTION_MESSAGE_BUILDING="Which building are you looking for?";
    final String QUESTION_MESSAGE_EMPLOYEE="What is the first and last name of the employee you are looking for?";
    final String FINAL_MESSAGE="Okay, good luck!";
    final String COMPANY_TABLE_FIRST_COLUMN_TITLE="Company name";
    final String COMPANY_TABLE_SECOND_COLUMN_TITLE="Building";

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
        webDriver.get("https://test.smartcampus.be");
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
        if (!header.getText().equals("Companies")){
            error=1;
        }
    }

    @Then("^I verify there is a employeesSearchBox$")
    public void iVerifyThereIsAEmployeesSearchBox() throws InterruptedException {
        searchBox = webDriver.findElement(By.id("searchBarEmployees"));
        Thread.sleep(2000);
    }

    @Then("^I give in firstname:(.*)")
    public void iGiveInFirstnameJaakie(String firstname) throws InterruptedException {
        searchBox.sendKeys(firstname);
        Thread.sleep(2000);
    }

    @Then("I verify given firstname:(.*) is in table")
    public void iVerifyGivenFirstnameIsInTable(String firstname) {

        table = webDriver.findElement(By.id("employeeTable"));
        employeeFirstname =table.findElement(By.id("1_First_Name"));
        Assert.assertEquals(firstname,employeeFirstname.getText());
        if (!employeeFirstname.getText().equals(firstname)){
            error=1;
        }
    }

    @When("^I verify there is a companiesSearchBox$")
    public void iVerifyThereIsACompaniesSearchBox(){
        searchBox = webDriver.findElement(By.id("searchBarCompanies"));
    }

    @Then("^I give in companyName (.*)$")
    public void iGiveInCompanyNameCompanyName(String companyName) throws InterruptedException {
        searchBox.sendKeys(companyName);
        Thread.sleep(1000);
    }

    @When("^I verify given companyName (.*) is in table$")
    public void iVerifyGivenCompanyNameCompanyNameIsInTable(String companyName){
        table = webDriver.findElement(By.id("companyTable"));
        this.companyName =table.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr[1]/td[1]"));
        Assert.assertEquals(companyName,this.companyName.getText()); //controle voor de test
        if (!this.companyName.getText().equals(companyName)){ //controle voor testrail
            error=1;
        }
    }
    @When("^I verify given employeeName (.*) is in table$")
    public void iVerifyGivenEmployeeNameCompanyNameIsInTable(String employeeName){
        table = webDriver.findElement(By.id("employeeTable"));
        this.employeeFirstname =table.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr[1]/td[1]"));
        Assert.assertEquals(employeeName,this.employeeFirstname.getText()); //controle voor de test
        if (!this.employeeFirstname.getText().equals(employeeName)){ //controle voor testrail
            error=1;
        }
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
        Assert.assertEquals(URL, "https://test.smartcampus.be/chatbot" );
    }

    @Then("^I look for the restart button$")
    public void iLookForTheRestartButton(){
        restartButton = webDriver.findElement(By.id("restartButton"));
    }

    @Then("^I Click The restart button$")
    public void iClickTheRestartButton() {
        restartButton.click();
    }

    @Then("^I Verify That The CUI Shows A Welcome Message$")
    public void iVerifyThatTheCUIShowsAWelcomeMessage() throws InterruptedException {
        Thread.sleep(5000);
        WebElement welcomeMessage = webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div/div[2]/div[1]/p"));
        Assert.assertEquals("Hi there, I'm Charlie and I can help you get to your destination!",welcomeMessage.getText());
        if (!welcomeMessage.getText().equals(WELCOME_MESSAGE)){
            error=1;
        }
    }

    @Then("^add to testrun (.*) (.*)$")
    public void addToTestRun(String testRun,String testCase) throws IOException, APIException, InterruptedException {
        APIClient client = new APIClient("https://pxl.testrail.com/");
        client.setUser("caglar.celikoz@student.pxl.be");
        client.setPassword("mlyA4v8xVPsMKUc/Fo.R-x9jBlbG02evy98aezcAy"); // api key testrail ipv persoonlijke wachtwoord

        JSONObject obj = new JSONObject();

        if(error == 0) {
            // Er is geen error
            obj.put("status_id", "1");

        } else {
            // Er is een error
            obj.put("status_id", "5");

        }
        obj.put("defects", "");//we laten die leeg zodat er via testrail een bug aangemaakt kan worden in Jira
        obj.put("version", "0.1");
        obj.put("elapsed", "1s");
        obj.put("assignedto_id", "13"); //id caglar
        obj.put("comment", "Automatisch testen met selenium & cucumber");

        client.sendPost("add_result_for_case/"+testRun+"/"+testCase, obj);

    }


    @Then("save to testrail")
    public void save() throws IOException, APIException {
        APIClient client = new APIClient("https://pxl.testrail.com/");
        client.setUser("caglar.celikoz@student.pxl.be");
        client.setPassword("mlyA4v8xVPsMKUc/Fo.R-x9jBlbG02evy98aezcAy"); // api key testrail ipv persoonlijke wachtwoord

      /*  JSONObject c = (JSONObject) client.sendGet("get_case/3640");
        System.out.println("Test voor: " + c.get("title"));

        System.out.println();

        c = (JSONObject) client.sendGet("get_user_by_email&email=caglar.celikoz@student.pxl.be");
        System.out.println("Test uitgevord als: " + c.get("name"));
        System.out.println(c.get("email"));
        System.out.println(c.get("id"));*/

        JSONObject obj = new JSONObject();

        if(error == 0) {
            // Er is geen error
            obj.put("status_id", "1");
            obj.put("defects", "");
        } else {
            // Er is een error
            obj.put("status_id", "5");
            obj.put("defects", "");

        }

        obj.put("version", "0.1");
        obj.put("elapsed", "1s");
        obj.put("assignedto_id", "13");
        obj.put("comment", "Automatisch testen door selenium door caglar");

        client.sendPost("add_result/6885", obj);


    }

    @Then("^I Verify That There Is A Buildings Button In The CUI$")
    public void iVerifyThatThereIsABuildingsButtonInTheCUI() {
        buildingsButtonCUI= webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[3]/button"));
        Assert.assertNotNull(buildingsButtonCUI);
        if (!buildingsButtonCUI.getText().equals("buildings")){
            error=1;
        }
    }
    @Then("^I Verify That There Is A Companies Button In The CUI$")
    public void iVerifyThatThereIsACompaniesButtonInTheCUI() {
        companiesButtonCUI= webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[1]/button"));
        Assert.assertNotNull(companiesButtonCUI);
        if (!companiesButtonCUI.getText().equals("companies")){
            error=1;
        }
    }
    @Then("^I Verify That There Is A Employees Button In The CUI$")
    public void iVerifyThatThereIsAEmployeesButtonInTheCUI() {
        employeesButtonCUI= webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[2]/button"));
        Assert.assertNotNull(employeesButtonCUI);
        if (!employeesButtonCUI.getText().equals("employees")){
            error=1;
        }
    }

    @When("^I Click On The Buildings Button In The CUI$")
    public void iClickOnTheBuildingsButtonInTheCUI(){
      buildingsButtonCUI.click();
    }
    @When("^I Click On The Employees Button In The CUI$")
    public void iClickOnTheEmployeesButtonInTheCUI(){
        employeesButtonCUI.click();
    }


    @Then("^I Verify That There The CUI Shows A Message With The Text buildings")
    public void iVerifyThatThereTheCUIShowsAMessageWithTheTextBuildings() {
        categoryMessageCUI=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[3]/div/div/p"));
        Assert.assertEquals("buildings", categoryMessageCUI.getText());

        if (!categoryMessageCUI.getText().equals("buildings")){
            error=1;
        }
    }
    @Then("^I Verify That There The CUI Shows A Message With The Text employees")
    public void iVerifyThatThereTheCUIShowsAMessageWithTheTextEmployees() {
        categoryMessageCUI=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[3]/div/div/p"));
        Assert.assertEquals("employees", categoryMessageCUI.getText());

        if (!categoryMessageCUI.getText().equals("employees")){
            error=1;
        }
    }
    @Then("^I Verify That The CUI Asks Which Employee The User Is Looking For$")
    public void iVerifyThatTheCUIAsksWhichEmployeeTheUserIsLookingFor() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        questionMessage=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[4]/div/div[2]/div/p"));
        Assert.assertEquals(QUESTION_MESSAGE_EMPLOYEE,questionMessage.getText());
        if (!QUESTION_MESSAGE_EMPLOYEE.equals(questionMessage.getText())){
            error=1;
        }
    }

    @And("^I Verify That The CUI Asks Which Building The User Is Looking For$")
    public void iVerifyThatTheCUIAsksWhichBuildingTheUserIsLookingFor() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        questionMessage=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[4]/div/div[2]/div/p"));
        Assert.assertEquals(QUESTION_MESSAGE_BUILDING,questionMessage.getText());
        if (!QUESTION_MESSAGE_BUILDING.equals(questionMessage.getText())){
            error=1;
        }
    }

    @When("^I give in BuildingName (.*) On The InputField$")
    public void iGiveInBuildingNameOnTheInputField(String buildingName) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputFieldCUI=webDriver.findElement(By.id("inputField"));
        inputFieldCUI.sendKeys(buildingName);
        inputText=buildingName;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("^I give in EmployeeName (.*) On The InputField$")
    public void iGiveInEmployeeNameEmployeeNameOnTheInputField(String employeeName) {

        inputFieldCUI=webDriver.findElement(By.id("inputField"));
        inputFieldCUI.sendKeys(employeeName);
        inputText=employeeName;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I Verify That The CUI Shows The Correct Messages When The Given Building Name Exists$")
    public void iVerifyThatTheCUIShowsTheCorrectMessagesWhenTheGivenBuildingNameExists() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        foundBuildingMessage=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[6]/div/div[2]/div[1]/p"));
        Assert.assertTrue(foundBuildingMessage.getText().contains(inputText.substring(0,1).toUpperCase()));
        if (!foundBuildingMessage.getText().contains(inputText.substring(0,1).toUpperCase())){
            error=1;
        }
    }
    @Then("^I Verify That The CUI Shows The Correct Messages When The Given Employee Name Exists$")
    public void iVerifyThatTheCUIShowsTheCorrectMessagesWhenTheGivenEmployeeNameExists() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        foundEmployeeMessage=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[6]/div/div[2]/div[1]/p"));
        Assert.assertTrue(foundEmployeeMessage.getText().contains("You selected"));
        if (!foundEmployeeMessage.getText().contains("You selected")){
            error=1;
        }
    }

    @When("^I Click On No Button In Buildings Flow$")
    public void iClickOnNoButtonInBuildingsFlow() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        noButtonBuildings=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[7]/div/div[2]/div[2]/button"));
        noButtonBuildings.click();
    }

    @Then("^I Verify That The CUI Shows A Correct Final Message In The Buildings Flow$")
    public void iVerifyThatTheCUIShowsACorrectFinalMessageInTheBuildingsFlow() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finalMessageBuildings=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[9]/div/div[2]/div/p"));
        Assert.assertEquals(FINAL_MESSAGE,finalMessageBuildings.getText());
        if (!FINAL_MESSAGE.equals(finalMessageBuildings.getText())){
            error=0;
        }
    }

    @And("^I Click On The Send Button$")
    public void iClickOnTheSendButton() {
        sendButton=webDriver.findElement(By.id("sendButton"));
        sendButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I verify that the correct column titles are visible in the table$")
    public void iVerifyThatTheCorrectColumnTitlesAreVisibleInTheTable() {
        companyTableName=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/table/thead/tr/th[1]"));
        companyTableBuilding=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/table/thead/tr/th[2]"));
        Assert.assertEquals(COMPANY_TABLE_FIRST_COLUMN_TITLE,companyTableName.getText());
        Assert.assertEquals(COMPANY_TABLE_SECOND_COLUMN_TITLE,companyTableBuilding.getText());
    }

    @Then("^I verify that the table contains given companyName (.*) and the corresponding building details (.*)$")
    public void iVerifyThatTheTableContainsGivenCompanyNameCompanyNameAndTheCorrespondingBuildingDetailsBuilding(String companyName,String building) throws InterruptedException {

        companyTableNameColumn = webDriver.findElement(By.id("companyTable"));
        List<WebElement> rowVals = companyTableNameColumn.findElements(By.tagName("tr"));
        int colNum = webDriver.findElements(By.xpath("//table[@id='companyTable']/tbody/tr[1]/td")).size();
        int rowNum = webDriver.findElements(By.xpath("//table[@id='companyTable']/tbody/tr")).size();
        List<String>list=new ArrayList<>();
        for(int i=1; i<rowNum; i++){
            List<WebElement> colVals = rowVals.get(i).findElements(By.tagName("td"));
            for(int j=0; j<colNum; j++){
                list.add(colVals.get(j).getText());

            }


        }
     //   list.forEach(System.out::println);
          Assert.assertTrue(list.contains(companyName));
         Assert.assertTrue(list.get(list.indexOf(companyName)+1).contains(building));
         if (list.contains(companyName)||!list.get(list.indexOf(companyName)+1).contains(building)){
             error=1;

         }
         Thread.sleep(1000);
    }

    @Then("^I Verify That The CUI Shows The Correct Messages When The Given Building Name Not Exists$")
    public void iVerifyThatTheCUIShowsTheCorrectMessagesWhenTheGivenBuildingNameNotExists()  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        foundBuildingMessage=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[6]/div/div[2]/div[1]/p"));
        Assert.assertTrue(foundBuildingMessage.getText().contains("I could not find a building with the name"));
        if (!foundBuildingMessage.getText().contains(inputText.substring(0,1).toUpperCase())){
            error=1;
        }
    }

    @When("^I Click On The Buildings Button To Check The Table With All Buildings$")
    public void iClickOnTheBuildingsButtonToCheckTheTableWithAllBuildings() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buttonToTable = webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[7]/div/div[2]/div/a"));
        buttonToTable.click();

    }

    @Then("^I Verify That The Buildings Page Is Opened$")
    public void iVerifyThatTheBuildingsPageIsOpened() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       header=webDriver.findElement(By.id("buildingsHeader"));
    }


    @When("^I Click On No Button In Employee Flow$")
    public void iClickOnNoButtonInEmployeeFlow() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        noButtonEmployees=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[7]/div/div[2]/div[2]/button"));
        noButtonEmployees.click();
    }

    @Then("^I Verify That The CUI Shows A Correct Final Message In The Employee Flow$")
    public void iVerifyThatTheCUIShowsACorrectFinalMessageInTheEmployeeFlow(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finalMessageEmployees=webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[9]/div/div[2]/div/p"));
        Assert.assertEquals(FINAL_MESSAGE,finalMessageEmployees.getText());
        if (!FINAL_MESSAGE.equals(finalMessageEmployees.getText())){
            error=0;
        }
    }


    @Then("^I give in employeeName <employeeName>$")
    public void iGiveInEmployeeNameEmployeeName() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
