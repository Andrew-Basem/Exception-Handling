

public class NotVaildAutosarFileException extends Exception {
    private String msg;
    public NotVaildAutosarFileException() {
    }

    public NotVaildAutosarFileException(String message) {
        System.out.println(message);
        this.msg = message;
    }

    @Override
    public String toString() {
        return msg;
    }
}
