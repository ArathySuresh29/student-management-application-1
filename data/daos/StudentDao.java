package data.daos;

import logic.models.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);

    void remove(String idToRemove);

    List<Student> getAll();

    Student get(String id);
}
