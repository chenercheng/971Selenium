package javaBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

/**
 * 我是来车上的，请回复
 *
 */
public class login {
    public static void main(String[] arge) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.917.cs");

        //获得当前窗口
        String search_handle = driver.getWindowHandle();

        //打开首页登录窗口
        driver.findElement(By.linkText("进入厦门站")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("登录")).click();

        //判断是否为注册窗口， 并操作注册窗口上的元素
        Thread.sleep(2000);
        driver.findElement(By.name("txtMobile")).clear();
        driver.findElement(By.name("txtMobile")).sendKeys("15260776750");
        Thread.sleep(2000);
                //关闭当前窗口
                driver.close();
            }
        }





