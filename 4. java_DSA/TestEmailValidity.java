

// List<String> validEmails = new ArrayList<>();

// for (String email : emails) {
//     if (!email.contains("@")) {
//         validEmails.add(email);
//     }
// }

// Filtering Logic Bug

import java.util.*;

public class TestEmailValidity {
    public static  List emailList(String[] emails) {
        List<String> validEmails = new ArrayList<>();
        // loop thru the email list with edge cases
        for(String email: emails){
            if(!email.contains("@")) {
                return false;
            }
            // split email into two parts
            String[] parts = email.split("@");
            // part 1 local 
            String local = parts[0];
            if(local.length() < 0) {
                return false;
            }
            // part 2 domain part
            String domain = parts[1];
            if(domain.length() < 0 && !domain.contains(".")) {
                return false;
            }
            validEmails.add(email);
        }
        return ArrayList(validEmails);
    }
    
}