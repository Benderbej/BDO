<%-- 
    Document   : usersLogin
    Created on : 05.11.2015, 20:07:15
    Author     : Ostap

Модуль авторизации, делаю отдельно, чтобы можно было в разных местах сайта выводить. 
Этот модуль только для пользователей. Для нашего админского бекенда будет другой


--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<jsp:useBean id="UserAuthorisation" class="customBeans.UserAuthorisation">
<%
    /*сюда нужно будет подгрузить драйвер для коннекта с базой*/
    
  try {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  }
  catch (Exception e) {
    out.println(e.toString());
  }
%>
</jsp:useBean>
<jsp:setProperty name="UserAuthorisation" property="userName"/>
<jsp:setProperty name="UserAuthorisation" property="password"/>
<jsp:setProperty name="UserAuthorisation" property="connectionUrl" value="jdbc:odbc:JavaWeb"/>
<jsp:setProperty name="UserAuthorisation" property="sql"/>
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>Авторизуйтесь, пожалуйста</TITLE>
</HEAD>
<BODY>
<BR><H2>Авторизуйтесь, пожалуйста</H2>
<BR>Заполните поля логин и пароль для получения дополнительных возможностей сайта
<BR>
<BR><FORM METHOD=POST>
<INPUT TYPE=HIDDEN NAME=userName VALUE="<jsp:getProperty name="UserAuthorisation" property="userName"/>">
<INPUT TYPE=HIDDEN NAME=password VALUE="<jsp:getProperty name="UserAuthorisation" property="password"/>">
<TEXTAREA NAME=sql COLS=80 ROWS=8>
<jsp:getProperty name="theBean" property="sql"/>
</TEXTAREA>
<BR>
<INPUT TYPE=SUBMIT>
</FORM>
<BR>
<HR>
<BR>
<%= UserAuthorisation.getResult() %>
</BODY>
</HTML>