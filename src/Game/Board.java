package Game;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    Tile tile[][] = new Tile[9][9];
    ArrayList<EmptySpaces> emptySpacesArrayList = new ArrayList<EmptySpaces>();

    public void fillTileWithInputData() {
        int data[][] = new InputData().getData();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                tile[i][j] = new Tile(data[i][j]);
            }
        }
    }

    public void printArray() {
        System.out.println("|----------------------|");
        for (int i = 0; i < tile.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("|-------|-------|------|");
            }
            for (int j = 0; j < tile[i].length; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(tile[i][j].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println("|----------------------|");
    }

    public void findEmtySpace() {
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                if (tile[i][j].getValue() == 0) {
                    emptySpacesArrayList.add(new EmptySpaces(i, j));
                }
            }
        }
    }










    public void checkRow(int y) {
        for (int i = 0; i < tile.length; i++) {
            tile[y][i].deleteRepeatingNum(tile[y][i].getValue());
        }
    }


    public int[] checkColum() {
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < possibleNumbetrs.length; j++) {
                if (possibleNumbetrs[j] == tile[i][x].getValue()) {
                    possibleNumbetrs = removeTheElement(possibleNumbetrs, j);
                }
            }
        }
        return possibleNumbetrs;
    }

    public void checkSquare() {
        for (int i = findCornerForSquare(y); i < findCornerForSquare(y) + 3; i++) {
            for (int j = findCornerForSquare(x); j < findCornerForSquare(x) + 3; j++) {
                for (int k = 0; k < possibleNumbetrs.length; k++) {
                    if (possibleNumbetrs[k] == tile[j][i].getValue()) {
                        possibleNumbetrs = removeTheElement(possibleNumbetrs, k);
                    }
                }
            }
        }
    }






    public int findCornerForSquare(int axis) {
        if (axis > -1 && axis < 3) {
            return 0;
        }
        if (axis > 2 && axis < 6) {
            return 3;
        }
        return 6;
    }









/*
    public void setPossibleNumbetrs(int[] possibleNumbetrs) {
        this.possibleNumbetrs = possibleNumbetrs;
    }




    public void fillTile() {
        Random rnd = new Random();
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++)
                tile[i][j] = new Tile(rnd.nextInt(9));
        }
    }

    public void fillTileWithInputData() {
        int data[][] = new InputData().getData();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                tile[i][j] = new Tile(data[i][j]);
            }
        }
    }

    public void printArray() {
        System.out.println("|----------------------|");
        for (int i = 0; i < tile.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("|-------|-------|------|");
            }
            for (int j = 0; j < tile[i].length; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(tile[i][j].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println("|----------------------|");
    }

    /*
        public boolean findEmtySpace() {
            for (; y < tile.length; y++) {
                for (; x < tile[y].length; x++) {
                    if (tile[y][x].getValue() == 0) {
                        System.out.println(x + " " + y);
                        return true;
                    }
                }
            }
            return false;
        }

    public void findEmtySpace() {
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                if (tile[i][j].getValue() == 0) {
                    emptySpacesArrayList.add(new EmptySpaces(i, j));
                }
            }
        }
    }

    public void printEmptySpacesArrayList() {
        for (int i = 0; i < emptySpacesArrayList.size(); i++) {
            System.out.println(emptySpacesArrayList.get(i).getX() + " " + emptySpacesArrayList.get(i).getY());
        }
    }

    public void tryFillBoard() {
        for (int i = 0; i < emptySpacesArrayList.size(); i++) {
            x = emptySpacesArrayList.get(i).getX();
            y = emptySpacesArrayList.get(i).getY();
            checkRow();
            checkColum();
            checkSquare();
            possibleNumbetrs=getPossibleNumbers();
            printPossibleNumbers();
            if (possibleNumbetrs.length == 1) {
                System.out.println(x+" "+y);
                tile[y][x].setValue(possibleNumbetrs[0]);
            }
        }
    }

    public boolean nextTile() {
        if (x < 8) {
            x += 1;
            return true;
        }
        if (y < 8 && x == 8) {
            y += 1;
            x = 0;
            return true;
        }
        if (x == 8 && y == 8) {
            return false;
        }
        return false;
    }

    public int[] checkRow() {
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < possibleNumbetrs.length; j++) {
                if (possibleNumbetrs[j] == tile[y][i].getValue()) {
                    possibleNumbetrs = removeTheElement(possibleNumbetrs, j);
                }
            }
        }
        return possibleNumbetrs;
    }


    public int[] checkColum() {
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < possibleNumbetrs.length; j++) {
                if (possibleNumbetrs[j] == tile[i][x].getValue()) {
                    possibleNumbetrs = removeTheElement(possibleNumbetrs, j);
                }
            }
        }
        return possibleNumbetrs;
    }

    public void checkSquare() {
        for (int i = findCornerForSquare(y); i < findCornerForSquare(y) + 3; i++) {
            for (int j = findCornerForSquare(x); j < findCornerForSquare(x) + 3; j++) {
                for (int k = 0; k < possibleNumbetrs.length; k++) {
                    if (possibleNumbetrs[k] == tile[j][i].getValue()) {
                        possibleNumbetrs = removeTheElement(possibleNumbetrs, k);
                    }
                }
            }
        }
    }

    public void printPossibleNumbers() {
        for (int i = 0; i < possibleNumbetrs.length; i++) {
            System.out.print(possibleNumbetrs[i]);
        }
        System.out.println();
    }

    public int findCornerForSquare(int axis) {
        if (axis > -1 && axis < 3) {
            return 0;
        }
        if (axis > 2 && axis < 6) {
            return 3;
        }

        return 6;

    }

    public static int[] removeTheElement(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }

    public boolean tryFilltile() {
        checkSquare();
        checkColum();
        checkRow();
        if (possibleNumbetrs.length == 1) {
            tile[y][x].setValue(possibleNumbetrs[0]);
            return true;
        }
        return false;
    }

    public boolean isSolved() {
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                if (tile[i][j].getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    */
}