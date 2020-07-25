package seleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HubTest {
    WebDriver webDriver ;

//    @BeforeMethod
//    public void start() throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities().chrome();
////        System.setProperty("webdriver.chrome.driver","D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\drivers\\84.0.4147.30\\chromedriver.exe");
//        webDriver = new RemoteWebDriver(new URL("http://192.168.43.225:5551/wd/hub"),desiredCapabilities);
//    }

    @DataProvider(name = "data")
    public Object[][] test1(){
        return  new Object[][]{
                {"chrome"},
                {"firefox"}
        };
    }

    @Test(dataProvider = "data")
    public void case01(String data){
        System.out.println(data);
        webDriver.get("https://www.baidu.com/");
    }

    @Test
    public void case02() throws Exception {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        webDriver = new RemoteWebDriver(new URL("http://192.168.43.225:5551/wd/hub"),desiredCapabilities);
        webDriver.get("https://www.baidu.com/");
        By name = By.xpath("");
        webDriver.findElement(name);
        Thread.sleep(5000);
        webDriver.quit();
    }


    public void login(WebDriver webDriver ){
        webDriver.findElement(By.xpath(""));
    }
}
