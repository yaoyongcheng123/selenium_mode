import org.openqa.selenium.*;
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

public class IndexTest {
    private WebDriver webDriver;

    @BeforeMethod
    public void start() {
        System.setProperty("webdriver.chrome.driver", "D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\drivers\\84.0.4147.30\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void case1() throws InterruptedException {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        webDriver.findElement(By.id("user")).sendKeys("开心一刻");
        Thread.sleep(3000);
        webDriver.findElement(By.linkText("登陆界面")).click();
        new WebDriverWait(webDriver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"link\"]/a")));
        String text = webDriver.findElement(By.xpath("//*[@id=\"link\"]/a")).getText();
        Assert.assertEquals("baidu", text);
    }

    @Test
    public void case2() {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        WebElement moreSelect = webDriver.findElement(By.id("moreSelect"));
        Select select = new Select(moreSelect);
        select.selectByIndex(3);
        String value = moreSelect.getAttribute("value");
        Assert.assertEquals("meizu", value);
    }

    @Test
    public void case3() throws InterruptedException {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        List<WebElement> identity = webDriver.findElements(By.name("identity"));
        identity.get(2).click();
        Thread.sleep(3000);
    }

    @Test
    public void casee4() throws InterruptedException {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@id=\"checkbox\"]/input"));
        elements.get(0).click();
        elements.get(3).click();
        Thread.sleep(3000);
    }

    @Test
    public void case5() {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        webDriver.findElement(By.id("id01")).click();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("su")));
        Assert.assertEquals("百度一下", webDriver.findElement(By.id("su")).getAttribute("value"));
    }

    @Test
    public void case6() {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        webDriver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Alert alert = webDriver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals("请点击确定", text);
    }

    @Test
    public void case7() {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        webDriver.findElement(By.xpath("//*[@id=\"confirm\"]/input")).click();
        Alert alert = webDriver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.accept();
        String text1 = alert.getText();
        System.out.println(text1);
        alert.accept();
        Assert.assertEquals("我是提示信息", text);
        Assert.assertEquals("你点击的结果是-确定", text1);
    }

    @Test
    public void case8() throws InterruptedException {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        webDriver.findElement(By.xpath("//*[@id=\"prompt\"]/input")).click();
        Alert alert = webDriver.switchTo().alert();
        String text = alert.getText();
        alert.sendKeys("你好");
        alert.accept();
        String text1 = alert.getText();
        System.out.println(text + "----" + text1);
        Assert.assertEquals("我是提示信息", text);
        Assert.assertEquals("你点击的结果是-确定", text1);
    }

    @Test
    public void case9() throws InterruptedException {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        WebElement load = webDriver.findElement(By.id("load"));
        load.sendKeys("C:\\Users\\Administrator\\Desktop\\work\\DB2错误码大全.txt");
        Thread.sleep(3000);
    }

    @Test
    public void cast10() {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        webDriver.findElement(By.xpath("//*[@id=\"open\"]/a")).click();
        String windowHandle = webDriver.getWindowHandle();
        for (String win : webDriver.getWindowHandles()) {
            if (!win.equals(windowHandle)) {
                webDriver.switchTo().window(win);
            }
        }
        String text = webDriver.findElement(By.xpath("/html/body/div/div/b")).getText();
        System.out.println(text);
        Assert.assertEquals("UI 自动化测试Iframe", text);
    }

    @Test
    public void case11() throws InterruptedException {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"action\"]/input"))).perform();
        WebElement element1 = webDriver.findElement(By.xpath("//*[@id=\"action\"]/div[1]"));
        System.out.println("=======" + element1.getText());
        Assert.assertEquals( element1.getText(),"Hello World!");
    }

    @Test
    public void case12() {
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
//        WebElement select = webDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
//        List<WebElement> elements = select.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.LEFT_CONTROL).click(elements.get(0))
                .click(elements.get(1)).click(elements.get(3)).perform();
        WebElement select = webDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        String value = select.getAttribute("value");
        String text = select.getText();
        String tagName = select.getTagName();
        System.out.println("value ="+value+";text="+text+";tagName="+tagName);
    }

    @Test
    public void case13(){
        webDriver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        webDriver = webDriver.switchTo().frame(webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe")));
        webDriver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
        webDriver.switchTo().defaultContent();
        String text1 = webDriver.findElement(By.xpath("//*[@id=\"open\"]/a")).getText();
        System.out.println(text1);

    }

    @AfterMethod
    public void quit() {
        webDriver.quit();
    }

}
