package EntrataPageObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntrataLogInPage {
	
	private WebDriver driver;
	
    public EntrataLogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }	
    
    // Log In Page Locators 
    
    @FindBy(xpath = "//input[@id='entrata-username']")
    public WebElement UserNameTextBox;
    
    @FindBy(xpath = "//input[@id='entrata-password']")
    private WebElement PasswordTextBox;
    
    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Sign In')]")
    private WebElement SignInButton;
    
    //Login Page Action Methods 
    
    public Boolean VerifyIfUserNameTextBoxIsDisplayed()
    {
 	   return UserNameTextBox.isDisplayed(); 
    }
    
    public Boolean VerifyIfPasswordTextBoxIsDisplayed()
    {
 	   return PasswordTextBox.isDisplayed(); 
    }
    
    public Boolean VerifyIfSignInButtonIsDisplayed()
    {
 	   return SignInButton.isDisplayed(); 
    }
    
    public void EnterUserName(String userName) 
    {
    	UserNameTextBox.sendKeys(userName);
    }
    
    public void EnterPassword(String password) 
    {
    	PasswordTextBox.sendKeys(password);
    }
    
    public void ClickOnSignInButton() 
    {
    	SignInButton.click();
    }
    
}
