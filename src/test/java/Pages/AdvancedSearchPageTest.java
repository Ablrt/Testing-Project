package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class AdvancedSearchPageTest extends BaseTest {
    @Test
    public void differentYearsTest(){
        int start = 2015;
        int end = 2021;
        AdvancedSearchPage a = homePage.goToAdvancedSearchPage();
        a.setDates(start, end);
        List<WebElement> dates = a.getResultYears();
        int result1 = Integer.parseInt(getRandomElement(dates).getText());
        int result2 = Integer.parseInt(getRandomElement(dates).getText());
        int result3 = Integer.parseInt(getRandomElement(dates).getText());
        Assert.assertTrue(result1>=start && result1 <= end);
        Assert.assertTrue(result2>=start && result2 <= end);
        Assert.assertTrue(result3>=start && result3 <= end);
    }

    // Actually found a failure in their website
    @Test
    public void sameYearsTest(){
        int year = 2015;
        AdvancedSearchPage a = homePage.goToAdvancedSearchPage();
        a.setDates(year, year);
        List<WebElement> dates = a.getResultYears();
        int result1 = Integer.parseInt(getRandomElement(dates).getText());
        int result2 = Integer.parseInt(getRandomElement(dates).getText());
        int result3 = Integer.parseInt(getRandomElement(dates).getText());
        Assert.assertEquals(result1, year);
        Assert.assertEquals(result2, year);
        Assert.assertEquals(result3, year);
    }

    private WebElement getRandomElement(List<WebElement> list) {
        Random rand = new Random();
        return  list.get(rand.nextInt(list.size()));
    }
}