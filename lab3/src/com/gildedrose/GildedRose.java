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

            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                        Item.increaseQualityByOne(item);
                } else {
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        item.quality = 0;
                    } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            Item.decreaseQualityByOne(item);
                        }

                }
            }
        }
    }

}
