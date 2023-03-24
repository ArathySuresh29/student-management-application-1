package services;

import logic.models.Student;

public interface StudentService {
    void add(Student student);

    void remove(String idToRemove);

    Student[] getAll();

    Student get(String id);
}
