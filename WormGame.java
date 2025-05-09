import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import entidades.*;
import janelas.*;
import functions.*;

public class WormGame extends JPanel implements ActionListener {
    private final ControlePersonagem controle = new ControlePersonagem();
    private Worm worm = new Worm();
    private Jjogo jjogo = new Jjogo();
    private Redimension r = new Redimension();
    private WorldGeneration w = new WorldGeneration();
    private Geral ge = new Geral();
    String seed = "0";
    int[] world = w.gen(seed);

    int[][] worldc = new int[50][50];
    int worldx = 25;
    int worldy = 25;
    int worldn = 1;
    List<int[]> worlds = new ArrayList<>();

    public WormGame() {
        Timer timer = new Timer(16, this); // ~60 FPS
        timer.start();

        worlds.add(world);
        worldc[worldx][worldy] = worldn;

        setFocusable(true);
        addKeyListener(controle);
        controle.setVelocidade(5);

        JFrame frame = new JFrame("WormGame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] actualWorld = worlds.get(worldc[worldx][worldy] - 1);
        jjogo.desenhar(g, worm, getWidth(), getHeight(), this, controle.getVelocidadeX(), controle.getVelocidadeY(),
                actualWorld);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (0 != controle.getVelocidadeX() || 0 != controle.getVelocidadeY()) {
            if (worm.getX() + controle.getVelocidadeX() >= 0 && worm.getX() + controle.getVelocidadeX() <= getWidth())
                worm.setX(worm.getX() + controle.getVelocidadeX());
            else {
                try {
                    String direcao = r.direcao(controle.getVelocidadeX(), controle.getVelocidadeY(), "a");
                    switch (direcao) {
                        case "a" -> {
                            worldx -= 1;
                            if (worldx <= 0)
                                worldx = 49;
                            if (worldc[worldx][worldy] != 0)
                                worldn = worldc[worldx][worldy];
                            else {
                                worldn = ge.maxBi(worldc) + 1;
                                worlds.add(w.gen(seed + (worldn * worldn)));
                            }
                            worldc[worldx][worldy] = worldn;
                            worm.setX(getWidth());
                        }
                        case "d" -> {
                            worldx += 1;
                            if (worldx >= 50)
                                worldx = 0;
                            if (worldc[worldx][worldy] != 0)
                                worldn = worldc[worldx][worldy];
                            else {
                                worldn = ge.maxBi(worldc) + 1;
                                worlds.add(w.gen(seed + (worldn * worldn)));
                            }
                            worldc[worldx][worldy] = worldn;
                            worm.setX(0);
                        }
                        default -> {
                            System.out.println(direcao);
                            worldy += 1;
                            worldc[worldx][worldy] = worldn;
                            worm.setY(getHeight());
                        }
                    }
                    System.out.println("x:" + worldx + "\ny:" + worldy +"\nn:"+worldn+"\n_______");
                } catch (Exception ex) {
                }
            }
            if (worm.getY() + controle.getVelocidadeY() >= 0 && worm.getY() + controle.getVelocidadeY() <= getHeight())
                worm.setY(worm.getY() + controle.getVelocidadeY());
            else {
                try {
                    String direcao = r.direcao(controle.getVelocidadeX(), controle.getVelocidadeY(), "a");
                    switch (direcao) {
                        case "s" -> {
                            worldy -= 1;
                            if (worldy <= 0)
                                worldy = 49;
                            if (worldc[worldx][worldy] != 0)
                                worldn = worldc[worldx][worldy];
                            else {
                                worldn = ge.maxBi(worldc) + 1;
                                worlds.add(w.gen(seed + (worldn * worldn)));
                            }
                            worldc[worldx][worldy] = worldn;
                            worm.setY(0);
                        }
                        case "w" -> {
                            worldy += 1;
                            if (worldy >= 50)
                                worldy = 0;
                            if (worldc[worldx][worldy] != 0)
                                worldn = worldc[worldx][worldy];
                            else {
                                worldn = ge.maxBi(worldc) + 1;
                                worlds.add(w.gen(seed + (worldn * worldn)));
                            }
                            worldc[worldx][worldy] = worldn;
                            worm.setY(getHeight());
                        }
                        default -> {
                             System.out.println(direcao);
                            worldy += 1;
                            worldc[worldx][worldy] = worldn;
                            worm.setY(getHeight());
                        }
                    }
                    System.out.println("x:" + worldx + "\ny:" + worldy + "\nn:" + worldn + "\n_______");
                } catch (Exception ex) {
                }
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        new WormGame();
    }
}
