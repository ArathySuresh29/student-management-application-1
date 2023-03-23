package data.daos.implementations;

import data.daos.StudentDao;
import data.daos.exceptions.NoSuchStudentExist;
import data.daos.exceptions.StudentWithSameIdException;
import logic.models.Student;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class ArrayListStudentDao implements StudentDao {
    private final ArrayList<Student> students;

    public ArrayListStudentDao() {
        students = new ArrayList<>();
    }

    @Override
    public void add(Student newStudent) {
                 students.stream()
                .filter(student -> student.getId().equals(newStudent.getId()))
                .findFirst()
                .ifPresent(student -> {
                    throw new StudentWithSameIdException("Student with same id already exists : " +  newStudent.getId());
                });
        students.add(newStudent);
    }

    @Override
    public void remove(Student student)throws NoSuchStudentExist {
        students.remove(student) ;
    }

    @Override
    public Student[] getAll() {
        return students.toArray(new Student[students.size()]);
    }

    @Override
    public Student get(String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElseThrow(() -> new NoSuchStudentExist(id));
    }

    @Override
    public void sorting(int choiceForSorting) {
        if (choiceForSorting == 1) {
           Collections.sort(students, Comparator.comparing(Student::getId));
           for (Student student : students) {
               System.out.println( student.getId()+" " +student.getFirstName() + " " + student.getLastName());
           }

        } else if (choiceForSorting == 2) {
            Collections.sort(students, Comparator.comparing(Student::getFirstName));
            for (Student student : students) {
                System.out.println( student.getId()+" " +student.getFirstName() + " " + student.getLastName());
            }
        } else if (choiceForSorting == 3) {
            Collections.sort(students, Comparator.comparing(Student::getLastName));
            for (Student student : students) {
                System.out.println( student.getId()+" " +student.getFirstName() + " " + student.getLastName());
            }
        }
    }


}
