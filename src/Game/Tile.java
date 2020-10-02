package Game;

public class Tile {
    int value;
    int[] possibleNumbers={1, 2, 3, 4, 5, 6, 7, 8, 9};
    boolean isFilled;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Tile(int value) {

        if (value >= 0 && value < 10) {
            this.value = value;

        } else {
            System.out.println("Wrong input!!!");
        }

    }

    public void deleteRepeatingNum(int value) {
        if (value==0){
            return;
        }
        for (int k = 0; k < this.possibleNumbers.length; k++) {

            if (possibleNumbers[k] == value) {
                possibleNumbers = removeTheElement(possibleNumbers, k);
            }
        }
        if (possibleNumbers.length==1){
            this.value= possibleNumbers[0];
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

    public void printPossibleNumbers() {
        for (int i = 0; i < possibleNumbers.length; i++) {
            System.out.print(possibleNumbers[i]);
        }
        System.out.println();
    }


}
