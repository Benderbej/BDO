
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


public class ServerDb implements Constatnts {

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

    public ServerDb() {
        System.out.println("SERVERDb: default constructor without arguments");
    }    
    
    public ServerDb(String url, String user, String password) {
        if (connect(url, user, password) != Constatnts.READY) {
            JOptionPane.showMessageDialog(null, "Не удается устрановить соединение с базой", "Внимание", 0);
        }
        System.out.println("SERVERDb: constructor");
    }

    public int connect(String url, String user, String password) {

        try {
            try {
                    Class.forName("org.postgresql.Driver");     
                } catch(ClassNotFoundException e) {
                   e.printStackTrace();
                }
            conn = DriverManager.getConnection(url, user, password);//Подключаемся к баде данных
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//Делаем многонаправленный ResultSet
            System.out.println("SUCCESSFULLY connected with database!");
        } catch (SQLException ex) {
            System.out.println("ServerDb:connect(url, user, password):Error connecting od creatingе Statement - " + ex);
            return Constatnts.ERROR;
        }
        return Constatnts.READY;
    }

    @Override
    public int connect() {
        System.out.println("SERVERDb: connect");
        String[] args = {""};
        if (this.connect(args) == Constatnts.ERROR) {
            return Constatnts.ERROR;
        }
        return Constatnts.READY;
    }

    @Override
    public int connect(String[] args) {
        System.out.println("SERVERDb: connect");
        String url = args[0];//--Разбираем массив параметров
        String user = args[1];
        String password = args[2];
               
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerDb.class.getName()).log(Level.SEVERE, null, ex);
        }     
        try {
            conn = DriverManager.getConnection(url, user, password);//Подключаемся к баде данных
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//Делаем многонаправленный ResultSet
            System.out.println("SUCCESSFULLY connected with database!");
        } catch (SQLException ex) {
            System.out.println("ServerDb:connect(String[] args):Error connecting od creating Statement - " + ex);
            return Constatnts.ERROR;
        }
        
        System.out.println("ok good connection with DATABASE");
        return Constatnts.READY;
    }

    public int insertDb(String sql) {
        int rezult = 0;
        try {
            st = conn.createStatement();
            rezult = st.executeUpdate(sql);
            st.close();
        } catch (SQLTimeoutException ex) {
            System.out.println("ServerDb:insertDb():Error connecting od creating Statement - " + ex + " sql: " + sql);
        } catch (SQLException ex) {
            System.out.println("ServerDb:insertDb():Error connecting od creating Statement - " + ex + " sql: " + sql);
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
            System.out.println("ServerDb:updateDb():Error connecting od creating - " + ex + " sql: " + sql);
        } catch (SQLException ex) {
            System.out.println("ServerDb:updateDb():Error connecting od creating - " + ex + " sql: " + sql);
        }
        return rezult;
    }

    public ResultSet selectDb(String sql) {
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("ServerDb:selectDb():Error connecting od creating Statement - " + ex + " sql: " + sql);
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
            Logger.getLogger(ServerDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constatnts.DISCONNECT;
    }

}