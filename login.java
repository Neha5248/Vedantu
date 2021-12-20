package Demo;


	import java.util.Iterator;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class login {

		public static void main(String[] args) throws InterruptedException  
		{
			String checkin_date="24";
			String checkout_date="25";
			String adultCount="2";
			String childCount="1";
			
			System.setProperty("webdriver.chrome.driver", "D:\\workspace\\RahulShettySelenium\\driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			// driver.manage().timeouts().pageLoadTimeout(5, T);
			driver.get("https://www.makemytrip.com/");
			driver.findElement(By.xpath("//label[contains(text(),'Login with Phone/Email')]")).click();

			System.out.println(driver.findElements(By.tagName("iframe")).size());

			String parentWindow = driver.getWindowHandle();
			System.out.println("parentWindow:" + parentWindow);
			Set<String> allWindow = driver.getWindowHandles();
			System.out.println("allWindow:" + allWindow);

			for (String allWindIds : allWindow) {
				System.out.println(allWindIds);
			}

			// Now iterate using Iterator
			Iterator<String> itr = allWindow.iterator();

			while (itr.hasNext()) {
				String childWindow = itr.next();

				if (!parentWindow.equals(childWindow)) {
					driver.switchTo().window(childWindow);
					System.out.println(driver.switchTo().window(childWindow).getTitle());
				}
			}

			driver.findElement(By.xpath("//input[@data-cy='userName']")).sendKeys("nehak101012@gmail.com");
			driver.findElement(By.xpath("//button[@data-cy='continueBtn']")).click();
			Thread.sleep(5000);

			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Neha@5248");

			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@data-cy='login']")).click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			driver.get("https://www.makemytrip.com/hotels/");
			driver.findElement(By.xpath("//input[@id='city' and @type='text']")).sendKeys("beng");
			Thread.sleep(10000);

			int count = driver.findElements(By.xpath("//ul[@role='listbox']//li")).size();
			System.out.println(count);

			List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//li//div//div//div//div//p"));

			for (WebElement option : options) {

				System.out.println(option.getText());

				if (option.getText().equalsIgnoreCase("Bengaluru")) {
					option.click();
					break;
				}
			}
			
			//Calender 1
			driver.findElement(By.xpath("//input[@id='checkin']")).click();		
			 List <WebElement> dates =driver.findElements(By.xpath("//div[@class='DayPicker Selectable Range']//div//div[@class='DayPicker-Day']"));
			 int count1 =driver.findElements(By.xpath("//div[@class='DayPicker Selectable Range']//div//div[@class='DayPicker-Day']")).size();
			 System.out.println(count1);

			 for(int i=0; i<count ; i++)
			 {
				 String text= driver.findElements(By.xpath("//div[@class='DayPicker Selectable Range']//div//div[@class='DayPicker-Day']")).get(i).getText();
				 if(text.equalsIgnoreCase(checkin_date))
				 {
					 driver.findElements(By.xpath("//div[@class='DayPicker Selectable Range']//div//div[@class='DayPicker-Day']")).get(i).click();
					 break;

				 }
			 }
			 
			 //Calender2

			 driver.findElement(By.xpath("//input[@id='checkout']")).click();		
			 List <WebElement> dates1 =driver.findElements(By.xpath("//div[@class='DayPicker Selectable Range']//div//div[@class='DayPicker-Day']"));
			 int count2 =driver.findElements(By.xpath("//div[@class='DayPicker Selectable Range']//div//div[@class='DayPicker-Day']")).size();
			 System.out.println(count2);

			 for(int i=0; i<count2 ; i++)
			 {
				 String text= driver.findElements(By.xpath("//div[@class='DayPicker Selectable Range']//div//div[@class='DayPicker-Day']")).get(i).getText();
				 if(text.equalsIgnoreCase(checkout_date))
				 {
					 driver.findElements(By.xpath("//div[@class='DayPicker Selectable Range']//div//div[@class='DayPicker-Day']")).get(i).click();
					 break;

				 }
			 }
			 
			 
			 driver.findElement(By.xpath("//input[@id='guest']")).click();		
			 List <WebElement> adults =driver.findElements(By.xpath("//ul[@data-cy='adultCount']//li"));
			 int count3 =driver.findElements(By.xpath("//ul[@data-cy='adultCount']//li")).size();
			 System.out.println(count3);

			 for(int i=0; i<count3 ; i++)
			 {
				 String text= driver.findElements(By.xpath("//ul[@data-cy='adultCount']//li")).get(i).getText();
				 if(text.equalsIgnoreCase(adultCount))
				 {
					 driver.findElements(By.xpath("//ul[@data-cy='adultCount']//li")).get(i).click();
					 break;

				 }
			 }
			 
			 
			 List <WebElement> child =driver.findElements(By.xpath("//div[@class='addRooomDetails']//ul[2]//li"));
			 int count4 =driver.findElements(By.xpath("//div[@class='addRooomDetails']//ul[2]//li")).size();
			 System.out.println(count4);

			 for(int i=0; i<count4 ; i++)
			 {
				 String text= driver.findElements(By.xpath("//div[@class='addRooomDetails']//ul[2]//li")).get(i).getText();
				 if(text.equalsIgnoreCase(childCount))
				 {
					 driver.findElements(By.xpath("//div[@class='addRooomDetails']//ul[2]//li")).get(i).click();
					 break;

				 }
			 }
			 Thread.sleep(5000);

			 WebElement element=driver.findElement(By.xpath("//select[@class='ageSelectBox']"));
			 Select select = new Select(element);
			 select.selectByIndex(2);		 
			 driver.findElement(By.xpath("//button[@data-cy='submitGuest']")).click();
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//button[@data-cy='submit' and @id='hsw_search_button']")).click();
			 Thread.sleep(5000);

			 
			 driver.findElement(By.xpath("//input[@name='min']")).sendKeys("1000");
			 driver.findElement(By.name("max")).sendKeys("2000");
			 driver.findElement(By.xpath("//span[@class='sprite icWhiteArrow']")).click();
			 driver.switchTo().frame(0);
			 Thread.sleep(2000);
			
			 driver.findElement(By.xpath("(//img[@alt='hotelImg'])[1]")).click();
			 driver.navigate().back();
			 //driver.findElement(By.xpath("//span[contains(text(),'Applied Filters')]/following-sibling::a")).click();
			 driver.findElement(By.xpath("//button[@class='apldFltr__item--close']")).click();
		}
			
		
		
		
			
		}
		

