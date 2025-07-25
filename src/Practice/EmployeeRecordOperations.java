package Practice;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeRecordOperations {
    public static void main(String[] args) {
        List<EmployeeRecord> employeeRecords = List.of(
                new EmployeeRecord("Sujay", 100000, "Dev", LocalDate.of(2024, 7, 5),LocalDate.of(2024, 1, 21)),
                new EmployeeRecord("Dhiraj", 10000, "Test", LocalDate.of(2025, 7, 6),LocalDate.of(2023, 8, 23)),
                new EmployeeRecord("Nikhil", 30000, "BA", LocalDate.of(2023, 2, 15),LocalDate.of(2022, 11, 11)),
                new EmployeeRecord("Kamesh", 3000, "BA", LocalDate.of(2025, 4, 5),LocalDate.of(2024, 6, 1)),
                new EmployeeRecord("Rohit", 100000, "Test", LocalDate.of(2024, 7, 2),LocalDate.of(2022, 10, 3))
        );

        //check doj before 31st Dec 2024 and sort according to Names
        List<EmployeeRecord> sortedList = employeeRecords.stream()
                .filter(e -> e.doj().isBefore(LocalDate.of(2024, 12, 31)))
                .sorted(Comparator.comparing(EmployeeRecord::name).reversed())
                .toList();
        System.out.println(sortedList);

        //check find the highest rating employee, if 2 employee has same rating then compare date of joining
        Optional<EmployeeRecord> topEmployee = employeeRecords.stream()
                .max(Comparator.comparingDouble(EmployeeRecord::salary)
                        .thenComparing(EmployeeRecord::doj, Comparator.reverseOrder()));
        System.out.println(topEmployee);

        topEmployee.ifPresent(e -> System.out.println("Top employee: " + e));

        //groupBy dept
        Map<String, List<EmployeeRecord>> collectByDept = employeeRecords.stream()
                .collect(Collectors.groupingBy(EmployeeRecord::Dept));
        System.out.println(collectByDept);

        //check last salary raise before one year
        List<EmployeeRecord> list1 = employeeRecords.stream()
                .filter(emp -> emp.lastRaiseSalary().isBefore(isMoreThanOneYear))
                .toList();
        System.out.println(list1);

        //check last salary raise before one year and increase by 1500, update the lastRaiseDate
        List<EmployeeRecord> list = employeeRecords.stream().filter(emp -> isSalInc(emp.lastRaiseSalary()))
                .map(emp -> {
                    EmployeeRecord updatedEmp = new EmployeeRecord(emp.name(), emp.salary() + 1500, emp.Dept(), LocalDate.now(), LocalDate.now());
                    return updatedEmp;
                }).toList();
        System.out.println(list);

        //find employee with highest salary, give hike of 2k
        EmployeeRecord employeeRecord1 = employeeRecords.stream()
//                .sorted(Comparator.comparing(EmployeeRecord::salary).reversed())
//                .findFirst()
                .max(Comparator.comparing(EmployeeRecord::salary))
                .map(emp -> {
                    System.out.println("Before Bonus: "+emp);
                    return new EmployeeRecord(emp.name(), emp.salary() + 2000, emp.Dept(), LocalDate.now(), LocalDate.now());
                }).get();
        System.out.println("After Bonus: "+employeeRecord1);

    }

    private static final LocalDate isMoreThanOneYear = LocalDate.now().minusYears(1);

    private static boolean isSalInc(LocalDate localDate) {
        Period period=localDate.until(LocalDate.now());
//        System.out.println(period.getYears());
        return period.getYears()>=1 ;
    }
}
