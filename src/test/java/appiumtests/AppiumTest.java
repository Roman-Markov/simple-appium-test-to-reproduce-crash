package appiumtests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;


public class AppiumTest {
	
	static AndroidDriver driver;
	
	public static void main(String[] args) throws IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        // Replace with your path
        capabilities.setCapability("appium:app", "/Users/markovroman/Desktop/learning/android-samples/testing-samples/testing-samples/ui/espresso/BasicSample/app/build/outputs/apk/debug/app-debug.apk");
//        capabilities.setCapability("appium:udid", "emulator-5554"); // Not necessary if one device connected
        
        capabilities.setCapability("appium:automationName", "Espresso");
        capabilities.setCapability("appium:forceEspressoRebuild", true); // Force rebuild espresso server to apply changes in espressoBuildConfig
        capabilities.setCapability("appium:showGradleLog", true);
        
        // Read the espressoBuildConfig JSON file
//      String espressoBuildConfig = new String(Files.readAllBytes(Paths.get("./espressoBuildConfig.json")));
			
      // Set the espressoBuildConfig capability
//      capabilities.setCapability("appium:espressoBuildConfig", espressoBuildConfig);

        // Creating driver
        
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            System.out.println("Appium Driver started successfully.");
            
            try {
                Thread.sleep(10000); // Pause for 10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            WebElement element = driver.findElement(AppiumBy.androidViewTag("openActivityAndChangeText"));
            element.click();
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
            driver.quit();
        }
    }
}
