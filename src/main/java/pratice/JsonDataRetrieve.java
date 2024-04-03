package pratice;

import org.json.JSONObject;

public class JsonDataRetrieve {

    public static void main(String[] args) {

        String jsonData = "{\"payTypes\":\"C,I,W\",\"discountMax\":100,\"laborDepartmentAllocations\":{\"allocationPercentage\":50," +
                "\"allocations\":[{\"allocation\":100,\"department\":\"Service\",\"account\":\"Policy\"}]},\"applyWithOtherDiscount\":1," +
                "\"description\":\"RO-Percent10CIW\",\"applyTax\":0,\"dealerDiscountId\":220,\"fromDate\":\"2024-02-01T00:00:00-08:00\"," +
                "\"expiryDate\":\"2024-03-30T00:00:00-07:00\",\"partsDepartmentAllocations\":{\"allocationPercentage\":50," +
                "\"allocations\":[{\"allocation\":100,\"department\":\"Parts\",\"account\":\"Policy\"}]},\"dollarAmount\":0,\"percentage\":10," +
                "\"discountType\":\"Percent\",\"category\":\"Ad Hoc\",\"allowDiscountRepair\":1}";
        // Retrieve laborDepartmentAllocations.allocationPercentage from jsonData
        int allocationPercentage = new JSONObject(jsonData).getJSONObject("laborDepartmentAllocations").getInt("allocationPercentage");
        System.out.println( "laborDepartmentAllocations.allocationPercentage: " + allocationPercentage);
    }
}
