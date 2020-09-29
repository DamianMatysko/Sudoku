package Game;

public class Tile {
    int value;
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public Tile(int value) {
        if(value>=0&&value<10) {
            this.value = value;
        }else {
            System.out.println("Wrong input!!!");
        }
    }
}
