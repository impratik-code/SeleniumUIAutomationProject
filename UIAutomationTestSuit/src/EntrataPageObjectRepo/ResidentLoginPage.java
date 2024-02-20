package EntrataPageObjectRepo;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResidentLoginPage {
	
	private WebDriver driver;
	public ResidentLoginPage(WebDriver driver) 
	{
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	// Resident Log In Page Locators 
    
    @FindBy(xpath = "//div[text()='View the App']")
    private WebElement ViewTheAppButton;
    
    @FindBy(xpath = "//div[text()='View the Website']")
    public WebElement ViewTheWebSiteButton;
    
    @FindBy(xpath = "//input[@id='name' and @type='text']")
    public WebElement NameTextBox;
    
    @FindBy(xpath = "//input[@id='email' and @type='text']")
    private WebElement EmailTextBox;
    
    @FindBy(xpath = "//input[@id='property_name' and @type='text']")
    private WebElement PropertyNameTextBox;
    
    @FindBy(xpath = "//input[@id='property_url' and @type='text']")
    private WebElement PropertyURLTextBox;
    
    @FindBy(xpath = "//select[@id='category' and @data-menu='selector']")
    private WebElement SelectCategoryComboBox;
    
    @FindBy(xpath = "//textarea[@id='message' and @placeholder='Message']")
    private WebElement MessageTextArea;

    @FindBy(xpath = "//button[@id='contact-submit' and @type='button']")
    private WebElement SubmitButton;
    
    @FindBy(xpath = "//div[@class='landing-nav four-content']//child::a[text()='How-to Guides']")
    public WebElement howToGuidesHeader;

    @FindBy(xpath = "//div[@class='landing-nav four-content']//child::a[text()='Features']")
    private WebElement featuresHeader;

    @FindBy(xpath = "//div[@class='landing-nav four-content']//child::a[text()='Tips']")
    private WebElement tipsHeader;

    @FindBy(xpath = "//div[@class='landing-nav four-content']//child::a[text()='FAQs']")
    private WebElement faqsHeader;

    @FindBy(xpath = "//div[@class='landing-nav four-content']//child::a[text()='Contact Us']")
    private WebElement contactUsHeader;
    
    @FindBy(xpath = "//div[@class='sticky-title move-sticky-title']//child::span[text()='How-To Guides']")
    public WebElement howToGuidesStickyTitle;

    @FindBy(xpath = "//div[@class='sticky-title move-sticky-title']//child::span[text()='Features']")
    public WebElement featuresStickyTitle;

    @FindBy(xpath = "//div[@class='sticky-title move-sticky-title']//child::span[text()='Tips']")
    public WebElement tipsStickyTitle;

    @FindBy(xpath = "//div[@class='sticky-title move-sticky-title']//child::span[text()='FAQs']")
    public WebElement faqsStickyTitle;

    @FindBy(xpath = "//div[@class='sticky-title move-sticky-title']//child::span[text()='Contact Us']")
    public WebElement contactUsStickyTitle;
    
    // Resident Log In Page Action Methods 
    
    public boolean isHowToGuidesStickyTitleDisplayed() {
        return howToGuidesStickyTitle.isDisplayed();
    }

    public boolean isFeaturesStickyTitleDisplayed() {
        return featuresStickyTitle.isDisplayed();
    }

    public boolean isTipsStickyTitleDisplayed() {
        return tipsStickyTitle.isDisplayed();
    }

    public boolean isFaqsStickyTitleDisplayed() {
        return faqsStickyTitle.isDisplayed();
    }

    public boolean isContactUsStickyTitleDisplayed() {
        return contactUsStickyTitle.isDisplayed();
    }
    
    public boolean isHowToGuidesHeaderDisplayed() {
        return howToGuidesHeader.isDisplayed();
    }

    public boolean isFeaturesHeaderDisplayed() {
        return featuresHeader.isDisplayed();
    }

    public boolean isTipsHeaderDisplayed() {
        return tipsHeader.isDisplayed();
    }

    public boolean isFaqsHeaderDisplayed() {
        return faqsHeader.isDisplayed();
    }

    public boolean isContactUsHeaderDisplayed() {
        return contactUsHeader.isDisplayed();
    }
    
    public void ClickOnViewTheAppButton()
    {
    	ViewTheAppButton.click();
    }
    
    public void ClickOnViewTheWebSiteButton()
    {
    	ViewTheWebSiteButton.click();
    }
    
    public void ClickOnSubmitButton()
    {
    	SubmitButton.click();
    }
    
    public void clickHowToGuidesHeader() {
        howToGuidesHeader.click();
    }

    public void clickFeaturesHeader() {
        featuresHeader.click();
    }

    public void clickTipsHeader() {
        tipsHeader.click();
    }

    public void clickFaqsHeader() {
        faqsHeader.click();
    }

    public void clickContactUsHeader() {
        contactUsHeader.click();
    }
    
    public void EnterTextInNameTextBox(String text)
    {
    	NameTextBox.sendKeys(text);
    }
    
    public void EnterTextInEmailTextBox(String text)
    {
    	EmailTextBox.sendKeys(text);
    }
    
    public void EnterTextInPropertyNameTextBox(String text)
    {
    	PropertyNameTextBox.sendKeys(text);
    }
    
    public void EnterTextInPropertyURLTextBox(String text)
    {
    	PropertyURLTextBox.sendKeys(text);
    }
    
    public void EnterTextInMessageTextArea(String text)
    {
    	MessageTextArea.sendKeys(text);
    }
    
    public void SelectElementFromSelectCategoryComboBox(String value) 
    {
    	Select select = new Select(SelectCategoryComboBox);
    	select.selectByVisibleText(value);
    	
    }
    
    public void ScrollUpTillElementIsInteractable(WebElement elem)
    {
    	while (true) {
    	    try {
    	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	        wait.until(ExpectedConditions.elementToBeClickable(elem));
    	        break;
    	    } catch (Exception e) {
    	        // Scroll up
    	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'start'});", elem);
    	    }
    	}
    }
    
    
    
}
