import java.util.*;

public class ContactManager {

    private ArrayList<Contact> contacts = new ArrayList<>();
    
    public void addContacts(String name, String phonenumber, String relationship){
        if (name.isBlank() || relationship.isBlank() || !phonenumber.matches("[0-9]{10}")) {
            System.out.println("Invalid contact details. Enter a name, relationship and 10-digit phone number.");
            return;
        }
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name) || c.getphonenumber().equals(phonenumber)) {
                System.out.println("Contact already exists!");
                return;
            }
        }
        Contact c1 = new Contact(name, phonenumber, relationship);
        
        contacts.add(c1);

        System.out.println("Contact Successfully Added!!");
        }

        public void viewContacts(){

            if(contacts.isEmpty()){
                System.out.println("No Contact found!!");
                return ;
            }

            else{
                for(Contact c : contacts){
                    System.out.println(c.getName());
                    System.out.println(c.getphonenumber());
                    System.out.println(c.getrelationship());
                    
                }
            }
        }

        public void searchContact(String name){
            for(Contact c : contacts){
                if(c.getName().equalsIgnoreCase(name)){
                    System.out.println(c.getName());
                    System.out.println(c.getphonenumber());
                    System.out.println(c.getrelationship());
                    return;
                }
            }
            System.out.println("Contact not found!");
        }

        public void deleteContacts(String name) {

            Iterator<Contact> it = contacts.iterator();

            while (it.hasNext()) {

                Contact c = it.next();

                if (c.getName().equalsIgnoreCase(name)) {
                    it.remove();
                    System.out.println("Contact deleted successfully!");
                    return;
                }
            }

            System.out.println("Contact not found!");
        }



    public void simulateNotifications(int alertId) {
        System.out.println("SIMULATED CONTACT NOTIFICATIONS");
        if (contacts.isEmpty()) {
            System.out.println("No emergency contacts registered. Alert saved; no notifications simulated.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println("[SIMULATION] SMS and call to " + c.getName() + " (" + c.getphonenumber() + ") for alert " + alertId);
        }
        System.out.println("No real SMS or calls were made.");
    }
}
