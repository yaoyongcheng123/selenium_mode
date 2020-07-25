import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ClickTest {
    WebDriver webDriver;

    @BeforeMethod
    public void  start(){
        System.setProperty("webdriver.chrome.driver","D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\drivers\\84.0.4147.30\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public  void clickTest() throws InterruptedException {
        webDriver.get("D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\src\\htlm\\index.html");
        webDriver.findElement(By.xpath("/html/body/button[1]")).click();
        Alert alert = webDriver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }

    @Test
    public void openTest() throws IOException, InterruptedException {
        webDriver.get("D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\src\\htlm\\index.html");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("/html/body/button[2]")).click();
        Thread.sleep(3000);
        File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\src\\imgs\\"+file.getName()));
    }

    @Test
    public void confimTest() throws InterruptedException {
        webDriver.get("D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\src\\htlm\\index.html");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("/html/body/button[3]")).click();
        Alert alert = this.webDriver.switchTo().alert();
        Thread.sleep(3000);
        alert.dismiss();
        Thread.sleep(3000);
    }

    @Test
    public void promptTest() throws InterruptedException {
        webDriver.get("D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\src\\htlm\\index.html");
        webDriver.findElement(By.xpath("/html/body/button[4]")).click();
        Alert alert = this.webDriver.switchTo().alert();
        alert.sendKeys("你好呀");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }

    @Test
    public void selectTest() throws InterruptedException {
        webDriver.get("D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\src\\htlm\\index.html");
        WebElement sel = webDriver.findElement(By.id("sel"));
        Select select = new Select(sel);
        select.selectByValue("opel");
        Thread.sleep(3000);
        select.selectByIndex(1);
        Thread.sleep(3000);
    }

    @Test
    public void openNewTest() throws InterruptedException {
        webDriver.get("D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\src\\htlm\\index.html");
        Thread.sleep(3000);
        WebDriver frame = webDriver.switchTo().frame(webDriver.findElement(By.xpath("/html/body/iframe")));
        frame.findElement(By.linkText("你点我呀2222")).click();
        Thread.sleep(3000);
    }

    @Test
    public void openSwitchToTest() throws InterruptedException {
        webDriver.get("D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\src\\htlm\\index.html");
        webDriver = webDriver.switchTo().frame(webDriver.findElement(By.xpath("/html/body/iframe")));
        webDriver.findElement(By.linkText("你点我呀2222")).click();
        Thread.sleep(3000);
        String windowHandle = webDriver.getWindowHandle();
        Set<String> windowHandles = webDriver.getWindowHandles();
        for (String str:windowHandles){
            if (!windowHandle.equals(str)){
                webDriver.switchTo().window(str);
                break;
            }
        }
        webDriver.findElement(By.linkText("你真点我呀")).click();
        Thread.sleep(3000);
        webDriver.switchTo().window(windowHandle);
        webDriver.findElement(By.xpath("/html/body/button[1]")).click();
        Alert alert = webDriver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        // 设置等待时间
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,10);
        ExpectedCondition<WebElement> webElementExpectedCondition = ExpectedConditions.presenceOfElementLocated(By.xpath(""));
        webDriverWait.until(webElementExpectedCondition);
        // 设置等待时间
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void quitCase(){
        webDriver.quit();
    }
}
