
public class EmptyAutosarFileException extends RuntimeException{
    private String msg;
    public EmptyAutosarFileException() {
    }

    public EmptyAutosarFileException(String message) {
        System.out.println(message);
        this.msg = message;
    }

    @Override
    public String toString() {
        return msg;
    }


}
