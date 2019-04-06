import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
public class BaseRunner {
    WebDriver driver;
    String baseUrl;
    public String browserName = System.getProperty("browser");
    @Before
    public void setUp(){
        driver = getDriver();
        baseUrl = "https://www.tinkoff.ru/mobile-operator/tariffs/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    private WebDriver getDriver() {
        try {
            if (browserName == null) browserName = "chrome";
            BrowsersFactory.valueOf(System.getProperty("browser"));
        } catch (Exception e) {
            System.setProperty("browser", browserName);
        }
        return BrowsersFactory.valueOf(browserName).create();
    }
}
