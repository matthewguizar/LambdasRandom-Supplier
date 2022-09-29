import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        // new Thread(() -> {
        //     System.out.println("Print");
        //     System.out.println("Line 2");
        //     System.out.format("This is line %d\n", 3);
            
        // }).start();

        Employee matte = new Employee("Matte Azul", 31);
        Employee matte1 = new Employee("Matte Name", 24);
        Employee matte2 = new Employee("Azul Matte", 23);
        Employee matte3 = new Employee("Name Name", 35);

        List<Employee> employees = new ArrayList<>();
        employees.add(matte);
        employees.add(matte1);
        employees.add(matte2);
        employees.add(matte3);

        Collections.sort(employees, (employee1, employee2) ->
            employee1.getName().compareTo(employee2.getName()));

    
        
        // employees.forEach(employee -> {
        //     System.out.println(employee.getName());
        //     System.out.println(employee.getAge());
        // });

        printEmployeesByAge(employees, "Employees over 30", employee ->  employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployees under 30", employee -> employee.getAge() < 30);
        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee){
                return employee.getAge() <25;
            }
        });


        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        int a = 20;
        System.out.println(greaterThan15.test(10));
        System.out.println(greaterThan15.test(a + 5));
        System.out.println(greaterThan15.and(lessThan100).test(15));


        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i=0; i <10; i ++){
            System.out.println(randomSupplier.get());
        }

    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("====================");
        for (Employee employee : employees){
            if (ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
    
}
