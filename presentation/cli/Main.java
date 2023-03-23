package presentation.cli;

import data.daos.exceptions.NoSuchStudentExist;
import data.daos.exceptions.StudentWithSameIdException;
import data.daos.implementations.ArrayListStudentDao;
import logic.models.Student;
import services.StudentEntryService;
import services.implementations.DaoStudentEntryService;

import java.util.*;


public class Main {

    public static final int NO_MENU_ITEM = 0;
    public static final int ADD_STUDENT = 1;
    public static final int UPDATE_STUDENT = 2;
    public static final int SHOW_STUDENTS = 3;
    public static final int DELETE_STUDENT = 4;

    public static final int SORT_STUDENT = 5;
    public static final int EXIT = 6;

    public static void main(String[] args) {
        int choice = NO_MENU_ITEM;
        StudentEntryService studentEntryService = new DaoStudentEntryService(new ArrayListStudentDao());
        Menu menu = new Menu();

        while (choice != EXIT) {
            System.out.println();
            menu.display();
            System.out.print("Enter your choice:");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case ADD_STUDENT:
                    Student student = new Student();
                    System.out.print("Enter Student ID: ");
                    student.setId(new Scanner(System.in).nextLine());
                    System.out.print("Enter Student First Name: ");
                    student.setFirstName(new Scanner(System.in).nextLine());
                    System.out.print("Enter Student Last Name: ");
                    student.setLastName(new Scanner(System.in).nextLine());
                    try {
                        studentEntryService.add(student);
                    } catch (StudentWithSameIdException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case UPDATE_STUDENT:
                    System.out.print("Enter Student ID: ");
                    String id = new Scanner(System.in).nextLine();
                    Student oneStudent = studentEntryService.get(id);
                    System.out.print("Enter Student First Name: ");
                    oneStudent.setFirstName(new Scanner(System.in).nextLine());
                    System.out.print("Enter Student Last Name: ");
                    oneStudent.setLastName(new Scanner(System.in).nextLine());

                    break;
                case SHOW_STUDENTS:
                    System.out.println("Id, First Name, Last Name");
                    for (Student s : studentEntryService.getAll()) {

                        System.out.println(s.getId() + ", " + s.getFirstName() + ", " + s.getLastName());
                    }
                    break;
                case DELETE_STUDENT:
                    System.out.print("Enter Student ID: ");
                    String idToDelete = new Scanner(System.in).nextLine();
                    try {
                        Student studentToDelete = studentEntryService.get(idToDelete);
                        studentEntryService.remove(studentToDelete);
                    } catch (NoSuchStudentExist e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case SORT_STUDENT:
                    System.out.println("For Which Field You Want To Apply Sorting\n");
                    System.out.println("1. Id");
                    System.out.println("2. First Name");
                    System.out.println("3. Last Name");
                    System.out.print("Enter your choice for sorting:");
                    int choiceForSorting = new Scanner(System.in).nextInt();
                       studentEntryService.sorting(choiceForSorting);
                    break;

                case EXIT:
                    System.out.println("Exiting...");
                    break;

            }
        }
    }
}
