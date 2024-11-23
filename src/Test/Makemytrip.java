package Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.synth.SynthGraphicsUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Makemytrip {

	public static void main(String[] args) {
		WebDriver d=new ChromeDriver();
		d.get("https://www.makemytrip.com/flights/");
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w=new WebDriverWait(d,Duration.ofSeconds(15));
		d.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		d.findElement(By.xpath("//div[@class='flt_fsw_inputBox searchCity inactiveWidget ']")).click();
		
		d.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("pun");
		
		List<WebElement> wbs = d.findElements(By.xpath("//ul[@role='listbox']/li/div/div/p"));
		Iterator<WebElement> itr = wbs.iterator();
		w.until(ExpectedConditions.visibilityOf(wbs.get(0)));
		int k=0;
		while(itr.hasNext()) {
			WebElement wb=itr.next();
			if(wb.getText().equalsIgnoreCase("Pune Airport")) {
				wb.click();
				k++;
				break;
				
			}
		}
		if(k==0) {
			wbs.get(0).click();
		}
        d.findElement(By.cssSelector("label[for='toCity']")).click();
        d.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("dub");
        List<WebElement> ws = d.findElements(By.xpath("//ul[@role='listbox']/li/div/div/p"));
       System.out.println(ws.size());
		Iterator<WebElement> itr1 = ws.iterator();
		w.until(ExpectedConditions.visibilityOf(ws.get(0)));
		int m=0;
		while(itr1.hasNext()) {
			WebElement wb=itr1.next();
			if(wb.getText().contains("Dubai International")) {
				wb.click();
				m++;
				break;
				
			}
		}
		if(m==0) {
			ws.get(0).click();
		}
	List<WebElement> dts = d.findElements(By.xpath("//div[@class='DayPicker-Week']/div[@aria-disabled='false']/div/p[2]"));
//	w.until(ExpectedConditions.visibilityOfAllElements(dts));
	
	//int sum=Integer.parseInt(dts.get(0).getText());
	int index=0;
	for(int i=0;i<dts.size();i++) {
		System.out.println(dts.get(i).getText()+" "+i);
//		if((Integer.parseInt(dts.get(i).getText())<sum)) {
//			sum=Integer.parseInt(dts.get(i).getText());
//			
//			index=i;
//		}
	}
//	dts.get(index).click();
//	System.out.println(sum);
	}

}
