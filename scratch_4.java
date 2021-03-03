import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private Grade grade;
    private Long fatherContactNumber;
    // add the other necessary member methods here

    public Student(String name, Grade grade, Long fatherContactNumber) {
        this.name = name;
        this.grade = grade;
        this.fatherContactNumber = fatherContactNumber;
    }

    public Grade getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public Long getFatherContactNumber() {
        return fatherContactNumber;
    }
}
class Grade {
    private List<Double> marksInFiveSubjects;
    private char grade;
    // add the other necessary member methods here, grade must be immutable!
    // create a method to calculate the grade of a
    // student from the marksInFiveSubjects list
    // if total marks is 100:'A', 99-90:'B', 89-80:'C',
    // 79-70:'D', 69-60:'E', >=59:'F'

    public void setMarksInFiveSubjects(List<Double> marksInFiveSubjects) {
        this.marksInFiveSubjects = marksInFiveSubjects;
    }

    public char getGrade() {
        return grade;
    }

    public void calculateGrade() {
        double totalMarks = 0.0;
        for (Double i : marksInFiveSubjects) {
            totalMarks += i;
        }
        if (totalMarks == 100)
            grade = 'A';
        else if (totalMarks < 100 && totalMarks >= 90)
            grade = 'B';
        else if (totalMarks < 90 && totalMarks >= 80)
            grade = 'C';
        else if (totalMarks < 80 && totalMarks >= 70)
            grade = 'D';
        else if (totalMarks < 70 && totalMarks >= 60)
            grade = 'E';
        else
            grade = 'F';
    }
}
class StudentsRecords {
    public List<String> fetchNamesOfFailedStudents(List<Student> studentsList) {
        // TODO: COMPLETE THIS METHOD!
        List <String> list = new ArrayList<>();
        for (Student s : studentsList) {
            if (s.getGrade().getGrade() == 'F')
                list.add(s.getName() + ", " + s.getFatherContactNumber());
        }
        return list;
    }
    // append the fatherContactNumber after the name with a comma and a space
    // ex - Divyansh, 123465789
}
class Main {
    public static void main(String[] args) {
        Grade g = new Grade();
        StudentsRecords str = new StudentsRecords();

        List<Student> listOfStudent = new ArrayList<>();
        List<Double> marks = new ArrayList<>();

        marks.add(5.0);
        marks.add(5.0);
        marks.add(5.0);
        marks.add(5.0);
        marks.add(5.0);

        g.setMarksInFiveSubjects(marks);
        g.calculateGrade();
        Student s = new Student("Sachin Sharma", g, Long.parseLong("6005325257"));
        listOfStudent.add(s);
        System.out.println(str.fetchNamesOfFailedStudents(listOfStudent));
    }
}