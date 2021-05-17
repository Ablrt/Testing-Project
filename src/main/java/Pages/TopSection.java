package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopSection {
    private static WebDriver driver;
    private By advancedSearch = By.linkText("Advanced Search");
    private By searchBar = By.name("term");
    private By searchButton = By.name("submit");

    public TopSection(WebDriver driver) { this.driver = driver;}

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
