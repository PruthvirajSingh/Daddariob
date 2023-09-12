package Pkg.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pkg.Utiltiy.UtilClass;
import io.qameta.allure.Step;

public class LoginAndAddProductIntoCart {
	private WebDriver driver;
	private JavascriptExecutor j;
	private LoginPage loginPage;
	WebDriverWait wait;
	Actions builder;
	String productName;
	String parentWindow;
	@FindBy (css="#search-form-trigger")
	private WebElement searchForProduct;
	
	@FindBy (css="#global-search-input")
	private WebElement inputForSearch;
	
	@FindBy (xpath="//button[@class='button search-button']")
	private WebElement searchAgain;
	
	@FindBy (xpath="//div[@class='product-tile-title']")
	private List<WebElement> productList;
	
	@FindBy (xpath="(//div[@class='suggestions-container']//div[@class='product-tile-title'])[1]")
	private WebElement firstProduct;
	@FindBy (xpath="//button[text()='Add to Cart']")
	private WebElement addToCart;
	@FindBy (css="#cart-link-trigger")
	private WebElement cartLogoClcik;
	
	@FindBy (css=".animated-button.primary.mini-cart-subtotal-cta")
	private WebElement goToCart;
	
	@FindBy (css="h1[class='cart-title']")
	private WebElement yourCart;
	
	@FindBy (css="#proceed-to-checkout-button")
	private WebElement proceedToCheckOut;
	
	@FindBy (css="#shipping-F_Orange")
	private WebElement firstNameCheckout;
	
	@FindBy (css="#shipping-L_Red")
	private WebElement lastNameCheckout;
	
	@FindBy (xpath="//label[text()='Address line 1']/..//input")
	private WebElement shippingAddress;
	
	@FindBy (css="#shipping-city-name")
	private WebElement cityName;
	
	@FindBy (css="#shipping-postal-code")
	private WebElement zipCodeValue;
	
	@FindBy (css="input#phoneNumber")
	private WebElement phoneNumber;
	
	@FindBy (css="#PayPal")
	private WebElement payPalWhiteButton;
	
	@FindBy (css="iframe[title='PayPal']")
	private WebElement iframePayPalYellow;
	
	@FindBy (css="div[class='paypal-button-label-container']")
	private WebElement payPalButton;
	
	@FindBy (css="#emailSubTagLine")
	private WebElement headerForThePayPalPaymentWindow;
	
	@FindBy (css="#order-summary-ShippingName")
	private WebElement shippingName;
	
	@FindBy (css="#email")
	private WebElement emailIdPayPal;
	
	@FindBy (css="#btnNext")
	private WebElement buttonNext;
	
	@FindBy (css="#password")
	private WebElement passwordPayPal;
	
	@FindBy (css="#btnLogin")
	private WebElement buttonLogin;
	
	@FindBy (css="#payment-submit-btn")
	private WebElement paymentSubmitButton;
	
	@FindBy (css=".order-confirmation h1")
	private WebElement orderConfirmations;
	
	@FindBy (xpath="(//div[@class='three-up-container'])[1]/h2")
	private WebElement firstHeader;
	
	@FindBy (css=".comp-carouselImageBlock")
	private WebElement firstBlock;
	
	@FindBy (xpath="//div[@class='recommendation-block-container']//h2")
	private WebElement recommandedBlockForAddToCartItems;
	
	@FindBy (xpath="(//div[contains(@class,'next-arrow slick-arrow')])[1]")
	private WebElement nextButton;
	
	public WebElement cartButtonForClick(String ariaLabel) {
		String locator = String.format("(//div[text()='%s'])[2]/../..//div[@class='add-to-cart-buttons']", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}
	
	
	@FindBy (css=".mini-cart-item-title a")
	private WebElement cartItems;
	
	@FindBy (xpath="(//button[contains(@class,'button update-qty')])[2]")
	private WebElement updateProductButton;
	
	@FindBy (xpath="(//input[contains(@class,'only-number')])[2]")
	private WebElement updateNumberOfQutProductInput;
	
	@FindBy (css=".price-col p span")
	private WebElement priceOfOneQuantity;
	
	@FindBy (xpath="//div[contains(@class,' screen-sm-hidden ')]//p//span")
	private WebElement finalPricing;
	
	@FindBy (css="div.td.cell-remove a.remove-item-action svg")
	private WebElement removeProductFromTheCart;
	
	@FindBy (css="button[class='ok remove-all-item-action']")
	private WebElement yesButtonRemoveCart;
	
	@FindBy (css=".rich-text-area.narrowWidth h2")
	private WebElement yourCartEmptyMessage;
	
	@FindBy (css="#global-search-form .button.search-button")
	private WebElement searchButtonAfterProductEnter;
	
	@FindBy (css=".results-container")
	private WebElement resultsAfterSearch;
	
	@FindBy (css="div[class='product-tile-image'] img")
	private List<WebElement> productListToClick;
	
	@FindBy (css="div[data-view='VariantSelector'] label label")
	private WebElement packSizeText;
	
	@FindBy (css="div[class='text-option']")
	private List<WebElement> packSizeOptions;
	
	@FindBy (css=".out-of-stock-message span")
	private WebElement outOfStockMessage;
	
	@FindBy (xpath="//button[text()='Add to Cart']")
	private WebElement addIntoCart;
	
	@FindBy (css=".table.cart-table p[class='product-name'] a")
	private WebElement productNameInYourCart;
	
	@FindBy (css="div[class='comp-variantList'] div[class='variant-list-title'] label")
	private WebElement scrollUptoSelectAnItems;
	
	@FindBy (xpath="(//div[@class='variant-list-container'])[1]//div//div[@class='variant-title']")
	private List<WebElement> veriantTitle;
	@FindBy (xpath="(//div[@class='variant-data ']//div/div[@class='variant-title'])[5]")
	private WebElement oneElementTitle;
	@FindBy (css="div[class='comp-variantList'] div[class='variant-list-container']")
	private WebElement veriantList;
	
	@FindBy (css="div[class='tbody'] p[class='product-name'] a")
	private List<WebElement> cartItemsList;
	
	@FindBy (css="div[class='mini-cart-item-quantity']")
	private List<WebElement> cartIteamsQuatity;
	
	@FindBy (css="h1[class='underlined-heading']")
	private WebElement checkOutPage;
	public WebElement headersThatNeedToScrollIntoView(String ariaLabel) {
		String locator = String.format("(//div[@class='three-up-container'])[%s]/h2", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}
	
	@FindBy (xpath="//div[@class='product-tile-title']")
	private List<WebElement> addProductIntoCart;
	public LoginAndAddProductIntoCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		j = (JavascriptExecutor) driver;
		loginPage=new LoginPage(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		builder = new Actions(driver);        
	}
	@Step("Search Product and click to add to cart and check for it will added into the cart")
	public String prodcutAddIntoTheCart(String productValue) throws InterruptedException {
		searchForProduct.click();
		inputForSearch.sendKeys(productValue);
		firstProduct.click();
		wait.until(ExpectedConditions.visibilityOf(addToCart)).click();
		cartLogoClcik.click();
		goToCart.click();
		wait.until(ExpectedConditions.visibilityOf(yourCart));
		return yourCart.getText();
	}
	@Step("CheckOut for the product by filling the all the details")
	public void methodProceedToCheckOut(String firstName,String lastName,String shoppingAddress,String cityNameValue,String zipCode,String phoneNumberValue) {
		proceedToCheckOut.click();
		firstNameCheckout.sendKeys(firstName);
		lastNameCheckout.sendKeys(lastName);
		shippingAddress.click();
		wait.until(ExpectedConditions.visibilityOf(shippingAddress)).sendKeys(shoppingAddress);
		cityName.sendKeys(cityNameValue);
		zipCodeValue.sendKeys(zipCode);
		phoneNumber.sendKeys(phoneNumberValue);
		payPalWhiteButton.click();
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",shippingName);
		driver.switchTo().frame(iframePayPalYellow);
		payPalButton.click();
		driver.switchTo().defaultContent();
		parentWindow = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
	}
	@Step("return to parentWindow for the delete product")
	public void deleteProductBackToParentWindows() {
		driver.switchTo().window(parentWindow);
		driver.navigate().back();
	}
	@Step("Fill the details for the paypal payment and Validate order confirmations message")
	public String payamentForPayPal(String emailAddressPayPal,String passwordValuePayPal) {
		emailIdPayPal.sendKeys(emailAddressPayPal);
		buttonNext.click();
		passwordPayPal.sendKeys(passwordValuePayPal);
		buttonLogin.click();
		wait.until(ExpectedConditions.visibilityOf(paymentSubmitButton)).click();
		driver.switchTo().window(parentWindow);
		
		return wait.until(ExpectedConditions.visibilityOf(orderConfirmations)).getText();
		
	}
	@Step("Add the product into the cart by its cart logo shortcut and validate the product added")
	public String addproductByLogo(String productValue) {
		j.executeScript("arguments[0].scrollIntoView({block: 'end', inline: 'nearest'});", firstBlock);
		for (int i = 1; i <=3; i++) {
		
			j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",headersThatNeedToScrollIntoView(String.valueOf(i)));
		}
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",recommandedBlockForAddToCartItems);
		if(cartButtonForClick(productValue).isDisplayed()==true) {
			System.out.println("if block");
			wait.until(ExpectedConditions.visibilityOf(cartButtonForClick(productValue))).click();
		}
		else {
			System.out.println("else block");
			nextButton.click();
			wait.until(ExpectedConditions.visibilityOf(cartButtonForClick(productValue))).click();
		}
		cartLogoClcik.click();
		
		return cartItems.getText();
	}
	@Step("Chanage the product quantity and validate that it will be update after click on 'Update' button")
	public String updateProductQuatity(String num) {
		int finalValue = 0;
		goToCart.click();
		updateNumberOfQutProductInput.clear();
		updateNumberOfQutProductInput.sendKeys(num);
		updateProductButton.click();
		String price=priceOfOneQuantity.getText();
		System.out.println(price);
		String updatedPrice=price.replace("€", "").replace(",", "").replace(" ","");
		int priceValue = Integer.parseInt(updatedPrice);
		if(updateNumberOfQutProductInput.getAttribute("value").equals(num)) {
			int numberUpdated=Integer.parseInt(num);
			finalValue=numberUpdated*priceValue;
		}
		String formatedString =UtilClass.formatNumber(finalValue);
		System.out.println(formatedString);
		return formatedString;
		
	}
	@Step("Check for the updated price text after the quality chages")
	public String finalUpdatedPriceAfterCalcultions() {
		return finalPricing.getText();
	}
	@Step("Clcik on the delete button after product sussesfully add into the cart")
	public String delProductFormCart() {
		removeProductFromTheCart.click();
		yesButtonRemoveCart.click();
		return yourCartEmptyMessage.getText();
	}
	@Step("Search for the product and validate text it is showing expected results or not")
	public String searchForSepecificProductAndValidateThat(String productValue) throws InterruptedException {
		addProductMultipleTime(productValue);
		return productNameInYourCart.getText();
	}
	@Step("Select the multiple veriants of the product ")
	public void multipleVeriantOfTheProduct(String productValue,String selectionOfProductsFromListMultipleProduct,String veriantValues) {
		searchForProduct.click();
		inputForSearch.sendKeys(productValue);
		searchButtonAfterProductEnter.click();
		j.executeScript("arguments[0].scrollIntoView({block: 'end', inline: 'nearest'});",resultsAfterSearch);
		UtilClass.listOfWebElementMethodToGetAttributesWithoutActions(productListToClick, "Plain Steel Singles");
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",scrollUptoSelectAnItems);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",veriantList);
		for (WebElement element : veriantTitle) {
			if (element.getText().equalsIgnoreCase(veriantValues)) {
				wait.until(ExpectedConditions.visibilityOf(element));
				j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",element);
				j.executeScript("arguments[0].click();", element);
				System.out.println("if block");
				break;
			}
		}
		
	}
	@Step("Click on add cart and check for the expected/selected product is added into the cart")
	public String cartValues() throws InterruptedException {
	    addToCart.click();
	    builder.moveToElement(addToCart).click(addToCart).build().perform();
	    goToCart.click();
	    Thread.sleep(2000);
	    for(WebElement element : cartItemsList) {
	    	String title = element.getAttribute("title");
	    	if(title.equalsIgnoreCase("D'ADDARIO PL009-5 PLAIN STEEL GUITAR SINGLE STRING, .009, 5-PACK")) {
	    		System.out.println("If block");
	    		productName=element.getText();
	    		return productName;
	    	}
	    }
//	    for (WebElement element : cartItemsList) {
//	        String title = element.getAttribute("title");
//	        System.out.println("Element Title: " + title); // Add this line for debugging
//	        
//	        if (title != null && title.contains("Abc")) {
//	            System.out.println("if block" + "|||||||||||||||||||||||||||||||||");
//	            productName = element.getText();
//	            System.out.println(productName + "==================");
//	            return productName;
//	        }
//	        
//	
//	    } 
//	    
//	    return null;
//	
		return null;
	}



	public void addProductMultipleTime(String productValue) throws InterruptedException {
		searchForProduct.click();
		inputForSearch.sendKeys(productValue);
		searchButtonAfterProductEnter.click();
		j.executeScript("arguments[0].scrollIntoView({block: 'end', inline: 'nearest'});",resultsAfterSearch);
		Thread.sleep(2000);
		UtilClass.listOfWebElementMethodToGetAttributesWithoutActions(productListToClick, "10-46 Regular Light, XL Nickel Electric Guitar Strings");
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",packSizeText);
		boolean foundOutOfStockOption = false;

		for (WebElement element : packSizeOptions) {
		    if (element.getText().contains("1") && outOfStockMessage.getText().contains("We’re temporarily out of stock. Please check your favorite local or online retailer to purchase.")) {
		        foundOutOfStockOption = true;
		        continue; // Skip the "1" option if it's out of stock
		    }

		    // If the element is not out of stock or not "1", click it
		    JavascriptExecutor j = (JavascriptExecutor) driver;
		    j.executeScript("arguments[0].click();", element);
		    try {
		        wait.until(ExpectedConditions.elementToBeClickable(addIntoCart)).click();
		        break; // Exit the loop after clicking "addIntoCart"
		    } catch (TimeoutException e) {
		        
		    }
		}
		if (!foundOutOfStockOption) {
		    
		}
		goToCart.click();
	}
	@Step("Delete product after the add into the cart if cart is not open")
	public void deleteProductfromCartFinally() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(cartLogoClcik)).click();
		wait.until(ExpectedConditions.visibilityOf(goToCart)).click();
		removeProductFromTheCart.click();
		yesButtonRemoveCart.click();
	}
	@Step("Delete product after the add into the cart if cart is already open")
	public void deleteIfCartAlreadyOpen() {
		wait.until(ExpectedConditions.visibilityOf(goToCart)).click();
		removeProductFromTheCart.click();
		yesButtonRemoveCart.click();
	}
}
