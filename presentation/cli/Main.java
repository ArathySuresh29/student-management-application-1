package presentation.cli;

import data.daos.implementations.ArrayListStudentDao;
import logic.models.Student;
import services.StudentService;
import services.implementations.StudentServiceImpl;
import java.util.Scanner;

public class Main {

    public static final int NO_MENU_ITEM = 0;
    public static final int ADD_STUDENT = 1;
    public static final int UPDATE_STUDENT = 2;
    public static final int SHOW_STUDENTS = 3;
    public static final int REMOVE_STUDENT = 4;
    public static final int EXIT = 5;

    public static void main(String[] args) {
        int choice = NO_MENU_ITEM;
        StudentService studentService = new StudentServiceImpl(new ArrayListStudentDao());
        Menu menu = new Menu();

        while (choice != EXIT) {
            System.out.println();
            menu.display();
            System.out.println("Enter your choice:");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case ADD_STUDENT:
                    Student student = new Student();
                    System.out.println("Enter Student ID:");
                    student.setId(new Scanner(System.in).nextLine());
                    System.out.println("Enter Student First Name:");
                    student.setFirstName(new Scanner(System.in).nextLine());
                    System.out.println("Enter Student Last Name:");
                    student.setLastName(new Scanner(System.in).nextLine());
                    studentService.add(student);
                    break;
                case UPDATE_STUDENT:
                    System.out.println("Enter Student ID:");
                    String id = new Scanner(System.in).nextLine();
                    Student oneStudent = studentService.get(id);
                    System.out.println("Enter Student First Name:");
                    oneStudent.setFirstName(new Scanner(System.in).nextLine());
                    System.out.println("Enter Student Last Name:");
                    oneStudent.setLastName(new Scanner(System.in).nextLine());
                    break;
                case SHOW_STUDENTS:
                    System.out.println("Id, First Name, Last Name");
                    for (Student s : studentService.getAll()) {

                        System.out.println(s.getId() + ", " + s.getFirstName() + ", " + s.getLastName());
                    }
                    break;
                case REMOVE_STUDENT:
                    System.out.println("Enter Student ID To Remove:");
                    String idToRemove = new Scanner(System.in).nextLine();
                    studentService.remove(idToRemove);
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    break;

            }
        }
    }
}
