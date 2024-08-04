package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeadDriver {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null) {
            createDriver();
            return driver;
        }
        return driver;
        }
        public static void createDriver(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }

        public static void closeDriver(){
        getDriver().close();
        getDriver().quit();
        driver=null;
        }
    public static void open(String URL) {
        getDriver().get(URL);
    }

    public static void setWindowSize() {
        getDriver().manage().window().maximize();
    }
    }

