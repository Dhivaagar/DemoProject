package selenium.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Map;


public class NotificationsTests {
    public static void main (String[] args) {

        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption(
                "prefs",
                Map.of("profile.default_content_setting_values.notifications", 1)
        );
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://kitchen.applitools.com/ingredients/notification");
        var notification_body = getObject((JavascriptExecutor) driver);
        System.out.println(notification_body);
    }

    private static String getObject(JavascriptExecutor driver) {
        String getNotificationText = "const callback = arguments[arguments.length - 1]; const original_notification = window.Notification; window.Notification = function stubNotification(value){const new_notification = new original_notification(value); new_notification.onshow = function(){const notification_text = new_notification.title; window.Notification = original_notification; console.log(notification_text); callback(notification_text);}}; document.getElementById('notification-button').click();";
        var notification_body = driver.executeAsyncScript(getNotificationText);
        return (String) notification_body;
    }
}