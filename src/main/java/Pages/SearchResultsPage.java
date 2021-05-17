package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends BasePage{
    private By resultsLocator = By.className("movie");
    private By noResultsLocator = By.xpath("//body/div[1]/div[2]/div[2]/div[2]/div[1]");
    private WebElement noResults = driver.findElement(noResultsLocator);
    private List<WebElement> results;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        if(!noResults.isDisplayed()) {
            results = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(resultsLocator));
        }
        else results = null;
    }
    public List<WebElement> getResults(){
        return results;
    }

}
