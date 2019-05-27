package com.gildedrose.support;

import com.gildedrose.Item;

import static com.gildedrose.support.ItemCommand.decreaseSellInByOne;
import static com.gildedrose.support.ItemCommand.tryToDecreaseQualityBy;
import static com.gildedrose.support.ItemQuery.sellByDateHasPassed;

public class ConjuredItemHandler extends AbstractItemHandler {

    ConjuredItemHandler(Item item) {
        super(item);
    }

    @Override
    public void doHandleItem() {
        tryToDecreaseQualityBy(item(), 2);

        decreaseSellInByOne(item());

        if (sellByDateHasPassed(item())) {
            tryToDecreaseQualityBy(item(), 2);
        }
    }
}
