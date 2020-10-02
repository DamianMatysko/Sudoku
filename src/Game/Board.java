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


    public void checkRow(EmptySpaces emptySpace) {
        for (int i = 0; i < tile.length; i++) {
            tile[emptySpace.getY()][emptySpace.getX()].deleteRepeatingNum(tile[emptySpace.getY()][i].getValue());
           // System.out.println(emptySpace.getY()+" "+i);
        }
    }


    public void checkColum(EmptySpaces emptySpace) {
        for (int i = 0; i < tile.length; i++) {
            tile[emptySpace.getY()][emptySpace.getX()].deleteRepeatingNum(tile[i][emptySpace.getX()].getValue());
        }

    }

    public void checkSquare(EmptySpaces emptySpace) {
        for (int i = findCornerForSquare(emptySpace.getY()); i < findCornerForSquare(emptySpace.getY()) + 3; i++) {
            for (int j = findCornerForSquare(emptySpace.getX()); j < findCornerForSquare(emptySpace.getX()) + 3; j++) {
                tile[emptySpace.getX()][emptySpace.getY()].deleteRepeatingNum(tile[j][i].getValue());
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

    public void tryFillBoard() {
        for (int i=0;i<emptySpacesArrayList.size();i++) {
            checkColum(emptySpacesArrayList.get(i));
            checkRow(emptySpacesArrayList.get(i));
            checkSquare(emptySpacesArrayList.get(i));
            tile[emptySpacesArrayList.get(i).getY()][emptySpacesArrayList.get(i).getX()].printPossibleNumbers();
        }

    }

}