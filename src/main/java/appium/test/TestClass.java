package appium.test;
import java.util.*;

public class TestClass {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("0","0","-0.4","-1.1","-1.6");
        String str = "[-12, 12, 18, -17]";
        System.out.println(str.replaceAll("-", ""));
        String str2 = "[[-12], [12], [18], [-17]]";
        System.out.println(str2.replaceAll("-", ""));
        LinkedHashMap<String, LinkedHashMap<String, String>> toolTipValues = new LinkedHashMap<>();
        
        LinkedHashMap<String, String> toolTip1 = new LinkedHashMap<>();
        toolTip1.put("Solar Produced", "1.7 kWh");
        toolTip1.put("Home Usage", "0 kWh");
        toolTip1.put("Imported from Grid", "0 kWh");
        toolTip1.put("Battery Charged", "-1.7 kWh");
        toolTipValues.put("Monday, 08/14/23 12 am - 1 am", toolTip1);

        LinkedHashMap<String, String> toolTip2 = new LinkedHashMap<>();
        toolTip2.put("Solar Produced", "1.7 kWh");
        toolTip2.put("Home Usage", "0 kWh");
        toolTip2.put("Imported from Grid", "0 kWh");
        toolTip2.put("Battery Charged", "-1.8 kWh");
        toolTipValues.put("Monday, 08/14/23 1 am - 2 am", toolTip2);

        LinkedHashMap<String, String> toolTip3 = new LinkedHashMap<>();
        toolTip3.put("Solar Produced", "1.7 kWh");
        toolTip3.put("Home Usage", "0 kWh");
        toolTip3.put("Imported from Grid", "0 kWh");
        toolTip3.put("Battery Charged", "-1.7 kWh");
        toolTipValues.put("Monday, 08/14/23 2 am - 3 am", toolTip3);

        LinkedHashMap<String, String> toolTip4 = new LinkedHashMap<>();
        toolTip4.put("Solar Produced", "1.7 kWh");
        toolTip4.put("Home Usage", "0 kWh");
        toolTip4.put("Imported from Grid", "0 kWh");
        toolTip4.put("Battery Charged", "-1.8 kWh");
        toolTipValues.put("Monday, 08/14/23 3 am - 4 am", toolTip4);

        LinkedHashMap<String, String> toolTip5 = new LinkedHashMap<>();
        toolTip5.put("Solar Produced", "1.7 kWh");
        toolTip5.put("Home Usage", "0 kWh");
        toolTip5.put("Imported from Grid", "0 kWh");
        toolTip5.put("Battery Charged", "-1.8 kWh");
        toolTipValues.put("Monday, 08/14/23 4 am - 5 am", toolTip5);

        LinkedHashMap<String, String> toolTip6 = new LinkedHashMap<>();
        toolTip6.put("Solar Produced", "1.7 kWh");
        toolTip6.put("Home Usage", "0 kWh");
        toolTip6.put("Imported from Grid", "0 kWh");
        toolTip6.put("Battery Charged", "-1.7 kWh");
        toolTipValues.put("Monday, 08/14/23 5 am - 6 am", toolTip6);

        LinkedHashMap<String, String> toolTip7 = new LinkedHashMap<>();
        toolTip7.put("Solar Produced", "1.7 kWh");
        toolTip7.put("Home Usage", "0 kWh");
        toolTip7.put("Imported from Grid", "0 kWh");
        toolTip7.put("Battery Charged", "-1.8 kWh");
        toolTipValues.put("Monday, 08/14/23 6 am - 7 am", toolTip7);

        LinkedHashMap<String, String> toolTip8 = new LinkedHashMap<>();
        toolTip8.put("Solar Produced", "1.7 kWh");
        toolTip8.put("Home Usage", "0.1 kWh");
        toolTip8.put("Imported from Grid", "0 kWh");
        toolTip8.put("Battery Charged", "-1.6 kWh");
        toolTipValues.put("Monday, 08/14/23 7 am - 8 am", toolTip8);

        LinkedHashMap<String, String> toolTip9 = new LinkedHashMap<>();
        toolTip9.put("Solar Produced", "1.7 kWh");
        toolTip9.put("Home Usage", "1.8 kWh");
        toolTip9.put("Imported from Grid", "0.2 kWh");
        toolTip9.put("Battery Charged", "-0.1 kWh");
        toolTipValues.put("Monday, 08/14/23 8 am - 9 am", toolTip9);

        LinkedHashMap<String, String> toolTip10 = new LinkedHashMap<>();
        toolTip10.put("Solar Produced", "1.7 kWh");
        toolTip10.put("Home Usage", "2 kWh");
        toolTip10.put("Imported from Grid", "0.2 kWh");
        toolTip10.put("Battery Charged", "0.1 kWh");
        toolTipValues.put("Monday, 08/14/23 9 am - 10 am", toolTip10);

        LinkedHashMap<String, String> toolTip11 = new LinkedHashMap<>();
        toolTip11.put("Solar Produced", "1.7 kWh");
        toolTip11.put("Home Usage", "1.4 kWh");
        toolTip11.put("Imported from Grid", "0.1 kWh");
        toolTip11.put("Battery Charged", "-0.4 kWh");
        toolTipValues.put("Monday, 08/14/23 10 am - 11 am", toolTip11);

        LinkedHashMap<String, String> toolTip12 = new LinkedHashMap<>();
        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "1.9 kWh");
        toolTip12.put("Imported from Grid", "0.2 kWh");
        toolTip12.put("Battery Charged", "0 kWh");
        toolTipValues.put("Monday, 08/14/23 11 am - 12 pm", toolTip12);

        LinkedHashMap<String, String> toolTip13 = new LinkedHashMap<>();
        toolTip13.put("Solar Produced", "1.7 kWh");
        toolTip13.put("Home Usage", "1,9 kWh");
        toolTip13.put("Imported from Grid", "0.2 kWh");
        toolTip13.put("Battery Charged", "0 kWh");
        toolTipValues.put("Monday, 08/14/23 12 pm - 1 pm", toolTip13);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "5.2 kWh");
        toolTip12.put("Imported from Grid", "0.5 kWh");
        toolTip12.put("Battery Charged", "2.9 kWh");
        toolTipValues.put("Monday, 08/14/23 1 pm - 2 pm", toolTip12);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "0 kWh");
        toolTip12.put("Imported from Grid", "0 kWh");
        toolTip12.put("Battery Charged", "-1.7 kWh");
        toolTipValues.put("Monday, 08/14/23 2 pm - 3 pm", toolTip12);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "0 kWh");
        toolTip12.put("Imported from Grid", "0 kWh");
        toolTip12.put("Battery Charged", "-1.7 kWh");
        toolTipValues.put("Monday, 08/14/23 3 pm - 4 pm", toolTip12);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "5.9 kWh");
        toolTip12.put("Imported from Grid", "0.6 kWh");
        toolTip12.put("Battery Charged", "3.5 kWh");
        toolTipValues.put("Monday, 08/14/23 4 pm - 5 pm", toolTip12);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "6.4 kWh");
        toolTip12.put("Imported from Grid", "0.7 kWh");
        toolTip12.put("Battery Charged", "4 kWh");
        toolTipValues.put("Monday, 08/14/23 5 pm - 6 pm", toolTip12);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "6.4 kWh");
        toolTip12.put("Imported from Grid", "0.7 kWh");
        toolTip12.put("Battery Charged", "4 kWh");
        toolTipValues.put("Monday, 08/14/23 6 pm - 7 pm", toolTip12);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "6.4 kWh");
        toolTip12.put("Imported from Grid", "0.7 kWh");
        toolTip12.put("Battery Charged", "4 kWh");
        toolTipValues.put("Monday, 08/14/23 7 pm - 8 pm", toolTip12);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "2 kWh");
        toolTip12.put("Imported from Grid", "0.2 kWh");
        toolTip12.put("Battery Charged", "0.1 kWh");
        toolTipValues.put("Monday, 08/14/23 8 pm - 9 pm", toolTip12);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "0.1 kWh");
        toolTip12.put("Imported from Grid", "0 kWh");
        toolTip12.put("Battery Charged", "-1.6 kWh");
        toolTipValues.put("Monday, 08/14/23 9 pm - 10 pm", toolTip12);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "0 kWh");
        toolTip12.put("Imported from Grid", "0 kWh");
        toolTip12.put("Battery Charged", "-1.8 kWh");
        toolTipValues.put("Monday, 08/14/23 10 pm - 11 pm", toolTip12);
        

        toolTip12.put("Solar Produced", "1.7 kWh");
        toolTip12.put("Home Usage", "0 kWh");
        toolTip12.put("Imported from Grid", "0 kWh");
        toolTip12.put("Battery Charged", "-1.7 kWh");
        toolTipValues.put("Monday, 08/14/23 12 pm - 1 pm", toolTip12);
        

        System.out.println(toolTipValues);
    }
}
