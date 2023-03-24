package data.daos;

import logic.models.Student;

public interface StudentDao {
    void add(Student student);

    void remove(String idToRemove);

    Student[] getAll();

    Student get(String id);
}
