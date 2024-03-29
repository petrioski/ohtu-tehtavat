package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    

    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) {        
        logInWith(username, password);
    }


    @Given("command new user is selected")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    }  

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        signUpWith(username, password, password);
    }

    @Then("a new user is created")
    public void aNewUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("a too short username {string} and password {string} and matching password confirmation are entered")
    public void aTooShortUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        signUpWith(username, password, password);
    }    

    @When("a valid username {string} and too short password {string} and matching password confirmation are entered")
    public void aValidUsernameAndTooShortPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {        
        signUpWith(username, password, password);
    }

    @When("a valid username {string} and password containing only letters {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordContainingOnlyLettersAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        signUpWith(username, password, password);
    }

    @When("a valid username {string} and password {string} and non-matcing password confimation {string} are entered")
    public void aValidUsernameAndPasswordAndNonMatcingPasswordConfimationAreEntered(String username, String password, String passConfirmation) {    
        //try{ Thread.sleep(2000); } catch(Exception e){}  // suoritus pysähtyy 120 sekunniksi
        signUpWith(username, password, passConfirmation);
        //try{ Thread.sleep(4000); } catch(Exception e){}  // suoritus pysähtyy 120 sekunniksi
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String string) {
        pageHasContent(string);
        pageHasContent("Create username and give password");
    }


    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String username, String password) {
        newUserIsSelected();
        signUpWith(username, password, password);        
        pageHasContent("Welcome to Ohtu Application!");
        logOut();
    }


    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String username, String password) {
        newUserIsSelected();
        signUpWith(username, password, password);        
        pageHasContent("Create username and give password");
        clickLink("back to home");
    }




    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }
    
    private void logOut() {
        //try{ Thread.sleep(1000); } catch(Exception e){}  
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click();  
        //try{ Thread.sleep(1000); } catch(Exception e){}  
        element = driver.findElement(By.linkText("logout"));
        //try{ Thread.sleep(1000); } catch(Exception e){}         
        element.click();  

    }
    
    private void clickLink(String linkText) {
        WebElement element = driver.findElement(By.linkText(linkText));       
        element.click();  
    }

    private void signUpWith(String username, String password, String passConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }
}
