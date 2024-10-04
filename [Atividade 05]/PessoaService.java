public class PessoaService {
    
    private CadastroPessoas cadastroPessoas;

    public PessoaService() {
        cadastroPessoas = new CadastroPessoas();
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws QuantidadeExcedidaException {
        cadastroPessoas.cadastrarFuncionario(funcionario);
    }

    public void setGerente(Gerente gerente) throws QuantidadeExcedidaException {
        cadastroPessoas.setGerente(gerente);
    }

    public void imprimeCadastro() {
        cadastroPessoas.imprimeCadastro();
    }
}
