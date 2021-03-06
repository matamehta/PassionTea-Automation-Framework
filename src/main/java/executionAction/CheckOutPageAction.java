package executionAction;

import config._Constants;
import objectRepo.CheckOutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.DriverFactory;
import utility.EyesFactory;

/**
 * Created by zhangd on 4/04/2016.
 */
public class CheckOutPageAction {
    CheckOutPage cop = new CheckOutPage();
    WebDriver driver = DriverFactory.getCurrentDriver();

    /**
     * Constructor
     * Load the page, initiate page elements and clean files in the directory
     */
    public CheckOutPageAction() {
        DriverFactory.loadPage(_Constants.CheckOutPageURL, _Constants.CheckOutPageTitle);
        PageFactory.initElements(driver, cop);
    }

    /**
     * Fill in the customer form
     *
     * @param email
     * @param name
     * @param address
     */
    public void fillCustomerInfo(String email, String name, String address) {
        cop.txtEmail.sendKeys(email);
        cop.txtName.sendKeys(name);
        cop.txtAddress.sendKeys(address);
    }

    /**
     * Fill in the payment form
     *
     * @param cardType
     * @param cardNo
     * @param cardholderName
     * @param verificationCode
     */
    public void fillPaymentInfo(String cardType, String cardNo, String cardholderName, String verificationCode) {
        cop.selectCard.sendKeys(cardType);
        cop.txtCardNo.sendKeys(cardNo);
        cop.txtCardHolderName.sendKeys(cardholderName);
        cop.txtVerificationCode.sendKeys(verificationCode);
        cop.btnPlaceOrder.click();
    }

    /**
     * Visual Validation Tests
     */
    public void eyesTest() {
        EyesFactory.visualValidation("PassionTea - Checkout", 1920, 1080, _Constants.CheckOutPageTitle);
    }
}
