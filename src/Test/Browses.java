package Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browses {

	public static void main(String[] args) throws InterruptedException {
	WebDriver d=new ChromeDriver();
	d.get("https://rahulshettyacademy.com/AutomationPractice/");
	d.manage().window().maximize();
	d.manage().deleteAllCookies();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	WebDriverWait w=new WebDriverWait(d,Duration.ofSeconds(5));
	w.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//input[@value='radio1']"))));
	System.out.println(d.findElement(By.xpath("//input[@value='radio1']")).isSelected());
	d.findElement(By.xpath("//input[@value='radio1']")).click();
	System.out.println(d.findElement(By.xpath("//input[@value='radio1']")).isSelected());
	System.out.println(d.findElements(By.xpath("//input[@type='radio']")).size());
   d.findElement(By.cssSelector("input#autocomplete")).sendKeys("ind");
   Thread.sleep(3000);
   List<WebElement> wb = d.findElements(By.xpath("//li[@class='ui-menu-item'] //div[@class='ui-menu-item-wrapper']"));
   for(WebElement p : wb) {
	   if(p.getText().equalsIgnoreCase("India")) {
		   p.click();
		   System.out.println("clicked");
		   break;
	   }
   }
   WebElement st=d.findElement(By.id("dropdown-class-example"));
	Select a=new Select (st);
	System.out.println(a.getFirstSelectedOption().getText());
	a.selectByIndex(1);
	System.out.println(a.getFirstSelectedOption().getText());
	a.selectByValue("option2");
	System.out.println(a.getFirstSelectedOption().getText());
	a.selectByVisibleText("Option3");
	System.out.println(a.getFirstSelectedOption().getText());
	d.findElement(By.id("checkBoxOption2")).click();
	d.findElement(By.id("name")).sendKeys("ajksm");
	d.findElement(By.id("alertbtn")).click();
	System.out.println(d.switchTo().alert().getText());
	d.switchTo().alert().accept();
	Thread.sleep(3000);
	d.findElement(By.id("name")).sendKeys("ajksm");
	d.findElement(By.id("alertbtn")).click();
	w.until(ExpectedConditions.alertIsPresent());
	d.switchTo().alert().dismiss();
    d.findElement(By.xpath("//button[contains(@id,'openwindow')]")).click();
    Set<String> handles = d.getWindowHandles();
    System.out.println(handles.size());
    Iterator<String> itr = handles.iterator();
    String parent=itr.next();
    System.out.println(d.getTitle());
  String  child=itr.next();
  d.switchTo().window(child);
  System.out.println(d.getTitle());
  d.findElement(By.xpath("//div[@class='button float-left']/a")).click();
  d.navigate().back();
  d.close();
  d.switchTo().window(parent);
  d.findElement(By.id("opentab")).click();
 d.findElement(By.xpath("//button[text()='Home']")).click();
 Set<String> ab = d.getWindowHandles();
 System.out.println(ab.size());
 System.out.println(d.getTitle());
	}

}
