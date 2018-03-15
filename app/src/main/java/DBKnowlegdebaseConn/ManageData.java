package DBKnowlegdebaseConn;

/**
 * Created by Michel on 17/10/17.
 */

public class ManageData {

    public String userkey, email, username, password;

    public ManageData() {
    }


    public ManageData(String userkey, String email, String username, String password) {
        super();

        this.userkey = userkey;
        this.username = username;
        this.email = email;
        this.password = password;

    }


    public String getUserkey() { return userkey; }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() { return password; }
}