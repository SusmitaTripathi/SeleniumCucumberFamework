package utils;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    WebDriver driver;

    public GenericUtils(WebDriver driver){ this.driver = driver;}
    public void switchToChildWindow(){
        Set<String> openWindows = driver.getWindowHandles();
        Iterator<String> openWindowIterator = openWindows.iterator();
        String parentWindow = openWindowIterator.next();
        String childWindow = openWindowIterator.next();
        driver.switchTo().window(childWindow);
    }

    public byte[] takeScreenshot() throws Exception {
        File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
        return fileContent;
    }

    public void addScreenshotToReport(Scenario scenario) throws Exception {
        scenario.attach(takeScreenshot(),"image/png","Failure");
    }
}
