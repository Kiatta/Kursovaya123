package Service;

public class User {
    private String login;
    private String password;
    private String firstname;
    private String secondname;

    public User(String login, String password, String firstname, String secondname) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.secondname = secondname;
    }

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
}



