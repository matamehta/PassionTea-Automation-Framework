package executionAction;

import config._Constants;
import objectRepo.MenuPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.BrowserDriver;
import utility.PublicFunctions;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangd on 4/04/2016.
 */
public class MenuPageAction {
    MenuPage mp = new MenuPage();
    WebDriver driver = BrowserDriver.getCurrentDriver();

    /**
     * Constructor
     * Load the page, initiate page elements and clean files in the directory
     */
    public MenuPageAction() {
        BrowserDriver.loadPage(_Constants.MenuPageURL, _Constants.MenuPageTitle);
        PageFactory.initElements(driver, mp);

        // Clean previous files in the directory
        try {
            FileUtils.cleanDirectory(new File(_Constants.MenuPageScreenshot));
            PublicFunctions.captureScreenShot(driver, _Constants.MenuPageScreenshot, "TestCase003");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Capture Menu Page's logo
     */
    public void captureMenuPageLogo() {
        PublicFunctions.captureLogo(driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[20]/div/div/img")), _Constants.MenuPageScreenshot);
        PublicFunctions.captureLogo(driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[28]/div/div/img")), _Constants.MenuPageScreenshot);
        PublicFunctions.captureLogo(driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[24]/div/div/img")), _Constants.MenuPageScreenshot);
    }

    /**
     * Check out one type of tea
     * @param teaType
     */
    public void clickCheckOut(String teaType) {
        switch (teaType) {
            case "Green Tea":
                mp.btnCheckOutGreenTea.click();
                break;
            case "Red Tea":
                mp.btnCheckOutRedTea.click();
                break;
            case "Oolong Tea":
                mp.btnCheckOutOolongTea.click();
                break;
        }
    }
}
