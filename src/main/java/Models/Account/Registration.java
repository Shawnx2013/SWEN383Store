package Models.Account;

public class Registration {

    private String name;
    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String home;
    private String mobile;

    public Registration(String name, String email, String password, String addr, String city, String state, String zip, String home, String mobile){
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = addr;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.home = home;
        this.mobile = mobile;
    }

    @Override
    public String toString(){
        return "Registration{" +
                "name=" + name +
                ", email=" + email +
                ", password=" + password +
                ", address=" + address +
                ", city=" + city +
                ", state=" + state +
                ", zip=" + zip +
                ", home=" + home +
                ", mobile=" + mobile + '}';
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return home;
    }

    public String getMobilePhone() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {return city;}

    public String getState() {return state;}

    public String getZip() {return zip;}

    public void setName(String name) {
        this.name = name;
    }

    public void setHomeAddr(String homeAddr) {
        this.address = homeAddr;
    }

    public void setHomePhone(String homePhone) {
        this.home = homePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobile = mobilePhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {this.city = city;}

    public void setState(String state) {this.state = state;}

    public void setZip(String zip) {this.zip = zip;}

}
