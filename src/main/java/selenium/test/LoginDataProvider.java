package selenium.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LoginDataProvider {

    @DataProvider(name = "excelLogin")
    public static Object[][] excelLogin() throws IOException {

        String regex = "^[1-9]\\d{0,2}(,\\d{3})*(\\.\\d{2})?$";
        String currentPath = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + currentPath);
        String path = currentPath + "/Test-Data/Login-Data.xlsx";
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        int row = sheet.getLastRowNum();
        int cell = sheet.getRow(1).getLastCellNum();
        System.out.println(row+" "+cell);
        String[][] data = new String[row][cell];
        for (int i=1; i<=row;i++){

            for (int j=0;j<cell;j++){
                System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }

    @DataProvider(name = "dataLogin")
    public static Object[][] dataLogin() {
        return new Object[][] {{"dhivaagar02@gmail.com", "hi"}, {"dhivaagar02@gmail.com", "hi"}};
    }
}
