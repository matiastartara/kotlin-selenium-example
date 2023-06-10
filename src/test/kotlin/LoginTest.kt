import org.testng.Assert
import org.testng.annotations.Test
import pages.HomePage


class LoginTest : BaseTest() {

    @Test
    fun checkValidUserTest() {
        var home = HomePage(driver)
        home.login("admin", "admin")
        Assert.assertEquals(home.getH3Message(), "Login Successfully")
        Assert.assertTrue(driver!!.currentUrl.contains("login_sucess"))
    }

    @Test
    fun checkInvalidUserTest() {
        var home = HomePage(driver)
        home.login("test", "admin123")
        Assert.assertFalse(driver!!.currentUrl.contains("login_sucess"))
    }

}