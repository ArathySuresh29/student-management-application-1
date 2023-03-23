package data.daos.exceptions;

public class NoSuchStudentExist extends RuntimeException {
    public NoSuchStudentExist(String id) {
        super("No such student exist with id: " + id);
    }

}
