import java.util.*;

public class AlertManager {

    private ArrayList<SOSAlert> alerts = new ArrayList<SOSAlert>();

    private int nextAlertId = 1;

    public void createAlert(int userId, String emergencyType, String location, String emergencyMessage, String serverity, ContactManager contacts){
        SOSAlert a1 = new SOSAlert(nextAlertId, userId, emergencyType, location, emergencyMessage, serverity);

        alerts.add(a1);

        nextAlertId++;
        System.out.println("--------------------------------------------------\n" + 
                        "              SOS ALERT CONFIRMATION\n" + 
                        "--------------------------------------------------");

        a1.displayAlert();
        contacts.simulateNotifications(a1.getAlertId());
        System.out.println("--------------------------------------------------\n" + //
                        "       SOS ALERT CREATED SUCCESSFULLY\n" + //
                        "--------------------------------------------------");

    }

    public void findAlertById(int alertId){
        for(SOSAlert s : alerts){
            if(s.getAlertId() == alertId){
                System.out.println("--------------------------------------------------\n" + //
                                        "                 ALERT FOUND\n" + //
                                        "--------------------------------------------------");
                s.displayAlert();
                System.out.println("--------------------------------------------------");
                return ;
            }
        }
        System.out.println("--------------------------------------------------\n" + //
                        "                 ALERT NOT FOUND\n" + //
                        "--------------------------------------------------");
    }

    public void resolveAlertById(int alertId){
        for(SOSAlert s : alerts){
            if(s.getAlertId() == alertId){
                System.out.println("--------------------------------------------------\n" + //
                                        "               ALERT STATUS\n" + //
                                        "--------------------------------------------------");
                if(s.getStatus().equalsIgnoreCase("RESOLVED")){
                    String currentStatus = s.getStatus();
                    System.out.println("Alert ID        : " + alertId);
                    System.out.println("Current Status :" + currentStatus);
                    System.out.println("This SOS alert has already been resolved.\n" + //
                                                "--------------------------------------------------");
                    return ;
                }
                else{
                    String previousStatus = s.getStatus();
                    System.out.println("Alert ID        : " + alertId);
                    System.out.println("Previous Status : " + previousStatus);
                    s.resolveAlert();
                    System.out.println("Current Status  : " + s.getStatus());
                    System.out.println("              SOS ALERT RESOLVED SUCCESSFULLY!              ");
                    System.out.println("--------------------------------------------------");
                    return ;
                }
                
            }
        }
        System.out.println("--------------------------------------------------\n" + //
                        "                 ALERT NOT FOUND\n" + //
                        "--------------------------------------------------");
    }
    AlertHistory history = new AlertHistory();
    public void showAlertHistory(){
        history.displayHistory(alerts);
    }
}