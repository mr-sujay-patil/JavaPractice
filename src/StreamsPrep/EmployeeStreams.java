package StreamsPrep;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeStreams {

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "sujay", "dev", 25000);
        Employee e2 = new Employee(102, "rohit", "dev", 15000);
        Employee e3 = new Employee(103, "dhiraj", "test", 3000);
        Employee e4 = new Employee(104, "nikhil", "test", 2000);
        Employee e5 = new Employee(105, "kamesh", "hr", 6000);
        Employee e6 = new Employee(106, "kandya", "test", 4000);
        Employee e7 = new Employee(107, "kailash", "dev", 20000);
        Employee e8 = new Employee(108, "sagar", "test", 2000);
        Employee e9 = new Employee(109, "dhiraj", "hr", 6000);
        Employee e10 = new Employee(110, "shekhar", "hr", 9000);

        List<Employee> employeeList = List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        //distinct employees by name
//        List<String> employeeNames = employeeList.stream()
//                .map(Employee::name)
//                .distinct()
//                .toList();
//        System.out.println(employeeNames);

        //employees earning more than 5k
//        List<String> employeeSal = employeeList.stream()
//                .filter(e -> e.salary() > 5000)
//                .map(Employee::name)
//                .toList();
//        System.out.println(employeeSal);

        //any employee with matching dept
//        boolean anyMatch = employeeList.stream()
//                .anyMatch(e -> "test".equalsIgnoreCase(e.dept()));
//        System.out.println(anyMatch);

        //max salary employee
//        Employee maxSal = employeeList.stream()
//                .max(Comparator.comparing(Employee::salary))
//                .orElse(null);
//        System.out.println(maxSal);

        //second Highest Salary
//        Employee secondHighestSal = employeeList.stream()
//                .sorted(Comparator.comparing(Employee::salary).reversed())
//                .skip(1)
//                .findAny()
//                .orElse(null);
//        System.out.println(secondHighestSal);

        //top 3 salary
//        List<String> top3sal = employeeList.stream()
//                .sorted(Comparator.comparing(Employee::salary).reversed())
//                .map(Employee::name)
//                .limit(3)
//                .toList();
//        System.out.println(top3sal);

        //Average salary
//        double avgSalary = employeeList.stream()
//                .mapToDouble(Employee::salary)
//                .average()
//                .orElse(0);
//        System.out.println(avgSalary);

        //Total Salary
//        int totalSal = employeeList.stream()
//                .mapToInt(Employee::salary)
//                .sum();
//        System.out.println(totalSal);

        //Group Employees by dept
//        Map<String, List<Employee>> groupByDept = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::dept));
//        System.out.println(groupByDept);

        //count emp by dept
//        Map<String, Long> countByDept = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::dept, Collectors.counting()));
//        System.out.println(countByDept);

        //avg sal by dept
//        Map<String, Double> avgSalByDept = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::dept, Collectors.averagingDouble(Employee::salary)));
//        System.out.println(avgSalByDept);

        //sum sal by dept
//        Map<String, Integer> sumSalByDept = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::dept, Collectors.summingInt(Employee::salary)));
//        System.out.println(sumSalByDept);

        //highest paid emp by dept
//        Map<String, Employee> highestPaidByDept = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::dept,
//                        Collectors.collectingAndThen(
//                                Collectors.maxBy(Comparator.comparingDouble(Employee::salary)), Optional::get)));
//        System.out.println(highestPaidByDept);

        //find duplicate names
//        Set<String> duplicateNames = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::name, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(e -> e.getValue() > 1)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toSet());
//        System.out.println(duplicateNames);

        //dept with highest avg sal
//        Map.Entry<String, Double> deptHighAvgSal = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::dept, Collectors.averagingDouble(Employee::salary)))
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .orElse(null);
//        System.out.println(deptHighAvgSal);

        //map emp id with emp
//        Map<Integer, Employee> empMap = employeeList.stream()
//                .collect(Collectors.toMap(Employee::id, e -> e));
//        System.out.println(empMap);

        //partitioned by sal
//        Map<Boolean, List<Employee>> patitioned = employeeList.stream()
//                .collect(Collectors.partitioningBy(e -> e.salary() > 5000));
//        System.out.println(patitioned);

        //dept->list of emp names
//        Map<String, List<String>> listNamesByDept = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::dept, Collectors.mapping(Employee::name, Collectors.toList())));
//        System.out.println(listNamesByDept);

        //comma separated emp names
//        String commaSeparatedMapping = employeeList.stream()
//                .collect(Collectors.mapping(Employee::name, Collectors.joining(",")));
//        System.out.println(commaSeparatedMapping);
//
//        String commaSeparated = employeeList.stream()
//                .map(Employee::name)
//                .collect(Collectors.joining(","));
//        System.out.println(commaSeparated);

        //increase sal by 20%
//        List<Integer> increasedSal = employeeList.stream()
//                .map(e -> e.salary()+(e.salary() * 20 / 100))
//                .toList();
//        System.out.println(increasedSal);

        //nth highest sal
//        int n=3;
//        Employee nthHighestSal = employeeList.stream()
//                .sorted(Comparator.comparing(Employee::salary).reversed())
//                .skip(n - 1)
//                .findFirst()
//                .orElse(null);
//        System.out.println(nthHighestSal);

        //sal histogram
//        Map<String, Long> histogram = employeeList.stream()
//                .collect(Collectors.groupingBy(e -> {
//                    if (e.salary() > 5000) return "LOW";
//                    if (e.salary() < 15000) return "MEDIUM";
//                    return "HIGH";
//                }, Collectors.counting()));
//        System.out.println(histogram);

        //longest emp name
//        String maxLength = employeeList.stream()
//                .map(Employee::name)
//                .max(Comparator.comparing(String::length))
//                .orElse(null);
//        System.out.println(maxLength);

        //emp name freq
//        Map<String, Long> nameFreq = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::name, Collectors.counting()));
//        System.out.println(nameFreq);

        //dept with max emp
//        Map.Entry<String, Long> maxEmpByDept = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::dept, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .orElse(null);
//        System.out.println(maxEmpByDept);

        //multiple comparators
//        List<Employee> compEmployees = employeeList.stream()
//                .sorted(Comparator.comparing(Employee::name)
//                        .thenComparing(Employee::id)
//                        .thenComparing(Employee::salary))
//                .toList();
//        System.out.println(compEmployees);

    }
}
