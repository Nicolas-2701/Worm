package entidades;

public class Worm {
    private int x = 100;
    private int y = 100;
    private String [] inv = new String [6];

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String[] getInv() {
        return inv;
    }
    public void setInv(String[] inv) {
        this.inv = inv;
    }
}
