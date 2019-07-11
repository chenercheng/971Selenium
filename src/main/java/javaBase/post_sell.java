
package javaBase;


import com.google.gson.JsonObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class post_sell {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D://Driver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //首页
        test1(driver);

        //登录
        String account = "18850000023";
        String password = "123654";
        test2(driver,account,password);


        test3(driver);

        Map<String,String> map = new HashMap<String, String>();
        //小区名称
        map.put("xiaoqu","海星小区");
        //房屋户型 室
        map.put("shi","2");
        //房屋户型 厅
        map.put("ting","2");
        //房屋户型 厨
        map.put("chu","2");
        //房屋户型 卫
        map.put("wei","2");
        //房屋户型 阳台
        map.put("yang","2");
        //建筑面积
        map.put("jzmj","135");
        //总价
        map.put("zongjia","236");
        //建造年代
        map.put("yearLimit","2018");
        //楼层 楼
        map.put("louceng","2");
        //楼层 共x楼
        map.put("zonglouceng","38");
        //标题
        map.put("biaoti","2标题标题标题标题标题标题标题标题标题标题标题");
        //房源编码
        map.put("userHouseCode","88888888");
        //详细描述
        map.put("xxms","详细描述详细描述详细描述详细描述详细描述详细描述详细描述");
        //业主心态
        map.put("yzxt","业主心态业主心态业主心态业主心态业主心态业主心态业主心态业主心态");
        //小区配套
        map.put("xqpt","小区配套小区配套小区配套小区配套小区配套小区配套小区配套小区配套");
        //服务介绍
        map.put("serviceIntro","服务介绍服务介绍服务介绍服务介绍服务介绍服务介绍服务介绍服务介绍服务介绍");

        //发布出售房源
        test4(driver,map);
    }

    /**
     * 首页点击登录
     * @throws InterruptedException
     */
    public static void test1(WebDriver driver) throws InterruptedException {
        driver.get("http://xm.917.cs/");
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(1000);
    }

    /**
     * 登录页-点击普通登录及登录
     * @throws InterruptedException
     */
    public static void test2(WebDriver driver,String account,String password) throws InterruptedException {

        driver.findElement(By.className("puLogin")).click();
        WebElement txtUserName =  driver.findElement(By.id("txtUserName"));
        WebElement txtPassword =  driver.findElement(By.id("txtPassword"));
        txtUserName.sendKeys(account);
        txtPassword.sendKeys(password);
        Thread.sleep(100);
        driver.findElement(By.id("btnLogin")).click();
    }
    /**
     * 个人中心-我的房源-发布出售
     * @throws InterruptedException
     */
    public static void test3(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        //进入我的房源列表
        driver.findElement(By.id("cssNavPost")).click();
        Thread.sleep(500);
        //发布出售
        search_listUtil(driver,0,null,"ziZhiOption",null,null);
        Thread.sleep(500);
    }
    /**
     * 个人中心-我的房源-发布出售
     * @throws InterruptedException
     */
    public static void test4(WebDriver driver, Map<String,String> map) throws InterruptedException {

        //赋值-点击别墅
        driver.findElement(By.id("cztype5")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("xiaoqu")).clear();
        driver.findElement(By.name("xiaoqu")).sendKeys(map.get("xiaoqu"));
        driver.findElement(By.name("shi")).clear();
        driver.findElement(By.name("shi")).sendKeys(map.get("shi"));
        driver.findElement(By.name("ting")).clear();
        driver.findElement(By.name("ting")).sendKeys(map.get("ting"));
        driver.findElement(By.name("chu")).clear();
        driver.findElement(By.name("chu")).sendKeys(map.get("chu"));
        driver.findElement(By.name("wei")).clear();
        driver.findElement(By.name("wei")).sendKeys(map.get("wei"));
        driver.findElement(By.name("yang")).clear();
        driver.findElement(By.name("yang")).sendKeys(map.get("yang"));

        driver.findElement(By.name("jzmj")).clear();
        driver.findElement(By.name("jzmj")).sendKeys(map.get("jzmj"));
        driver.findElement(By.name("zongjia")).clear();
        driver.findElement(By.name("zongjia")).sendKeys(map.get("zongjia"));

        driver.findElement(By.id("daikuang")).click();

        //点击类型1
        driver.findElement(By.id("fymd")).click();
        search_listUtil(driver,0,null,null,null,"//span[@id='fymd']/span/div/div/ul/li");
        //点击类型2
        driver.findElement(By.id("fwlx")).click();
        search_listUtil(driver,1,null,null,null,"//span[@id='fwlx']/span/div/div/ul/li");
        //点击类型3
        driver.findElement(By.id("jzjg")).click();
        search_listUtil(driver,1,null,null,null,"//span[@id='jzjg']/span/div/div/ul/li");
        //点击类型4
        driver.findElement(By.id("zxcd")).click();
        search_listUtil(driver,1,null,null,null,"//span[@id='zxcd']/span/div/div/ul/li");
        //点击类型4
        driver.findElement(By.id("chaoxiang")).click();
        search_listUtil(driver,4,null,null,null,"//span[@id='chaoxiang']/span/div/div/ul/li");

        //房本年限
        search_listUtil(driver,1,null,null,null,"//input[@name='fbnx']");
        //抵押信息
        search_listUtil(driver,0,null,null,null,"//input[@name='diya']");

        //产权
        driver.findElement(By.id("cqnx")).click();
        search_listUtil(driver,1,null,null,null,"//span[@id='cqnx']/span/div/div/ul/li");
        driver.findElement(By.id("cqlx")).click();
        search_listUtil(driver,2,null,null,null,"//span[@id='cqlx']/span/div/div/ul/li");
        driver.findElement(By.id("ownership")).click();
        search_listUtil(driver,0,null,null,null,"//span[@id='ownership']/span/div/div/ul/li");

        driver.findElement(By.name("yearLimit")).clear();
        driver.findElement(By.name("yearLimit")).sendKeys(map.get("yearLimit"));

        driver.findElement(By.name("louceng")).clear();
        driver.findElement(By.name("louceng")).sendKeys(map.get("louceng"));

        driver.findElement(By.name("zonglouceng")).clear();
        driver.findElement(By.name("zonglouceng")).sendKeys(map.get("zonglouceng"));

        //配套设施
        search_listUtil(driver,4,null,null,null,"//input[@name='ptss[]']");

        driver.findElement(By.name("biaoti")).clear();
        driver.findElement(By.name("biaoti")).sendKeys(map.get("biaoti"));

        driver.findElement(By.name("userHouseCode")).clear();
        driver.findElement(By.name("userHouseCode")).sendKeys(map.get("userHouseCode"));

        //房源特色
        driver.findElement(By.className("publishlabel-switch")).click();

        //房源特色-添加标签
        search_listUtil(driver,0,null,null,null,"//ul[@class='store-list']/li");
        search_listUtil(driver,0,null,null,null,"//a[@class='ui-link']");
        search_listUtil(driver,1,null,null,null,"//ul[@class='store-list']/li");
        search_listUtil(driver,1,null,null,null,"//a[@class='ui-link']");
        search_listUtil(driver,2,null,null,null,"//ul[@class='store-list']/li");
        search_listUtil(driver,2,null,null,null,"//a[@class='ui-link']");
        search_listUtil(driver,3,null,null,null,"//ul[@class='store-list']/li");
        search_listUtil(driver,3,null,null,null,"//a[@class='ui-link']");
        search_listUtil(driver,4,null,null,null,"//ul[@class='store-list']/li");
        search_listUtil(driver,4,null,null,null,"//a[@class='ui-link']");
        search_listUtil(driver,5,null,null,null,"//ul[@class='store-list']/li");
        search_listUtil(driver,0,null,null,null,"//a[@class='ui-link']");
        search_listUtil(driver,6,null,null,null,"//ul[@class='store-list']/li");
        search_listUtil(driver,0,null,null,null,"//a[@class='ui-link']");

        //详细描述
        driver.findElement(By.name("xxms")).clear();
        driver.findElement(By.name("xxms")).sendKeys(map.get("xxms"));
        //业主心态
        driver.findElement(By.name("yzxt")).clear();
        driver.findElement(By.name("yzxt")).sendKeys(map.get("yzxt"));
        //小区配套
        driver.findElement(By.name("xqpt")).clear();
        driver.findElement(By.name("xqpt")).sendKeys(map.get("xqpt"));
        //服务介绍
        driver.findElement(By.name("serviceIntro")).clear();
        driver.findElement(By.name("serviceIntro")).sendKeys(map.get("serviceIntro"));

        //上传户型图

    }

    /**
     * 工具方法-列表
     * @throws InterruptedException
     */
    public static void search_listUtil(WebDriver driver,int i,String name,String className,String tagName,String xpath) throws InterruptedException {
        Thread.sleep(100);
        List<WebElement> search_result = null;
        if(name != null){
            search_result = driver.findElements(By.name(name));
        }else if(className != null){
            search_result = driver.findElements(By.className(className));
        }else if(tagName != null){
            search_result = driver.findElements(By.tagName(tagName));
        }else if(xpath != null){
            search_result = driver.findElements(By.xpath(xpath));
        }

        if (search_result != null){
            WebElement search = search_result.get(i);
            search.click();
        }

    }



}
