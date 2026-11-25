import java.util.*;
public class AlertHistory {
    public void displayHistory(ArrayList<SOSAlert> alerts){
    
        
        int totalAlerts = alerts.size();
        int activeAlerts = 0;
        int resolvedAlerts = 0;

        for (SOSAlert a : alerts) {
            if(a.getStatus().equalsIgnoreCase("ACTIVE")){
                activeAlerts++;
            }
            else if(a.getStatus().equalsIgnoreCase("RESOLVED")){
                resolvedAlerts++;
            }
        }

        System.out.println("----------------------------------------------------------------\n" + //
                        "                  SOS ALERT HISTORY\n" + //
                        "----------------------------------------------------------------");

        System.out.println("Total Alerts    : " + totalAlerts);
        System.out.println("Active Alerts   : " + activeAlerts);
        System.out.println("Resolved Alerts : " + resolvedAlerts);

        System.out.printf("%-5s %-10s %-20s %-12s %-12s%n",
        "ID", "User ID", "Emergency Type", "Severity", "Status");

        if (alerts.isEmpty()) System.out.println("No SOS alerts found in history");
        for(SOSAlert a : alerts){
            System.out.printf("%-5d %-10d %-20s %-12s %-12s%n",
                a.getAlertId(),
                a.getUserId(),
                a.getEmergencyType(),
                a.getServerity(),
                a.getStatus());
            }

        System.out.println("----------------------------------------------------------------\n" + //
                        "\n" + //
                        "                 END OF ALERT HISTORY\n" + //
                        "----------------------------------------------------------------");

        
    }
}
