import java.util.*;

public class UserManager {
    private ArrayList<User> users = new ArrayList<User>();

    public void registerUser(int id, String name, String phoneNumber, String address){
        if (id <= 0 || name.isBlank() || address.isBlank() || !phoneNumber.matches("[0-9]{10}")) {
            System.out.println("Invalid user details. Enter a positive ID, name, address and 10-digit phone number.");
            return;
        }
        User u1 = new User(id, name, phoneNumber, address);

        for(User u : users){
            if(u.getId() == u1.getId()){
                System.out.println("User already exists!!");
                return ;
            }
        }

        users.add(u1);

        System.out.println("New User registered!!");

    }

    public void findUserById(int searchById){

        for (User u : users) {
            if(u.getId() == searchById){
                System.out.println("User " + searchById + " found!!");
                u.displayUser();
                return ;
            }
        }    
        System.out.println("User " + searchById + " not found!!");
    }
    public boolean userExists(int id) {
        for (User u : users) if (u.getId() == id) return true;
        return false;
    }
}
