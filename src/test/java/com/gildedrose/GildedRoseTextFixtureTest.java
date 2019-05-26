package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTextFixtureTest {

    @Test
    public void go() throws Exception {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printer = new PrintStream(outputStream);

        printer.println("OMGHAI!");

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 31;

        // Act
        for (int i = 0; i < days; i++) {
            printer.println("-------- day " + i + " --------");
            printer.println("name, sellIn, quality");
            for (Item item : items) {
                printer.println(item);
            }
            printer.println();
            app.updateQuality();
        }

        // Assert
        assertEquals(readExpected(), outputStream.toString());
    }

    private String readExpected() throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("com/gildedrose/GildedRoseTextFixtureTest.txt")).toURI());

        Stream<String> lines = Files.lines(path);
        String expected = lines.collect(Collectors.joining("\n"));
        lines.close();

        return expected;
    }

}
