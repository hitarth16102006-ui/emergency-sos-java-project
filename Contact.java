public class Contact {

    private String name;
    private String phonenumber;
    private String relationship;

    public Contact(String name, String phonenumber, String relationship){
        this.name = name;
        this.phonenumber = phonenumber;
        this.relationship = relationship;
    }

    public String getName(){
        return name;
    }
    public String getphonenumber(){
        return phonenumber;
    }
    public String getrelationship(){
        return relationship;
    }
}
