import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FileDownloadTest {
    private WebDriver webDriver;

    @BeforeMethod
    public void start() {
        System.setProperty("webdriver.chrome.driver", "D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\drivers\\84.0.4147.30\\chromedriver.exe");

        webDriver = new ChromeDriver();
    }


    @Test
    public void case01() throws AWTException, InterruptedException {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        StringSelection stringSelection = new StringSelection("D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\src\\htlm\\index.html");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        WebElement load = webDriver.findElement(By.id("load"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(load).click().perform();
        Robot robot = new Robot();
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    @Test
    public void case02() {
        webDriver.get("https://www.baidu.com");
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //指定图片路径

        StringSelection selection = new StringSelection("C:\\Users\\你的用户名\\Desktop\\selenium.jpg");

        //把图片路径复制到剪切板

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        System.out.println("selection" + selection);

        //点击照相机这个工具

        webDriver.findElement(By.xpath("//*/span[@class='soutu-btn']")).click();

        //点击本地上传图片

        webDriver.findElement(By.xpath("//*/div[@class='upload-wrap']")).click();
    }

    @Test
    public void case03() throws InterruptedException, AWTException {
        webDriver.get("https://prep-dcsc.lenovo.com/");
        new WebDriverWait(webDriver, 3600)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[@id=\"entry\"]/div/div/div[1]/div[2]/div[2]/div/div[2]/a/span")));
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //指定图片路径
        StringSelection selection = new StringSelection("C:\\Users\\Administrator\\Desktop\\selenium_html\\aa.xml");
        //把图片路径复制到剪切板
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        System.out.println("selection" + selection);
        //点击工具
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"entry\"]/div/div/div[1]/div[2]/div[2]/div/div[2]/a/span")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div/ul/li[1]/a")).click();
        Thread.sleep(2000);
        //点击本地上传图片
        new WebDriverWait(webDriver, 3600)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .className("ant-upload-drag-container")));
        webDriver.findElement(By.className("ant-upload-drag-container")).click();

        // 键盘粘贴&回车键
        Robot robot = new Robot();
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
