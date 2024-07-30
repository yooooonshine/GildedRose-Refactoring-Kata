package com.gildedrose;

public enum ItemName {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured Mana Cake"),
    SULFURAS("Sulfuras, Hand of Ragnaros")
    ;

    private String value;

    ItemName(String value) {
        this.value = value;
    }
}
