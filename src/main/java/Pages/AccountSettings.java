package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSettings extends BasePage{
    private By fName = By.name("user[firstname]");
    private By sName = By.name("user[lastname]");
    private By saveChangesButton = By.xpath("//body/div[1]/div[2]/div[2]/div[2]/form[1]/p[6]/input[1]");
    private By nameWasChanged = By.xpath("//*[@id=\"cmn_wrap\"]/div[2]/div[2]/div");
    private By name = By.xpath("//header/span[1]");
    private By noChangesLocator = By.xpath("//div[contains(text(),'No changes were made to your information')]");


    public AccountSettings(WebDriver driver) {
        super(driver);
    }

    public WebElement changeName(String newFName, String newSName){
        WebElement fNameField = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(fName));
        fNameField.clear();
        fNameField.sendKeys(newFName);

        WebElement sNameField = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(sName));
        sNameField.clear();
        sNameField.sendKeys(newSName);

        WebElement save = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(saveChangesButton));
        save.click();

        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(nameWasChanged));
    }

    public boolean noChanges(){
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(noChangesLocator)).isDisplayed();
    }

    public String getCurrentName(){
        return  new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(name)).getText();
    }
}
