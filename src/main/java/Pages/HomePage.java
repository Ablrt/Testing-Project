package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private By gearIcon = By.xpath("/html/body/div[1]/div[1]/div/div/div[3]/nav[2]/ul/li/span[2]");
    private By accountSettingsButton = By.xpath("/html/body/div[1]/div[1]/div/div/div[3]/nav[2]/ul/li/div/ul/li[5]/a");
    private By favoriteMovies = By.xpath("//a[contains(text(),'Favorite Movies')]");


    public HomePage(WebDriver driver){
        super(driver);
    }


    public AccountSettings goToAccountSettings(){
        try {
            logInToAccount();
        }
        catch (NoSuchElementException e){}
        finally {
            WebElement gear = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(gearIcon));
            gear.click();
            WebElement accountSettings = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(accountSettingsButton));
            accountSettings.click();
            return new AccountSettings(this.driver);
        }
    }

    public FavoritesPage goToFavorites(){
        try {
            logInToAccount();
        }
        catch (NoSuchElementException e){}
        finally {
            WebElement gear = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(gearIcon));
            gear.click();
            WebElement favorites = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(favoriteMovies));
            favorites.click();
            return new FavoritesPage(this.driver);
        }
    }
}
