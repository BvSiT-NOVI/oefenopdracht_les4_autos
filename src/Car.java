import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Car {
    //bouwjaar, merk, soort, kenteken en aantal gereden kilometers
    // vraagprijs en willen we de uiteindelijke verkoopprijs registreren. ex Btw.

    private String manufacturer;
    private String model;
    private Date yearMake;
    private String plateNumber;
    private int mileage;//In kilometers
    private BigDecimal askPrice; //VAT excluded
    private BigDecimal sellPrice; //VAT excluded
    public final static double VAT_RATE= 0.16;

    //Random max values
    public final static int MAX_PRICE= 30000;
    public final static int MAX_MILEAGE= 300000;
    public final static int MAX_DIFF_SELL_PRICE= 1000;
    public final static int MAX_PLATE_NUMBER= 100000;

    public Car(String manufacturer, String model, Date yearMake, String plateNumber, int mileage, BigDecimal askPrice, BigDecimal sellPrice) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearMake = yearMake;
        this.plateNumber = plateNumber;
        this.mileage = mileage;
        this.askPrice = askPrice;
        this.sellPrice = sellPrice;
    }

    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearMake = randomYearMake();
        this.plateNumber=randomPlateNumber();
        this.mileage = randomMileage();
        this.askPrice = randomAskPrice();
        this.sellPrice = randomSellPrice(askPrice);
    }

    public BigDecimal askPriceVatInclusive(){
        BigDecimal bd = askPrice.add(askPrice.multiply(new BigDecimal(VAT_RATE)));
        return bd.setScale(0,RoundingMode.DOWN);
    }

    private BigDecimal sellPriceVatInclusive(){
        BigDecimal bd = sellPrice.add(askPrice.multiply(new BigDecimal(VAT_RATE)));
        return bd.setScale(0, RoundingMode.DOWN);
    }

    private String randomPlateNumber(){
        return Integer.toString(new Random().nextInt(MAX_PLATE_NUMBER));
    }

    private Date randomYearMake(){
        int year = new Random().nextInt(20)+2000;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getTime();
    }

    private int randomMileage(){
        return new Random().nextInt(MAX_MILEAGE);
    }

    private BigDecimal randomAskPrice(){
        return new BigDecimal(new Random().nextInt(MAX_PRICE));
    }

    private BigDecimal randomSellPrice(BigDecimal askPrice){
        return askPrice.subtract(BigDecimal.valueOf(new Random().nextInt(MAX_DIFF_SELL_PRICE)));
    }


    @Override
    public String toString() {
        return new StringBuilder()
            .append("Car manufacturer: ").append(manufacturer)
            .append("\n\r")
            .append("model: ").append(model)
            .append("\n\r")
            .append("year make: ").append(getYearMake())
            .append("\n\r")
            .append("mileage(km): ").append(mileage)
            .append("\n\r")
            .append("plate nr. : ").append(plateNumber)
            .append("\n\r")
            .append("ask price excl. : ").append(askPrice).append("\tincl. ").append(askPriceVatInclusive())
            .append("\n\r")
            .append("selling price excl. : ").append(sellPrice).append("\tincl. ").append(sellPriceVatInclusive())
            .toString();
    }

    public String getYearMake(){
        //TODO BvS Ridiculously complex to get year from date, but Date.getYear is deprecated. Better solution?
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(yearMake);
        return Integer.toString(calendar.get(Calendar.YEAR));
    }

}
