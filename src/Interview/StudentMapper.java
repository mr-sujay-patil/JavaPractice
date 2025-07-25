package Interview;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

class StudentMapper {

    public static void main(String[] args) {
        //list of students
        List<Student> students = List.of(new Student(1L, "sujay", "patil", LocalDate.of(2025, 1, 5), "science"),
                new Student(2L, "nikhil", null, LocalDate.of(2023, 5, 8), "arts"),
                new Student(3L, "dhiraj", "patil", null, "commerce"));

        List<StudentDto> list = students.stream()
                .map(StudentMapper::mapStudentToStudentDto)
                .toList();
        System.out.println(list);
    }

    //mapper class Student -> StudentDto
    public static StudentDto mapStudentToStudentDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setName(Optional.ofNullable(student.getFirstName()).orElse("")+" "+Optional.ofNullable(student.getLastName()).orElse(""));
        studentDto.setEnrolDuration(getDuration(student.getEnrollDate()));
        studentDto.setMajor(student.getMajor());
        return studentDto;
    }

    //method to get the duration using Period
    private static String getDuration(LocalDate enrollDate) {
        if(enrollDate==null)
            return "No enroll date provided.";
        Period period=Period.between(enrollDate,LocalDate.now());
        return period.getYears() + " years " + period.getMonths() +" months "+ period.getDays()+" days";
    }
}

//Student class with Getter Setters and Constuctors
class Student{
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate enrollDate;
    private String major;

    public Student(Long id, String firstName, String lastName, LocalDate enrollDate, String major) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollDate = enrollDate;
        this.major = major;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrollDate=" + enrollDate +
                ", major='" + major + '\'' +
                '}';
    }
}

//StudentDto class with Getter Setters and Constuctors
class StudentDto{
    private String name;
    private String enrolDuration;
    private String major;

    public StudentDto(){}
    public StudentDto(String name, String enrolDuration, String major) {
        this.name = name;
        this.enrolDuration = enrolDuration;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrolDuration() {
        return enrolDuration;
    }

    public void setEnrolDuration(String enrolDuration) {
        this.enrolDuration = enrolDuration;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", enrolDuration='" + enrolDuration + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}

