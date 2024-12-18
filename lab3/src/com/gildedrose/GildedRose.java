package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name){
                case "Aged Brie":
                    Item.increaseQualityByOne(item);
                    item.sellIn = item.sellIn - 1;
                    if (item.sellIn < 0) {
                        Item.increaseQualityByOne(item);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    Item.increaseQualityByOne(item);
                    if (item.sellIn < 11) {
                        Item.increaseQualityByOne(item);
                    }
                    if (item.sellIn < 6) {
                        Item.increaseQualityByOne(item);
                    }
                    item.sellIn = item.sellIn - 1;
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    Item.decreaseQualityByOne(item);
                    item.sellIn = item.sellIn - 1;
                    if (item.sellIn < 0) {
                        Item.decreaseQualityByOne(item);
                    }
                    break;
            }
        }
    }
}
