package appium.test;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpEnums {

    USERNAME_TEXTBOX(By.xpath("//android.widget.EditText[@resource-id='emailId']"), "UserName Textbox"),

    PASSWORD_TEXTBOX(By.xpath("//android.widget.EditText[@resource-id='passwordId']"), "Password Textbox"),

    PASSWORD_EYE_BUTTON(By.xpath("//android.view.ViewGroup[@resource-id='eye-button-PASSWORD']"), "Password Eye Button"),

    SIGNIN(By.xpath("//android.view.ViewGroup[@resource-id='loginButton']"), "Sign In button"),

    HOME_TITLE_LINK(By.xpath("//android.widget.TextView[@resource-id='homeTitle']"), "Right Now Link"),

    WELCOME_SCREEN_STATUS(By.xpath("//android.widget.TextView[@resource-id='welcomeStatus']"), "Welcome Screen Status"),

    ANALYZE_MENU(By.xpath("//android.view.View[@resource-id='navigateAnalyze']"), "Analyze Menu"),

    PANELS_MENU(By.xpath("//android.view.View[@resource-id='navigatePanels']"), "Panels Menu"),

    TOGGLE_BUTTON(By.xpath("//android.view.ViewGroup[@resource-id='TOGGLER_BUTTON_ID']"),
            "Toggle button"),

    POWER_AT_VALUE(By.xpath("//android.widget.TextView[@resource-id='AT']"), "Power section at value"),

    TOTAL_POWER_VALUE(By.xpath("//android.widget.TextView[@resource-id='Total Power ']"), "Total power value"),

    POWER_TIMELAPSE_BOX(By.xpath("(//android.widget.TextView[@resource-id='Total Power ']/.."
            + "/following-sibling::android.view.ViewGroup)[3]"), "power timelapse box"),

    AGGREGATE_SELECTION("//XCUIElementTypeOther[@name=\"intervalSelection-%s\"]", "Home page loading icon"),

    GRAPH_BOX(By.xpath("(//android.widget.TextView[@content-desc='Solar Production']/../../following-sibling::android.view.ViewGroup)[1]"), "Graph box in analyze page");

    private By by;

    private String description;

    private String xpath;

    /**
     * Constructor that accepts By locator and description String
     * @param by
     * @param description
     */
    private SpEnums(By by, String description) {
        this.by = by;
        this.description = description;
    }

    /**
     * Constructor that accepts String xpath and String description
     * @param xpath
     * @param description
     */
    private SpEnums(String xpath, String description) {
        this.xpath = xpath;
        this.description = description;
    }
    public By getBy() {
        return this.by;
    }
}
