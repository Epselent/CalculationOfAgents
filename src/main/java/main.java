import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class main {
    public static void main(String[] args) {
        XSSFWorkbook workbook = Import.readWorkbook();
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row;
        Post[] post = new Post[6];
        int firstRow = 10;
        for (int i = 0; i < post.length; i++) {
            row = sheet.getRow(firstRow);
            post[i] = new Post();
            post[i].setInvoiceNumber(row.getCell(0).getStringCellValue());
            post[i].setCityOfDelivery(row.getCell(7).getStringCellValue());
            post[i].setWeight(row.getCell(12).getNumericCellValue());
            post[i].setDate(sheet.getRow(5).getCell(0).getStringCellValue());
            firstRow++;
        }
        int sum = 0;
        for (Post ps : post) {
            if(ps.getWeight()>5){
                sum+=City.getByCity(ps.getCityOfDelivery()).getPrice()+(((int)Math.ceil(ps.getWeight())-5)*10);
            }else {
                sum+=City.getByCity(ps.getCityOfDelivery()).getPrice();
            }

        }
        System.out.println("Должны агенту города- " + post[1].getCityOfDelivery() + " "+ sum);
        Import.close();

    }


}

