public class Gerente extends Funcionario {
    String area;

    public Gerente(String nome, Data nascimento, float salario, String area) {
        super(nome, nascimento, salario);
        this.area = area;
    }

    @Override
    public void imprimeDados() {
        System.out.println("gerente: " + nome + ", area: " + area + ", salário: " + salario + ", nascimento: " + nascimento);
    }

    @Override
    public float calculaImposto() {
        return salario * 0.05f;
    }
}
