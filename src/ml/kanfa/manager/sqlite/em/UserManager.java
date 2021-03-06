package ml.kanfa.manager.sqlite.em;

import ml.kanfa.entity.User;
import ml.kanfa.manager.sqlite.SQLiteManager;
import ml.kanfa.utils.dbutils.connection.AbstractConnection;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ibrahim Maïga.
 */
public class UserManager extends SQLiteManager<User> {

    public UserManager(AbstractConnection abstractConnection) {
        super(abstractConnection);
    }

    @Override protected boolean delete_impl(User object) {
        try{
            final PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setInt(1, object.getId());
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    @Override protected boolean add_impl(User object) {

        return false;
    }

    @Override protected boolean update_impl(User object) {

        return false;
    }

    @Override protected User find_impl(int id) {
        User user = new User();

        return user;
    }

    @Override protected List<User> findAll_impl() {
        List<User> users = new ArrayList<>();

        return users;
    }

    public User createUser(String username, char[] password) {
        User user = new User();
        return user;
    }

}
