package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.getName()){
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.increaseQualityByOne();
                    if (item.getSellIn() < 11) {
                        item.increaseQualityByOne();
                    }
                    if (item.getSellIn() < 6) {
                        item.increaseQualityByOne();
                    }
                    item.setSellIn(item.getSellIn()-1);
                    if (item.getSellIn() < 0) {
                        item.setQuality(0);
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    item.updateQuality();
                    break;
            }
        }
    }

}
