package ml.kanfa.utils.dbutils.connection.mysql;

import ml.kanfa.parser.With_Authentication;
import ml.kanfa.parser.XMLParser;
import ml.kanfa.utils.dbutils.IUser;
import ml.kanfa.utils.dbutils.connection.AbstractConnection;
import ml.kanfa.utils.facade.MessageBox;
import ml.kanfa.utils.system.SystemUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Ibrahim Maïga.
 */

public abstract class AbstractMySQLConnection extends AbstractConnection {

    private static final String HOST = "host";
    private static final String USER = "user";
    private static final String PASS = "password";

    AbstractMySQLConnection(XMLParser parser){
        super();
        this.parser = parser;
    }


    @Override protected void loadLibrary() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    @Override protected void displayError() {
        MessageBox.showDialogBox("Impossible de se connecter à la base de données");
        SystemUtils.exit();
        if ((this instanceof IUser) && !this.fistConnection){
        }
    }

    @Override protected Connection getDriverManagerConnection() throws SQLException {
        return DriverManager.getConnection(
                ((With_Authentication)parser).get(HOST),
                ((With_Authentication)parser).get(USER),
                ((With_Authentication)parser).get(PASS)
        );
    }

}
