package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class HomePage(driver: WebDriver?) : BasePage(driver) {

    @FindBy(css = "[name='userName']")
    private val username: WebElement? = null

    @FindBy(css = "[name='password']")
    private val password: WebElement? = null

    @FindBy(css = "[name='submit']")
    private val submitBtn: WebElement? = null

    @FindBy(css = "table h3")
    private val h3: WebElement? = null

    fun login(user: String, pwd: String) {
        type(username!!, user)
        type(password!!, pwd)
        click(submitBtn!!)
    }

    fun getH3Message(): String {
        wait!!.until(ExpectedConditions.visibilityOf(h3))
        return h3!!.text
    }

}