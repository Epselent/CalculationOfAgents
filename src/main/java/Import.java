



import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Import {
    private static FileInputStream file;
    private static XSSFWorkbook wb;
    public static XSSFWorkbook readWorkbook() {
        try {
            file = new FileInputStream("./src/main/resources/manifest.xlsx");
            wb = new XSSFWorkbook(file);
            System.out.println("connect");
            return wb;
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }
    public static void close(){
        try {
            file.close();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
