package Pages;


import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class SearchResultsPageTest extends BaseTest {
    @Test
    public void searchTest(){
        String expected = "matrix";
        SearchResultsPage s = homePage.search(expected);
        String result1 = s.getResults().get(0).getText().toLowerCase(Locale.ENGLISH);
        String result2 = s.getResults().get(1).getText().toLowerCase(Locale.ENGLISH);
        String result3 = s.getResults().get(2).getText().toLowerCase(Locale.ENGLISH);
        Assert.assertTrue(result1.contains(expected));
        Assert.assertTrue(result2.contains(expected));
        Assert.assertTrue(result3.contains(expected));
    }
    @Test
    public void nothingFoundTest(){
        SearchResultsPage s = homePage.search("kagdfkakfaljdnzn");
        Assert.assertTrue(s.getResults() == null);
    }
}