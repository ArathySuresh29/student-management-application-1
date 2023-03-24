package services.implementations;

import data.daos.StudentDao;
import data.daos.implementations.ArrayListStudentDao;
import logic.models.Student;
import services.StudentEntryService;

public class DaoStudentEntryService implements StudentEntryService {
    private final StudentDao studentDao;

    public DaoStudentEntryService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public void remove(String idToRemove) {
        studentDao.remove(idToRemove);
    }

    @Override
    public Student[] getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student get(String id) {
        return studentDao.get(id);
    }
}
