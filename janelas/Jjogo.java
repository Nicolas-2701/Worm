package janelas;

import functions.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import java.awt.*;
import entidades.*;

public class Jjogo {

    private Redimension r = new Redimension();
    private Geral ge = new Geral();

    public void desenhar(Graphics g, Worm worm, int largura, int altura, Component componente, int velocidadeX,
            int velocidadeY, int[] world) {
        r.setW(largura);
        r.setH(altura);
        int wormSizeW = r.porcentagem(4, "w");
        int wormSizeH = r.porcentagem(8, "h");

        ImageIcon icon = new ImageIcon("sprites/worm/parado_W_1.png");
        Image image = icon.getImage();
        for (int i = 0; i < world.length; i++) {
            switch (world[i]) {
                case 5:
                    icon = new ImageIcon("sprites/minerios/terra_1.png");
                    break;
                case 4:
                    icon = new ImageIcon("sprites/minerios/cobre_1.png");
                    break;
                case 3:
                    icon = new ImageIcon("sprites/minerios/ferro_1.png");
                    break;
                case 2:
                    icon = new ImageIcon("sprites/minerios/ouro_1.png");
                    break;
                case 1:
                    icon = new ImageIcon("sprites/minerios/diamante_1.png");
                    break;
                case 0:
                    icon = new ImageIcon("sprites/minerios/rubi_1.png");
                    break;
                default:
                    icon = new ImageIcon("sprites/minerios/nada_1.png");
                    break;
            }
            image = icon.getImage();
            g.drawImage(image, (wormSizeW * (i % 26)), (wormSizeH * (i / 26)), wormSizeW, wormSizeH, componente);
            Rectangle wormColi = new Rectangle(worm.getX(), worm.getY(), wormSizeW, wormSizeH);
            Rectangle blockColi = new Rectangle((wormSizeW * (i % 26)), (wormSizeH * (i / 26)), wormSizeW, wormSizeH);
            if (wormColi.intersects(blockColi)) {
                if(world[i]>-1){
                    world[i] = -1;
                    ge.tocarSom("sons/comendo.wav");
                }
            }
        }

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
        image = icon.getImage();
        g.drawImage(image, worm.getX(), worm.getY(), wormSizeW, wormSizeH, componente); // Personagem
    }

}
