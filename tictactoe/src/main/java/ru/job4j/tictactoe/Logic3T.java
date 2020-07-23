package ru.job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return isWin(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWin(Figure3T::hasMarkO);
    }

    public boolean isWin(Predicate<Figure3T> pr) {
        boolean diagFromTopRight = true;
        boolean diagFromTopLeft = true;
        for (int y = 0; y < table.length; y++) {
            boolean horizontal = true;
            boolean vertical = true;
            for (int x = 0; x < table.length; x++) {
                horizontal &= pr.test(table[y][x]);
                vertical &= pr.test(table[x][y]);
            }
            if (horizontal) return true;
            else if (vertical) return true;
            diagFromTopLeft &= pr.test(table[y][y]);
            diagFromTopRight &= pr.test(table[y][table.length - 1 - y]);
        }
        return diagFromTopLeft || diagFromTopRight;
    }

    public boolean hasGap() {
        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .anyMatch(f -> !f.hasMarkO() && !f.hasMarkX());
    }
}
