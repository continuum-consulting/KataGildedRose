package com.gildedrose.support;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ItemHandlerFactory {
    private static Function<Item, ItemHandler> DEFAULT_ITEM_HANDLER_CONSTRUCTOR = DefaultItemHandler::new;
    private static Map<String, Function<Item, ItemHandler>> SPECIALIZED_ITEM_HANDLER_CONSTRUCTORS = new HashMap<>();

    private ItemHandlerFactory() {
        //
    }

    static {
        SPECIALIZED_ITEM_HANDLER_CONSTRUCTORS.put("Aged Brie", AgedBrieItemHandler::new);
        SPECIALIZED_ITEM_HANDLER_CONSTRUCTORS.put("Backstage passes to a TAFKAL80ETC concert", BackstagePassesItemHandler::new);
        SPECIALIZED_ITEM_HANDLER_CONSTRUCTORS.put("Sulfuras, Hand of Ragnaros", SulfurasItemHandler::new);
    }


    public static ItemHandler fetchItemHandler(Item item) {
        return SPECIALIZED_ITEM_HANDLER_CONSTRUCTORS.getOrDefault(item.name, DEFAULT_ITEM_HANDLER_CONSTRUCTOR).apply(item);
    }
}
