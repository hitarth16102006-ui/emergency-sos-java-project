import java.time.*;
import java.time.format.DateTimeFormatter; 

public class SOSAlert {

    private int alertId;
    private int userId;
    private String emergencyType;
    private String location;
    private String emergencyMessage;
    private String serverity;   
    private String status;
    private LocalDateTime timeStamp;

    public SOSAlert(int alertId, int userId, String emergencyType, String location, String emergencyMessage, String serverity){
        this.alertId = alertId;
        this.userId = userId;
        this.emergencyType = emergencyType;
        this.location = location;
        this.emergencyMessage = emergencyMessage;
        this.serverity = serverity;
        this.status = "ACTIVE";
        this.timeStamp = LocalDateTime.now();
    }

    public int getAlertId(){
        return alertId;
    }
    public int getUserId(){
        return userId;
    }
    public String getEmergencyType(){
        return emergencyType;
    }
    public String getLocation(){
        return location;
    }
    public String getStatus(){
        return status;
    }
    public String getEmergencyMessage(){
        return emergencyMessage;
    }
    public String getServerity(){
        return serverity;
    }
    public LocalDateTime getTimeStamp(){
        return timeStamp;
    }

    public void resolveAlert(){
        status = "RESOLVED";
    }

    public void displayAlert(){
        System.out.println("ALERT INFORMATION");
        System.out.println("Alert ID     :" + getAlertId());
        System.out.println("User Id      :" + getUserId());
        System.out.println("Emergency type  :" + getEmergencyType());
        System.out.println("Location     :" + getLocation());
        System.out.println("Severity     :" + getServerity());
        System.out.println("Status       :" + status);
        System.out.println("EMERGENCY MESSAGE");
        System.out.println(getEmergencyMessage());
        System.out.println("DATE & TIME");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy | hh:mm a");

        System.out.println(timeStamp.format(formatter));

        
    }
    
}