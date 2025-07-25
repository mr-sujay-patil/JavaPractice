import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("Sujay", 70000,"Dev");
        Employee e2 = new Employee("Dhiraj", 30000,"HR");
        Employee e3 = new Employee("Rohit", 40000,"QA");
        Employee e4 = new Employee("Hulya", 30000,"HR");
        Employee e5 = new Employee("Ramya", 50000,"Dev");
        Employee e6 = new Employee("Hemant", 10000,"QA");

        List<Employee> employees = List.of(e1, e2, e3, e4, e5,e6);
//        Second-highest salary
//        Optional<Employee> secondHighest = employees.stream().distinct().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).skip(1).findFirst();
//        System.out.println(secondHighest.map(employee -> "Second-highest salary: " + employee.getSalary()).orElse(null));

//        Dept wise highest salary
//        Map<String, List<Employee>> empDeptMap = employees.stream().collect(Collectors.groupingBy(Employee::getDept));
//        System.out.println(empDeptMap);
        Optional<Employee> first = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findAny();
        System.out.println(first);

        Map<String, List<Employee>> collect = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.groupingBy(Employee::getDept));
        System.out.println(collect);

        Employee employee = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).orElse(null);

        Map<String, Long> deptCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(deptCount);
    }
}
