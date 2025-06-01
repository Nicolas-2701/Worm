package functions;

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import java.awt.*;

import java.io.File;
import java.io.IOException;

public class Geral {
    public void tocarSom(String caminhoArquivo) {
        try {
            File arquivo = new File(caminhoArquivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // inicia o som
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public int maxBi(int [] [] array){
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }

        return max;
    }

    public Image image (String url){
        ImageIcon icon  = new ImageIcon(url);
        return icon.getImage();
    }
}
