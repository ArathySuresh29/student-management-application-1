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
        students.remove(students.get(students.indexOf(get(idToRemove))));
    }

    @Override
    public Student[] getAll() {
        return students.toArray(new Student[students.size()]);
    }

    @Override
    public Student get(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        throw new NoSuchStudentExist(id);
    }

}
