package server;

import ServletPack.CalcMinMax;
import ServletPack.Item;
import ServletPack.ItemList;
import ServletPack.Recipe;
import ServletPack.RecipeList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Core {

    private static ServerDb sdb;
    private final String strConn = "jdbc:postgresql://localhost:5432/bdoMarket";
    private final String login = "postgres";
    private final String pwd = "sa";
    private static RecipeList recipeList;
    private static ItemList itemList;
    private CalcMinMax calc;

    public CalcMinMax getCalc() {
        return calc;
    }

    public static RecipeList getRecipeList() {
        return recipeList;
    }

    public static ItemList getItemList() {
        return itemList;
    }

    public Core() {

        sdb = new ServerDb(strConn, login, pwd);
        sdb.getItems();
        sdb.getRecept();
    }

    public void init() {
        fillRecipesCollection();
        fillItemsCollection();
    }

    private void fillRecipesCollection() { /// НУЖНО СДЕЛАТЬ. разобраться с ResultSet-> коллекция
        int recipeId = -1;
        int itemResultId = -1;
        HashSet<Item> reagentsList = new HashSet<>();
        HashSet<Integer> itemQuantity = new HashSet<>();

        ResultSet rs = sdb.getRecept();

        try {
            while (rs.next()) {// забиваем коллекцию рецептов собственно данными
//"SELECT \"dRecept\".idrecept, \"dRecept\".iditem AS \"idItemRecept\", \"dReceptSostav\".iditem AS \"idItemIngr\", \"dReceptSostav\".kol 
//"FROM  public.\"dRecept\",  public.\"dReceptSostav\"\n"
//"WHERE \"dReceptSostav\".idrecept = \"dRecept\".idrecept"
                recipeId = rs.getInt(1);
                itemResultId = rs.getInt(2);
                reagentsList.add(itemList.getItem(rs.getInt(3)));
                itemQuantity.add(rs.getInt(4));
                recipeList.addRecipe(new Recipe(recipeId, itemResultId, reagentsList, itemQuantity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    private void fillItemsCollection() {
        try {
            ResultSet rs = sdb.getItems();

            while (rs.next()) {// забиваем коллекцию итемов собственно данными
                //"SELECT \"idItem\", \"nameItem\", type1, type2, \"idTipDobich\", \"intItemGroup\",\"refPicture\" FROM public.\"sItems\"");
                itemList.addItem(new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), 0, 0));
                // min\max цены указаны нулями - нужно возвращать что-нибудь более интересное из базы
            }

        } catch (SQLException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
