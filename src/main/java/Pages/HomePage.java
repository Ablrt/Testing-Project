package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    private By login = By.xpath("/html/body/div[1]/div[1]/div/div/div[3]/nav[2]/ul/li[3]");
    private By gearIcon = By.xpath("/html/body/div[1]/div[1]/div/div/div[3]/nav[2]/ul/li/span[2]");
    private By accountSettingsButton = By.xpath("/html/body/div[1]/div[1]/div/div/div[3]/nav[2]/ul/li/div/ul/li[5]/a");
    private By favoriteMovies = By.xpath("//a[contains(text(),'Favorite Movies')]");

    private boolean loggedIn = false;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void logInToAccount(){
        WebElement log_in = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(login));
        log_in.click();
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[3]/iframe")));

        WebElement email = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.name("email")));
        email.sendKeys("beastmaster600004@gmail.com");

        WebElement password = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.name("password")));
        password.sendKeys("soft12345");
        WebElement loginButton = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.name("submit")));
        loginButton.click();
        loggedIn = true;
    }
    public AccountSettings goToAccountSettings(){
        if(!loggedIn)
            logInToAccount();
        WebElement gear = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(gearIcon));
        gear.click();
        WebElement accountSettings = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(accountSettingsButton));
        accountSettings.click();
        return new AccountSettings(this.driver);
    }

    public FavoritesPage goToFavorites(){
        if(!loggedIn)
            logInToAccount();
        WebElement gear = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(gearIcon));
        gear.click();
        WebElement favorites = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(favoriteMovies));
        favorites.click();
        return new FavoritesPage(this.driver);
    }

}
