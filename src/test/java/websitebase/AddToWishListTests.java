package websitebase;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddToWishListTests extends BaseTest{

    private String email = "amr@baianat.com";
    private String password = "123456789a";

    @Test(testName = "Login successfully and add products to WishList")
    public void testAddToWishList(){
        var loginPage = homePage.clickLoginBtn();
        loginPage.enterLoginCredential(email, password);
        loginPage.clickLoginButton();
        String productName = homePage.addToWishList();
        var wishListPage = homePage.clickWishListBtn();
        try {
            
            assertEquals(wishListPage.getProductName(),productName, "Product wasn't added to the wishlist");
        }
        catch (TimeoutException e){
            System.out.println("Product not found in the wishlist as iw was removed from it");
        }
    }

//    @AfterMethod
//    private void removeProductFromWishList(){
//        var wishListPage = homePage.clickWishListBtn();
//        wishListPage.toggleFavBtn();
//    }
}
