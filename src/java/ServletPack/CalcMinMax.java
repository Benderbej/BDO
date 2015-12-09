/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPack;

import java.util.ArrayList;
import server.Core;

/**
 *
 * @author RusTe
 */
public class CalcMinMax {

    private ArrayList<Double> data;
    private Item current_item;
    private Recipe current_recipe;
    private final double aucRate = 0.78;

    public CalcMinMax() {

    }


    public CalcMinMax(int item_id) {
        this.current_item = Core.getItemList().getItem(item_id);
        this.current_recipe = Core.getRecipeList().getRecipe(item_id);
    }


    /**
     *
     * @param item_id
     * @return
     */
    public ArrayList calc(int item_id) {
        this.current_item = Core.getItemList().getItem(item_id);
        this.current_recipe = Core.getRecipeList().getRecipe(item_id);
        double sellMaxPrice = current_item.getItem_maxprice() * aucRate;
        double sellMinPrice = current_item.getItem_minprice() * aucRate;
        double sellMedPrice = current_item.getItem_medprice() * aucRate;

        Item[] reagents = new Item[current_recipe.getItems_list().size()];
        Integer[] quantities = new Integer[current_recipe.getItem_quantity().size()];

        int minbuildCost = 0;
        int maxbuildCost = 0;
        int medbuildCost = 0;

        for (int i = 0; i < current_recipe.getItems_list().size(); i++) {
            reagents = current_recipe.getItems_list().toArray(reagents);
            quantities = current_recipe.getItem_quantity().toArray(quantities);

            minbuildCost = minbuildCost + reagents[i].getItem_minprice() * quantities[i];
            maxbuildCost = maxbuildCost + reagents[i].getItem_maxprice() * quantities[i];
            medbuildCost = medbuildCost + reagents[i].getItem_medprice() * quantities[i];

        }

//        double minmin = sellMinPrice - minbuildCost;
//        double minmax = sellMinPrice - maxbuildCost;
//        double maxmin = sellMaxPrice - minbuildCost;
//        double medmed = sellMedPrice - medbuildCost;
//        double median =(minmin+minmax+maxmin+medmed)/4;
        data.add(sellMinPrice - minbuildCost);
        data.add(sellMinPrice - maxbuildCost);
        data.add(sellMaxPrice - minbuildCost);
        data.add(sellMedPrice - medbuildCost);
        data.add((data.get(0) + data.get(1) + data.get(2) + data.get(3)) / 4);
        return data;
    }
}
