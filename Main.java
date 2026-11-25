import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int User_Choice = 0;
        Map<Integer, ContactManager> contactManagers = new HashMap<>();
        UserManager Umanager = new UserManager();
        AlertManager sManager = new AlertManager();

        try {
        while(User_Choice != 11){
            System.out.println("Press 1 to Register User:");
            System.out.println("Press 2 to Find User:");
            System.out.println("Press 3 to Add Emergency Contact:");
            System.out.println("Press 4 to View All Contacts:");
            System.out.println("Press 5 to Search Contact:");
            System.out.println("Press 6 to Delete Contact:");
            System.out.println("Press 7 to Create SOS Alert:");
            System.out.println("Press 8 to Search SOS Alert:");
            System.out.println("Press 9 to Resolve SOS Alert:");
            System.out.println("Press 10 to View SOS Alert History:");
            System.out.println("Press 11 to Exit:");

            System.out.print("Enter your choice: ");
            User_Choice = readInt(sc);
        
            ContactManager manager = null;
            if (User_Choice >= 3 && User_Choice <= 6) {
                System.out.print("Enter Registered User ID: ");
                int ownerId = readInt(sc);
                if (!Umanager.userExists(ownerId)) {
                    System.out.println("User not found! Register the user first.");
                    continue;
                }
                manager = contactManagers.computeIfAbsent(ownerId, k -> new ContactManager());
            }
            switch (User_Choice){

                case 1:
                    System.out.println("--------------------------------------------------");
                    System.out.println("                USER REGISTRATION");
                    System.out.println("--------------------------------------------------");

                    System.out.print("Enter User ID: ");
                    int UserId = readInt(sc);


                    System.out.print("Enter Full Name: ");
                    String Name = sc.nextLine().trim();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = sc.nextLine().trim();

                    System.out.print("Enter Full Address: ");
                    String address = sc.nextLine().trim();

                    Umanager.registerUser(UserId, Name, phoneNumber, address);
                    break;
                
                case 2:
                    System.out.println("--------------------------------------------------");
                    System.out.println("                   FIND USER");
                    System.out.println("--------------------------------------------------");

                    System.out.print("Enter User ID: ");
                    int id = readInt(sc);

                    Umanager.findUserById(id);
                    break;

                case 3:
                    System.out.println("--------------------------------------------------");
                    System.out.println("              ADD EMERGENCY CONTACT");
                    System.out.println("--------------------------------------------------");


                    System.out.print("Enter Contact Full Name: ");
                    String name = sc.nextLine().trim();

                    System.out.print("Enter Contact Phone Number: ");
                    String phonenumber = sc.nextLine().trim();

                    System.out.print("Enter Relationship: ");
                    String relationship = sc.nextLine().trim();

                    manager.addContacts(name, phonenumber, relationship);
                    break;

                case 4:
                    System.out.println("--------------------------------------------------");
                    System.out.println("              EMERGENCY CONTACT LIST");
                    System.out.println("--------------------------------------------------");
                    manager.viewContacts();
                    break;

                case 5:
                    System.out.println("--------------------------------------------------");
                    System.out.println("              SEARCH EMERGENCY CONTACT");
                    System.out.println("--------------------------------------------------");


                    System.out.print("Enter Contact Name: ");
                    String SearchName = sc.nextLine().trim();

                    manager.searchContact(SearchName);
                    break;

                case 6:
                    System.out.println("--------------------------------------------------");
                    System.out.println("              DELETE EMERGENCY CONTACT");
                    System.out.println("--------------------------------------------------");

                    

                    System.out.print("Enter Contact Name to Delete: ");
                    String DeleteContact = sc.nextLine().trim();
                    System.out.print("Confirm deletion (yes/no): ");
                    if (!sc.nextLine().trim().equalsIgnoreCase("yes")) {
                        System.out.println("Deletion cancelled.");
                        break;
                    }

                    manager.deleteContacts(DeleteContact);
                    break;

                
                case 7: {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("                  CREATE NEW SOS ALERT                      ");
                    System.out.println("------------------------------------------------------------");

                    // USER INFORMATION
                    System.out.print("Enter Registered User ID: ");
                    int userId = readInt(sc);
                    if (!Umanager.userExists(userId)) {
                        System.out.println("User not found! Register the user first.");
                        break;
                    }

                    // EMERGENCY CATEGORY
                    System.out.println("------------------------------------------------------------");
                    System.out.println("EMERGENCY DETAILS");
                    System.out.println("Select Emergency Category:");
                    System.out.println("[1] Medical Emergency");
                    System.out.println("[2] Fire Emergency");
                    System.out.println("[3] Road Accident");
                    System.out.println("[4] Personal Safety");
                    System.out.println("[5] Other Emergency");

                    System.out.print("Enter your choice: ");
                    int emergencyChoice = readInt(sc);

                    String emergencyType = "";

                    switch (emergencyChoice) {
                        case 1:
                            emergencyType = "Medical Emergency";
                            break;
                        case 2:
                            emergencyType = "Fire Emergency";
                            break;
                        case 3:
                            emergencyType = "Road Accident";
                            break;
                        case 4:
                            emergencyType = "Personal Safety";
                            break;
                        case 5:
                            emergencyType = "Other Emergency";
                            break;
                        default:
                            System.out.println("Invalid Emergency Category!");
                            break;
                    }

                    if (emergencyChoice < 1 || emergencyChoice > 5) {
                        break;
                    }

                    // CLEAR LEFTOVER NEWLINE


                    // LOCATION AND MESSAGE
                    System.out.println("------------------------------------------------------------");
                    System.out.print("Enter Location: ");
                    String location = sc.nextLine().trim();

                    System.out.print("Enter Emergency Message: ");
                    String emergencyMessage = sc.nextLine().trim();

                    // SEVERITY SELECTION
                    System.out.println("------------------------------------------------------------");
                    System.out.println("SEVERITY LEVEL");
                    System.out.println("[1] LOW       [2] MEDIUM");
                    System.out.println("[3] HIGH      [4] CRITICAL");

                    System.out.print("Enter your choice: ");
                    int severityChoice = readInt(sc);

                    String severity = "";

                    switch (severityChoice) {
                        case 1:
                            severity = "LOW";
                            break;
                        case 2:
                            severity = "MEDIUM";
                            break;
                        case 3:
                            severity = "HIGH";
                            break;
                        case 4:
                            severity = "CRITICAL";
                            break;
                        default:
                            System.out.println("Invalid Severity Level!");
                            break;
                    }

                    if (severityChoice < 1 || severityChoice > 4) {
                        break;
                    }

                    sManager.createAlert(
                        userId,
                        emergencyType,
                        location,
                        emergencyMessage,
                        severity,
                        contactManagers.computeIfAbsent(userId, k -> new ContactManager())
                    );
                    break;
                }

                case 8:
                    System.out.println("--------------------------------------------------\n" + //
                                                "                SEARCH SOS ALERT\n" + //
                                                "--------------------------------------------------");

                    System.out.print("Enter Alert ID: ");
                    int SaID = readInt(sc);

                    sManager.findAlertById(SaID);
                    break;

                case 9:
                    System.out.println("--------------------------------------------------\n" + //
                                                "                 RESOLVE SOS ALERT\n" + //
                                                "--------------------------------------------------");
                    System.out.println("Enter Alert ID: ");
                    int RaID = readInt(sc);

                    sManager.resolveAlertById(RaID);
                    break;
                case 10:
                    sManager.showAlertHistory();
                    break;
                case 11:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        } catch (NoSuchElementException e) {
            System.out.println("Input ended. Exiting simulator.");
        }
        sc.close();
    }
    private static int readInt(Scanner sc) {
        while (sc.hasNextLine()) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a whole number: ");
            }
        }
        throw new NoSuchElementException("Input ended");
    }
}
