package Game;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();


        board.fillTileWithInputData();

        board.findEmtySpace();


        for (int i=0; i<10;i++) {
            board.printArray();
            board.tryFillBoard();
            board.printArray();
        }


    }
}
