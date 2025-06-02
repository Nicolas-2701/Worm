package entidades.extension;

public class Inventario {
    private String[][] inv = new String[50][3];
    private int dinheiro = 0;
    private String[][] loja = new String[3][3];

    public String[][] getInv() {
        return inv;
    }

    public void setInv(String[][] inv) {
        this.inv = inv;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String[][] getLoja() {
        return loja;
    }

    public void setLoja(String[][] loja) {
        this.loja = loja;
    }
}
