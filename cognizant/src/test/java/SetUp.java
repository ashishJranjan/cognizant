import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.List;
import java.util.Random;

public class SetUp {

    AndroidDriver driver;
    @BeforeClass
    public void testcase1()throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        cap.setCapability(MobileCapabilityType.APP, "/Users/300068094/Documents/assignment/cognizantAssignment/cognizant/Amazon_shopping.apk");
        cap.setCapability("appActivity","com.amazon.mShop.home.HomeActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

    }

    @Test
    public void gotoHomePage() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement skipSignIn = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.amazon.mShop.android.shopping:id/sign_in_button")));
        skipSignIn.click();



//        wait = new WebDriverWait(driver, 30);
//        WebElement signUpInRadio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains (@text,'Create account. New to Amazon?')]")));
//        signUpInRadio.click();
//        Thread.sleep(5000);

        wait = new WebDriverWait(driver, 30);
        WebElement signInRadio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains (@text,'Sign-In. Already a customer?')]")));
        signInRadio.click();
        Thread.sleep(1000);

        wait = new WebDriverWait(driver, 30);
        WebElement signInEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@resource-id = 'ap_email_login']")));
        signInEmail.sendKeys("tistony.ashish@gmail.com");
        Thread.sleep(1000);

        wait = new WebDriverWait(driver, 30);
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@index='0' and contains(@text,'Continue')]")));
        continueButton.click();
        Thread.sleep(1000);

        wait = new WebDriverWait(driver, 30);
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@resource-id='ap_password']")));
        password.click();
        password.sendKeys("batman@123");
        Thread.sleep(1000);

        wait = new WebDriverWait(driver, 30);
        WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[contains(@text,'Sign-In')]")));
        signIn.click();
        Thread.sleep(10000);

        wait = new WebDriverWait(driver, 30);
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[contains(@text,'What are you looking for?')]")));
        searchBox.sendKeys("16-inch tv"+"\n");
        Thread.sleep(2000);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));



        wait = new WebDriverWait(driver, 30);
        WebElement searchResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[ @resource-id = 'com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout']")));
        searchResult.sendKeys("16-inch tv");
        //android.widget.LinearLayout[ @resource-id = 'com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout']

        Thread.sleep(1000);
        wait = new WebDriverWait(driver, 10);
        try {
            WebElement additionalBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'change your delivery address')]")));
            if (additionalBox.isDisplayed()) {
                wait = new WebDriverWait(driver, 10);
                WebElement donTChnage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id = 'com.amazon.mShop.android.shopping:id/left_button']")));
                donTChnage.click();
            }
        }
        catch (Exception e){

        }
        Thread.sleep(5000);

        wait = new WebDriverWait(driver, 30);
        searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[contains(@text,'What are you looking for?')]")));
        searchBox.sendKeys("16-inch tv");
        Thread.sleep(5000);

        List<WebElement> element = driver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id = 'com.amazon.mShop.android.shopping:id/list_product_linear_layout' and @index ='1']"));

        Random random = new Random();
        int randomInt = random.nextInt(10);

        if(randomInt < 5){
            element = driver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id = 'com.amazon.mShop.android.shopping:id/list_product_linear_layout' and @index ='1']"));
            element.get(randomInt).click();
        }
        else{
            randomInt = randomInt-5;
            element = driver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id = 'com.amazon.mShop.android.shopping:id/list_product_linear_layout' and @index ='1']"));
            element.get(randomInt).click();
        }









    }
    @AfterClass
    public void testCaseTearDown() {
        driver.quit();
    }


}
