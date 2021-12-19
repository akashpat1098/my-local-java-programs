import java.util.Scanner;

class Student {
    void student(String n) {
        System.out.println("Name of student is:" + n);
    }
}

class RollNo extends Student {
    void rollno(int n) {
        System.out.println("RollNo of student is:" + n);
    }
}

class Div extends RollNo {
    void div(char n) {
        System.out.println("Division of student is:" + n);
    }
}

public class prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of student:");
        String n = sc.nextLine();
        System.out.println("Enter RollNo of student:");
        int m = sc.nextInt();
        System.out.println("Enter Division of student:");
        char o = sc.next().charAt(0);
        Div s = new Div();
        s.student(n);
        s.rollno(m);
        s.div(o);

    }

}