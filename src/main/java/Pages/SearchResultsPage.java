package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends BasePage{
    private By resultsLocator = By.xpath("//li[@class='movie']//div[@class='title']//a[@href]");
    private By suggestions = By.xpath("//h3[contains(text(),'Suggestions:')]");
    private List<WebElement> results;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
        fillResults();
    }

    private void fillResults(){
        if(!noResultsFound()){
            results = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(resultsLocator));
        }
        else {
            System.out.println("Nothing Found");
            results = null;
        }
    }
    private boolean noResultsFound(){
        try {
             new WebDriverWait(driver, 2)
                    .until(ExpectedConditions.visibilityOfElementLocated(suggestions));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public MoviePage selectResult(int index){
        results.get(index).click();
        return new MoviePage(this.driver);
    }
    public List<WebElement> getResults(){
        return results;
    }

}
