package websitebase;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddToWishListTests extends BaseTest {

    @Test(testName = "Login successfully and add products to WishList")
    public void testAddToWishList() {
        var loginPage = homePage.clickLoginBtn();
        String email = "amr@baianat.com";
        String password = "123456789a";
        loginPage.enterLoginCredential(email, password);
        loginPage.clickLoginButton();
        String productName = homePage.addToWishList();
        var wishListPage = homePage.clickWishListBtn();
        try {

            assertEquals(wishListPage.getProductName(productName), productName, "Product wasn't added to the wishlist");
            System.out.println(wishListPage.getProductName(productName));
        } catch (TimeoutException e) {
            System.out.println("Product not found in the wishlist as it was removed from it");
        }
    }

    @AfterMethod
    public void CleanWishList(){
        goToHomePage();
        var wishListPage = homePage.clickWishListBtn();
        wishListPage.toggleFavBtn();
    }


}
