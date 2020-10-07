public class Company {
    private String name;
    private String vatNumber;
    private String phoneNumber;
    private String webAddress;

    public Company(String name, String vatNumber, String phoneNumber,String webAddress) {
        this.name = name;
        this.vatNumber = vatNumber;
        this.phoneNumber = phoneNumber;
        this.webAddress = webAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("Name company : ").append(name)
            .append("\n\r")
            .append("phone company: ").append(phoneNumber)
            .append("\n\r")
            .append("VAT number: ").append(vatNumber)
            .append("\n\r")
            .append("web: ").append(webAddress)
            .toString();
    }
}
