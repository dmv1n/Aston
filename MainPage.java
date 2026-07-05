package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private final By selectHeader = By.className("select__header");
    private final By serviceTab = By.xpath("//p[@class='select__option' and text()='Услуги связи']");
    private final By internetTab = By.xpath("//p[@class='select__option' and text()='Домашний интернет']");
    private final By installmentTab = By.xpath("//p[@class='select__option' and text()='Рассрочка']");
    private final By debtTab = By.xpath("//p[@class='select__option' and text()='Задолженность']");

    private final By phoneInput = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By internetAccountInput = By.id("internet-sum");
    private final By installmentAccountInput = By.id("score-instalment");
    private final By debtAccountInput = By.id("score-arrears");

    private final By titleBlock = By.xpath("//h2[contains(.,'Онлайн пополнение')]");
    private final By continueButton = By.xpath("//button[contains(text(),'Продолжить')]");
    private final By detailsLink = By.linkText("Подробнее о сервисе");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleBlock)).isDisplayed();
    }

    public void selectTab(String tabName) {
        wait.until(ExpectedConditions.elementToBeClickable(selectHeader)).click();
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

        By tabLocator;
        switch (tabName.toLowerCase()) {
            case "услуги связи": tabLocator = serviceTab; break;
            case "домашний интернет": tabLocator = internetTab; break;
            case "рассрочка": tabLocator = installmentTab; break;
            case "задолженность": tabLocator = debtTab; break;
            default: throw new IllegalArgumentException("Неизвестная вкладка: " + tabName);
        }
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(tabLocator));
        try { option.click(); } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
        }
    }

    public void enterPhoneNumber(String phone) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        input.clear();
        input.sendKeys(phone);
    }

    public void enterSum(String sum) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(sumInput));
        input.clear();
        input.sendKeys(sum);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public String getPhonePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).getAttribute("placeholder");
    }

    public String getInternetPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(internetAccountInput)).getAttribute("placeholder");
    }

    public String getInstallmentPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentAccountInput)).getAttribute("placeholder");
    }

    public String getDebtPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(debtAccountInput)).getAttribute("placeholder");
    }

    public void clickDetailsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(detailsLink)).click();
    }

    public boolean isDetailsPageOpened() {
        return wait.until(ExpectedConditions.urlContains("help"));
    }

    public boolean areLogosDisplayed() {
        String[] logoAlt = {"Visa", "MasterCard", "Белкарт"};
        for (String alt : logoAlt) {
            try {
                WebElement logo = driver.findElement(By.xpath("//img[@alt='" + alt + "']"));
                if (!logo.isDisplayed()) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}