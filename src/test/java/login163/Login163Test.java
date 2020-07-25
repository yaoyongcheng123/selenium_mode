package login163;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login163Test {

    WebDriver webDriver;
    @BeforeMethod
    public void start(){
        System.setProperty("webdriver.chrome.driver","D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\drivers\\84.0.4147.30\\chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
    }

    @Test
    public void loginCase01(){
        // 点击注册新账号
        webDriver.findElement(By.xpath("//*[@id=\"normalLoginTab\"]/div[1]/div[2]/a[1]")).click();
        // 跳转新页面，转交控制权
        String windowHandle = webDriver.getWindowHandle();
        for (String window:webDriver.getWindowHandles()){
            if (!window.equals(windowHandle)){
                webDriver.switchTo().window(window);
            }
        }

        webDriver.findElement(By.id("username")).sendKeys("1111");
        webDriver.findElement(By.id("password")).sendKeys("1111");
        webDriver.findElement(By.id("phone")).sendKeys("1111");
        webDriver.findElement(By.className("j-register")).click();
        String text = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]")).getText();
        String text1 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div")).getText();
        String text2 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[3]/div[2]")).getText();
        System.out.println(text);
        System.out.println(text1);
        System.out.println(text2);
        Assert.assertEquals(text,"长度应为6～18个字符");
        Assert.assertEquals(text1,"密码长度应为6～16个字符");
        Assert.assertEquals(text2,"请填写正确的中国大陆地区手机号，其他地区手机号请点击此处");
    }

    @Test
    public void loginCase02(){
        // 点击注册新账号
        webDriver.findElement(By.xpath("//*[@id=\"normalLoginTab\"]/div[1]/div[2]/a[1]")).click();
        // 跳转新页面，转交控制权
        String windowHandle = webDriver.getWindowHandle();
        for (String window:webDriver.getWindowHandles()){
            if (!window.equals(windowHandle)){
                webDriver.switchTo().window(window);
            }
        }

        webDriver.findElement(By.id("username")).sendKeys("yaoyongcheng1");
        webDriver.findElement(By.id("password")).sendKeys("feifei520");
        webDriver.findElement(By.id("phone")).sendKeys("15255633402");
        webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[4]/span")).click();


    }

}
