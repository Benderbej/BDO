/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


            var htmlString = "krutoj recept";
            JQuery( ".material_icon" ).click(function() {
                alert("work");
                var htmlString = $( this ).html();
                alert("htmlString="+htmlString);
              $( "#recipe_info" ).text( htmlString );
            });