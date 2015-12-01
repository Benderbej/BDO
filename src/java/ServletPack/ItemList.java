package ServletPack;

import java.util.HashSet;

public class ItemList {

    private HashSet<Item> items_list;

    public HashSet<Item> getItems_list() {
        return items_list;
    }

    /**
     *
     * @param item
     * @return
     */
    public boolean addItem(Item item) {
        if (!items_list.contains(item)) {
            return items_list.add(item);
        }
        return false;
    }

    /**
     *
     * @param item_id
     * @return 
     */
    public Item getItem(int item_id) {// можно конечно сделать и правильнее - через другую коллекцию.. 
        for (Item item : items_list) {//но у нас в лучшем случае 1500-2000 тыс итемов и лепить мапу смысла нет
            if (item.getItem_id() == item_id) {
                return item;
            }
        }
        return null;
    }

    /**
     * в item нужно закидывать объект созданный конструктором "для обновления
     * данных"
     *
     * @param itemUpd
     * @return 
     */
    public boolean updateItemData(Item itemUpd) {
        if (!items_list.contains(itemUpd)) {
            for (Item item : items_list) {
                if (item.getItem_id() == itemUpd.getItem_id()) {
                    item.setItem_minprice(itemUpd.getItem_minprice());
                    item.setItem_maxprice(itemUpd.getItem_maxprice());
                    item.setItem_lastprice(itemUpd.getItem_lastprice());
                    item.setItem_medprice(itemUpd.getItem_medprice());
                    item.setItem_currentquantity(itemUpd.getItem_currentquantity());
                    item.setItem_quantitysold(itemUpd.getItem_quantitysold());
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean reloadCollectionData()
    {
        // метод для очистки коллекции.. а нужен ли он? или тут его лучше не делать
        return false;
    }
}
