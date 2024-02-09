package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestMobile {
    AndroidDriver driver;
    
    @BeforeClass()
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Users\\Luka\\AndroidStudioProjects\\order-manager\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
        capabilities.setCapability("VERSION", "9.0");
        capabilities.setCapability("deviceName", "emulator");
        capabilities.setCapability("platformName", "Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test(priority = 2)
    public void successfulLogin() throws Exception {
        
        String xpathUsername = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText";
        String xpathPassword = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText";
        String xpathLoginButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.widget.Button";
        String xpathNextPageElement = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[1]/android.view.View";
        
        MobileElement usernameField = (MobileElement) driver.findElement(By.xpath(xpathUsername));
        MobileElement passwordField = (MobileElement) driver.findElement(By.xpath(xpathPassword));
        MobileElement loginButton = (MobileElement) driver.findElement(By.xpath(xpathLoginButton));
        
        usernameField.clear();
        passwordField.clear();
        
        usernameField.sendKeys("kon");
        passwordField.sendKeys("kon");
        
        loginButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathNextPageElement)));
        
        MobileElement nextPageElement = (MobileElement) driver.findElement(By.xpath(xpathNextPageElement));
        
        Assert.assertTrue(nextPageElement.isDisplayed(), "Next page element is not displayed");
        
    }
    
    @Test(priority = 1)
    public void invalidLogin() throws Exception {
        
        String xpathUsername = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText";
        String xpathPassword = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText";
        String xpathLoginButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.widget.Button";
        String toastMessageXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.widget.TextView";
        
        MobileElement usernameField = (MobileElement) driver.findElement(By.xpath(xpathUsername));
        MobileElement passwordField = (MobileElement) driver.findElement(By.xpath(xpathPassword));
        MobileElement loginButton = (MobileElement) driver.findElement(By.xpath(xpathLoginButton));
        
        usernameField.clear();
        passwordField.clear();
        
        usernameField.sendKeys("ko");
        passwordField.sendKeys("kon");
        
        loginButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toastMessageXpath)));
        
        MobileElement toastMessage = (MobileElement) driver.findElement(By.xpath(toastMessageXpath));
        
        Assert.assertEquals(toastMessage.getText(), "Invalid username or password", "Toast message is not displayed");
    }
    
    @Test(priority = 3)
    public void navigateToConfirmOrder() throws Exception {
        
        String xpathClickElement = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View";
        
        String xpathTableNumberElement = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.TextView";
        
        MobileElement clickElement = (MobileElement) driver.findElement(By.xpath(xpathClickElement));
        clickElement.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathTableNumberElement)));
        
        MobileElement tableNumberElement = (MobileElement) driver.findElement(By.xpath(xpathTableNumberElement));
        
        Assert.assertEquals(tableNumberElement.getText(), "Table number", "Table number element text is not as expected");
    }
    
    @Test(priority = 4)
    public void addOrderAndClickThreeTimes() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        String xpathAddOrderTabButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View[1]/android.view.View";
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathAddOrderTabButton))).click();
        
        String xpathAddOrderTabElement = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View";
        
        MobileElement addOrderTabElement = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathAddOrderTabElement)));
        Assert.assertTrue(addOrderTabElement.isDisplayed(), "Add Order tab element is not displayed");
        
        for (int i = 0; i < 3; i++) {
            addOrderTabElement.click();
        }
    }
    
    @Test(priority = 5)
    public void navigateBackToConfirmOrder() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        String xpathNavigateBackButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View";
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathNavigateBackButton))).click();
    }
    
    @Test(priority = 6)
    public void createOrder() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        String xpathSuccessMessage = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.TextView";
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathSuccessMessage)));
        
        MobileElement successMessage = (MobileElement) driver.findElement(By.xpath(xpathSuccessMessage));
        Assert.assertTrue(successMessage.getText().contains("Successfully added item") || successMessage.getText().contains("Beer 0.5"), "Success message text is not as expected");
    }
    
    @Test(priority = 7)
    public void logout() throws Exception {
     WebDriverWait wait = new WebDriverWait(driver, 10);
     
     
     String xpathLogoutButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.widget.Button";
     
     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLogoutButton))).click();
    }
    
    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
