package functions;

public class Redimension {
    private int w;
    private int h;

    public int getW() {
        return w;
    }
    public void setW(int w) {
        this.w = w;
    }
    public int getH() {
        return h;
    }
    public void setH(int h) {
        this.h = h;
    }

    public int porcentagem(int n, String side){
        switch (side) {
            case "w" -> {
                return w*n/100;
            }
            case "h" -> {
                return h*n/100;
            }
            default -> {
                return 0;
            }
        }
    }

    public String direcao(int velocidadeX, int velocidadeY, String init){
        if(velocidadeY!=0){
            if(velocidadeY>0){
                return "s";
            } else{
                return "w";
            }
        }
        else if(velocidadeX!=0){
            if(velocidadeX>0){
                return "d";
            } else{
                return "a";
            }
        } else{
            return init;
        }

    }
}
