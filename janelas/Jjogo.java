package janelas;

import functions.*;
import java.awt.*;
import entidades.*;

public class Jjogo {

    private Redimension r = new Redimension();
    private Geral ge = new Geral();
    private Specific s = new Specific();

    public void desenhar(Graphics g, Worm worm, int largura, int altura, Component componente, int velocidadeX,
            int velocidadeY, int[] world) {
        r.setW(largura);
        r.setH(altura);
        int wormSizeW = r.porcentagem(4, "w");
        int wormSizeH = r.porcentagem(8, "h");

        Image image;
        //desenha o mundo
        for (int i = 0; i < world.length; i++) {
            switch (world[i]) {
                case 5:
                    image = ge.image("sprites/minerios/terra_1.png");
                    break;
                case 4:
                    image = ge.image("sprites/minerios/cobre_1.png");
                    break;
                case 3:
                    image = ge.image("sprites/minerios/ferro_1.png");
                    break;
                case 2:
                    image = ge.image("sprites/minerios/ouro_1.png");
                    break;
                case 1:
                    image = ge.image("sprites/minerios/diamante_1.png");
                    break;
                case 0:
                    image = ge.image("sprites/minerios/rubi_1.png");
                    break;
                default:
                    image = ge.image("sprites/minerios/nada_1.png");
                    break;
            }
            g.drawImage(image, (wormSizeW * (i % 26)), (wormSizeH * (i / 26)), wormSizeW, wormSizeH, componente);
            Rectangle wormColi = new Rectangle(worm.getX(), worm.getY(), wormSizeW, wormSizeH);
            Rectangle blockColi = new Rectangle((wormSizeW * (i % 26)), (wormSizeH * (i / 26)), wormSizeW, wormSizeH);
            if (wormColi.intersects(blockColi) && world[i] > -1) {
                s.armazenar(worm, world[i]);
                world[i] = -1;
                ge.tocarSom("sons/comendo.wav");
                s.enemieEncounter(worm);
            }
        }

        String direcao = "d";
        direcao = r.direcao(velocidadeX, velocidadeY, direcao);
        //desenha o personagem na direção que ele ta virado
        switch (direcao) {
            case "a" -> {
                image = ge.image("sprites/worm/parado_A_1.png");
            }
            case "s" -> {
                image = ge.image("sprites/worm/parado_S_1.png");
            }
            case "w" -> {
                image = ge.image("sprites/worm/parado_W_1.png");
            }
            case "d" -> {
                image = ge.image("sprites/worm/parado_D_1.png");
            }
            default -> {
                image = ge.image("sprites/worm/parado_A_1.png");
            }
        }
        g.drawImage(image, worm.getX(), worm.getY(), wormSizeW, wormSizeH, componente); // Personagem
    }

}
