package data.daos.implementations;

import data.daos.StudentDao;
import data.daos.exceptions.NoSuchStudentExist;
import logic.models.Student;

import java.util.ArrayList;

public class ArrayListStudentDao implements StudentDao {
    private final ArrayList<Student> students;

    public ArrayListStudentDao() {
        students = new ArrayList<>();
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void remove(String idToRemove) {
        studentToRemove=idToRemove;
        students.remove(students.stream()
                .filter(s -> s.getId().equals(studentToRemove))
                .findFirst().
                orElseThrow(() -> new NoSuchStudentExist(studentToRemove)));
    }

    @Override
    public Student[] getAll() {
        return students.toArray(new Student[students.size()]);
    }

    @Override
    public Student get(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchStudentExist(id));
    }


}
