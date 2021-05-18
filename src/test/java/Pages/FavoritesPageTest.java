package Pages;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoritesPageTest extends BaseTest {
    @Test
    public void addToFavorites(){
        SearchResultsPage s = homePage.search("matrix");
        MoviePage m = s.selectResult(0);
        m.addToFavorites();
        String expected = m.getMovieTitle();
        FavoritesPage f = homePage.goToFavorites();
        Assert.assertTrue(f.isInFavorites(expected));
        f.remove(0);
    }
    @Test
    public void removeFromFavorites(){
        SearchResultsPage s = homePage.search("saw");
        MoviePage m = s.selectResult(0);
        m.addToFavorites();
        String expected = m.getMovieTitle();
        FavoritesPage f = homePage.goToFavorites();
        String result = f.getFavorites().get(0).getText();
        Assert.assertEquals(result, expected);

        f.remove(0);
        getWindowManager().refreshPage();
        Assert.assertTrue(!f.isInFavorites(expected));
    }
}