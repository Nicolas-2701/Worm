package janelas;

import java.awt.*;
import entidades.Worm;
import functions.*;

public class Jinv {

    private Redimension r = new Redimension();
    private Geral ge = new Geral();
    private Specific s = new Specific();

    public void desenhar(Graphics g, Worm worm, int largura, int altura, Component componente, int invx, int invy,
            boolean vendido, boolean comprado, String[][] loja, ControlePersonagem controle) {

        Image image;
        r.setW(largura);
        r.setH(altura);
        String[][] inventario = worm.getInventario().getInv();
        s.itemCheck(worm, controle);
        // background
        image = ge.image("sprites/inventario/bg_1.png");
        g.drawImage(image, 0, 0, largura, altura, componente);
        image = ge.image("sprites/inventario/bg_2.png");
        g.drawImage(image, 0, 0, largura, altura, componente);
        // loja
        image = ge.image("sprites/inventario/SeuZé_1.png");
        g.drawImage(image, r.porcentagem(70, "w"), r.porcentagem(50, "h"), r.porcentagem(25, "w"),
                r.porcentagem(50, "h"), componente);
        image = ge.image("sprites/inventario/Loja_1.png");
        g.drawImage(image, r.porcentagem(70, "w"), r.porcentagem(50, "h"), r.porcentagem(25, "w"),
                r.porcentagem(50, "h"), componente);
        image = ge.image("sprites/inventario/Loja_2.png");
        g.drawImage(image, r.porcentagem(70, "w"), r.porcentagem(25, "h"), r.porcentagem(25, "w"),
                r.porcentagem(50, "h"), componente);
        for (int i = 0; i < 3; i++) {
            image = ge.image("sprites/inventario/Slot_1.png");
            g.drawImage(image, (r.porcentagem(70, "w") + r.porcentagem((i) * 10, "w")),
                    (r.porcentagem(80, "h") + r.porcentagem((i / 3) * 10, "h")), r.porcentagem(5, "w"),
                    r.porcentagem(10, "h"), componente);
            if (loja[i][1] != null) {
                image = ge.image(loja[i][0]);
                g.drawImage(image, (r.porcentagem(70, "w") + r.porcentagem((i) * 10, "w")),
                        (r.porcentagem(80, "h") + r.porcentagem((i / 3) * 10, "h")), r.porcentagem(5, "w"),
                        r.porcentagem(10, "h"), componente);
                image = ge.image(s.raridade(Integer.parseInt(loja[i][1])));
                g.drawImage(image, (r.porcentagem(70, "w") + r.porcentagem((i) * 10, "w")),
                        (r.porcentagem(80, "h") + r.porcentagem((i / 3) * 10, "h")), r.porcentagem(5, "w"),
                        r.porcentagem(10, "h"), componente);
            }
        }
        // slots
        for (int i = 0; i < 50; i++) {
            int x = r.porcentagem((i / 10) * 5, "w");
            int y = r.porcentagem((i % 10) * 10, "h");
            int w = r.porcentagem(5, "w");
            int h = r.porcentagem(10, "h");
            image = ge.image("sprites/inventario/Slot_1.png");
            g.drawImage(image, x, y, w, h, componente);
            if (inventario[i][0] != null) {
                image = ge.image(inventario[i][0]);
                g.drawImage(image, x, y, w, h, componente);
                image = ge.image(s.raridade(Integer.parseInt(inventario[i][2])));
                g.drawImage(image, x, y, w, h, componente);
                g.setFont(new Font("Arial", Font.BOLD, 24));
                g.drawString(inventario[i][1], x + r.porcentagem(1, "h"), y + r.porcentagem(3, "h"));

            } 
        }
        image = ge.image("sprites/inventario/SlotSelecionado_1.png");
        if (invx < 5) {
            g.drawImage(image, r.porcentagem(invx * 5, "w"), r.porcentagem(invy * 10, "h"),
                    r.porcentagem(5, "w"), r.porcentagem(10, "h"), componente);
        } else {
            g.drawImage(image, (r.porcentagem(70, "w") + r.porcentagem(((invx - 5)) * 10, "w")),
                    (r.porcentagem(80, "h")), r.porcentagem(5, "w"),
                    r.porcentagem(10, "h"), componente);
        }
        if (vendido && inventario[(invx * 5 + invy)][2] != null) {
            int raridade = Integer.parseInt(inventario[(invx * 5 + invy)][2]);
            int quantidade = Integer.parseInt(inventario[(invx * 5 + invy)][1]);
            switch (raridade) {
                case 5:
                    worm.getInventario().setDinheiro(worm.getInventario().getDinheiro() + 1 * quantidade);
                    break;
                case 4:
                    worm.getInventario().setDinheiro(worm.getInventario().getDinheiro() + 4 * quantidade);
                    break;
                case 3:
                    worm.getInventario().setDinheiro(worm.getInventario().getDinheiro() + 8 * quantidade);
                    break;
                case 2:
                    worm.getInventario().setDinheiro(worm.getInventario().getDinheiro() + 16 * quantidade);
                    break;
                case 1:
                    worm.getInventario().setDinheiro(worm.getInventario().getDinheiro() + 320 * quantidade);
                    break;
                case 0:
                    worm.getInventario().setDinheiro(worm.getInventario().getDinheiro() + 640 * quantidade);
                    break;
                default:
                    break;
            }
            inventario[(invx * 5 + invy)][0] = null;
            inventario[(invx * 5 + invy)][1] = null;
            inventario[(invx * 5 + invy)][2] = null;
        }
        if (comprado && invx>4) {
            s.comprar(worm,loja[invx-5][0], loja[invx - 5][1], controle);
        }
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("$" + worm.getInventario().getDinheiro(), r.porcentagem(25, "w"), r.porcentagem(3, "h"));

    }

}
