package Account;

abstract class Acc{
    protected String name;
    protected String homeAddr;
    protected String homePhone;
    protected String mobilePhone;
    protected String email;
    protected int custID;
    protected int lateCharge;

    public String getName() {
        return name;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public int getCustID() {
        return custID;
    }

    public int getLateCharge() {
        return lateCharge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String firstname, String lastname){
        this.name = firstname + " " + lastname;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public void setLateCharge(int lateCharge) {
        this.lateCharge = lateCharge;
    }
}
