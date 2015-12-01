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
    private int item_minprice;
    private int item_maxprice;
    private int item_lastprice;
    private int item_medprice;
    private int item_quantitysold;
    private int item_currentquantity;

    public int getItem_minprice() {
        return item_minprice;
    }

    public int getItem_maxprice() {
        return item_maxprice;
    }

    public int getItem_lastprice() {
        return item_lastprice;
    }

    public int getItem_medprice() {
        return item_medprice;
    }

    public int getItem_quantitysold() {
        return item_quantitysold;
    }

    public int getItem_currentquantity() {
        return item_currentquantity;
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

    public void setItem_minprice(int item_minprice) {
        this.item_minprice = item_minprice;
    }

    public void setItem_maxprice(int item_maxprice) {
        this.item_maxprice = item_maxprice;
    }

    public void setItem_lastprice(int item_lastprice) {
        this.item_lastprice = item_lastprice;
    }

    public void setItem_medprice(int item_medprice) {
        this.item_medprice = item_medprice;
    }

    public void setItem_quantitysold(int item_quantitysold) {
        this.item_quantitysold = item_quantitysold;
    }

    public void setItem_currentquantity(int item_currentquantity) {
        this.item_currentquantity = item_currentquantity;
    }

    /**
     * дефолтный конструктор- можно пользовать для тестов
     */
    public Item() {
        this.item_id = 0;
        this.item_name = "";
        this.item_type1 = 0;
        this.item_type2 = 0;
        this.item_typeofspoil = 0;
        this.item_group = 0;
        this.item_refPicture = "";

    }

    /**
     * конструктор для создания типового экземлпяра с базовым набором данных
     *
     * @param item_id
     * @param item_name
     * @param item_type1
     * @param item_type2
     * @param item_typeofspoil
     * @param item_group
     * @param item_minprice
     * @param item_maxprice
     */
    public Item(int item_id, String item_name, int item_type1, int item_type2, int item_typeofspoil, int item_group, String item_refPicture,int item_minprice, int item_maxprice) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_type1 = item_type1;
        this.item_type2 = item_type2;
        this.item_typeofspoil = item_typeofspoil;
        this.item_group = item_group;
        this.item_refPicture = item_refPicture;
        this.item_minprice = item_minprice;
        this.item_maxprice = item_maxprice;
        this.item_lastprice = -1;
        this.item_medprice = -1;
        this.item_quantitysold = -1;
        this.item_currentquantity = -1;
    }

    /**
     * конструктор для обновления данных
     *
     * @param item_id
     * @param item_minprice
     * @param item_maxprice
     * @param item_lastprice
     * @param item_medprice
     * @param item_quantitysold
     * @param item_currentquantity
     */
    public Item(int item_id, int item_minprice, int item_maxprice, int item_lastprice, int item_medprice, int item_quantitysold, int item_currentquantity) {
        this.item_id = item_id;
        this.item_minprice = item_minprice;
        this.item_maxprice = item_maxprice;
        this.item_lastprice = item_lastprice;
        this.item_medprice = item_medprice;
        this.item_quantitysold = item_quantitysold;
        this.item_currentquantity = item_currentquantity;
        this.item_name = "";
        this.item_type1 = -1;
        this.item_type2 = -1;
        this.item_typeofspoil = -1;
        this.item_group = -1;
        this.item_refPicture = "";
    }
        /**
     * конструктор для ItemAsIngr
     *
     * @param item_id
     */
    public Item(int item_id) {
        this.item_id = item_id;
        this.item_name = "";
        this.item_type1 = 0;
        this.item_type2 = 0;
        this.item_typeofspoil = 0;
        this.item_group = 0;
        this.item_refPicture = "";

    }
}
