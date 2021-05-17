package CinemaTicket;

public class User {
    public int id;
    public int password;
    public String phoneNumber;
    public String name;

    public User(int id, String phoneNumber, String name,int password) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
