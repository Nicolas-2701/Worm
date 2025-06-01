package janelas;

import java.awt.*;
import entidades.Worm;
import functions.*;

public class Jinv {

    private Redimension r = new Redimension();
    private Geral ge = new Geral();
    private Specific s = new Specific();

    public void desenhar(Graphics g, Worm worm, int largura, int altura, Component componente) {

        Image image;
        r.setW(largura);
        r.setH(altura);
        String[][] inventario = worm.getInv();
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
        }
        // slots
        for (int i = 0; i < 50; i++) {
            int x = r.porcentagem((i / 10) * 5, "w");
            int y = r.porcentagem((i % 10) * 10, "h");
            int w = r.porcentagem(5, "w");
            int h = r.porcentagem(10, "h");
            if (inventario[i][0] != null) {
                image = ge.image(inventario[i][0]);
                g.drawImage(image, x, y, w, h, componente);
                image = ge.image(s.raridade(Integer.parseInt(inventario[i][2])));
                g.drawImage(image, x, y, w, h, componente);
                g.setFont(new Font("Arial", Font.BOLD, 24));
                g.drawString(inventario[i][1], x + r.porcentagem(1, "h"), y + r.porcentagem(3, "h"));

            } else {
                image = ge.image("sprites/inventario/Slot_1.png");
                g.drawImage(image, x, y, w, h, componente);
            }
        }
    }

}
