package websitebase;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTests extends BaseTest{

    private String email = "amr@baianat.com";
    private String password = "123456789a";

    @Test(testName = "Login successfully and add products to WishList")
    public void testAddToWishList(){
        var loginPage = homePage.clickLoginBtn();
        loginPage.enterLoginCredential(email, password);
        loginPage.clickLoginButton();
        homePage.addToWishList();
        var wishListPage = homePage.clickWishListBtn();
        assertEquals(wishListPage.getProductName(),"Cheap product ", "Product wasn't added to the wishlist");

    }
}
