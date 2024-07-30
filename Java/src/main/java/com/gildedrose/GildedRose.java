package com.gildedrose;

import static com.gildedrose.Constants.*;
import static com.gildedrose.ItemName.*;

import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            // 기본적으로 떨어지는 사항
            // 일반, 감염, 전설
            if (!items[i].name.equals(AGED_BRIE.name()) && !items[i].name.equals(BACKSTAGE_PASSES.name())) {
                // 일반, 감염
                if (items[i].quality > Constants.NORMAL_ITEM_MIN_QUALITY) {
                    if (!items[i].name.equals(SULFURAS.name())) {
                        items[i].quality = items[i].quality - NORMAL_ITEM_DECREASE_AMOUNT;
                    }
                }
            // 오래된 브리치즈 및 백스테이지 패스
            } else {
                if (items[i].quality < NORMAL_ITEM_MAX_QUALITY) {
                    items[i].quality = items[i].quality + 1;

                    //백스테이지 패스 퀄리티 증가
                    if (items[i].name.equals(BACKSTAGE_PASSES.name())) {
                        if (items[i].sellIn < Constants.BACKSTAGE_PASSES_SELL_IN_STANDARD_INCREASING_2_TIMES) {
                            if (items[i].quality < NORMAL_ITEM_MAX_QUALITY) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                        if (items[i].sellIn < Constants.BACKSTAGE_PASSES_SELL_IN_STANDARD_INCREASING_3_TIMES) {
                            if (items[i].quality < NORMAL_ITEM_MAX_QUALITY) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            updateItemSellIn();

            // 판매기간이 지났을 때 2배 떨어지는 기능
            if (items[i].sellIn < Constants.SELL_IN_STANDARD) {

                // 일반, 감염, 전설
                if (!items[i].name.equals(AGED_BRIE.name())) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES.name())) {
                        if (items[i].quality > Constants.NORMAL_ITEM_MIN_QUALITY) {
                            if (!items[i].name.equals(SULFURAS.name())) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                // 오래된 브리치즈
                } else {
                    if (items[i].quality < NORMAL_ITEM_MAX_QUALITY) {
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
