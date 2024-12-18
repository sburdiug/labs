package com.gildedrose;

public class Backstage extends Item{
    public Backstage(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }
    @Override
    public void updateQuality() {
        increaseQualityByOne();
        if (getSellIn() < 11) {
            increaseQualityByOne();
        }
        if (getSellIn() < 6) {
            increaseQualityByOne();
        }
        setSellIn(getSellIn()-1);
        if (getSellIn() < 0) {
            setQuality(0);
        }
    }
}
