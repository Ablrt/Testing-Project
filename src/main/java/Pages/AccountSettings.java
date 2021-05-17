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


    public AccountSettings(WebDriver driver) {
        super(driver);
    }

    public void changeName(String newFName, String newSName){
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

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(nameWasChanged));
    }
}
