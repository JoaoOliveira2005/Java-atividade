public class Cidade {
    private String nome;
    private String uf;

    public Cidade(String uf, String nome) {
        this.uf = uf;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}