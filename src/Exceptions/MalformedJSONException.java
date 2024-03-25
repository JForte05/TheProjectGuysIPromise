package Exceptions;

public class MalformedJSONException extends RuntimeException{
    private final String fileName; 
    private final String[] expectedFields;

    public MalformedJSONException(String fileName, String... expectedFields){
        this.fileName = fileName;
        this.expectedFields = expectedFields;
    }

    @Override
    public void printStackTrace(){
        System.err.println("JSON file: " + fileName + " does not contain appropriate fields");
        System.err.println("Expected fields:");
        for (String s : expectedFields){
            System.err.println("\t" + s);
        }
        super.printStackTrace();
    }
}
