public class User {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;

    public User (int id, String name, String phoneNumber, String address){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId (){
        return id;
    }
    public String getName(){
        return name;
    }

    public String getphoneNumber(){
        return phoneNumber;
    }

    public String getAddress(){
        return address;
    }

    public void displayUser(){
        System.out.println("User ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getphoneNumber());
        System.out.println("Address: " + getAddress());
    }
}
