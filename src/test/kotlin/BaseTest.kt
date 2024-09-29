import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeMethod
import utils.Driver

abstract class BaseTest {

    var driver = Driver.getDriver(headless = true)

    @BeforeMethod
    fun beforeMethod() {
        driver.get(UtilResources.getProperties("pageURL"))
    }

    @AfterSuite
    fun afterMethod() {
        Driver.quitDriver();
    }

}