public class Funcionario extends Pessoa {
    
    float salario;

    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }

    @Override
    public void imprimeDados() {
        
        System.out.println("Funcionário: " + nome + ", Salário: " + salario + ", Nascimento: " + nascimento);
        
    }

    public float calculaImposto() {
        return salario * 0.03f;
    }
}
