package com.gildedrose;

import static com.gildedrose.ItemName.*;

import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(AGED_BRIE.name())
                    && !items[i].name.equals(BACKSTAGE_PASSES.name())) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(SULFURAS)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(BACKSTAGE_PASSES.name())) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            updateItemSellIn();

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(AGED_BRIE.name())) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES.name())) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(SULFURAS.name())) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    //아이템 판매기간 변경
    private void updateItemSellIn() {
        Arrays.stream(items)
            .filter(item -> item.name.equals(SULFURAS.name()))
            .forEach(item -> item.sellIn--);
    }

    // public void updateItemQuality() {
    //
    // }
}

// 품목 별로 변경되도록 리팩토링 하자
