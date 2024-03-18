package appium.test;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AnalyzeGraphDataEnumAndroid {


    GRAPH_BOX_FOR_DAY(By.xpath("(//android.widget.TextView[@content-desc='Solar Production']/../../"
            + "following-sibling::android.view.ViewGroup)[2]"), "Graph box for day in analyze page"),

    GRAPH_BOX(By.xpath("(//android.widget.TextView[@content-desc='Solar Production']/../../"
            + "following-sibling::android.view.ViewGroup)[1]"), "Graph box in analyze page"),

    TOOLTIP_PERIOD(By.xpath("//android.widget.TextView[@text='Solar Produced']"
            + "/preceding-sibling::android.widget.TextView[1]"), "Tool tip period"),

    PRODUCTION_SITE_TOOLTIP_PERIOD(By.xpath("(//android.widget.TextView[contains(@text,'Solar Production')]"
            + "/preceding-sibling::android.widget.TextView)[2]"), "production site tool tip period"),

    PRODUCTION_SITE_LABEL(By.xpath("//android.widget.TextView[contains(@text,'Solar Production')]"),
            "production site label"),

    PRODUCTION_SITE_VALUE(By.xpath("(//android.widget.TextView[contains(@text,'Solar Production')]"
            + "/preceding-sibling::android.widget.TextView)[1]"), "production site value "),

    SOLAR_PRODUCED_LABEL(By.xpath("//android.widget.TextView[@text='Solar Produced']"), "Solar tooltip"),

    SOLAR_PRODUCED_VALUE(By.xpath("(//android.widget.TextView[@text='Solar Produced']"
            + "/following-sibling::android.widget.TextView)[1]"), "Solar tool tip value "),

    HOME_USAGE_LABEL(By.xpath("//android.widget.TextView[@text='Home Usage']"), "Home Usage tooltip label"),

    HOME_USAGE_VALUE(By.xpath("(//android.widget.TextView[@text='Home Usage']"
            + "/following-sibling::android.widget.TextView)[1]"), "Home Usage tooltip value"),

    EXPORTED_TO_GRID_LABEL(By.xpath("//android.widget.TextView[@text='Exported to Grid']"), "Exported to grid label"),

    EXPORTED_TO_GRID_VALUE(By.xpath("(//android.widget.TextView[@text='Exported to Grid']"
            + "/following-sibling::android.widget.TextView)[1]"), "Exported to grid value"),

    IMPORTED_FROM_GRID_LABEL(By.xpath("//android.widget.TextView[@text='Imported from Grid']"),
            "Imported from grid label"),

    IMPORTED_FROM_GRID_VALUE(By.xpath("(//android.widget.TextView[@text='Imported from Grid']"
            + "/following-sibling::android.widget.TextView)[1]"), "Imported from grid value"),

    BATTERY_DISCHARGED_LABEL(By.xpath("//android.widget.TextView[@text='Battery Discharged']"),
            "Battery discharged label"),

    BATTERY_DISCHARGED_VALUE(By.xpath("(//android.widget.TextView[@text='Battery Discharged']"
            + "/following-sibling::android.widget.TextView)[1]"), "Battery Discharged value"),

    BATTERY_CHARGED_LABEL(By.xpath("//android.widget.TextView[@text='Battery Charged']"), "Battery charged label"),

    BATTERY_CHARGED_VALUE(By.xpath("(//android.widget.TextView[@text='Battery Charged']"
            + "/following-sibling::android.widget.TextView)[1]"), "Battery charged value"),

    POPUP_CLOSE_BUTTON(By.xpath("//android.view.ViewGroup[@resource-id='']"), "close button for alert popup");

    private By by;
    private String xpath;
    private String description;

    /**
     * Constructor to accept By Locator and description
     * @param by By locator of the element
     * @param description description of the element
     */
    private AnalyzeGraphDataEnumAndroid(By by, String description) {
        this.by = by;
        this.description = description;
    }

    /**
     * Constructor to accept String xpath and description
     * @param xpath xpath of element
     * @param description description of the element
     */
    private AnalyzeGraphDataEnumAndroid(String xpath, String description) {
        this.xpath = xpath;
        this.description = description;
    }
}
