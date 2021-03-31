package exceptions2;

@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException{
    public InvalidPositionException(String err) { super(err); }
}
