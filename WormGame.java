import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entidades.*;
import janelas.*;
import functions.*;

public class WormGame extends JPanel implements ActionListener {
    private final ControlePersonagem controle = new ControlePersonagem();
    private Worm worm = new Worm();
    private Jjogo jjogo = new Jjogo();
    private Redimension r = new Redimension();

    public WormGame() {
        Timer timer = new Timer(16, this); // ~60 FPS
        timer.start();

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
        jjogo.desenhar(g, worm, getWidth(), getHeight(), this, controle.getVelocidadeX(), controle.getVelocidadeY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (0 != controle.getVelocidadeX() || 0 != controle.getVelocidadeY()) {
            worm.setX(worm.getX() + controle.getVelocidadeX());
            worm.setY(worm.getY() + controle.getVelocidadeY());
            repaint();
        }
    }

    public static void main(String[] args) {
        new WormGame();
    }
}
