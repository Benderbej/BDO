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
public class ItemAsIngr extends Item {
    private int itemQuantity;//Количество в рецепте

    public ItemAsIngr(int itemQuantity, int item_id) {
        super(item_id);
        this.itemQuantity = itemQuantity;    
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
