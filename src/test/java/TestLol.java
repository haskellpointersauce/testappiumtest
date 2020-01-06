import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class TestLol {

    @Test
    public void testTheManyWebviews() throws MalformedURLException, InterruptedException {
        var capabilities = new DesiredCapabilities();

        capabilities.setCapability("testobject_api_key", "xxx");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("appiumVersion", "1.16.0-webviews"); // a 1.16.0 prerelease branch, the one that added additionalBundleIds

        var remote = "https://appium.testobject.com/wd/hub";
        AppiumDriver<WebElement> driver = new AppiumDriver<>(new URL(remote), capabilities);

        try {
            driver.findElementById("loginButton").click();

            driver.findElementByName("Continue").click();


            for (int i = 0; i < 3; i++) {
                System.out.println(driver.getContextHandles());
                Thread.sleep(1000);
            }
        } finally {
            driver.quit();
        }
    }
}
