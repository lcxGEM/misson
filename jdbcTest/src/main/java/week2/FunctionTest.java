package week2;

public class FunctionTest {
    public static void main(String[] args) {
        FunctionDao fd = new FunctionDao();
        System.out.println(fd.sum());
        System.out.println(fd.sum(1,5));
        System.out.println(fd.average());
        System.out.println(fd.countUser());
        System.out.println(fd.countUserById(2,6));
        System.out.println(fd.countUserBySalary(6000.2));
        System.out.println(fd.maxSalary().toString());
        System.out.println(fd.minSalary().toString());
    }
}
