package addToCart;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestAddProductToCart {
    public  static  void main ( String [] args){
        Playwright playwright = Playwright.create();
        Browser browser=  playwright.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://askomdch.com/");
        Locator  productImage  =  page.locator(".products a.woocommerce-LoopProduct-link");
        productImage.first().click();
        page.pause();
        Locator addToCartBtn = page.locator(".single_add_to_cart_button.button.alt");
        addToCartBtn.click();

        Locator succefullyAddingMessage = page.locator(".woocommerce-message");
        assertThat(succefullyAddingMessage).isVisible();
        browser.close();
        playwright.close();

    }
}
