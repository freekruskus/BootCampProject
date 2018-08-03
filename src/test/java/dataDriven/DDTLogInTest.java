package dataDriven;

import chapterSix.TestShopScenario;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.AccountPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DDTLogInTest extends TestShopScenario{

    @Parameters({"email", "password", "wishListName", "expectedResult"})
    @Test
    public void logInAndAddWishList(String email, String password, String wishListName, String expectedResult){

        LogInPage myLoginPage = new LogInPage(driver);
        myLoginPage.LogIn(email, password);
        assertThat(myLoginPage.checkLogInHeaderName()).isEqualTo(expectedResult);

        AccountPage myAccountPage = new AccountPage(driver);
        myAccountPage.createWishList(wishListName);
        assertThat(myAccountPage.checkWishList()).isEqualTo(wishListName);


    }
}
