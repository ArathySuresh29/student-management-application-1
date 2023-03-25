package services;

import logic.models.Student;

import java.util.List;

public interface StudentService {
    void add(Student student);

    void remove(String idToRemove);

    List<Student> getAll();

    Student get(String id);
}
