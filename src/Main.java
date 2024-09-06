import java.util.Scanner;

class Main {

    public static void main(String[] args) {
             Scanner scanner = new Scanner(System.in);
             BombadeCombustivel bomba = new BombadeCombustivel("Gasolina", 6.19, 10000);

             int opcao;
             do {
                 System.out.println("\nEscolha uma opção:");
                 System.out.println("1. Abastecer por valor");
                 System.out.println("2. Abastecer por litros");
                 System.out.println("3. Alterar valor do litro");
                 System.out.println("4. Alterar tipo de combustível");
                 System.out.println("5. Alterar quantidade de combustível restante");
                 System.out.println("6. Sair");

                 opcao = scanner.nextInt();

                 switch (opcao) {
                     case 1:
                         System.out.print("Informe o valor a ser abastecido: ");
                         double valor = scanner.nextDouble();
                         bomba.abastecerPorValor(valor);
                         break;
                     case 2:
                         System.out.print("Informe a quantidade de litros: ");
                         double litros = scanner.nextDouble();
                         bomba.abastecerPorLitro(litros);
                         break;
                     case 3:
                         System.out.print("Informe o novo valor por litro: ");
                         double novoValor = scanner.nextDouble();
                         bomba.alterarValor(novoValor);
                         break;
                     case 4:
                         System.out.print("Informe o novo tipo de combustível: ");
                         String novoTipo = scanner.next();
                         bomba.alterarCombustivel(novoTipo);
                         break;
                     case 5:
                         System.out.print("Informe a nova quantidade de combustível restante: ");
                         double novaQuantidade = scanner.nextDouble();
                         bomba.alterarQuantidadeCombustivel(novaQuantidade);
                         break;
                     case 6:
                         System.out.println("Saindo...");
                         break;
                     default:
                         System.out.println("Opção inválida.");
                 }
             } while (opcao != 6);

             scanner.close();
         }
     }
