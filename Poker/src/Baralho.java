import java.util.Random;
import java.util.Scanner;

public class Baralho {
    String array_baralho[] = {"A_Espadas", "2_Espadas", "3_Espadas", "4_Espadas", "5_Espadas", "6_Espadas", "7_Espadas", "8_Espadas", "9_Espadas", "10_Espadas", "j_Espadas", "Q_Espadas", "K_Espadas", "A_Copa", "2_Copa", "3_Copa", "4_Copa", "5_Copa", "6_Copa", "7_Copa", "8_Copa", "9_Copa", "10_Copa", "j_Copa", "Q_Copa", "K_Copa", "A_Paus", "2_Paus", "3_Paus", "4_Paus", "5_Paus", "6_Paus", "7_Paus", "8_Paus", "9_Paus", "10_Paus", "j_Paus", "Q_Paus", "K_Paus", "A_Ouros", "2_Ouros", "3_Ouros", "4_Ouros", "5_Ouros", "6_Ouros", "7_Ouros", "8_Ouros", "9_Ouros", "10_Ouros", "j_Ouros", "Q_Ouros", "K_Ouros"};

    public void embaralhar() {
        String antigo = "";
        String novo = "";
        Random random = new Random();
        for (int i = 0; i < 500; i++) {
            int valorAleatorio = random.nextInt(52);
            antigo = array_baralho[valorAleatorio];
            if (novo != "") {
                array_baralho[valorAleatorio] = novo;
                novo = antigo;
            } else {
                novo = antigo;
            }

        }
    }

    public String darcarta() {
        String carta = null;
        for (int i = 0; i < array_baralho.length; ) {
            if (array_baralho[i] != null) {
                carta = array_baralho[i];
                array_baralho[i] = null;
                return carta;
            } else if (array_baralho[i] == null) {
                i++;
            } else {
                System.out.println("acabou as cartas");
            }
        }
        return carta;
    }


    public void temcarta() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a carta com nipe:");
        String carta_baralho = scan.nextLine();
        System.out.println("a carta selecionada e:"+ carta_baralho);
        for (int i = 0; i<array_baralho.length;i++){
            if(carta_baralho.equalsIgnoreCase(array_baralho[i])){
                System.out.println("a Carta ainda está no baralho ela é"+ carta_baralho);
            }
        }
        System.out.println("a carta infelizmente não esta mais no baralho");
    }

    public void imprimirbaralho() {
        for (int i = 0; i < array_baralho.length; i++) {
            System.out.println(array_baralho[i]);
        }
    }
}





