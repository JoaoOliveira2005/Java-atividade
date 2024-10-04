public class ClienteVip extends Cliente {
    
    private float percentualDesconto;

    public ClienteVip(String nome, Data nascimento, int codigo, float percentualDesconto) {
        super(nome, nascimento, codigo);
        this.percentualDesconto = percentualDesconto;
    }

    public float getPercentualDesconto() {
        return percentualDesconto;
    }

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Percentual de Desconto: " + percentualDesconto + "%");
    }
}
