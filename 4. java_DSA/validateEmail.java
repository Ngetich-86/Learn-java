//good email: gideonkngetich@gmail.com
// - has @ symbol
// - has atleast 1 char before @ symbol 
// - has a lenght of above 2 char
// - dot symbol for domain
// -- note that email has two parts the local naming part and domain part


//invalid email: gideon.gmail.com

public class ValidateEmail{
    public static boolean isEmailValid(String email){
        //check if it has @ 
        if(!email.contains("@")){
            return false;
        }
        // check if email has 2 paths separated by the @ symbol
        String[] parts = email.split("@");
        if(parts.length != 2){
            return false;
        }
        // local naming and domain part 
        String local = parts[0];
        String domain = parts[1];
        // local part nameing should not be empty
        if(local.length() == 0){
            return false;
        }
        // domain part must contain .
        if(!domain.contains(".")){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(isEmailValid("gkngetch.com"));
    }
}

// practise test 1
//good email: gideonkngetich@gmail.com
// - has @ symbol
// - has atleast 1 char before @ symbol 
// - has a lenght of above 2 char
// - dot symbol for domain
// -- note that email has two parts the local naming part and domain part
//invalid email: gideon.gmail.com

public class Test{
    public static boolean isEmailTest(String email) {
        if(email.contains("@")){
            return false;
        }
        // split email to two parts domain and local part
        String[] parts = email.split("@");
        if(parts.length != 2){
            return false;
        }
        String local = parts[0];
        String domain = parts[1];

        if(local.length() == 0){
            return false;
        }
        if(!domain.contains(".")){
            return false;
        }
        return true;
    }
}
