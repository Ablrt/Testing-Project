package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private By iframe = By.xpath("//body/div[3]/iframe[1]");
    private By login = By.xpath("/html/body/div[1]/div[1]/div/div/div[3]/nav[2]/ul/li[3]");
    private By advancedSearch = By.linkText("Advanced Search");
    private By searchBar = By.name("term");
    private By searchButton = By.name("submit");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void logInToAccount(){
        WebElement log_in = new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(login));
        log_in.click();
        driver.switchTo().frame(driver.findElement(iframe));

        WebElement email = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.name("email")));
        email.sendKeys("beastmaster600004@gmail.com");

        WebElement password = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.name("password")));
        password.sendKeys("soft12345");
        WebElement loginButton = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.name("submit")));
        loginButton.click();
    }

    public AdvancedSearchPage goToAdvancedSearchPage(){
        WebElement advancedSearchWE = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(advancedSearch));
        advancedSearchWE.click();
        return new AdvancedSearchPage(driver);
    }

    public SearchResultsPage search(String text){
        WebElement textBox = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(searchBar));
        WebElement button = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(searchButton));

        textBox.sendKeys(text);
        button.click();
        return new SearchResultsPage(this.driver);
    }
}