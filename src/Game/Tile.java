package Game;

public class Tile {
    int value;
    int[] possibleNumbetrs = getPossibleNumbers();
    boolean isFilled;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Tile(int value) {
        if (value > 0 && value < 10) {
            this.value = value;

        } else {
            System.out.println("Wrong input!!!");
        }
        if (value == 0) {
            possibleNumbetrs=null;
            isFilled = false;
        } else {
            isFilled = true;
        }
    }

    public int[] getPossibleNumbers() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    public int[] deleteRepeatingNum(int value) {
        for (int k = 0; k < possibleNumbetrs.length; k++) {
            if (possibleNumbetrs[k] == value) {
                possibleNumbetrs = removeTheElement(possibleNumbetrs, k);
            }
        }
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




}
