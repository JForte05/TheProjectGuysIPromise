package Exceptions;

/**
 * Represents an error in a file name.
 * <p>Ex. {@code .txt}
 */
public class IllegalFileNameException extends RuntimeException{
    protected String attemptedName;

    public IllegalFileNameException(String fileName){
        attemptedName = fileName;
    }

    @Override
    public void printStackTrace(){
        super.printStackTrace();

        System.err.printf("Cannot write file with name \"%s\"\n", attemptedName);   
    }
}
