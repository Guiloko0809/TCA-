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

        for (int i = 0; i < 10; i++) {
            
           int valorFaces1 = mostrarFaces.nextInt(6) + 1;
           int valorFaces2 = mostrarFaces.nextInt(6) + 1;
           
           MostrarDados(valorFaces1, valorFaces2);
           System.out.print("\u001B[5A");
           System.out.flush();

            try{
                Thread.sleep(60 * ((i / 2) + 1) );
            }
            catch(InterruptedException e){

            }
        }

        MostrarDados(dado1, dado2);

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

}