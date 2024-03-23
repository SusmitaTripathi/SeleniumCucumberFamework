package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws Exception {
        /*
        * C:\Users\Susmita Tripathi\eclipse-workspace\CucumberFramework\src\test\resources\global.properties
        * System.getProperty("user.dir") + "src\\test\\resources\\global.properties"
        * */
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String browser = "";
        //get browser value from global.properties file
        String browser_properties = properties.getProperty("browser");
        //get browser value from command line during mvn execution
        String browser_maven = System.getProperty("browser");
        //will assign browser value as browser_properties if browser_maven is null
        browser = (browser_maven!=null)? browser_maven : browser_properties;
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita Tripathi\\eclipse-workspace\\chromeDriver\\chromedriver-win64\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                default:
                    System.out.println("Setup browser exe file and path");
                    System.exit(0);
                    break;
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(properties.getProperty("ImplicitWaitTime"))));
            driver.get(properties.getProperty("test_url"));
        }
        return driver;
    }
}
