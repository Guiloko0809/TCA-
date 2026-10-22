import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class DadoAnimado {

    // Faces do dado em ASCII Art
    private static final String[][] FACES = {
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
        DadoAnimado jogo = new DadoAnimado();
        jogo.jogarDado("dado.wav"); // Substitua pelo nome do seu arquivo de som
    }

    public void jogarDado(String caminhoSom) {
        Random random = new Random();
        
        // 1. Inicia o som em uma thread separada para não travar a animação
        tocarSom(caminhoSom);

        System.out.println("Jogando o dado...");
        
        // 2. Executa a animação rodando as faces
        int framesAnimacao = 15;
        int faceSorteada = 0;
        
        for (int i = 0; i < framesAnimacao; i++) {
            // Escolhe uma face aleatória para o efeito de rotação
            faceSorteada = random.nextInt(6); 
            imprimirFace(faceSorteada);
            
            // Pausa curta entre os frames para dar efeito de movimento
            esperar(120); 
            
            // Limpa o console (funciona melhor em terminais externos)
            limparConsole();
        }

        // 3. Resultado Final
        int resultadoFinal = random.nextInt(6); // Gera o número definitivo (0 a 5)
        System.out.println("======= RESULTADO =======");
        imprimirFace(resultadoFinal);
        System.out.println("Você tirou o número: " + (resultadoFinal + 1));
        System.out.println("=========================");
    }

    // Método auxiliar para imprimir a arte ASCII da face
    private void imprimirFace(int indiceFace) {
        for (String linha : FACES[indiceFace]) {
            System.out.println(linha);
        }
    }

    // Método para tocar o arquivo de áudio WAV
    private void tocarSom(String caminhoArquivo) {
        new Thread(() -> {
            try {
                File arquivoSom = new File(caminhoArquivo);
                if (!arquivoSom.exists()) {
                    System.out.println("[Aviso] Arquivo de som não encontrado: " + caminhoArquivo);
                    return;
                }
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivoSom);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println("Erro ao reproduzir o som: " + e.getMessage());
            }
        }).start();
    }

    // Método para pausar a execução (fazer o delay do frame)
    private void esperar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Método para tentar "limpar" a tela do terminal
    private void limparConsole() {
        // Imprime linhas em branco para empurrar o frame anterior para cima
        // (Solução universal simples para IDEs como Eclipse/IntelliJ)
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}
