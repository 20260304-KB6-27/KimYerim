package basic.lecture;

public class Application {
    public static void main(String[] args) {
        Student student = new Student("yerim", Grade.A);

        System.out.println(student.grade.getDescription());
    }
}
