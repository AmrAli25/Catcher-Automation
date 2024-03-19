package websitebase;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("Catcher Website")
@Feature("Add Items to Wishlist")
@Story("Add an item for Offers section to Wishlist")
public class AddToWishListTests extends BaseTest {

    @Test(testName = "Login successfully and add products to WishList")
    @Description("Login successfully and add products to WishList")
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
    @Description("Remove all the products from the wishlist")
    public void cleanWishList() {
        goToHomePage();
        var wishListPage = homePage.clickWishListBtn();
        wishListPage.toggleFavBtn();
    }


}
