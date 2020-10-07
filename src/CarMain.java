import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarMain {
    public static void main(String[] args) {
        Company company1= new Company("van Balen","23456","023-123456","www.vanbalen.nl");
        Company company2= new Company("Wrecks BV","67777","020-123456","www.wrecks.nl");

        List<SalesEmployee> employeeList = new ArrayList();

        employeeList.add(new SalesEmployee("Peter Hoekstra",company1));
        employeeList.add(new SalesEmployee("Jan Jansen",company1));
        employeeList.add(new SalesEmployee("Piet Pieterse",company2));
        employeeList.add(new SalesEmployee("Klaas Klaassen",company2));
        employeeList.add(new SalesEmployee("Wim Wiebel",company2));


        //Create cars
        List<Car> carList = new ArrayList<>();
        for (int i = 0;i<10;i++){
            for (int j = 0;j<5;j++){
                carList.add(new Car("Manu"+i,"Model"+j));
            }
        }

        //Add random cars to employees
        for (Car car : carList){
            int bound = employeeList.size();
            int idx = new Random().nextInt(bound);
            SalesEmployee salesEmployee = employeeList.get(idx);
            salesEmployee.getCarsSold().add(car);
        }


        for (SalesEmployee s: employeeList){
            System.out.println("\n\r*****************************");
            System.out.println(s.toString());
        }

    }

}
