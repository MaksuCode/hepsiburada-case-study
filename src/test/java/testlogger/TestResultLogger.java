package testlogger;

import com.google.common.io.Files;
import driver.DriverManager;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * Used for logging and taking screenshot when a test fails.
 */
public class TestResultLogger implements TestWatcher {

   Log log = new Log();

    /**
     * When a test pass this method is called for logging purposes
     */
    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        log.info(testName + " PASSED");
    }

    /**
     * When a test fails this method is called for logging purposes and taking screenshot of the actual page.
     */
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage() ;
        log.error(testName + " FAILED with cause : " + testFailCause);
        String fileName = context.getDisplayName();
        takeScreenShot(fileName);
    }

    /**
     * Used to take a screenshot when a test fails and saves it to /screenshots path.
     * @param fileName is the filename of the screenshot.
     */
    private void takeScreenShot(String fileName){
        TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
        File image = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(image , new File("src/test/resources/screenshots/".concat(fileName).concat(".png")));
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }

}