import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Test {

    @AfterTest
    public  void test(){
        System.out.println(33);
    }

    @BeforeTest
    public  void test1(){
        System.out.println(222);
    }

    @org.testng.annotations.Test
    public void test3(){
        System.out.println(111);
        System.setProperty("webdriver.chrome.driver","D:\\project\\ahnx\\jnyd\\jnyd\\WebDriver_demo\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();


    }

}
