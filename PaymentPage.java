package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage {

    // Локаторы для label'ов (надписей) полей карты
    private final By cardNumberLabel = By.xpath("//label[text()='Номер карты']");
    private final By cardExpiryLabel = By.xpath("//label[text()='Срок действия']");
    private final By cardCvcLabel = By.xpath("//label[text()='CVC']");
    private final By cardHolderLabel = By.xpath("//label[text()='Имя и фамилия на карте']");

    // Иконки платёжных систем
    private final By visaIcon = By.xpath("//img[contains(@src,'visa-system.svg')]");
    private final By mastercardIcon = By.xpath("//img[contains(@src,'mastercard-system.svg')]");
    private final By belkartIcon = By.xpath("//img[contains(@src,'belkart-system.svg')]");
    private final By maestroIcon = By.xpath("//img[contains(@src,'maestro-system.svg')]");

    // Кнопка оплаты
    private final By payButton = By.xpath("//button[@type='submit']//span[contains(text(),'Оплатить')]");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    // Проверка видимости всех надписей
    public boolean areCardLabelsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel)).isDisplayed()
                && wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryLabel)).isDisplayed()
                && wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvcLabel)).isDisplayed()
                && wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderLabel)).isDisplayed();
    }

    // Проверка иконок
    public boolean arePaymentIconsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(visaIcon)).isDisplayed()
                && wait.until(ExpectedConditions.visibilityOfElementLocated(mastercardIcon)).isDisplayed()
                && wait.until(ExpectedConditions.visibilityOfElementLocated(belkartIcon)).isDisplayed()
                && wait.until(ExpectedConditions.visibilityOfElementLocated(maestroIcon)).isDisplayed();
    }

    // Проверка кнопки оплаты
    public boolean isPayButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payButton)).isDisplayed();
    }

    // Проверка текста на кнопке
    public boolean doesPayButtonContainText() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(payButton)).getText();
        return text.contains("Оплатить");
    }
}