package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvancedSearchPage extends BasePage{
    private By startYear = By.name("start-year");
    private By endYear = By.name("end-year");
    private By year = By.className("year");

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public void setDates(int from, int to){
        WebElement start = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(startYear));
        start.click();
        start.sendKeys(Integer.toString(from));

        WebElement end = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(endYear));
        end.click();
        end.sendKeys(Integer.toString(to) + Keys.ENTER);
    }
    public List<WebElement> getResultYears(){
        List<WebElement> resultYears = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(year));
        resultYears.remove(0);
        return resultYears;
    }
}
