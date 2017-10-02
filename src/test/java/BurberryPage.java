import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions


import static java.lang.Thread.sleep;Ø
import static org.junit.Assert.assertTrue;

public class BurberryPage {
    WebDriver driver;
    String searchField = "input[class$='js-main-search-form-text']";
    String searchButton = "i[class$='burb-icon-arrow-down']";
    String productID = "a[data-product-id='39004561']";
    String productTitle = ".product-title";
    String addToBag = "button[class$='ga-add-to-bag']";
    String findInStore = "div[class='find-in-store-section']";
    String imageOnPage = "a[aria-label='Click and expand to view product gallery']";

    boolean present;


    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://ru.burberry.com/");

    }

    @After
    public void close() {

        driver.quit();
    }

    @Test()
    public void checkBurberryPage() throws InterruptedException {


        sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Burberry (Россия) | Легендарная британская элитная марка с 1856 года");
        driver.findElement(By.cssSelector(searchField)).sendKeys("Kensington");
        driver.findElement(By.cssSelector(searchButton)).click();
        driver.findElement(By.cssSelector(productID)).click();
        String actualString = driver.findElement(By.cssSelector(productTitle)).getText();
        assertTrue(actualString.contains("Kensington"));


        try {
            driver.findElement(By.cssSelector(addToBag));
            driver.findElement(By.cssSelector(findInStore));
            driver.findElement(By.cssSelector(imageOnPage));
            present = true;
            System.out.println("Все элементы присутсвуют на странице");
        } catch (NoSuchElementException e) {
            present = false;
        }

    }

}


