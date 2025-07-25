package Interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewQuestions {

    public static void main(String[] args) {
//        1. Flatten a nested list using Streams
        List<List<String>> list = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d"));
        List<String> list1 = list.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(list1);

//        2. Find the second highest salary from a list of employees
        List<Employee> employees = List.of(
                new Employee(1, "sujay", 110000,"Comp", "Dev"),
                new Employee(2, "rohit", 10000,"QA", "Tester"),
                new Employee(3, "kamesh", 11000,"QA", "Tester"),
                new Employee(4, "dhiraj", 20000,"BA", "Dev"),
                new Employee(4, "dhiraj", 70000,"BA", "Dev"),
                new Employee(5, "nikhil", 40000,"Comp", "Dev")
        );
        Employee employee = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(employee);

//        3. Group a list of employees by department and then by designation
        Map<String, Map<String, List<Employee>>> collectByDeptDesig = employees.stream()
                .collect(Collectors.groupingBy(Employee::dept,
                        Collectors.groupingBy(Employee::designation)));
        System.out.println(collectByDeptDesig);

//        	•	Modify the code to return average salary per designation per department.
        Map<String, Map<String, Double>> collectAvgSalByDesignDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::designation,
                        Collectors.groupingBy(Employee::dept,
                                Collectors.averagingDouble(Employee::salary))));
        System.out.println(collectAvgSalByDesignDept);

//        4. Custom Collector: Create a comma-separated string of all unique employee names
//        in uppercase,sorted alphabetically.
        List<String> empList = employees.stream()
                .map(emp -> emp.name().toUpperCase())
                .distinct()
                .sorted()
                .toList();
        System.out.println(empList);

//        5. Partition Employee into passing (salary >= 40000) and failing groups using partitioningBy()
        Map<Boolean, List<Employee>> collectByPartition = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.salary() >= 40000));
        System.out.println(collectByPartition);

//        6. Find the first non-repeating character in a string using Streams
        String str="new string";
        Map.Entry<String, Long> stringLongEntry = Arrays.stream(str.split(""))
                .filter(c -> c.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() > 2)
                .findFirst()
                .orElse(null);
        System.out.println(stringLongEntry);

//        7. Create a comma-separated string of all unique employee names in uppercase, sorted alphabetically.
        String commaSeparated = employees.stream()
                .distinct()
                .map(emp -> emp.name().toUpperCase())
                .collect(Collectors.joining(","));
        System.out.println(commaSeparated);

//        8. Partition students into passing (marks >= 50) and failing groups using partitioningBy()
        List<Students> studentsList = Arrays.asList(
                new Students(18, "Virat", 99),
                new Students(10, "Rohit", 90),
                new Students(33, "Pandya", 9),
                new Students(17, "Rahul", 49),
                new Students(67, "Bumrah", 51),
                new Students(7, "Dhoni", 50)
        );

        Map<String, List<String>> partitionByMarks = studentsList.stream()
                .collect(Collectors.partitioningBy(
                        c -> c.marks() > 50,
                        Collectors.mapping(c -> c.name(), Collectors.toList())
                )).entrySet()
                .stream()
                .collect(Collectors.toMap(c -> c.getKey() ? "Pass" : "Fail",
                        c -> c.getValue()));
        System.out.println(partitionByMarks);

//        9 Find the first non-repeating character in a string using Streams
        List<Map.Entry<String, Long>> nonRepeatingChar = Arrays.stream(str.split(""))
                .parallel()
                .filter(c->!c.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() < 2)
                .toList();
        System.out.println(nonRepeatingChar);

//        10. print set of 3 chars in separate lines
        String separate = "sadsewsdfrw";
        IntStream.iterate(0, i -> i < separate.length(), i -> i + 3)
                .mapToObj(i -> separate.substring(i, Math.min(i + 3, separate.length())))
                .forEach(System.out::println);

//        11. Implement a sum of even numbers using only reduce()
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sumWithReduce = integers.stream()
                .reduce(0, (acc, n) -> n % 2 == 0 ? acc + n : acc);
        System.out.println(sumWithReduce);

//        12. Given a map of departments and list of employees, flatten and get names of all employees with salary > 50,000
        HashMap<String, List<DeptEmp>> deptEmp = new HashMap<>();
        deptEmp.put("DEV", Arrays.asList(
                new DeptEmp("Messi", 100000),
                new DeptEmp("Ronaldo", 300000),
                new DeptEmp("Suarez", 20000)));
        deptEmp.put("HR", Arrays.asList(
                new DeptEmp("Ibrahimovic", 300000),
                new DeptEmp("Pepe", 50000),
                new DeptEmp("Kaka", 70000)));

        Map<String, Integer> deptEmpList = deptEmp.values()
                .stream()
                .flatMap(c->c.stream())
                .filter(c -> c.salary() > 50000)
                .collect(Collectors.toMap(c -> c.name(), c -> c.salary()));

        System.out.println(deptEmpList);


    }
}

record DeptEmp(String name, int salary){}

record Employee(int id, String name, double salary, String dept, String designation) {}

record Students(int rollNo, String name,int marks){}
