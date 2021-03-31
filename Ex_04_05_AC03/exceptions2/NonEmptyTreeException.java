package exceptions2;

@SuppressWarnings("serial")
public class NonEmptyTreeException extends RuntimeException{
    public NonEmptyTreeException(String err) { super(err); }
}
