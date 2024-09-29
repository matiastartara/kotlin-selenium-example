import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

abstract class BaseTest {

    protected var driver: WebDriver? = null;

    @BeforeMethod
    fun beforeMethod() {
        val chromeOptions = ChromeOptions()
        chromeOptions.addArguments("--start-maximized")
        chromeOptions.addArguments("--lang=es")
        chromeOptions.addArguments("--remote-allow-origins=*")
        driver = ChromeDriver(chromeOptions)
        driver!!.get(UtilResources.getProperties("pageURL"))
    }

    @AfterMethod
    fun afterMethod() {
        driver!!.quit()
    }

}