package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")
                    || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality < 50) {
                            Item.increaseQualityByOne(item);

                            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                                if (item.sellIn < 11) {
                                        Item.increaseQualityByOne(item);
                                }

                                if (item.sellIn < 6) {
                                        Item.increaseQualityByOne(item);
                                }
                            }
                        }
                    } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    Item.decreaseQualityByOne(item);
                }


            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            switch (item.name){
                case "Aged Brie":
                    if (item.sellIn < 0) {
                        Item.increaseQualityByOne(item);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    if (item.sellIn < 0) {
                        Item.decreaseQualityByOne(item);
                    }
                    break;

            }
        }
    }
}
