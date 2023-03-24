package services;

import logic.models.Student;

public interface StudentEntryService {
    void add(Student student);

    void remove(String idToRemove);

    Student[] getAll();

    Student get(String id);
}
