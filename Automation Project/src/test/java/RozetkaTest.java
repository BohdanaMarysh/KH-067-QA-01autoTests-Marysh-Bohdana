import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RozetkaTest {
    @Test
    public void testChrome(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://www.google.com/");
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.sendKeys("rozetka.ua");
        searchField.submit();
        WebElement firstResult = driver.findElement(By.cssSelector("a[href='https://rozetka.com.ua/']>h3"));
        firstResult.click();
        WebElement searchFieldRozetka = driver.findElement(By.xpath("//input[@name='search']"));
        searchFieldRozetka.sendKeys("мед");
        WebElement searchButton = driver.findElement(By.xpath("//*[contains(@class,'search-form__submit')]"));
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'goods-tile__title')][1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='buy-button__label ng-star-inserted']"))).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button button_size_large button_color_green cart-receipt__submit ng-star-inserted']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://rozetka.com.ua/checkout/']"))).click();
        System.out.println(driver.getCurrentUrl().equals("https://rozetka.com.ua/checkout/"));
        driver.quit();

    }
}
