package EntrataPageObjectRepo;
import static org.testng.Assert.*;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class EntrataHomePage {
	
	private WebDriver driver;
	
    public EntrataHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
	// Home Page Locators 
    @FindBy(css = "svg[alt='Entrata Inc. Logo']")
    private WebElement logo;
    
    @FindBy(xpath = "//div[@class='main-nav-link' and contains(text(), 'Products')]") 
    public WebElement ProductsHeaderMenu;
    
    @FindBy(xpath = "//div[@class='main-nav-link' and contains(text(), 'Solutions')]") 
    private WebElement SolutionsHeaderMenu;
    
    @FindBy(xpath = "//div[@class='header-nav-item' ]//child::a[contains(text(), 'Resources')]")
    private WebElement ResourcesHeaderMenu;
    
    @FindBy(xpath = "//div[@class='header-nav-item' ]//child::a[contains(text(), 'Base Camp')]")
    private WebElement BaseCampHeaderMenu;
    
    @FindBy(xpath = "//div[@class='header-desktop-buttons hide-on-mobile' ]//child::a[contains(text(), 'Watch Demo')]")
    private WebElement WatchDemoButton;
    
    @FindBy(xpath = "//div[@class='header-desktop-buttons hide-on-mobile' ]//child::a[contains(text(), 'Sign In')]")
    private WebElement SignInButton;
    
    @FindBy(xpath = "//div[@class='footer-nav-grid' ]//child::a")
    private List <WebElement> AllFooterElements;
    
    @FindBy(xpath = "//div[@class='fat-nav-grid']//child::a")
    private List <WebElement> AllElementsUnderProductsHeaderDropdown;
    
    @FindBy(xpath = "//div[@class='header-drop-nav']//child::a")
    private List <WebElement> AllElementsUnderSolutionsHeaderDropdown;
 
    // Action Methods.
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }
    
    public boolean isSolutionsHeaderMenuDisplayed() {
        return SolutionsHeaderMenu.isDisplayed();
    }

    public boolean isProductsHeaderMenuDisplayed() {
        return ProductsHeaderMenu.isDisplayed();
    }
    
    public boolean isResourcesHeaderMenuDisplayed() {
        return ResourcesHeaderMenu.isDisplayed();
    }
    
    public boolean isBaseCampHeaderMenuDisplayed() {
        return BaseCampHeaderMenu.isDisplayed();
    }
   
    public boolean isWatchDemoButtonDisplayed() {
        return WatchDemoButton.isDisplayed();
    }
    
    public boolean isSignInButtonDisplayed() {
        return SignInButton.isDisplayed();
    }
    
    public void clickOnProductsHeaderMenu() {
    	ProductsHeaderMenu.click();
    }

    public void clickOnSolutionsHeaderMenu() {
    	SolutionsHeaderMenu.click();
    }
    
    public void clickOnResourcesHeaderMenu() {
    	ResourcesHeaderMenu.click();
    }
    
    public void clickOnBaseCampHeaderMenu() {
    	BaseCampHeaderMenu.click();
    }
    
    public void clickOnWatchDemoButton() {
    	WatchDemoButton.click();
    }
    
    public void clickOnSignInButton() {
    	SignInButton.click();
    }
    
   public void VerifyIfAllFooterElementsAreVisible()
   {
	   for (WebElement element : AllFooterElements)
	   {
		   assertTrue(element.isDisplayed());
	   }
   }
   
   public void VerifyIfAllElementsUnderProductsAreVisible()
   {
	   for (WebElement element : AllElementsUnderProductsHeaderDropdown)
	   {
		   assertTrue(element.isDisplayed());
	   }
   }
   
   public void SelectElementFromProductsHeaderDropdown(String submenu)
   {
	   for (WebElement element : AllElementsUnderProductsHeaderDropdown)
	   {
		   
		   if(element.getText().equals(submenu))
		   {
			  element.click(); 
		   }	
	   }
   }
   
   public void SelectElementFromSolutionsHeaderDropdown(String submenu)
   {
	   for (WebElement element : AllElementsUnderSolutionsHeaderDropdown)
	   {
		   
		   if(element.getText().equals(submenu))
		   {
			  element.click(); 
		   }	
	   }
   }
   
   public void VerifyIfAllElementsUnderSolutionsAreVisible()
   {
	   for (WebElement element : AllElementsUnderSolutionsHeaderDropdown)
	   {
		   assertTrue(element.isDisplayed());
	   }
   }
   
}
