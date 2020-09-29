package Game;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();


        board.fillTileWithInputData();
        //board.fillTile();


        board.findEmtySpace();
        board.printArray();
        board.tryFillBoard();
        board.printArray();



    }
}
