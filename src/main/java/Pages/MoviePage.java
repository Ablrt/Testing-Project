package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoviePage extends BasePage{
    private By addToFavoritesLocator = By.xpath("//header/a[1]");
    private By movieTitle = By.tagName("h2");

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public String getMovieTitle(){
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(movieTitle)).getText()
                .replaceAll("\\(.*?\\)","").trim();
    }

    public void addToFavorites(){
        try {
            logInToAccount();
        }
        catch (NoSuchElementException e){}
        finally {
            WebElement addButton = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(addToFavoritesLocator));
            addButton.click();
        }
    }
}
