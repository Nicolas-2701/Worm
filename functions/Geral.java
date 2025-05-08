package functions;

import javax.sound.sampled.*;
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
}
