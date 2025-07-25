public class Employee {
    private String name;
    private int salary;
    private String Dept;

    private int lastRaiseSalary;

    public String getDept() {
        return Dept;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int salary, String dept) {
        this.name = name;
        this.salary = salary;
        Dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", Dept='" + Dept + '\'' +
                '}';
    }
}
