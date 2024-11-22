public class Cidade implements Comparable<Cidade> {
    
    private String nome;
    private String uf;
    private boolean capital;

    public Cidade(String uf, String nome, boolean capital) {
        
        this.uf = uf;
        this.nome = nome;
        this.capital = capital;
    }

    public String getNome() {
        
        return nome;
    }

    public String getUf() {
        
        return uf;
    }


    //usando o comparable 
    @Override
    public int compareTo(Cidade outra) {
        return outra.nome.compareTo(this.nome);
    }
}
