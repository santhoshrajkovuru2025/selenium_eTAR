package practice.LTC_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Service_Subacute {
	
	
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
	WebElement SpecHand =	driver.findElement(By.xpath("//select[@name='SpecHand']"));
		Select spcl = new Select(SpecHand);
		spcl.selectByValue("94");
		driver.findElement(By.xpath("//input[@name='PatLstNme']")).sendKeys("Rogers");
		driver.findElement(By.xpath("//input[@name='PatFrstNme']")).sendKeys("Steve");
		driver.findElement(By.xpath("//input[@name='PatDOB']")).sendKeys("09242024");
		driver.findElement(By.xpath("//input[@name='Gender'][1]")).click();
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
	}
	
	public void addServiceInformation() throws InterruptedException {
		
	Thread.sleep(500);
	driver.findElement(By.xpath("//a[normalize-space()='Subacute']")).click();
	driver.findElement(By.xpath("//input[@name='ServiceCode']")).sendKeys("11");
	driver.findElement(By.xpath("//input[@name='TotUnitsReq']")).sendKeys("12");
	driver.findElement(By.xpath("//input[@name='FromDate']")).clear();
	driver.findElement(By.xpath("//input[@name='FromDate']")).sendKeys("09242024");
	driver.findElement(By.xpath("//input[@name='AdmitDate']")).clear();
	driver.findElement(By.xpath("//input[@name='AdmitDate']")).sendKeys("09242024");
	driver.findElement(By.xpath("//input[@name='ThruDate']")).clear();
	driver.findElement(By.xpath("//input[@name='ThruDate']")).sendKeys("09242024");

	WebElement Admit = driver.findElement(By.xpath("//select[@name='AdmFrm']"));
	Select admit = new Select(Admit);
	admit.selectByValue("12");
	WebElement ICD = driver.findElement(By.xpath("//select[@name='Serv_ICDCodeType']"));
	Select code = new Select(ICD);
	code.selectByVisibleText("ICD-10");
	driver.findElement(By.xpath("//input[@name='Serv_ICD9_1']")).sendKeys("A52.9");
	
	WebElement PASRR_Exempt_Reason = driver.findElement(By.xpath("//select[@name='ExmptRsn']"));
	Select passr_exmept_reason = new Select(PASRR_Exempt_Reason);
	passr_exmept_reason.selectByValue("4");
	
	WebElement PASRR_Self_Certification = driver.findElement(By.xpath("//select[@name='PASSelfCert']"));
	Select pasrr_self_certification = new Select(PASRR_Self_Certification);
	pasrr_self_certification.selectByValue("1");
	driver.findElement(By.xpath("//input[@name='PASSDte']")).sendKeys("09242024");
	WebElement Community_Placement = driver.findElement(By.xpath("//select[@name='CommPlace']"));
	Select community_placement = new Select(Community_Placement);
	community_placement.selectByValue("4");
	WebElement Referral_Reason = driver.findElement(By.xpath("//select[@name='RefRsn']"));
	Select referral_reason = new Select(Referral_Reason);
	referral_reason.selectByValue("3");
	driver.findElement(By.xpath("//input[@value='2']")).click();
	driver.findElement(By.xpath("//input[@name ='accessF'][2]")).click();
	driver.findElement(By.xpath("//textarea[@name='CareReq']")).sendKeys("No Information");
	driver.findElement(By.xpath("//input[@value='A']")).click();
	driver.findElement(By.xpath("//input[@name='Treat_Proc1']")).click();
	WebElement Reason = driver.findElement(By.xpath("//select[@name='Proc1_Rsn']"));
	Select reason = new Select(Reason);
	reason.selectByValue("2");
	driver.findElement(By.xpath("//input[@name='Proc1_Frq']")).sendKeys("12");
	driver.findElement(By.xpath("//input[@name='Proc1_Rte']")).sendKeys("150");
	driver.findElement(By.xpath("//input[@name='Submit2']")).click();
		
	}
	
	public void  checkTARSummary() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@alt=\"['TAR Summary']\"]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -500);");
		Thread.sleep(2000);
		 js.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='button16']")).click();
	}
	
	public void submitTAR() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@href='http://sysdev.softsol.com/cgi-forte/forteisapi.dll??serviceName=softsolwebservice&templateName=SetAttachmentsInd.htm&CurrentPage=Serv_Sel']")).click();
		driver.findElement(By.xpath("//input[@alt='Attachment(s) Submission Option: 2']")).click();
		driver.findElement(By.xpath("//input[@id='submit1']")).click();
		Thread.sleep(3000);
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
		
		Service_Subacute TAR = new Service_Subacute();
		TAR.logintoeTAR();
		TAR.enterProviderInformation();
		TAR.enterPatientInformation();
		TAR.addServiceInformation();
		TAR.checkTARSummary();
		TAR.submitTAR();
	}
}
