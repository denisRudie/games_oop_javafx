package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return (winWithDiag(Figure3T::hasMarkX) || winWithVertOrHor(Figure3T::hasMarkX));
    }

    public boolean isWinnerO() {
        return (winWithDiag(Figure3T::hasMarkO) || winWithVertOrHor(Figure3T::hasMarkO));
    }

    public boolean winWithVertOrHor(Predicate<Figure3T> pr) {
            for (int y = 0; y < table.length; y++) {
                boolean horizontal = true;
                boolean vertical = true;
                for (int x = 0; x < table.length; x++) {
                    horizontal &= pr.test(table[y][x]);
                    vertical &= pr.test(table[x][y]);
                }
                if (horizontal) return true;
                else if (vertical) return true;
        }
        return false;
    }

    public boolean winWithDiag(Predicate<Figure3T> pr) {
        boolean diagFromTopRight = true;
        boolean diagFromTopLeft = true;
        for (int i = 0; i < table.length; i++) {
            diagFromTopLeft &= pr.test(table[i][i]);
            diagFromTopRight &= pr.test(table[i][table.length - 1 - i]);
        }
        return (diagFromTopLeft || diagFromTopRight);
    }

    public boolean hasGap() {
        for (int i = 0; i < table[0].length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkX() && !table[i][j].hasMarkO()) {
                    return true;
                }
            }
        }
        return false;
    }
}
