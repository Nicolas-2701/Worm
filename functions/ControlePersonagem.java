package functions;

import java.awt.event.*;

public class ControlePersonagem extends KeyAdapter {
    private int velocidadeX = 0, velocidadeY = 0;
    private int velocidade;
    private boolean inv = false;
    private boolean rfinv = false;
    private boolean lock = false;

    public int getVelocidadeX() {
        return velocidadeX;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getVelocidadeY() {
        return velocidadeY;
    }

    public boolean isInv() {
        return inv;
    }

    public boolean isRfinv() {
        return rfinv;
    }

    public void setRfinv(boolean rfinv) {
        this.rfinv = rfinv;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!lock){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A -> {
                    velocidadeX = -velocidade;
                    velocidadeY = 0;
                }
                case KeyEvent.VK_D -> {
                    velocidadeX = velocidade;
                    velocidadeY = 0;
                }
                case KeyEvent.VK_W -> {
                    velocidadeY = -velocidade;
                    velocidadeX = 0;
                }
                case KeyEvent.VK_S -> {
                    velocidadeY = velocidade;
                    velocidadeX = 0;
                }
                case KeyEvent.VK_E -> {
                    velocidadeX = 0;
                    velocidadeY = 0;
                    inv = true;
                    lock = true;
                }
            }
        } else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_E -> {
                    inv = false;
                    lock = false;
                    rfinv = true;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A, KeyEvent.VK_D -> velocidadeX = 0;
            case KeyEvent.VK_W, KeyEvent.VK_S -> velocidadeY = 0;
        }
    }
}
