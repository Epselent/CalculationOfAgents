import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Post {
    private String invoiceNumber;
    private String cityOfDelivery;
    private double weight;
    private Date date;
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCityOfDelivery() {
        return cityOfDelivery;
    }

    public void setCityOfDelivery(String cityOfDelivery) {
       String[] str = cityOfDelivery.split(" ");
        for (String s:str) {
            if(City.getByCity(s)!=null){
                this.cityOfDelivery = s;
            }

        }

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



    public void setDate(String date) {
        String[] str = date.split(" ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date newDate = dateFormat.parse(str[str.length-1]);

            this.date = newDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return ("Накладная № - " + invoiceNumber + ", город доставки - " + cityOfDelivery + ", вес - " + weight + "  кг, " + date);
    }
}
