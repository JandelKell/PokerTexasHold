import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double pote = 0;
        String priemira_carta, segunda_carta;
        Baralho baralho = new Baralho();
        System.out.println("quantos jogadores irão jogar");
        Scanner scan = new Scanner(System.in);
        int quantidade_jogadores = scan.nextInt();
        String jogadores[] = new String[quantidade_jogadores];
        Double apostas[] = new Double[quantidade_jogadores];
        for (int i = 0; i < jogadores.length; i++) {
            priemira_carta = baralho.darcarta();
            segunda_carta = baralho.darcarta();
            jogadores[i] = priemira_carta + " " + segunda_carta;
        }
        // aposta pre-flop
        for (int i = 0; i< apostas.length;i++){
            if(jogadores[i]!=null){
                System.out.println((i+1)+"º Jogador você gostaria de apostar:(1/0)");
                int entrada = scan.nextInt();
                if (entrada==1){
                    apostas[i] = Apostar(apostas[i]);
                }else{
                    jogadores[i] = null;
            }
            }
        }
        

    }
/*
    public static double Verificar_Aposta(double pote,String jogadores[]) {
        boolean loop = true;
        double apostas[] = new double[jogadores.length];
        Scanner scan = new Scanner(System.in);
        while (loop){
            double somatoria = 0;
            for (int i = 0; i < apostas.length; i++) {
                System.out.println( (i+1)+"º Jogador Digiete quanto voce quer apostar:");
                double aposta = scan.nextDouble();
                apostas[i] = aposta;
            }
            for (int i = 0;i<apostas.length;i++){
                somatoria = somatoria + apostas[i];
            }
            somatoria = somatoria/3;

            if (somatoria == apostas[(apostas.length-1)]) {
            somatoria = somatoria *3;
            pote = pote + somatoria;
            loop = false;
            }
        
    }
        return apostas;
    }*/
    public static double Apostar (Double apostas) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o quanto gostaria de aposta");
        double valor_aposta = scan.nextDouble();
        return valor_aposta;

    }
}