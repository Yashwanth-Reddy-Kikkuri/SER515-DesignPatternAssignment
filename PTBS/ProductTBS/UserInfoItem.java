package SER515.ProductTBS;

public class UserInfoItem {

    private String name;
    private String pass;
    private int userType;

    public UserInfoItem(String name, String pass, int userType) {
        this.name = name;
        this.pass = pass;
        this.userType = userType;
    }

    public UserInfoItem() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

}
