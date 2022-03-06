package connection;

import java.sql.*;

public class DataBaseConnection{
	public String username = "root";
    public String password = "123456";
    private String url="jdbc:mysql://localhost:3306/Student?useSSL=true&characterEncoding=utf-8";
    
    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);
   //         System.out.println("连接数据库成功.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    
    public void closeConn(ResultSet rs, PreparedStatement pstm, Connection conn) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}

	/*
    private final String DBDriver ="org.apache.derby.jdbc.ClientDriver";
    private final String DBURL ="jdbc:derby://localhost:1527/StudentDAO";
    private final String DBUSER ="classiccars";
    private final String DBPASSWORD ="classiccars";
    private Connection conn = null;
//构造器
    public DataBaseConnection(){
       try{
           Class.forName(DBDriver);
           conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
           }
        catch(Exception e){  }
                                 }

//获得连接
public Connection getConnection(){
return this.conn; }

//关闭连接
public void close() throws SQLException{
    this.conn.close(); }
} 
*/