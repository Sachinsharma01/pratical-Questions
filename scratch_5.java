import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private Grade grade;
    // add the other necessary member methods here

    public Student(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }
}
class Grade {
    private List<Double> marksInFiveSubjects;
    private char grade;
    // add the other necessary member methods here
    // create a method to calculate the grade of a student from the marksInFiveSubjects list
    // if total marks is 100:'A', 99-90:'B', 89-80:'C', 79-70:'D', 69-60:'E', >=59:'F'
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

    public char getGrade() {
        return grade;
    }
}
class StudentsRecords {
    public List<Student> fetchToppersList(List<Student> studentsList) {
        // TODO: COMPLETE THIS METHOD!
        ArrayList<Student> toppersList = new ArrayList<>();
        for (Student s : studentsList) {
            if (s.getGrade().getGrade() == 'B' || s.getGrade().getGrade() == 'A')
                toppersList.add(s);
        }
        return toppersList;
    }
    // topper is a student who has scored at least a 'B' grade!
}
class Main {
     
}