package selenium.Selenium_Test;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class seleniumTest 
{
    public static void main( String[] args )
    {
    	File file = new File(".");
        File rootPath = file.getAbsoluteFile();//현재 프로젝트 경로

    	System.setProperty("webdriver.chrome.driver", rootPath + "/chromedriver.exe");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        
        //Driver SetUp
        WebDriver driver = new ChromeDriver(options);
        String base_url = "https://youtube.com/results?search_query=kill+this+love+krashkarma";

        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
            List<WebElement> elms = driver.findElements(By.tagName("ytd-video-renderer"));
            
            for(WebElement elm:elms) {
            	System.out.println(elm.findElement(By.tagName("h3")).getText());
            }
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }

    }
}
