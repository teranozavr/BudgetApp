package teranozavr.helpers;

/**
 * Created by Admin on 29.09.2019.
 */
public class AuthData {
    private String login;
    private String password;

    public AuthData()
    {
        this.login = System.getProperty("login");
        this.password = System.getProperty("password");
        if(login==null){
            System.err.println("Set mvn property 'login' and 'password'");
            return;
        }
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }
}
