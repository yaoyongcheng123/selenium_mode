import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ChromeTest2 {

    WebDriver driver;

    @BeforeMethod
    public void start() {
        System.setProperty("webdriver.chrome.driver", "D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\drivers\\84.0.4147.30\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void case1() {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/demo1.html");

        new WebDriverWait(driver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.id("load")));
        WebElement load = driver.findElement(By.id("load"));
        load.sendKeys("C:\\Users\\Administrator\\Desktop\\index.html");
    }

    @Test
    public void case2() throws InterruptedException {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/demo1.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"select\"]/select"));
        Select select = new Select(element);
        select.selectByIndex(2);
        String value = element.getAttribute("value");
        Assert.assertEquals("opel",value);
    }

    @Test
    public void case3() {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/demo1.html");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"checkbox\"]/input"));
        elements.get(1).click();
        elements.get(2).click();
        String value = elements.toString();
        System.out.println(value);
    }

    @Test
    public void case4() throws InterruptedException {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/demo1.html");
        driver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals("I am an alert box!!",text);
    }

    @Test
    public void case5() throws InterruptedException {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/demo1.html");
        driver.findElement(By.linkText("Open new window")).click();
        String windowHandle = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(windowHandle)) {
                driver.switchTo().window(window);
                break;
            }
        }
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"virus-2020\"]")));
        driver.findElement(By.xpath("//*[@id=\"virus-2020\"]")).click();
        String windowHandle1 = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(windowHandle) && !window.equals(windowHandle1)) {
                driver.switchTo().window(window);
                break;
            }
        }

        new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.linkText("百度首页")));
        driver.findElement(By.linkText("百度首页")).click();
        driver.switchTo().window(windowHandle);
        driver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals("I am an alert box!!",text);
    }

    @Test
    public void case6() {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/demo1.html");
        WebElement element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[10]/td[2]/div/input"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"over\"]"));
        Assert.assertEquals("Hello World!", element2.getText());
    }

    @Test
    public void case7(){
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/demo1.html");
//        Actions actions =new Actions(driver);
//        WebElement wait = driver.findElement(By.className("wait"));
//        actions.moveToElement(wait).click().perform();
        driver.findElement(By.className("wait")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/table/tbody/tr[11]/td[2]/div[2]/div")));
        String text = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[11]/td[2]/div[2]/div")).getText();
        Assert.assertEquals("wait for display",text);
    }


    @AfterMethod
    public void quit() throws InterruptedException {
        driver.quit();
    }
}
