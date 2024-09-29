package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

abstract class BasePage {

    private var driver: WebDriver? = null
    protected var wait: WebDriverWait? = null

    constructor(driver: WebDriver?) {
        PageFactory.initElements(driver, this)
        this.driver = driver
        wait = WebDriverWait(this.driver, Duration.ofSeconds(40))
    }

    fun click(element: WebElement) {
        wait!!.until(ExpectedConditions.visibilityOf(element))
        element.click()
    }

    fun type(element: WebElement, text: String) {
        wait!!.until(ExpectedConditions.visibilityOf(element))
        element.sendKeys(text)
    }

}