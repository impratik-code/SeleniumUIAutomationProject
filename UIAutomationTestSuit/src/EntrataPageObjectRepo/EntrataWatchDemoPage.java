package EntrataPageObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EntrataWatchDemoPage {
	
private WebDriver driver;
	
    public EntrataWatchDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
 // Watch Demo Page Locators 

    @FindBy(xpath = "//img[@id='Header_Logo']']")
    private WebElement logo;
    
    @FindBy(xpath = "//input[@id='FirstName' and @name='FirstName']")
    private WebElement FirstNameTextBox;
    
    @FindBy(xpath = "//input[@id='LastName' and @name='LastName']")
    private WebElement LastNameTextBox;
    
    @FindBy(xpath = "//input[@id='Email' and @name='Email']")
    private WebElement EmailTextBox;
    
    @FindBy(xpath = "//input[@id='Company' and @name='Company']")
    private WebElement CompanyNameTextBox;
    
    @FindBy(xpath = "//input[@id='Phone' and @name='Phone' ]")
    private WebElement PhoneTextBox;
    
    @FindBy(xpath = "//select[@id='Unit_Count__c' and @name='Unit_Count__c' ]")
    private WebElement UnitCountComboBox;
    
    @FindBy(xpath = "//input[@id='Title' and @name='Title' ]")
    private WebElement JobTitleTextBox;
    
    public void EnterFirstName(String firstName) 
    {
    	FirstNameTextBox.sendKeys(firstName);
    }
    
    public void EnterLastName(String lastName) 
    {
    	LastNameTextBox.sendKeys(lastName);
    }
    
    public void EnterEmail(String email) 
    {
    	EmailTextBox.sendKeys(email);
    }
    
    public void EnterCompanyName(String companyName) 
    {
    	CompanyNameTextBox.sendKeys(companyName);
    }
    
    public void EnterPhoneNumber(String phoneNumber) 
    {
    	PhoneTextBox.sendKeys(phoneNumber);
    }
    
    public void SelectElementFromUnitCountComboBox(String unitCount) 
    {
    	Select select = new Select(UnitCountComboBox);
    	select.selectByVisibleText(unitCount);
    	
    }
    
    public void EnterJobTitle(String jobTitle) 
    {
    	JobTitleTextBox.sendKeys(jobTitle);
    }
    
   public Boolean VerifyIfLogoIsDisplayedOnWatchDemoPage()
   {
	   return logo.isDisplayed(); 
   }
   
   
   
}
