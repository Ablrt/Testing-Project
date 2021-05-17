package Pages;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class az extends BaseTest {
    AdvancedSearchPage a = homePage.getTopSection().goToAdvancedSearchPage();
    @Test
    public void na(){
        Assert.assertEquals(1,1);
    }
}