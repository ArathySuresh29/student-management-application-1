package services;

import logic.models.Student;

public interface StudentEntryService {
    void add(Student student);

    void remove(Student student);

    Student[] getAll();

    Student get(String id);

    void sorting(int choiceForSorting);
}
