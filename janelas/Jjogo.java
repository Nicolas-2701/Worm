package janelas;

import functions.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import java.awt.*;
import entidades.*;

public class Jjogo{

    private Redimension r = new Redimension();

    public void desenhar(Graphics g, Worm worm, int largura, int altura, Component componente, int velocidadeX, int velocidadeY) {
        r.setW(largura);
        r.setH(altura);
        int wormSizeW = r.porcentagem(2, "w");
        int wormSizeH = r.porcentagem(4, "h");

        ImageIcon icon = new ImageIcon("sprites/worm/parado_W_1.png");
        String direcao = "d";
        direcao = r.direcao(velocidadeX, velocidadeY, direcao);
        switch (direcao) {
            case "a" -> {
                icon = new ImageIcon("sprites/worm/parado_A_1.png");
            }
            case "s" -> {
                icon = new ImageIcon("sprites/worm/parado_S_1.png");
            }
            case "w" -> {
                icon = new ImageIcon("sprites/worm/parado_W_1.png");
            }
            case "d" -> {
                icon = new ImageIcon("sprites/worm/parado_D_1.png");
            }
            default -> {
                icon = new ImageIcon("sprites/worm/parado_A_1.png");
            }
        }
        Image image = icon.getImage();
        g.drawImage(image, worm.getX(), worm.getY(), wormSizeW, wormSizeH, componente); // Personagem
    }
    
}
