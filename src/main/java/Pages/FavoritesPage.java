package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FavoritesPage extends BasePage{
    private By favoritesLocator = By.className("movie");
    private By removesLocator = By.className("favorite-movie-remove");
    private List<WebElement> favoriteMovies;
    private List<WebElement> removes;

    public FavoritesPage(WebDriver driver) {
        super(driver);
        favoriteMovies = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(favoritesLocator));
        feelRemoves();
    }
    public List<WebElement> getFavorites(){
        return favoriteMovies;
    }

    public void feelRemoves(){
        removes = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(removesLocator));
    }
    public boolean isInFavorites(String name){
        for(WebElement movie: favoriteMovies){
            if(movie.getText().equals(name))
                return true;
        }
        return false;
    }

    public void remove(int index){
        removes.get(index).click();
    }
}
