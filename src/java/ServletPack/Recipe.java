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
    private final int item_result_id;
//    private  HashMap<Item, Integer> recipe_sostav;
    private final HashSet<Item> items_list;
    private final HashSet<Integer> item_quantity;

    public int getRecipe_id() {
        return recipe_id;
    }
    public int getItem_result_id() {
        return item_result_id;
    }
//    public HashMap<Item, Integer> getRecipe_sostav() {
//        return recipe_sostav;
//    }

    public HashSet<Item> getItems_list() {
        return items_list;
    }

    public HashSet<Integer> getItem_quantity() {
        return item_quantity;
    }

    /**
     *дефолтный конструктор - можно юзать под тестирование
     */
    public Recipe() {
        this.recipe_id = -1;
        this.items_list = new HashSet<>();
        this.item_quantity = new HashSet<>();
        this.item_result_id=-1;
    }

    /**
     * стандартное создание рецепта:(нужно ещё придумать как присобачить сюда взаимозаменяемые предметы)
     * @param id рецепта
     * @param item_result_id id результирующего предмета
     * @param items_list список компонентов типа Item
     * @param item_quantity список количеств каждого компонента
     */
    public Recipe(int id,int item_result_id, HashSet<Item> items_list, HashSet<Integer> item_quantity) {
        this.recipe_id = id;
        this.item_result_id=item_result_id;
        if (items_list.toArray().length == item_quantity.toArray().length) {
            this.items_list = items_list;
            this.item_quantity = item_quantity;
        } else {
            this.items_list = new HashSet<>();
            this.item_quantity = new HashSet<>();
        }
    }

}
