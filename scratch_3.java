import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Student {
    private StudentName name;
    private BigInteger rollNumber;
    // add the other necessary member methods here

    public Student(StudentName name, BigInteger rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return (name.getFirstName() + name.getLastName()).toString();
    }

    public StudentName getName() {
        return name;
    }

    public BigInteger getRollNumber() {
        return rollNumber;
    }
}
class StudentName {
    private String firstName;
    private String lastName;
    private String optionalMiddleName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOptionalMiddleName() {
        return optionalMiddleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setOptionalMiddleName(String optionalMiddleName) {
        this.optionalMiddleName = optionalMiddleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // add the other necessary member methods here, the name of a student can or cannot have a middle name, so adjust
    // the toString() method accordingly!
}
class StudentNamesFetcher {
    public List<String> fetchNamesList(List<Student> studentsList) {
        // TODO: COMPLETE THIS METHOD!
        var res = new ArrayList<String>();
        for (Student s : studentsList) {
            res.add(prependName(s));
        }
        return res;
    }
    // create a method to prepend a "Ms." before the name if
    // the name ends with an 'a', 'e', 'i', 'o' or 'u'
    // (i.e is a female name (INDIAN)) otherwise prepend a "Mr."
    public static String prependName(Student s) {
        String name = s.getName().getFirstName() + " " + s.getName().getOptionalMiddleName() +" " + s.getName().getLastName();
        System.out.println(name);
        if (name.endsWith("a") || name.endsWith("e") || name.endsWith("i") || name.endsWith("o") || name.endsWith("u"))
            return "Ms." + " " + name;
        else
            return "Mr." + " " + name;
    }
}
class Main {
    public static void main(String[] args) {
       StudentName st = new StudentName();
       st.setFirstName("Sachin");
       st.setLastName("Sharma");
       st.setOptionalMiddleName("Kumar");
       List<Student> l = new ArrayList<>();
       Student s = new Student(st, BigInteger.valueOf(191500688));
       l.add(s);
       StudentNamesFetcher stf = new StudentNamesFetcher();
        System.out.println(stf.fetchNamesList(l));
    }
}