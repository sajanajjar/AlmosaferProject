package almosaferproject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class testcases {
	WebDriver driver= new ChromeDriver();
	String Website= "https://global.almosafer.com/en";
	Random rand = new Random();
	
	@BeforeTest
	public void setup () throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(Website);
		Thread.sleep(3000);
//		WebElement ButtonForTheCurrency = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
//		ButtonForTheCurrency.click();
	}
	
	@Test (priority = 1)
	public void EnglishLanguageIsDefult () {
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedLanguage = "en";
		assertEquals(ActualLanguage, ExpectedLanguage);
//
//		WebElement LanguageButton = driver.findElement(By.cssSelector(".sc-gkFcWv.jJNggu"));
//		String WebsiteLanguage = LanguageButton.getText();
//		if (WebsiteLanguage == "en") {
//			LanguageButton.click();
//			System.out.println("The language now is english");
//
//		} else {
//			System.out.println("The language is english");
//
//		}
		
	}

	@Test (priority = 2)
	public void SARCurrencyIsDefult () {
	WebElement CurrencyButton =	driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"));
	//WebElement CurrencyButton =	driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO"));
	String ActualCurrency = CurrencyButton.getText();
	String ExpectedCurrency = "SAR";
	assertEquals(ActualCurrency, ExpectedCurrency);
		
	}
	
	@Test (priority = 3)
	public void CheckTheContactNumbers () {
		WebElement ContactNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG"));
		String ActualNumber = ContactNumber.getText();
		String ExpectedNumber = "+966554400000";
		assertEquals(ActualNumber, ExpectedNumber);
		
	}
//	
//	@Test(priority = 4)
//	public void QitafLogoIsDisplayedInTheFooter() {
//		WebElement TheFooter = driver.findElement(By.tagName("footer"));
//		Boolean ActualResult = TheFooter.findElement(By.cssSelector("")).isDisplayed();
//		Boolean ExpectedResult = true;
//		assertEquals(ActualResult, ExpectedResult);
//
//	}
	
	@Test (priority = 5)
	public void checkHotelTabIsNotSelected() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		
		String ActualResult = HotelTab.getAttribute("aria-selected");
		String ExpectedResult = "false";
		assertEquals(ActualResult, ExpectedResult);
		
	}	
	
	@Test (priority = 6)
	public void CheckDepatureDate() throws IOException {
		int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
		
		String ExpectedDepartureDate = Integer.toString(Tomorrow);
		

			String ActualDepature = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText();

			assertEquals(ActualDepature, ExpectedDepartureDate);
		
	}	
	
	@Test (priority = 7)
	public void CheckReturneDate() throws IOException {
		int DayAfterTomorrow = LocalDate.now().plusDays(2).getDayOfMonth();
		
		String ExpectedReturnDate = Integer.toString(DayAfterTomorrow);
		

			String ActualReturnDate = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText();

			assertEquals(ActualReturnDate, ExpectedReturnDate);
		
	}	
	
	@Test (priority = 7 )
	public void RandomlyChangeLanguage() {
		String [] myWebsite = {"https://qa.almosafer.com/ar" , "https://qa.almosafer.com/en" };
		int randomIndex = rand.nextInt(myWebsite.length);
		driver.get(myWebsite[randomIndex]);
		if (driver.getCurrentUrl().contains("ar")) {
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "ar";
			assertEquals(ActualLanguage, ExpectedLanguage);
		}
		else {
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "en";
			assertEquals(ActualLanguage, ExpectedLanguage);
		}

		
	}	

}
