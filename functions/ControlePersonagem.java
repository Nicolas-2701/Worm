package functions;

import java.awt.event.*;

public class ControlePersonagem extends KeyAdapter {
    private int velocidadeX = 0, velocidadeY = 0, xinv = 0, yinv = 0;;
    private int velocidade;
    private boolean inv = false, lock = false, rfinv = false, vendido = false, comprado = true;

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

    public int getXinv() {
        return xinv;
    }

    public int getYinv() {
        return yinv;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!lock) {
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
                case KeyEvent.VK_D -> {
                    if (xinv + 1 < 8)
                        xinv += 1;
                }
                case KeyEvent.VK_A -> {
                    if (xinv - 1 > -1)
                        xinv -= 1;
                }
                case KeyEvent.VK_S -> {
                    if (yinv + 1 < 10)
                        yinv += 1;
                }
                case KeyEvent.VK_W -> {
                    if (yinv - 1 > -1)
                        yinv -= 1;
                }
                case KeyEvent.VK_Q -> {
                    if (xinv + 1 < 5)
                        vendido = true;
                    else
                        comprado = true;
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
