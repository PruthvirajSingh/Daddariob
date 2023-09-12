package Pkg.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pkg.BaseClass.BaseClass;

public class AddProductIntoCart extends BaseClass{
	@Test(description="Verify whether the user can add the product to the cart and proceed to checkout using PayPal.",groups = {"Smoke","Regression"})
	public void productCartTC001() throws InterruptedException {
		String value=login.SignInWithEmailAddressValidate();
		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
		login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
		String yourCartHeader=loginCartAdd.prodcutAddIntoTheCart(jsonArrayValue("createNewAccountData","primaryInstrument"));
		Assert.assertEquals(yourCartHeader,jsonArrayValue("Assertions","yourCartValue"));
		loginCartAdd.methodProceedToCheckOut(jsonArrayValue("createNewAccountData","firstName"),jsonArrayValue("createNewAccountData","lastName"),jsonArrayValue("createNewAccountData","shoppingAddress"),jsonArrayValue("createNewAccountData","cityNameValue"),jsonArrayValue("createNewAccountData","zipCode"),jsonArrayValue("createNewAccountData","phoneNumberValue"));
		String thankYouForOrderMessage=loginCartAdd.payamentForPayPal(prop.getProperty("PayPalEamilId"),prop.getProperty("PayPalPassword"));
		Assert.assertEquals(thankYouForOrderMessage,jsonArrayValue("Assertions","orderConformMessage"));
		
	 }

	@Test(description="Verify that the user is able to see the product on the 'YOUR CART' page after adding it to the cart",groups = {"Regression"})
	public void yourCartProductTC002() throws InterruptedException {
		String value=login.SignInWithEmailAddressValidate();
		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
		login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
		String yourCartHeader=loginCartAdd.prodcutAddIntoTheCart(jsonArrayValue("createNewAccountData","primaryInstrument"));
		Assert.assertEquals(yourCartHeader,jsonArrayValue("Assertions","yourCartValue"));
		loginCartAdd.deleteProductfromCartFinally();
	}

	@Test(description="Verify that the user is able to fill in the mandatory information for the payment process",groups = {"Regression"})
	public void paymentDetailsTC003() throws InterruptedException {
		String value=login.SignInWithEmailAddressValidate();
		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
		login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
		String yourCartHeader=loginCartAdd.prodcutAddIntoTheCart(jsonArrayValue("createNewAccountData","primaryInstrument"));
		Assert.assertEquals(yourCartHeader,jsonArrayValue("Assertions","yourCartValue"));
		loginCartAdd.methodProceedToCheckOut(jsonArrayValue("createNewAccountData","firstName"),jsonArrayValue("createNewAccountData","lastName"),jsonArrayValue("createNewAccountData","shoppingAddress"),jsonArrayValue("createNewAccountData","cityNameValue"),jsonArrayValue("createNewAccountData","zipCode"),jsonArrayValue("createNewAccountData","phoneNumberValue"));
		loginCartAdd.deleteProductBackToParentWindows();
		loginCartAdd.deleteProductfromCartFinally();
	}
	@Test(description="Verify that the user is able to add the product to the cart by using the 'Add to Cart' button.",groups = {"Regression"})
	public void addToCartLogo() throws InterruptedException {
		String value=login.SignInWithEmailAddressValidate();
		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
		login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
		String cartValue=loginCartAdd.addproductByLogo(jsonArrayValue("createNewAccountData","addToCartProductByCartLogo"));
		Assert.assertEquals(cartValue,jsonArrayValue("Assertions","addToCartProductByCartLogo"));
		loginCartAdd.deleteIfCartAlreadyOpen();
	}
	@Test(description="Verify that the user should be able to change/update the product quantity from the 'YOUR CART'.",groups = {"Regression"})
	public void updateQuatity() throws InterruptedException {
		String value=login.SignInWithEmailAddressValidate();
		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
		login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
		String cartValue=loginCartAdd.addproductByLogo(jsonArrayValue("createNewAccountData","addToCartProductByCartLogo"));
		Assert.assertEquals(cartValue,jsonArrayValue("Assertions","addToCartProductByCartLogo"));
		String updatedValue=loginCartAdd.updateProductQuatity(jsonArrayValue("createNewAccountData","productQantityToUpdate"));
		String changeStringValue=loginCartAdd.finalUpdatedPriceAfterCalcultions();
		System.out.println(changeStringValue);
		boolean containsText = changeStringValue.contains(updatedValue);
		Assert.assertTrue(containsText, "The main string does not contain the expected text: " + updatedValue);
		loginCartAdd.deleteProductfromCartFinally();
      }
	@Test(description="Verify that the user should be able to delete the product from the cart.",groups = {"Regression"})
	public void deleteProductFromTheCart() {
		String value=login.SignInWithEmailAddressValidate();
		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
		login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
		String cartValue=loginCartAdd.addproductByLogo(jsonArrayValue("createNewAccountData","addToCartProductByCartLogo"));
		Assert.assertEquals(cartValue,jsonArrayValue("Assertions","addToCartProductByCartLogo"));
		String updatedValue=loginCartAdd.updateProductQuatity(jsonArrayValue("createNewAccountData","productQantityToUpdate"));
		String changeStringValue=loginCartAdd.finalUpdatedPriceAfterCalcultions();
		System.out.println(changeStringValue);
		boolean containsText = changeStringValue.contains(updatedValue);
		Assert.assertTrue(containsText, "The main string does not contain the expected text: " + updatedValue);
		String deleteMessage=loginCartAdd.delProductFormCart();
		Assert.assertEquals(deleteMessage,jsonArrayValue("Assertions","cartEmptyMessage"));
	}
	@Test(description="Verify that the user should be able to add the product with the 'Select a Pack Size' option, and if the product is 'out of stock,' then the user should be able to select another pack size",groups = {"Regression"})
	public void productWithPackSize() throws InterruptedException {
		String value=login.SignInWithEmailAddressValidate();
		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
		login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
		String productName=loginCartAdd.searchForSepecificProductAndValidateThat(jsonArrayValue("createNewAccountData","packSizeProduct"));
		loginCartAdd.deleteProductfromCartFinally();
		Assert.assertEquals(productName,jsonArrayValue("Assertions","productAssertionsOfVeriants"));
		
	}
	@Test(description="Verify that the user should be able to select multiple variants of the product and add them to the cart.",groups = {"Regression"})
	public void multipleVeriantsOfTheProduct() throws InterruptedException {
		String value=login.SignInWithEmailAddressValidate();
		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
		login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
		loginCartAdd.multipleVeriantOfTheProduct(jsonArrayValue("createNewAccountData","multipleVeriantTypeProductSearch"),jsonArrayValue("createNewAccountData","typeOfProduct"),jsonArrayValue("createNewAccountData","VeriantType"));
		String cartItemValue=loginCartAdd.cartValues();
		Assert.assertEquals(cartItemValue,jsonArrayValue("Assertions","addedProductIntoCartAfterVeriantSelections"));
		loginCartAdd.deleteProductfromCartFinally();
		loginCartAdd.deleteProductfromCartFinally();
	}
//	@Test(description="Verify that when the user clicks on the 'Add to cart' button, the product quantity will increase as a result of clicking the cart button.",groups = {"Regression"})
//	public void addToCartProductQuatityIncress() {
//		String value=login.SignInWithEmailAddressValidate();
//		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
//		login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
//
//		
//	}
}
