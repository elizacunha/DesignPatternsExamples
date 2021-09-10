package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

/*
 * The sample demonstrates connecting to Autonomous Database using 
 * Oracle JDBC driver and UCP as a client side connection pool.
 */
public class ConnectionFactory {
	private static final String DB_URL = "jdbc:oracle:thin:@dbbarao_medium?TNS_ADMIN=/home/eliza/oracleDB/drivers/wallet_DBBARAO/";
	private static final String DB_USER = "aluno";
	private static final String DB_PASSWORD = "Baraouga2buga123";
	private static final String CONN_FACTORY_CLASS_NAME = "oracle.jdbc.pool.OracleDataSource";
	private static PoolDataSource pds = null;
	
	public Connection getConnection() {
		try {
			Connection conn = null;
			if (pds != null) {
				pds = PoolDataSourceFactory.getPoolDataSource();
	
				// Set the connection factory first before all other properties
				pds.setConnectionFactoryClassName(CONN_FACTORY_CLASS_NAME);
				pds.setURL(DB_URL);
				pds.setUser(DB_USER);
				pds.setPassword(DB_PASSWORD);
				pds.setConnectionPoolName("JDBC_UCP_POOL");
				pds.setInitialPoolSize(5);
				pds.setMinPoolSize(5);
				pds.setMaxPoolSize(20);
			}
			conn = pds.getConnection();
			conn.setAutoCommit(false);
			System.out.println("Conexão aberta");
			
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void performSQLCommand(Connection conn) throws Exception {
		String queryStatement = "SELECT SYSDATE FROM DUAL";
	    try {
	    	Statement statement = conn.createStatement(); 
	    	ResultSet resultSet = statement.executeQuery(queryStatement);
	        while (resultSet.next()) {
	          System.out.println(resultSet.getString(1));
	        }
	    	System.out.println("\nCongratulations! You have successfully used Oracle Autonomous Database\n");
	    } catch (SQLException e) {
	    	throw e;
	    }
	}
	
	public static void main(String args[]) {
		try {
			ConnectionFactory fac = new ConnectionFactory();
			Connection conn = fac.getConnection();
			fac.performSQLCommand(conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}