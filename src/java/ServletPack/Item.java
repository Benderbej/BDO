/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPack;

/**
 *
 * @author RusTe
 */
public class Item {

    private final int item_id;
    private final String item_name;
    private final int item_type1;
    private final int item_type2;
    private final int item_typeofspoil;
    private final int item_group;
    private final String item_refPicture;

    public Item() {
        this.item_id = 0;
        this.item_name = "";
        this.item_type1 = 0;
        this.item_type2 = 0;
        this.item_typeofspoil = 0;
        this.item_group = 0;
        this.item_refPicture = "";

    }

    public  Item(int id, String name, int type1, int type2, int typeofspoil, int group) {
         this.item_id = id;
        this.item_name = name;
        this.item_type1 = type1;
        this.item_type2 = type2;
        this.item_typeofspoil = typeofspoil;
        this.item_group = group;
        this.item_refPicture = "";
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getItem_type1() {
        return item_type1;
    }

    public int getItem_type2() {
        return item_type2;
    }

    public int getItem_typeofspoil() {
        return item_typeofspoil;
    }

    public int getItem_group() {
        return item_group;
    }

    public String getItem_refPicture() {
        return item_refPicture;
    }

}
