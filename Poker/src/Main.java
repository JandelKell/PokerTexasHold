import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double pote = 0;
        String cartas = "";
        int quantidade_jogadores = 0;
        String flop_1, flop_2, flop_3, turn, river;
        String priemira_carta, segunda_carta;
        Baralho baralho = new Baralho();
        baralho.embaralhar();
        System.out.println("quantos jogadores irão jogar");
        Scanner scan = new Scanner(System.in);
        try {
            quantidade_jogadores = scan.nextInt();
        } catch (Exception e) {
            System.out.println("entrda invalida");
            System.exit(0);
        }
        String jogadores[] = new String[quantidade_jogadores];
        Double apostas[] = new Double[quantidade_jogadores];
        for (int i = 0; i < jogadores.length; i++) {
            priemira_carta = Converter_Carta(baralho.darcarta());
            segunda_carta = Converter_Carta(baralho.darcarta());
            jogadores[i] = priemira_carta + segunda_carta;
            System.out.printf("O cartas do %sº são: %n%s", (i + 1), jogadores[i]);
            System.out.println();
        }
        // aposta pre-flop
        pote = pote + Apostar(pote, jogadores);
        System.out.printf("O pote atual e de: R$ %.2f \n", pote);
        // flop
        flop_1 = Converter_Carta(baralho.darcarta());
        flop_2 = Converter_Carta(baralho.darcarta());
        flop_3 = Converter_Carta(baralho.darcarta());
        System.out.println("as cartas atuais da mesa sao:");
        System.out.println(flop_1 + " " + flop_2 + " " + flop_3);
        pote = pote + Apostar(pote, jogadores);
        System.out.printf("O pote atual e de: R$ %.2f \n", pote);
        //turn
        turn = Converter_Carta(baralho.darcarta());
        System.out.println("as cartas atuais da mesa sao:");
        System.out.println(flop_1 + " " + flop_2 + " " + flop_3 + " " + turn);
        pote = pote + Apostar(pote, jogadores);
        System.out.printf("O pote atual e de: R$ %.2f \n", pote);
        //river
        river = Converter_Carta(baralho.darcarta());
        System.out.println("as cartas atuais da mesa sao:");
        System.out.println(flop_1 + " " + flop_2 + " " + flop_3 + " " + turn + " " + river);
        pote = pote + Apostar(pote, jogadores);
        System.out.printf("O pote atual e de: R$ %.2f \n", pote);
        Final_Jogo(jogadores, pote);
    }

    public static double Apostar(Double pote, String jogadores[]) {
        double pote_new =0;
        double maior_aposta = 0;
        double incremento = 0;
        int ultima_aposta = 0;
        int contador = 0;
        boolean loop = true;
        Scanner scan = new Scanner(System.in);
        double apostas[] = new double[jogadores.length];
        while (loop) {
            for (int i = 0; i < apostas.length; i++) {
                if (!(jogadores[i].equals("Correu"))) {
                    String entrada = "";
                    System.out.println();
                    System.out.println((i + 1) + "º Jogador ainda Gostaria de participar do jogo: sim/não");
                    try {
                        entrada = scan.next();
                    } catch (Exception e) {
                        System.out.println("entrada invalida tente novamente");
                        System.exit(0);
                    }
                    if (entrada.equalsIgnoreCase("sim")) {
                        if (maior_aposta == 0 || maior_aposta > apostas[i]) {
                            double valor_aposta = 0;
                            System.out.println("a maior aposta atual é de:" + maior_aposta);
                            System.out.println("sua aposta atual é de:" + apostas[i]);
                            System.out.println("Digite o quanto gostaria de aposta: digite 0 se não quiser mais jogar");
                            try {
                                valor_aposta = scan.nextDouble();
                            } catch (Exception e) {
                                System.out.println("entrada invalida tente novamente");
                                System.exit(0);
                            }
                            apostas[i] = apostas[i] + valor_aposta;
                            pote_new = pote_new + valor_aposta;
                            ultima_aposta = i;
                            if (maior_aposta < valor_aposta) {
                                maior_aposta = valor_aposta;
                            }
                            if (valor_aposta == 0) {
                                jogadores[i] = "Correu";
                                System.out.println((i + 1) + "º jogador correu");
                                for (int k = 0; k < jogadores.length; k++) {
                                    System.out.println();
                                    if (jogadores[k].equalsIgnoreCase("Correu")) {
                                        System.out.printf("O jogador %s%n não está mais no jogo", (k+1));
                                    } else {
                                        System.out.printf("O jogador  %sº esta no jogo, é suas cartas são: %n%s", (k + 1), jogadores[k]);
                                        System.out.println();
                                    }
                                }
                            }
                        } else {
                            System.out.println("voce já é aposta mais alta");
                            loop = false;
                        }
                    } else {
                        jogadores[i] = "Correu";
                        System.out.println((i + 1) + "º jogador correu");
                        for (int j = 0; j < jogadores.length; j++) {
                            System.out.println();
                            if (jogadores[j].equalsIgnoreCase("Correu")) {
                                System.out.printf("O jogador %s%n não está mais no jogo", (j + 1));
                            } else {
                                System.out.printf("O jogador  %sº esta no jogo, é suas cartas são: %n%s", (j + 1), jogadores[j]);
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
                for (int i = 0; i < apostas.length; i++) {
                    if (!(jogadores[i].equals("Correu"))) {
                        incremento = incremento + apostas[i];
                        contador++;

                    }
                }
                incremento = incremento / contador;
                System.out.println("ainda tem :" + contador + " jogadores");
                System.out.println();
                if (contador == 1) {
                    pote = pote + pote_new;
                    Final_Jogo(jogadores, pote);

                }
                if (incremento == maior_aposta) {
                    return pote_new;
                } else {
                    System.out.println("entrada invalida");
                    System.exit(0);
                }
        return 0;
            }


            private static void Final_Jogo (String[]jogadores, Double pote){
                for (int i = 0; i < jogadores.length; i++) {
                    if (!(jogadores[i].equals("Correu"))) {
                        System.out.printf((i + 1) + "º jogar venceu a quantia:" + pote);
                        System.exit(0);
                    }
                }
            }
            private static String Converter_Carta (String cartas){
                String nipe = "";
                String nome = "";
                String card_1 = cartas;
                String card[] = new String[2];
                card = card_1.split("_");
                for (int i = 0; i < card.length; i++) {
                    if (i != 0) {
                        nipe = card[i];
                    } else {
                        nome = card[i];
                    }
                }
                Cartas carta = new Cartas(nipe, nome);
                carta.setNome(nome);
                carta.setNipe(nipe);
                nome = carta.getNome();
                nipe = carta.getNipe();
                String carta_final = nipe + nome;
                return carta_final;
            }
}