package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountSettingsTest extends BaseTest {

    @Test
    public void nameChangeTest(){
        String fName = createRandomName(5);
        String sName = createRandomName(6);
        String expectedName = fName + " " + sName;

        AccountSettings as = homePage.goToAccountSettings();
        WebElement popUp = as.changeName(fName,sName);
        String currentName = as.getCurrentName();

        Assert.assertTrue(popUp.isDisplayed());
        Assert.assertEquals(expectedName, currentName);
    }

    @Test
    public void nameNotChangeTest(){
        AccountSettings as = homePage.goToAccountSettings();
        String currentName = as.getCurrentName();
        String[] name  = currentName.split(" ");
        String fName = name[0];
        String sName = name[1];
        as.changeName(fName,sName);
        Assert.assertTrue(as.noChanges());

    }
    private String createRandomName(int targetStringLength){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}