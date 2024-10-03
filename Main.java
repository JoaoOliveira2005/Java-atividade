public class Main {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas(5);

        Data data1 = new Data(05, 12, 2004);
        Data data2 = new Data(9, 4, 2005);
        Data data3 = new Data(30, 9, 2005);

        Cliente cliente = new Cliente("João Rizza", data1, 1234);
        Funcionario funcionario = new Funcionario("Matheus ventura", data2, 3000f);
        Gerente gerente = new Gerente("Pedro Calil", data3, 7000f, "TI");

        cadastro.cadastraPessoa(cliente);
        cadastro.cadastraPessoa(funcionario);
        cadastro.cadastraPessoa(gerente);

        // Imprimir o cadastro completo
        cadastro.imprimeCadastro();

        // Acessando as pessoas pelo índice
        cadastro.acessaPessoaPorIndice(1);  // Deve acessar Maria
        cadastro.acessaPessoaPorIndice(3);  // Fora dos limites, lança exceção
    }
}

