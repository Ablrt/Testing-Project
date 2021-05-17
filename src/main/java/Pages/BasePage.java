package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    protected TopSection topSection;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        topSection = new TopSection(this.driver);
    }

    public TopSection getTopSection(){
        return this.topSection;
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public WebElement getWebElement(By locator){
        return driver.findElement(locator);
    }
}