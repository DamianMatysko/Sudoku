package Game;

public class InputData {

    public int[][] getData() {
        String data = "100026039008700601000000200400900516000000000796004008009000000301002900640180003";
        //String data = "530070000600195000098000060800000340080300170000200060600002800004190050000800790";
        int arr[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = (data.charAt(9 * i + j) - '0');
            }
        }
        return arr;
    }

}
