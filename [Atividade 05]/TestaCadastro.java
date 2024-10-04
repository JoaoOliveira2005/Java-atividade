import java.util.Scanner;

public class TestaCadastro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaService pessoaService = new PessoaService();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Cadastrar Gerente");
            System.out.println("3. Cadastrar Cliente VIP");
            System.out.println("4. Imprimir Cadastro");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha
            
            switch (opcao) {
                case 1:
                    // Cadastrar Funcionário
                    System.out.print("Nome: ");
                    String nomeFuncionario = scanner.nextLine();
                    System.out.print("Data de nascimento (dia mes ano): ");
                    int dia = scanner.nextInt();
                    int mes = scanner.nextInt();
                    int ano = scanner.nextInt();
                    Data dataNascimentoFuncionario = new Data(dia, mes, ano);
                    System.out.print("Salário: ");
                    float salario = scanner.nextFloat();
                    Funcionario funcionario = new Funcionario(nomeFuncionario, dataNascimentoFuncionario, salario);
                    try {
                        pessoaService.cadastrarFuncionario(funcionario);
                        System.out.println("Funcionário cadastrado com sucesso.");
                    } catch (QuantidadeExcedidaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    // Cadastrar Gerente
                    System.out.print("Nome: ");
                    String nomeGerente = scanner.nextLine();
                    System.out.print("Data de nascimento (dia mes ano): ");
                    dia = scanner.nextInt();
                    mes = scanner.nextInt();
                    ano = scanner.nextInt();
                    Data dataNascimentoGerente = new Data(dia, mes, ano);
                    System.out.print("Salário: ");
                    salario = scanner.nextFloat();
                    Gerente gerente = new Gerente(nomeGerente, dataNascimentoGerente, salario, "Área de Gerência");
                    try {
                        pessoaService.setGerente(gerente);
                        System.out.println("Gerente cadastrado com sucesso.");
                    } catch (QuantidadeExcedidaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    // Cadastrar Cliente VIP
                    System.out.print("Nome: ");
                    String nomeClienteVip = scanner.nextLine();
                    System.out.print("Data de nascimento (dia mes ano): ");
                    dia = scanner.nextInt();
                    mes = scanner.nextInt();
                    ano = scanner.nextInt();
                    Data dataNascimentoClienteVip = new Data(dia, mes, ano);
                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Percentual de desconto: ");
                    float percentualDesconto = scanner.nextFloat();
                    ClienteVip clienteVip = new ClienteVip(nomeClienteVip, dataNascimentoClienteVip, codigo, percentualDesconto);
                    System.out.println("Cliente VIP cadastrado com sucesso.");
                    break;

                case 4:
                    // Imprimir Cadastro
                    pessoaService.imprimeCadastro();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
