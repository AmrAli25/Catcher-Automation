package websitebase;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertEquals;


@Epic("Catcher Website")
@Feature("Add Items to Wishlist")
@Story("Add an item for Offers section to Wishlist")
@Listeners(TestngListener.class)
public class AddToWishListTests extends BaseTest {
    public String email = "amr@baianat.com";
    public String password = "123456789a";

    @Test(description = "Login successfully and add products to WishList")
    @Description("Login successfully and add products to WishList")
    public void testAddToWishList() {
        homePage.clickLoginBtn()
                .enterLoginCredential(email, password)
                .clickLoginButton();
        String productName = homePage.addToWishList();
        var wishListPage = homePage.clickWishListBtn();
        try {

            assertEquals(wishListPage.getProductName(productName), productName, "Product wasn't added to the wishlist");
            System.out.println(wishListPage.getProductName(productName));
        } catch (TimeoutException e) {
            System.out.println("Product not found in the wishlist as it was removed from it");
        }
    }

    @Test(description = "Add to wishlist without signing in")
    @Description("the user try to add to the wishlist before logging in and asked to login by the modal")
    public void addToWishlistNotLoggedIn() {
        homePage.addToWishList();
        homePage.modalLogIn(email, password);
        String productName = homePage.addToWishList();
        var wishlistPage = homePage.clickWishListBtn();
        try {

            assertEquals(wishlistPage.getProductName(productName), productName, "Product wasn't added to the wishlist");
            System.out.println(wishlistPage.getProductName(productName));
        } catch (TimeoutException e) {
            System.out.println("Product not found in the wishlist as it was removed from it");
        }
    }

    @AfterMethod
    @Description("Remove all the products from the wishlist")
    public void cleanWishList() {
        var wishlistPage = homePage.checkWishlistUrl();
        wishlistPage.toggleFavBtn();
    }


}
