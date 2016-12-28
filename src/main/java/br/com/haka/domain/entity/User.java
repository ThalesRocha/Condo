package br.com.haka.domain.entity;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: Tiago Magalhães
 * Date: 12/15/16
 * Time: 11:06 PM
 * <p/>
 * Responsabilidade:
 */
public class User {

    private String name;
    private String login;
    private String pass;
    //A unlocked user is a user that can book public areas
    private Boolean unlocked;

    private User(String name, String login, String pass, Boolean unlocked) {
        this.name = name;
        this.login = login;
        this.pass = pass;
        this.unlocked = unlocked;
    }

    public static User createUser(String name, String login, String pass, Boolean unlocked) {
        return new User(name, login, pass, unlocked);
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getUnlocked() { return unlocked; }

    public void setUnlocked(Boolean unlocked) { this.unlocked = unlocked; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        if (!name.equals(user.name)) return false;
        if (!pass.equals(user.pass)) return false;
        if (!unlocked.equals(user.unlocked)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + pass.hashCode();
        return result;
    }
}