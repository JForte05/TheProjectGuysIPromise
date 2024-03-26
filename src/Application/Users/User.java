package Application.Users;
import java.io.File;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exceptions.IllegalFileExtensionException;
import Exceptions.MalformedJSONException;

public class User {
    private static Optional<IllegalFileExtensionException> validateFileName(String fileName){
        String[] nameParts = fileName.split("\\.");
        if (nameParts.length != 2 || !nameParts[1].equals("json")){
            return Optional.of(new IllegalFileExtensionException(fileName));
        }

        return Optional.empty();
    }
    private static final String FIRSTNAME_REGEX = "(?<=\"fname\": \")[\\w\\s]+(?=\",)";
    private static final String LASTNAME_REGEX = "(?<=\"lname\": \")[\\w\\s]+(?=\",)";
    private static final String DOB_REGEX = "(?<=\"date-of-birth\": \")[\\d-]{10}(?=\",)";


    private final String firstName;
    private final String lastName;
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

        Matcher fNameMatcher = Pattern.compile(FIRSTNAME_REGEX).matcher(content);
        Matcher lNameMatcher = Pattern.compile(LASTNAME_REGEX).matcher(content);
        Matcher dobMatcher = Pattern.compile(DOB_REGEX).matcher(content);
        
        if (!(fNameMatcher.find() && lNameMatcher.find() && dobMatcher.find())){
            throw new MalformedJSONException(dirs[dirs.length - 1], "fname", "lname", "date-of-birth");
        }

        return new User(fNameMatcher.group(), lNameMatcher.group(), LocalDate.parse(dobMatcher.group()));
    }
    private User(String firstName, String lastName, LocalDate dob){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dob;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public LocalDate getBirthdate(){
        return dateOfBirth;
    }

    public void save(){
        //write data to json file
        //Will write to LnameFname.json
    }
}
