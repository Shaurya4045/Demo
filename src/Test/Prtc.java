package Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Prtc {

	public static void main(String[] args) throws IOException {
		WebDriver d=new ChromeDriver();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println(d.getTitle());
//		d.findElement(By.id("opentab")).click();
//		Set<String> handles = d.getWindowHandles();
//		Iterator<String> itr = handles.iterator();
//		String pthdl = itr.next();
//		String chdhdl = itr.next();
//		d.switchTo().window(chdhdl);
//		System.out.println(d.getTitle());
//		d.findElement(By.xpath("//div[@class='button float-left']/a")).click();
//		d.switchTo().window(pthdl);
//		System.out.println(d.getTitle());
//		System.out.println(d.findElement(By.xpath("//a[@class='blinkingText']")).getText());
//		d.switchTo().window(chdhdl).close();
//
//		d.switchTo().window(pthdl);
//		System.out.println(d.findElement(By.xpath("//a[@class='blinkingText']")).getText());
//		File tgt= new File("scrnshot.png");
//		TakesScreenshot ts=(TakesScreenshot)d;
//        File src=ts.getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(src, tgt);
        JavascriptExecutor js=(JavascriptExecutor)d;
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("window.scrollBy(0,-500)");
      List<WebElement> wbs = d.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td/ul/li"));
      for(WebElement wb : wbs) {
    	  System.out.println(wb.getText());
      }
      
	}

}
