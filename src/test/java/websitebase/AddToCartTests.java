package websitebase;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertEquals;

@Epic("Catcher Website")
@Feature("Add Items to The Cart")
@Story("Add an item form products section to Cart and continue to the Cart page")
@Listeners(TestngListener.class)
public class AddToCartTests extends BaseTest {
    public String productName = "ما فاي تي بي لينك M7200";

    @Test(description = "Validate adding an item to the cart")
    @Description("Choosing an item from the Home page and adding it to the cart, checking if the item is present in the cart")
    public void addingItemToCart() {
        var title = homePage.gotoProductsPage().clickSelectedProduct(productName)
                .addItemToCart().goToCart().getProductName();
        assertEquals(title, productName, "Something went wrong");
    }
}
