<%-- 
    Document   : index.jsp
    Created on : 19.11.2015, 15:41:34
    Author     : Ostap
--%>

<!--%@page import="serverDb.ServerDb"%-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="ConnectBean" class="serverDb.ConnectBean" />
<!--jsp:useBean id="ServerDb" class="serverDb.ServerDb"/>-->



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

            
            
//        ServerDb sdb;   

//            String strConn = "jdbc:postgresql://localhost:5432/bdoMarket";   //jdbc:postgresql://localhost/testdb
//            String login = "postgres";
//            String pwd = "sa";

//            sdb = new ServerDb(strConn, login, pwd);
            //sdb.getItems();
            //sdb.getRecept();
//            System.out.println("Подключение выполненно!");
                    
        %>
        
        
        
        
        
        
    </body>
</html>
