package com.gildedrose.support;

import com.gildedrose.Item;

import static com.gildedrose.support.ItemCommand.decreaseQualityByOne;
import static com.gildedrose.support.ItemCommand.decreaseSellInByOne;
import static com.gildedrose.support.ItemQuery.qualityIsNotNegative;
import static com.gildedrose.support.ItemQuery.sellByDateHasPassed;

public class DefaultItemHandler extends AbstractItemHandler {
    DefaultItemHandler(Item item) {
        super(item);
    }

    @Override
    public void doHandleItem() {
        if (qualityIsNotNegative(item())) {
            decreaseQualityByOne(item());
        }

        decreaseSellInByOne(item());

        if (sellByDateHasPassed(item())) {
            if (qualityIsNotNegative(item())) {
                decreaseQualityByOne(item());
            }
        }
    }
}
