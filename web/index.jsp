<%-- 
    Document   : index
    Created on : 07.12.2015, 20:50:33
    Author     : Ostap
--%>  



<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="serverDb.ServerDb"%>
<%@page import="backend.BaseData"%>
<!--%@page import="serverDb.ServerDb"%-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="ConnectBean" class="serverDb.ConnectBean" />
<jsp:useBean id="RecipeListWidget" class="widgets.RecipeListWidget"/>
<jsp:useBean id="BaseData" class="backend.BaseData"/>


<%! public void jspInit() {   
    
    
    
    
    BaseData bsdt = new BaseData();
    bsdt.setInfo("informacia");
    ServletContext context = this.getServletContext();
    context.setAttribute("baseData", bsdt);

 
    
    String strConn = "jdbc:postgresql://localhost/bdoMarket";
    String login = "postgres";
    String pwd = "sa";
    ServerDb sdb = new ServerDb(strConn, login, pwd);
    
    
                   
            ResultSet rs = sdb.getItems();  
            
                String it;
                String res = "";
                int i = 0;
                try {
                    rs.first();
                    while(rs.next()){
                        it = new String(rs.getString(1));//new String
                        i++;
                        res = res + " " + it;
                    }
                //sdb.getRecept();
                } catch (SQLException ex) {
                    System.out.println("index.jsp: jspInit(): SQLException");
                }
 
            
            
            //sdb.getItems();
            //sdb.getRecept(); 
    
    
    
 }  
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="/calculation/design/main.js"></script>
        <script type="text/javascript" language="JavaScript">
            $(document).ready(function() {
                var htmlString = "krutoj recept";
                $(".material_icon").click(function() {
                    //alert("work");
                    var htmlString = $(this).find(".recipe_name").html();
                    
                    //alert("htmlString=" + htmlString);
                  $("#recipe_info_content").text(htmlString);
                });
            });
        </script>

        <link type="text/css" rel="stylesheet" href="/calculation/design/main.css"/>
        <title>BDO calculation</title>
        
    </head>
    <body>

        <div id="main_block">
            <h1>BDO calculation</h1>
            <div class="materials_list">
                <div class="material_icon"><span class="recipe_name">1recipe</span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name">2recipe</span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name">3recipe</span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name">4recipe</span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
                <div class="material_icon"><span class="recipe_name"></span><img src="/calculation/design/00009267.png"></div>
            </div>
            
            <div id="recipe_info">
                <div id="recipe_info_name"><h1>RECIPE NAME=</h1></div>
                <div id="recipe_info_content">
                    netu recepta
                </div>
            </div>
            
        </div>        

        
                
        
        
        <%
            
            
          
            
            
            int i=4;
            int j= ConnectBean.intfunc(4);
            out.print("j="+j);

            
            ServletContext context = this.getServletContext();
            BaseData bsdt = (BaseData) context.getAttribute("baseData");

            
            String info;
            info = bsdt.getInfo();
            out.println("<hr /><h1>stringinfo</h1>");
            out.println("string="+info);
            
            
            
            
//                String strConn = "jdbc:postgresql://localhost/bdoMarket";
//                String login = "postgres";
//                String pwd = "sa";
//                ServerDb sdb = new ServerDb(strConn, login, pwd);
/*                ServerDbPool sdb = new ServerDbPool();                 
                
                ResultSet rs = sdb.getItems();
                
            out.println("Подключение2:");                 
                String it;
                String res = "";
                int i = 0;
                try {
                    rs.first();
                    while(rs.next()){
                        it = new String(rs.getString(1));//new String
                        i++;
                        res = res + " " + it;
                    }
                out.print(res);
                //sdb.getRecept();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectDbBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            out.println("Подключение выполнено!");   */
                    
         
           
            
            
        %>        
        
        
       
        
        
            
end

    </body>
</html>
