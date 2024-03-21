import java.io.File;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import Exceptions.IllegalFileExtensionException;

public class User {
    private static Optional<IllegalFileExtensionException> validateFileName(String fileName){
        String[] nameParts = fileName.split("\\.");
        if (nameParts.length != 2 || !nameParts[1].equals("json")){
            return Optional.of(new IllegalFileExtensionException(fileName));
        }

        return Optional.empty();
    }
    private static final String NAME_REGEX = "(?<=\"name\": \")[\\w\\s]+(?=\",)\"";
    private static final String DOB_REGEX = "(?<=\"date-of-birth\": \")[\\d-]{10}(?=\",)\"";


    private final String name;
    private final LocalDate dateOfBirth;

    public static User loadFromFile(String filepath) throws Exception{
        String[] dirs = filepath.split("\\/");
        var validity = validateFileName(dirs[dirs.length - 1]);

        //Illegal file extension
        if (validity.isPresent()){
            throw validity.get();
        }
        
        String content = "";
        
        try (Scanner sc = new Scanner(new File(filepath));) {
            while (sc.hasNextLine()){
                content += sc.nextLine();
            }
        } catch (Exception e) {
            throw e;
        }

        //Parse content

        return null;
    }

    private User(String name, LocalDate dob){
        this.name = name;
        this.dateOfBirth = dob;
    }

    public void save(){
        //write data to json file
    }
}
