package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import EntrataPageObjectRepo.EntrataHomePage;
import EntrataPageObjectRepo.EntrataLogInPage;
import EntrataPageObjectRepo.EntrataSignInPage;
import EntrataPageObjectRepo.EntrataWatchDemoPage;
import EntrataPageObjectRepo.ResidentLoginPage;
import TestUtilities.XmlReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import static org.testng.Assert.*;
import java.time.Duration;




public class UIAutomationTests {
	 
	
	 private WebDriver driver;
	 private EntrataHomePage homePage;
	 private EntrataWatchDemoPage demoPage;
	 private EntrataLogInPage loginPage;
	 private EntrataSignInPage signInPage;
	 private ResidentLoginPage residentLoginPage;
	 
	    @BeforeTest
	    public void setUp() {
	    	WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.entrata.com/");
	        driver.manage().window().maximize();
	        homePage = new EntrataHomePage(driver);
	        demoPage = new EntrataWatchDemoPage(driver);
	        signInPage = new EntrataSignInPage(driver);
	        loginPage = new EntrataLogInPage(driver);
	        residentLoginPage = new ResidentLoginPage(driver);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    
	    
	    /**
	     * This test case verifies homepage elements and navigation functionality.
	     * It checks that essential elements like the logo, header menus, buttons,
	     * and footer links are visible on the homepage. Additionally, it tests
	     * navigation by clicking on header menu items, verifying dropdown menus,
	     * and selecting options. Exception handling is included to ensure script
	     * robustness in case of stale element references.
	     */
	    @Test
	    public void HomePageVerificationsAndPagesNavigationTest() throws InterruptedException{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        assertTrue(homePage.isLogoDisplayed(), "Logo is not Visible");
	        assertTrue(homePage.isProductsHeaderMenuDisplayed(), "Products Menu is not Visible");
	        assertTrue(homePage.isSolutionsHeaderMenuDisplayed(), "Solutions Menu is not Visible");
	        assertTrue(homePage.isResourcesHeaderMenuDisplayed(), "Resources Menu is not Visible");
	        assertTrue(homePage.isBaseCampHeaderMenuDisplayed(), "Base Camp Menu is not Visible");
	        assertTrue(homePage.isWatchDemoButtonDisplayed(), "Watch demo Button is not Visible");
	        assertTrue(homePage.isSignInButtonDisplayed(), "Sign In Button is not Visible");
	        homePage.VerifyIfAllFooterElementsAreVisible();
	        
	        homePage.clickOnProductsHeaderMenu();
	        homePage.VerifyIfAllElementsUnderProductsAreVisible();
	        
	        homePage.SelectElementFromProductsHeaderDropdown("ResidentPay");
	        Thread.sleep(4000);
	        driver.navigate().back();
	        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(homePage.ProductsHeaderMenu)));
	       
	        try 
	        {
	        	homePage.clickOnProductsHeaderMenu();
		        Thread.sleep(2000);
		        homePage.SelectElementFromProductsHeaderDropdown("Renters Insurance");
		        Thread.sleep(4000);
		        driver.navigate().back();
	        }
	        catch(StaleElementReferenceException e)
	        {
	        	homePage = new EntrataHomePage(driver);
	        	homePage.clickOnProductsHeaderMenu();
		        Thread.sleep(2000);
		        homePage.SelectElementFromProductsHeaderDropdown("Renters Insurance");
		        Thread.sleep(4000);
		        driver.navigate().back();
	        }
	        
	        try 
	        {
	        	homePage.clickOnSolutionsHeaderMenu();
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header-drop-nav']//child::a")));
		        homePage.VerifyIfAllElementsUnderSolutionsAreVisible();
		        homePage.SelectElementFromSolutionsHeaderDropdown("Student");
	        	Thread.sleep(4000);
	        	driver.navigate().back();
	        }
	        
	        catch(StaleElementReferenceException ee)
	        {
	        	homePage = new EntrataHomePage(driver);
	        	
	        	homePage.clickOnSolutionsHeaderMenu();		        
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header-drop-nav']//child::a")));
		        homePage.VerifyIfAllElementsUnderSolutionsAreVisible();
		        homePage.SelectElementFromSolutionsHeaderDropdown("Student");
	        	Thread.sleep(4000);
	        	driver.navigate().back();
	        }
	    }
	    
	    /**
	     * This test case verifies the functionality of the login process across different pages.
	     * It performs the following steps:
	     * 1. Initiates a demo login by filling out the demo form but does not submit it.
	     * 2. Navigates back to the homepage and waits until the products header menu is not stale.
	     * 3. Initiates the sign-in process, handles any cookie acceptance prompts, and clicks on the property manager login button.
	     * 4. Waits until the login page elements are not stale, fills out the login credentials, but does not submit the form.
	     * 5. Navigates back to the homepage and waits until the property manager login button is not stale.
	     * 6. Initiates the resident login process, fills out the resident login form, and navigates back.
	     * 7. Waits until the name text box is clickable by scrolling down.
	     * 8. Fills out the resident login form with name, email, property details, category, and message, but does not submit it.
	     * 9. Navigates back to the previous pages without submitting the form.
	     */
	    @Test
	    public void loginFunctionalityTest()
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	String FilePath = "C://Pratik_SeleniumAutomationProj/UIAutomationTestSuit/src/Tests/TestData.xml";
	    	String username = XmlReader.readTestData(FilePath, "username");
            String password = XmlReader.readTestData(FilePath, "password");
            String firstName = XmlReader.readTestData(FilePath, "firstName");
            String lastName = XmlReader.readTestData(FilePath, "lastName");
            String email = XmlReader.readTestData(FilePath, "email");
            String company = XmlReader.readTestData(FilePath, "company");
            String phoneNo = XmlReader.readTestData(FilePath, "phoneNo");
            String unitCount = XmlReader.readTestData(FilePath, "unitCount");
            String jobtitle = XmlReader.readTestData(FilePath, "jobtitle");
            String propertyName = XmlReader.readTestData(FilePath, "propertyName");
            String propertyURL = XmlReader.readTestData(FilePath, "propertyURL");
            String category = XmlReader.readTestData(FilePath, "category");
            String message = XmlReader.readTestData(FilePath, "message");
            // Demo Page Login test
           
            homePage.clickOnWatchDemoButton();
            demoPage.EnterFirstName(firstName);
            demoPage.EnterLastName(lastName);
            demoPage.EnterEmail(email);
            demoPage.EnterCompanyName(company);
            demoPage.EnterPhoneNumber(phoneNo);
            demoPage.SelectElementFromUnitCountComboBox(unitCount);
            demoPage.EnterJobTitle(jobtitle);
            //as per instruction not clicking on the submit button.
            driver.navigate().back();
            wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(homePage.ProductsHeaderMenu)));
            
            //Sign In/logIn Page Test 
            homePage.clickOnSignInButton();
            WebElement acceptCookiesButton = null;
            try {
                acceptCookiesButton = driver.findElement(By.xpath("//button[@id='rcc-confirm-button']"));
            } catch (Exception ignored) {
                // Accept cookies button not found
            }
            if (acceptCookiesButton != null) {
                acceptCookiesButton.click();
                System.out.println("Accepted cookies.");
            } else {
                System.out.println("No cookies message found or already accepted.");
            }
            
            signInPage.clickOnPropertyManagerLoginButton();
            wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(loginPage.UserNameTextBox)));
            loginPage.EnterUserName(username);
            loginPage.EnterPassword(password);
            // loginPage.ClickOnSignInButton(); /*As per instruction not clicking on the submit button.*/
            driver.navigate().back();
            wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(signInPage.PropertyManagerLoginButton)));
            
            // Resident Page Log in Test
            signInPage.clickOnResidentLoginButton();
            wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(residentLoginPage.ViewTheWebSiteButton)));
            residentLoginPage.ClickOnViewTheWebSiteButton();
            while (true) {
                try {
                    
                    wait.until(ExpectedConditions.elementToBeClickable(residentLoginPage.NameTextBox));
                    System.out.println("Element is clickable now.");
                    break;
                } catch (Exception e) {
                    // Scroll down
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",residentLoginPage.NameTextBox);
                }
            }
            
            residentLoginPage.EnterTextInNameTextBox(firstName);
            residentLoginPage.EnterTextInEmailTextBox(email);
            residentLoginPage.EnterTextInPropertyNameTextBox(propertyName);
            residentLoginPage.EnterTextInPropertyURLTextBox(propertyURL);
            residentLoginPage.SelectElementFromSelectCategoryComboBox(category);
            residentLoginPage.EnterTextInMessageTextArea(message);
            driver.navigate().back();
            driver.navigate().back();
            //residentLoginPage.ClickOnSubmitButton(); /*As per instruction not clicking on the submit button.*/
                    
	    }
	    
	    /**
	     * This test case verifies various elements and functionalities on the resident portal page.
	     * It performs the following tasks:
	     * 1. Clicks on the sign-in button and handles cookie acceptance if required.
	     * 2. Navigates to the resident login page and clicks on the "View the Website" button to access the resident portal.
	     * 3. Verifies the visibility of header links such as How-To Guides, Features, Tips, FAQs, and Contact Us.
	     * 4. Clicks on each header link and verifies the visibility of sticky titles associated with them.
	     * 5. Scrolls up to ensure elements are interactable after clicking on each header link.
	     * 
	     * Importance:
	     * - Functionality Validation: Ensures essential functionalities of the resident portal are working as expected.
	     * - User Experience Assurance: Contributes to a seamless and user-friendly experience on the resident portal.
	     * - Error Detection: Detects discrepancies in element visibility or website malfunctioning for early issue resolution.
	     * - Regression Testing: Serves as a regression test to maintain existing functionalities amid website changes.
	     */
	    @Test
	    public void ResidentPortalPageVerificationTest() throws InterruptedException
	    {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	homePage.clickOnSignInButton();
	    	
	    	WebElement acceptCookiesButton = null;
            try {
                acceptCookiesButton = driver.findElement(By.xpath("//button[@id='rcc-confirm-button']"));
            } catch (Exception ignored) {
                // Accept cookies button not found
            }
            if (acceptCookiesButton != null) {
                acceptCookiesButton.click();
                System.out.println("Accepted cookies.");
            } else {
                System.out.println("No cookies message found or already accepted.");
            }
            
	    	signInPage.clickOnResidentLoginButton();
	    	wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(residentLoginPage.ViewTheWebSiteButton)));
	    	residentLoginPage.ClickOnViewTheWebSiteButton();
	    	
	    	assertTrue(residentLoginPage.isHowToGuidesHeaderDisplayed(), "HowToGuidesHeader is not Visible");
	    	assertTrue(residentLoginPage.isFeaturesHeaderDisplayed(), "FeaturesHeader is not Visible");
	    	assertTrue(residentLoginPage.isTipsHeaderDisplayed(), "TipsHeader is not Visible");
	    	assertTrue(residentLoginPage.isFaqsHeaderDisplayed(), "FaqsHeader is not Visible");
	    	assertTrue(residentLoginPage.isContactUsHeaderDisplayed(), "ContactUsHeader is not Visible");
	    	
	    	residentLoginPage.clickHowToGuidesHeader();
	    	wait.until(ExpectedConditions.visibilityOf(residentLoginPage.howToGuidesStickyTitle));
	    	assertTrue(residentLoginPage.isHowToGuidesStickyTitleDisplayed(), "How To Guides sticky Title is not Visible");
	    	residentLoginPage.ScrollUpTillElementIsInteractable(residentLoginPage.howToGuidesHeader);
	    	Thread.sleep(3000);
	    	
	    	residentLoginPage.clickFeaturesHeader();
	    	wait.until(ExpectedConditions.visibilityOf(residentLoginPage.featuresStickyTitle));
	    	assertTrue(residentLoginPage.isFeaturesStickyTitleDisplayed(), "Features sticky Title is not Visible");
	    	residentLoginPage.ScrollUpTillElementIsInteractable(residentLoginPage.howToGuidesHeader);
	    	Thread.sleep(3000);
	    	
	    	residentLoginPage.clickFaqsHeader();
	    	wait.until(ExpectedConditions.visibilityOf(residentLoginPage.faqsStickyTitle));
	    	assertTrue(residentLoginPage.isFaqsStickyTitleDisplayed(), "FAQs sticky Title is not Visible");
	    	residentLoginPage.ScrollUpTillElementIsInteractable(residentLoginPage.howToGuidesHeader);
	    	Thread.sleep(3000);
	    	
	    	residentLoginPage.clickContactUsHeader();
	    	wait.until(ExpectedConditions.visibilityOf(residentLoginPage.contactUsStickyTitle));
	    	assertTrue(residentLoginPage.isContactUsStickyTitleDisplayed(), "Contact Us sticky Title is not Visible");
	    	residentLoginPage.ScrollUpTillElementIsInteractable(residentLoginPage.howToGuidesHeader);
	    	Thread.sleep(3000);

	    	// this Step will fail because of Website's malfunctioning.
	    	residentLoginPage.clickTipsHeader();
	    	Thread.sleep(5000);
	    	assertTrue(residentLoginPage.isTipsStickyTitleDisplayed(), "Tips sticky Title is not Visible");
	    	residentLoginPage.ScrollUpTillElementIsInteractable(residentLoginPage.howToGuidesHeader);
	    	Thread.sleep(3000);
	    	
	    }
	 
}
