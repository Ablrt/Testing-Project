package Pages;

import Base.BaseTest;
import org.testng.annotations.Test;

public class AdvancedSearchPageTest extends BaseTest {
    @Test
    public void na(){
        AdvancedSearchPage a = homePage.getTopSection().goToAdvancedSearchPage();
        a.setDates(1915,2021);
        System.out.println(a.getResultYears().get(0).getText());
        System.out.println(a.getResultYears().get(1).getText());
        System.out.println(a.getResultYears().get(a.getResultYears().size()-1).getText());
    }
}