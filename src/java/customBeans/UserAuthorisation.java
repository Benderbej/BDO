/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customBeans;

/**
 *
 * @author Ostap
 * 
 * механизм авторизации обычного пользователя будет здесь
 * 
 */


import java.sql.*;
import customClasses.StringEncoding;/* импортим класс для обработки строк*/

public class UserAuthorisation {
  private String sql = "";
  private String userName = "";
  private String password = "";
  private String connectionUrl;

  public String getSql() {
    return StringEncoding.encodeHtmlTag(sql);
  }

  public void setSql(String sql) {
    if (sql!=null)
      this.sql = sql;
  }

  public void setUserName(String userName) {
    if (userName!=null)
      this.userName = userName;
  }
  public String getUserName() {
    return StringEncoding.encodeHtmlTag(userName);
  }
  public void setPassword(String password) {
    if (password!=null)
      this.password = password;
  }
  public String getPassword() {
    return StringEncoding.encodeHtmlTag(password);
  }

  public void setConnectionUrl(String url) {
    connectionUrl = url;
  }
public String getResult() {
    if (sql==null || sql.equals(""))
      return "";
    StringBuffer result = new StringBuffer(1024);
    try {
      Connection con = DriverManager.getConnection(connectionUrl, userName, password);
      Statement s = con.createStatement();
      if (sql.toUpperCase().startsWith("SELECT")) {
        result.append("<TABLE BORDER=1>");
        ResultSet rs = s.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
        // Write table headings
        int columnCount = rsmd.getColumnCount();
        result.append("<TR>");
        for (int i=1; i<=columnCount; i++) {
          result.append("<TD><B>" + rsmd.getColumnName(i) + "</B></TD>\n");
        }
        result.append("</TR>");
        while (rs.next()) {
          result.append("<TR>");
          for (int i=1; i<=columnCount; i++) {
            result.append("<TD>" + StringEncoding.encodeHtmlTag(rs.getString(i)) + "</TD>" );
          }
          result.append("</TR>");
        }
        rs.close();
        result.append("</TABLE>");
      }
      else {
        int i = s.executeUpdate(sql);
        result.append("Record(s) affected: " + i);
      }
      s.close();
      con.close();
      result.append("</TABLE>");
    }
    catch (SQLException e) {
      result.append("<B>Error</B>");
      result.append("<BR>");
      result.append(e.toString());
    }
    catch (Exception e) {
      result.append("<B>Error</B>");
      result.append("<BR>");
      result.append(e.toString());
    }

    return result.toString();
  }
}