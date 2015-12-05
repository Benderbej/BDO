
package serverDb;

import serverDb.Constatnts;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;


public class ServerDbPool implements Constatnts {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    protected Connection conn;
    private Statement st;
    private String sql;
    private ResultSet rs;
    public ResultSet rsClientFind;
    public String err = "";

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public ServerDbPool() {
        if (connect() != Constatnts.READY) {
            JOptionPane.showMessageDialog(null, "Не удается устрановить соединение с базой", "Внимание", 0);
        }
        System.out.println("SERVERDbPool: constructor");
    }

    @Override
    public int connect() {
        System.out.println("SERVERDbPool: connect");

            try {
                InitialContext initContext = new InitialContext();
                    try {
                        DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/postgres");//                         
                            try {
                                conn = ds.getConnection();
                            } catch (SQLException ex) {
                                Logger.getLogger(ServerDbPool.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println("SERVERDbPool: connect(): getConnection()");
                                
                            }          
                    } catch (NamingException ex) {
                        System.out.println("SERVERDbPool: connect(): lookup()");
                    }
            } catch (NamingException ex) {
                System.out.println("SERVERDbPool: connect(): InitialContext()");
            }      
        
        System.out.println("ok good connection with DATABASE");
        return Constatnts.READY;
    }
    
    @Override
    public int connect(String[] args) {
        if (this.connect() == Constatnts.ERROR) {
            return Constatnts.ERROR;
        }
        return Constatnts.READY;        
    }

    public int insertDb(String sql) {
        int rezult = 0;
        try {
            st = conn.createStatement();
            rezult = st.executeUpdate(sql);
            st.close();
        } catch (SQLTimeoutException ex) {
            System.out.println("SERVERDbPool:insertDb():Error connecting od creating Statement - " + ex + " sql: " + sql);
        } catch (SQLException ex) {
            System.out.println("SERVERDbPool:insertDb():Error connecting od creating Statement - " + ex + " sql: " + sql);
        }
        return rezult;
    }

    public int updateDb(String sql) {
        int rezult = 0;
        try {
            st = conn.createStatement();
            rezult = st.executeUpdate(sql);
            st.close();
        } catch (SQLTimeoutException ex) {
            System.out.println("SERVERDbPool:updateDb():Error connecting od creating - " + ex + " sql: " + sql);
        } catch (SQLException ex) {
            System.out.println("SERVERDbPool:updateDb():Error connecting od creating - " + ex + " sql: " + sql);
        }
        return rezult;
    }

    public ResultSet selectDb(String sql) {
        try {
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//Делаем многонаправленный ResultSet
            rs = st.executeQuery(sql);                
        } catch (SQLException ex) {
            System.out.println("SERVERDbPool:selectDb():Error connecting od creating Statement - " + ex + " sql: " + sql);
        }
        return rs;
    }

    public ResultSet getItems(){
        return selectDb("SELECT \"idItem\", \"nameItem\", type1, type2, \"idTipDobich\", \"intItemGroup\",\"refPicture\" FROM public.\"sItems\"");
    }
    
    public ResultSet getRecept(){
        return selectDb("SELECT \"rec\".\"nameItem\" AS \"Рецепт\",\"sItems\".\"nameItem\" AS \"Составляющее\" FROM public.\"dRecept\", public.\"dReceptSostav\",  public.\"sItems\" as \"rec\", public.\"sItems\" WHERE \"dReceptSostav\".idrecept = \"dRecept\".idrecept AND \"rec\".\"idItem\" = \"dRecept\".iditem AND \"sItems\".\"idItem\" = \"dReceptSostav\".iditem ORDER BY \"rec\".\"nameItem\"");
    }

    @Override
    public int disconnect() {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerDbPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constatnts.DISCONNECT;
    }

}