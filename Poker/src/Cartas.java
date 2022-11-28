public class Cartas {
    String nome;
    String nipe;

    public Cartas(String nipe, String nome) {
        this.nome = nome;
        this.nipe = nipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNipe() {
        switch (nipe){
            case "Copa":
                nipe = "♥";
                return nipe;
            case "Espadas":
                nipe = "♠";
                return nipe;
            case "Paus":
                nipe = "♣";
                return nipe;
            case "Ouros":
                nipe = "♦";
                return nipe;
        }
        return null;
    }

    public void setNipe(String nipe) {
        this.nipe = nipe;
    }
}
