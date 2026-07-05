import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsOnlinePaymentTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.mts.by");
        closeCookieBanner();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void closeCookieBanner() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Принять')]")
            ));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Куки-баннер не найден");
        }
    }

    @Test
    void testBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(.,'Онлайн пополнение')]")
        ));
        assertTrue(title.isDisplayed(), "Заголовок не отображается");
    }

    @Test
    void testPaymentSystemLogos() {
        String[] logoAlt = {"Visa", "MasterCard", "Белкарт"};
        for (String alt : logoAlt) {
            WebElement logo = driver.findElement(By.xpath("//img[@alt='" + alt + "']"));
            assertTrue(logo.isDisplayed(), "Логотип " + alt + " не отображается");
        }
    }

    @Test
    void testDetailsLink() {
        WebElement detailsLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        detailsLink.click();
        wait.until(ExpectedConditions.urlContains("help"));
        assertTrue(driver.getCurrentUrl().contains("help"), "Ссылка не ведёт на страницу помощи");
    }

    @Test
    void testContinueButtonForCommunicationService() {
        WebElement serviceTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Услуги связи')]")
        ));
        serviceTab.click();

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("connection-phone")
        ));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Продолжить')]")
        ));
        continueBtn.click();

        WebElement sumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("connection-sum")
        ));
        assertTrue(sumInput.isDisplayed(), "Поле для суммы не появилось");
    }
}