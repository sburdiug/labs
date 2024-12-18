package com.gildedrose;

public class Main {
    public static void main(String[] args) {
        Item[] items = new Item[] {
                new AgedBrie(2, 0),
                new Backstage( 15, 20),
                new Sulfuras(0, 80),
                new Item("Normal Item", 5, 10)
        };

        GildedRose app = new GildedRose(items);

        System.out.println("Before update:");
        for (Item item : items) {
            System.out.println(item);
        }

        app.updateQuality();

        System.out.println("\nAfter update:");
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
