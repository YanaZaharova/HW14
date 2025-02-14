package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket tic1 = new Ticket("Москва Домодедово", "Сочи", 24_000, 6_00, 9_50);
    Ticket tic2 = new Ticket("Москва Домодедово", "Сочи", 16_000, 13_20, 15_10);
    Ticket tic3 = new Ticket("Москва Домодедово", "Сочи", 18_000, 8_00, 11_55);
    Ticket tic4 = new Ticket("Москва Домодедово", "Сочи", 22_000, 7_00, 11_15);
    Ticket tic5 = new Ticket("Москва Домодедово", "Ташкент", 21_000, 17_40, 23_30);
    Ticket tic6 = new Ticket("Москва Внуково", "Сочи", 19_000, 10_10, 16_00);

    @Test
    public void shouldCompare() {
        AviaSouls avia = new AviaSouls();

        avia.add(tic1);

        Ticket tic = new Ticket("Москва Жуковский", "Сочи", 19_000, 14_30, 17_40);

        int expected = -1;
        int actual = tic.compareTo(tic1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortResult() {
        AviaSouls avia = new AviaSouls();

        avia.add(tic1);
        avia.add(tic2);
        avia.add(tic3);
        avia.add(tic4);
        avia.add(tic5);
        avia.add(tic6);

        Ticket[] expected = {tic2, tic3, tic4, tic1};
        Ticket[] actual = avia.search("Москва Домодедово", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareByTicketTime() {
        AviaSouls avia = new AviaSouls();

        avia.add(tic2);
        avia.add(tic3);

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 1;
        int actual = comparator.compare(tic2, tic3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTime() {
        AviaSouls avia = new AviaSouls();

        avia.add(tic1);
        avia.add(tic2);
        avia.add(tic3);
        avia.add(tic4);
        avia.add(tic5);
        avia.add(tic6);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {tic1, tic4, tic3, tic2};
        Ticket[] actual = avia.searchAndSortBy("Москва Домодедово", "Сочи", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
