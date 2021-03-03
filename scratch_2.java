import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Student {
    private String name;
    private RollNumber rollNumber;
    // add the other necessary member methods here

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(rollNumber, student.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RollNumber getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(RollNumber rollNumber) {
        this.rollNumber = rollNumber;
    }
}
class RollNumber {
    private final BigInteger rollNumber;

    RollNumber(BigInteger rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return rollNumber.toString();
    }
    // add the other necessary member methods here, A RollNumber object must always be immutable!
}
class RollNumberFetcher {
    public List<RollNumber> fetchRollNumbersList(List<Student> studentsList) {
        // TODO: COMPLETE THIS METHOD!
        List<RollNumber> rollNumbers = new ArrayList<>();
        for (Student s : studentsList) {
            rollNumbers.add(new RollNumber (fetchRollNumberFromStudent(s)));
        }

        return rollNumbers;
    }
    // create a method to fetch a roll number from a single student object, and prepend the year of joining as 19,
    // branch code as 150, then a 000, and then the roll number in the student object call it fetchRollNumberFromStudent
    public static BigInteger fetchRollNumberFromStudent(Student student) {
        BigInteger bg = new BigInteger("19150000" + student.getRollNumber().toString());
        return bg;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student st = new Student();
        List<Student> s = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter name : ");
            st.setName(sc.next());
            System.out.println("Enter the Roll no : ");
            st.setRollNumber(new RollNumber(BigInteger.valueOf(Long.parseLong(sc.next()))));
            s.add(st);
        }
        RollNumberFetcher rf = new RollNumberFetcher();
        System.out.println(rf.fetchRollNumbersList(s));
    }
}