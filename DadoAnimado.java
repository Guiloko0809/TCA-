import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.lang.Thread;


public class DadoAnimado{

    static Random mostrarFaces = new Random();

    public static void MostrarDados(int valorDoDadox, int valorDoDadoy){

            
            for (int j = 0; j < FACES[0].length; j++) {
                
                System.out.print(FACES[valorDoDadox-1][j] + " " + FACES[valorDoDadoy-1][j]);
                System.out.println();
            }
        }

    public static void animarDados(int dado1, int dado2){

        tocarSom("sons/Dado_Rolando.wav", false); // toca e o jogo segue

        for (int i = 0; i < 10; i++) {
            
           int valorFaces1 = mostrarFaces.nextInt(6) + 1;
           int valorFaces2 = mostrarFaces.nextInt(6) + 1;
           
           MostrarDados(valorFaces1, valorFaces2);
           System.out.print("\u001B[5A");
           System.out.flush();

            try{
                Thread.sleep(62 * ((i / 2) + 1) );
            }
            catch(InterruptedException e){

            }
        }

        MostrarDados(dado1, dado2);

    }    

    public static void tocarSom(String caminhoArquivoSom, boolean esperarTerminar){
              
        try {
            // Abrindo o arquivo de som
            File soundFile = new File(caminhoArquivoSom);
            if (!soundFile.exists()) {
                System.out.println("Arquivo de som não encontrado: " + caminhoArquivoSom);
                return;
            }

            // Criando um AudioInputStream
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            // Obtendo as informações do formato de áudio
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            // Criando o Clip e carregando o áudio
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);

            // Tocando o áudio
            // O áudio já foi carregado no Clip, então o arquivo pode ser fechado
            audioStream.close();

            // Quando o som terminar, libera os recursos automaticamente
            audioClip.addLineListener(evento -> {
                if (evento.getType() == LineEvent.Type.STOP) {
                    audioClip.close();
                }
            });

            // Tocando o áudio
            audioClip.start();

            // Se pediu para esperar, segura o programa enquanto o som toca
            if (esperarTerminar) {
                Thread.sleep(audioClip.getMicrosecondLength() / 1000);
            }
        } catch (UnsupportedAudioFileException e) {
            System.err.println("O formato de áudio não é suportado.");
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.err.println("Linha de áudio não disponível.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de áudio.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("O programa foi interrompido.");
            e.printStackTrace();
        }
    }

     public static final String[][] FACES = {   //digite (chcp 65001) no terminal pra liberar os caracteres
        {
            " ----- ",
            "|     |",
            "|  󠁯●  |",
            "|     |",
            " ----- "
        },
        {
            " ----- ",
            "| ●   |",
            "|     |",
            "|   ● |",
            " ----- "
        },
        {
            " ----- ",
            "| ●   |",
            "|  ●  |",
            "|   ● |",
            " ----- "
        },
        {
            " ----- ",
            "| ● ● |",
            "|     |", 
            "| ● ● |",
            " ----- "
        },
        {
            " ----- ",
            "| ● ● |",
            "|  ●  |",
            "| ● ● |",
            " ----- "
        },
        {
            " ----- ",
            "| ● ● |",
            "| ● ● |",
            "| ● ● |",
            " ----- "
        }

        
    };

    public static void main(String[] args) {
        

        animarDados(1, 2); // apenas teste
    }
}