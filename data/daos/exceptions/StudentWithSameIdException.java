package data.daos.exceptions;

public class StudentWithSameIdException extends RuntimeException {
    public StudentWithSameIdException(String newStudentId) {
        super("Student with same id already exists : " +  newStudentId + " Try with valid student id");
    }
}
