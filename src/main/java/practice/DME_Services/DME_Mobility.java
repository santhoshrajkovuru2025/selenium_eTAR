package practice.DME_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DME_Mobility {
	
	
	WebDriver driver = new ChromeDriver();
	String SplittedTAR;
	
	public void logintoeTAR() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Santhosh\\chromedriver\\chromedriver.exe");
		driver.get("http://sysdev.softsol.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[@id='MedicalService']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Create a New TAR']")).click();
		}
	
	public void enterProviderInformation() {
	
		driver.findElement(By.xpath("//input[@name='ProvFax_area']")).sendKeys("858");
		driver.findElement(By.xpath("//input[@name='ProvFax_pre']")).sendKeys("959");
		driver.findElement(By.xpath("//input[@name='ProvFax_sufx']")).sendKeys("7488");
		driver.findElement(By.xpath("//input[@name='txtTARCompBy']")).sendKeys("John Allebe");
		driver.findElement(By.xpath("//input[@name='txtProvContNme']")).sendKeys("sam Allebe");
		driver.findElement(By.xpath("//input[@name='ContPhne_area']")).sendKeys("141");
		driver.findElement(By.xpath("//input[@name='ContPhne_pre']")).sendKeys("525");
		driver.findElement(By.xpath("//input[@name='ContPhne_sufx']")).sendKeys("4156");
		driver.findElement(By.xpath("//input[@name='ContPhne_ext']")).sendKeys("91");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		driver.switchTo().alert().accept();
	}
	
	public void enterPatientInformation() {
		
		driver.findElement(By.xpath("//input[@name='MedicalID']")).sendKeys("000000001");
		driver.findElement(By.xpath("//input[@name='PatLstNme']")).sendKeys("Rogers");
		driver.findElement(By.xpath("//input[@name='PatFrstNme']")).sendKeys("Steve");
		driver.findElement(By.xpath("//input[@name='PatDOB']")).sendKeys("09241984");
		driver.findElement(By.xpath("//input[@name='Gender'][1]")).click();
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
	}
	
	public void addServiceInformation() throws InterruptedException {
		
	Thread.sleep(500);
	driver.findElement(By.xpath("//a[normalize-space()='Mobility']")).click();
	driver.findElement(By.xpath("//input[@name='ServiceCode']")).sendKeys("A4637");
	Thread.sleep(500);
	driver.findElement(By.xpath("//input[@name ='ModifierCode1']")).sendKeys("NU");
	driver.findElement(By.xpath("//input[@name ='TotUnitsReq']")).sendKeys("11");
	driver.findElement(By.xpath("//input[@name='FromDate']")).clear();
	driver.findElement(By.xpath("//input[@name='FromDate']")).sendKeys("09271990");
	Thread.sleep(500);
	driver.findElement(By.xpath("//input[@name='ThruDate']")).clear();
	driver.findElement(By.xpath("//input[@name='ThruDate']")).sendKeys("09271990");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='AdmitDate']")).clear();
	driver.findElement(By.xpath("//input[@name='AdmitDate']")).sendKeys("09271990");
	driver.findElement(By.xpath("//input[@name='DischDate']")).clear();
	driver.findElement(By.xpath("//input[@name='DischDate']")).sendKeys("09271990");
	driver.findElement(By.xpath("//input[@name='Frequency']")).sendKeys("11");
	WebElement Frequency =  driver.findElement(By.xpath("//select[@name='FrequencyInd']"));
	Select f= new Select(Frequency);
	f.selectByValue("W");
	driver.findElement(By.xpath("//input[@name='AntLength']")).sendKeys("11");
	WebElement AntLength =  driver.findElement(By.xpath("//select[@name='AntLengthInd']"));
	Select A= new Select(AntLength);
	A.selectByValue("W");
	WebElement POS =driver.findElement(By.xpath("//select[@name='POS']"));
	Select place = new Select(POS);
	place.selectByVisibleText("Home");
	
	WebElement ICD = driver.findElement(By.xpath("//select[@name='Serv_ICDCodeType']"));
	Select code = new Select(ICD);
	code.selectByVisibleText("ICD-10");
	
	driver.findElement(By.xpath("//input[@name='Serv_ICD9_1']")).sendKeys("A52.9");
	driver.findElement(By.xpath("//input[@name='PhysLimit_1']")).sendKeys("522");
	WebElement ICD1 = driver.findElement(By.xpath("//select[@name='Serv_ICDCodeType_1']"));
	Select code1 = new Select(ICD1);
	code1.selectByVisibleText("ICD-10");
	driver.findElement(By.xpath("//input[@name='ICD9_1']")).sendKeys("A52.9");
	driver.findElement(By.xpath("//textarea[@name='PhysPresc']")).sendKeys("No Prescption Needed");
	driver.findElement(By.xpath("//input[@name='PhysLicNum']")).sendKeys("1548201965");
	driver.findElement(By.xpath("//input[@name='PhysName']")).sendKeys("Prescribing provider1");
	driver.findElement(By.xpath("//input[@name='PhysPhne1']")).sendKeys("252");
	driver.findElement(By.xpath("//input[@name='PhysPhne2']")).sendKeys("252");
	driver.findElement(By.xpath("//input[@name='PhysPhne3']")).sendKeys("2525");
	driver.findElement(By.xpath("//input[@name='PrescriptDte']")).sendKeys("09271990");
	
	driver.findElement(By.xpath("//input[@alt='replace Yes']")).click();
	WebElement Replace = driver.findElement(By.xpath("//select[@name='ReplcRsn_1']"));
	Select replace = new Select(Replace);
	replace.selectByValue("8");
	driver.findElement(By.xpath("//tbody/tr/td[1]/span[1]/input[2]")).click();
	driver.findElement(By.xpath("//tbody/tr/td[2]/span[1]/input[2]")).click();
	driver.findElement(By.xpath("//tbody/tr/td[3]/span[1]/input[2]")).click();
	driver.findElement(By.xpath("//input[@name='Submit4']")).click();
		
	}
	
	public void  checkTARSummary() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@alt=\"['TAR Summary']\"]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -500);");
		Thread.sleep(2000);
		 js.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='button16']")).click();
	}
	
	public void submitTAR() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@href='http://sysdev.softsol.com/cgi-forte/forteisapi.dll??serviceName=softsolwebservice&templateName=SetAttachmentsInd.htm&CurrentPage=Serv_Sel']")).click();
		driver.findElement(By.xpath("//input[@alt='Attachment(s) Submission Option: 2']")).click();
		driver.findElement(By.xpath("//input[@id='submit1']")).click();
		Thread.sleep(5000);
		String TAR = driver.findElement(By.xpath("//*[text()='TAR # : ']")).getText();
		String[] splitTAR = TAR.split(":");
		
		if(splitTAR.length > 1) {
			
			System.out.println("TCN: "+ splitTAR[1].trim());
			SplittedTAR = splitTAR[1].trim();
			
		}else
		{
			System.out.println("No TAR Found");
		}
		
		TARInquiry(SplittedTAR);
	}
	
	public void TARInquiry(String SplittedTAR) throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@alt='[TAR Menu]']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Inquire on a TAR']")).click();
		driver.findElement(By.xpath("//input[@name='TarNum']")).sendKeys(SplittedTAR);
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//td[@headers='TCN']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -500);");
		Thread.sleep(2000);
		 js.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(5000);
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		DME_Mobility TAR = new DME_Mobility();
		TAR.logintoeTAR();
		TAR.enterProviderInformation();
		TAR.enterPatientInformation();
		TAR.addServiceInformation();
		TAR.checkTARSummary();
		TAR.submitTAR();
	}
}
