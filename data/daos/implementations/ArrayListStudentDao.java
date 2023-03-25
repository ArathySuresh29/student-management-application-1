package data.daos.implementations;

import data.daos.StudentDao;
import data.daos.exceptions.NoSuchStudentExist;
import logic.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

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
        Student studentToRemove=students.stream()
                .filter(s -> s.getId().equals(idToRemove))
                .findFirst().
                orElseThrow(() -> new NoSuchStudentExist(idToRemove));
       students.remove(studentToRemove);
    }

    @Override
    public List<Student> getAll() {
        return students.stream()
                .collect(Collectors.toList());

    }
    @Override
    public Student get(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchStudentExist(id));
    }


}
