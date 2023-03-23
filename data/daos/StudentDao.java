package data.daos;

import logic.models.Student;

public interface StudentDao {
    void add(Student student);

    void remove(Student student);

    Student[] getAll();

    Student get(String id);

    void sorting(int choiceForSorting);
}
