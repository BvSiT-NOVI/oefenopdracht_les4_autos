import java.util.ArrayList;
import java.util.List;

public class SalesEmployee {
    //bedrijfsnaam, telefoonnummers, website en btw-nummer registreren
    private String name;
    private List<String> phoneNumbers;
    private List<Car> carsSold;
    private Company company;

    public SalesEmployee(String name, Company company) {
        this.name = name;
        this.company = company;
        this.carsSold = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Car> getCarsSold() {
        return carsSold;
    }

    public void setCarsSold(List<Car> carsSold) {
        this.carsSold = carsSold;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name employee: ").append(name)
            .append("\n\r")
            //TODO phone
            .append(company.toString())
            .append("\n\r")
            .append("Number of cars sold:").append(carsSold.size());
            for (Car car: carsSold){
                sb.append("\n\r").append(car.toString());
            }
            return sb.toString();
    }
}
