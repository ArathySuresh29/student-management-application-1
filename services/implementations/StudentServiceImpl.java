package services.implementations;

import data.daos.StudentDao;
import logic.models.Student;
import services.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
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
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student get(String id) {
        return studentDao.get(id);
    }
}
