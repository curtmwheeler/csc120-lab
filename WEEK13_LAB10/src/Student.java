public class Student {

    private String name;
    private int age;
    private String major;

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    } // End of constructor

    public String getName() {
        return this.name;
    } // End of getName()

    public int getAge() {
        return this.age;
    } // End of getAge()

    public String getMajor() {
        return this.major;
    } // End of getMajor()
} // End of Student class
