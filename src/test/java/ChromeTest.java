import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ChromeTest {

    public  WebDriver webDriver;


    @Test
    public void view() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("访问地址："+currentUrl);
        // 设置最大窗口
//        webDriver.manage().window().maximize();
//        Thread.sleep(3000);
        // 设置200*300窗口
//        Dimension dimension = new Dimension(200,300);
//        webDriver.manage().window().setSize(dimension);
//        Thread.sleep(3000);

        WebElement element = webDriver.findElement(By.id("virus-2020"));
        String url = element.getAttribute("href");
        webDriver.get(url);
        Thread.sleep(3000);
        WebElement element1 = webDriver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[2]/div/div[2]/div[7]/a"));
        String href = element1.getAttribute("href");
        webDriver.get(href);
        Thread.sleep(3000);
    }

    @Test
    public void getName() throws InterruptedException, IOException {
        webDriver.get("http://www.baidu.com");
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("访问地址："+currentUrl);
        webDriver.findElement(By.id("kw")).sendKeys("我是帅哥");
        String attribute = webDriver.findElement(By.id("kw")).getAttribute("value");
        System.out.println(attribute);
        // 截图
        TakesScreenshot takes = (TakesScreenshot) this.webDriver;
        File file = takes.getScreenshotAs(OutputType.FILE);
        String name = "D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\src\\imgs\\"+file.getName();
        FileUtils.copyFile(file,new File(name));
    }

    @AfterMethod
    public void quit(){
        webDriver.quit();
    }
}
