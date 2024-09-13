public class Cachorro {
    private String nome;

    public Cachorro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void latir(){
        System.out.println(this.getNome() + ": AU AU AU AU AU!");
    }
    
    public void abanar(){
        System.out.println(this.getNome() + ": ABANANDO...");

    }
    public void rosnar(){
        System.out.println(this.getNome() + ": GRRRRRRRRRRRRRRRR.....");
    }

}
