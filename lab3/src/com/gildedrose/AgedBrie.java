package com.gildedrose;

public class AgedBrie extends Item{
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQualityByOne();
        setSellIn(getSellIn() - 1);
        if (getSellIn() < 0) {
            increaseQualityByOne();
        }
    }
}