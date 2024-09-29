package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.concurrent.ConcurrentHashMap

object Driver {

    private val drivers: ConcurrentHashMap<Long, WebDriver> = ConcurrentHashMap()

    @Synchronized
    fun getDriver(headless: Boolean = false): WebDriver {
        val threadId = Thread.currentThread().id
        return drivers.computeIfAbsent(threadId) {
            val options = ChromeOptions().apply {
                if (headless) {
                    addArguments("--headless")
                    addArguments("--no-sandbox")
                    addArguments("--disable-dev-shm-usage")
                }
                addArguments("--start-maximized")
                addArguments("--lang=es")
                addArguments("--remote-allow-origins=*")
            }

            ChromeDriver(options)
        }
    }

    @Synchronized
    fun quitDriver() {
        val threadId = Thread.currentThread().id
        drivers[threadId]?.quit()
        drivers.remove(threadId)
    }
}
