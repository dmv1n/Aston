package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.PaymentPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsPageObjectTest {

    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.mts.by");

        mainPage = new MainPage(driver);
        paymentPage = new PaymentPage(driver);

        try {
            driver.findElement(By.xpath("//button[contains(text(),'Принять')]")).click();
        } catch (Exception e) {
            // Баннера нет
        }
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testBlockTitle() {
        assertTrue(mainPage.isTitleDisplayed(), "Заголовок не отображается");
    }

    @Test
    void testPaymentSystemLogos() {
        assertTrue(mainPage.areLogosDisplayed(), "Логотипы не отображаются");
    }

    @Test
    void testDetailsLink() {
        mainPage.clickDetailsLink();
        assertTrue(mainPage.isDetailsPageOpened(), "Ссылка не ведёт на страницу помощи");
    }

    @Test
    void testPlaceholdersForAllTabs() {
        mainPage.selectTab("услуги связи");
        String phonePlaceholder = mainPage.getPhonePlaceholder();
        assertEquals("Номер телефона", phonePlaceholder, "Плейсхолдер для услуги связи неверный");

        mainPage.selectTab("домашний интернет");
        String internetPlaceholder = mainPage.getInternetPlaceholder();
        assertEquals("Сумма", internetPlaceholder, "Плейсхолдер для домашнего интернета неверный");

        mainPage.selectTab("рассрочка");
        String installmentPlaceholder = mainPage.getInstallmentPlaceholder();
        assertEquals("Номер счета на 44", installmentPlaceholder, "Плейсхолдер для рассрочки неверный");

        mainPage.selectTab("задолженность");
        String debtPlaceholder = mainPage.getDebtPlaceholder();
        assertEquals("Номер счета на 2073", debtPlaceholder, "Плейсхолдер для задолженности неверный");
    }

    @Test
    void testPaymentPageAfterContinue() {
        // 1. Выбираем услугу, вводим номер и сумму
        mainPage.selectTab("услуги связи");
        mainPage.enterPhoneNumber("297777777");
        mainPage.enterSum("100");

        // 2. Нажимаем "Продолжить"
        mainPage.clickContinue();

        // 3. Переключаемся на iframe с формой оплаты
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.className("payment-widget-iframe")
        ));
        driver.switchTo().frame(iframe);

        // 4. Проверяем наличие надписей полей карты
        assertTrue(paymentPage.areCardLabelsDisplayed(), "Надписи полей карты не отображаются");

        // 5. Проверяем кнопку оплаты
        assertTrue(paymentPage.isPayButtonDisplayed(), "Кнопка оплаты не отображается");
        assertTrue(paymentPage.doesPayButtonContainText(), "На кнопке нет текста 'Оплатить'");

        // 6. Проверяем иконки платёжных систем
        assertTrue(paymentPage.arePaymentIconsDisplayed(), "Иконки платёжных систем не отображаются");
    }
}