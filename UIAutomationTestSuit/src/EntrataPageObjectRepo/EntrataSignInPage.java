package EntrataPageObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EntrataSignInPage {
	
private WebDriver driver;
	
    public EntrataSignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

 // Sign In Page Locators 

    @FindBy(css = "svg[alt='svg[alt='Entrata Inc. Logo']")
    private WebElement logo;
    
    @FindBy(xpath = "//a[contains(text(), 'Property Manager Login')]")
    public WebElement PropertyManagerLoginButton;
    
    @FindBy(xpath = "//a[contains(text(), 'Resident Login')]")
    private WebElement ResidentLoginButton;
    
    
    
    
    // Sign In Page Action Methods
    public Boolean VerifyIfLogoIsDisplayedOnSignInPage()
    {
 	   return logo.isDisplayed(); 
    }
    
    public Boolean VerifyIfPropertyManagerLoginButtonIsDisplayedOnSignInPage()
    {
 	   return PropertyManagerLoginButton.isDisplayed(); 
    }
    
    public Boolean VerifyIfResidentLoginButtonIsDisplayedOnSignInPage()
    {
 	   return ResidentLoginButton.isDisplayed(); 
    }
    
    public void clickOnPropertyManagerLoginButton() {
    	PropertyManagerLoginButton.click();
    }
    
    public void clickOnResidentLoginButton() {
    	ResidentLoginButton.click();
    }

    
}
