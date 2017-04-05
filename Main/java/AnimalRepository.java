import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Gavin on 4/4/17.
 */
public class AnimalRepository {
    public Connection connection;

    public AnimalRepository(String jdbcUrl) throws SQLException{
        this.connection = DriverManager.getConnection(jdbcUrl);
    }




}
