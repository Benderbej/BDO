/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPack;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author RusTe
 */
public class Recipe {
    //idRecept	idItem	kol	intItemGroup
    //int          int     int     int

    private final int recipe_id;
    private int itemresult_id;
    private  HashMap<Item, Integer> recipe_sostav;
    private final HashSet<Item> items_list;
    private final HashSet<Integer> item_quantity;

    public Recipe() {
        this.recipe_id = -1;
        this.items_list=new HashSet<>();
        this.item_quantity=new HashSet<Integer>();
    }

    public Recipe(int id, HashSet<Item> items_list, HashSet<Integer> item_quantity) {
        this.recipe_id = id;
        this.items_list = items_list;
        this.item_quantity = item_quantity;
    }

}
