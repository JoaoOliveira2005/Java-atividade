import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {
    
    private List<Funcionario> funcionarios;
    private Gerente gerente;

    public CadastroPessoas() {
        
        funcionarios = new ArrayList<>();
        
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws QuantidadeExcedidaException {
        
        if (funcionarios.size() >= 7) {
            
            throw new QuantidadeExcedidaException("Quantidade máxima de funcionários excedida (máximo: 7).");
        }
        funcionarios.add(funcionario);
    }

    public void setGerente(Gerente gerente) throws QuantidadeExcedidaException {
        
        if (this.gerente != null) {
            
            throw new QuantidadeExcedidaException("Já existe um gerente cadastrado.");
        }
        this.gerente = gerente;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void imprimeCadastro() {
        System.out.println("Cadastro de Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            funcionario.imprimeDados();
        }
        if (gerente != null) {
            gerente.imprimeDados();
        } else {
            System.out.println("Nenhum gerente cadastrado.");
        }
    }
}
