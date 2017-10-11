package addressbookfx;

public class Person {
    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String zip;
    
    // Constructors
    public Person(String firstName, String lastName, String phone, String city, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.city = city;
        this.zip = zip;
    }
    
    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }
    public String getZIP() { return zip; }
    
    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCity(String city) { this.city = city; }
    public void setZIP(String zip) { this.zip = zip; }
}
