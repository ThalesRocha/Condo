package br.com.haka.domain.repository;

import br.com.haka.domain.entity.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: Tiago Magalhães
 * Date: 12/15/16
 * Time: 11:02 PM
 * <p/>
 * Responsabilidade:
 */
@Repository
public class Users {

    private List<User> users;

    public Users() {
        this.users = new ArrayList<User>();
    }

    public boolean add(User user){
        return this.users.add(user);
    }

    public boolean remove(User user){
        if ( users.contains(user) )
            return this.users.remove(user);

        return false;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User findByLogin(String login) {
        for (User user:this.users){
            if( user!=null && login!=null && user.getLogin().equals(login))
                return user;
        }
        return null;
    }
}
