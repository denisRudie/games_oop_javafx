package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
//        i - ось X
//        j - ось Y

        for (int i = 0; i < table[0].length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j].hasMarkX()) {
                    int countGor = 1;
                    int countVert = 1;
//                check for winning in horizontal
                    int gor = 1;
                    while ((i + gor) < table[0].length && table[i + gor][j].hasMarkX()) {
                        countGor++;
                    }
                    if (countGor == 3) {
                        return true;
                    }
//                check for winning in vertical
                    int vert = 1;
                    while ((j + vert) < table.length && table[i][j+vert].hasMarkX()) {
                        countVert++;
                    }
                    if (countVert == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isWinnerO() {
//        i - ось X
//        j - ось Y
        int countGor = 0;
        int countVert = 0;

        for (int i = 0; i < table[0].length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j].hasMarkO()) {
//                check for winning in horizontal
                    countGor++;
                    countVert++;
                    int gor = 1;
                    while ((i + gor) < table[0].length && table[i + gor][j].hasMarkO()) {
                        countGor++;
                    }
                    if (countGor == 3) {
                        return true;
                    }
//                check for winning in vertical
                    int vert = 1;
                    while ((j + vert) < table.length && table[i][j+vert].hasMarkO()) {
                        countVert++;
                    }
                    if (countVert == 3) {
                        return true;
                    }
                    countGor = 0;
                    countVert = 0;
                }
            }
        }
        return false;
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
