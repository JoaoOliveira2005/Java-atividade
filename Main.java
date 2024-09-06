import java.util.Scanner;


interface Imposto {
    double calcular(double valor);
}


class ISS implements Imposto {
    private static final double ALIQUOTA = 0.073;


    public double calcular(double valor) {
        return valor * ALIQUOTA;
    }
}


class ICMS implements Imposto {
    private static final double ALIQUOTA = 0.132;

    public double calcular(double valor) {
        return valor * ALIQUOTA;
    }
}


class IPI implements Imposto {
    private static final double ALIQUOTA = 0.219;


    public double calcular(double valor) {
        return valor * ALIQUOTA;
    }
}


class Produto {
    private String nome;
    private double precoBase;

    public Produto(String nome, double precoBase)
    {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    String getNome()
    {
        return nome;
    }

    double getPrecoBase()
    {
        return precoBase;
    }
}


class OperacaoComercial {
    Produto produto;
    double icms;
    double ipi;
    double valorTotal;

    public OperacaoComercial(Produto produto) {
        this.produto = produto;
        calcularImpostos();
    }

    void calcularImpostos() {
        ICMS icms = new ICMS();
        IPI ipi = new IPI();
        this.icms = icms.calcular(produto.getPrecoBase());
        this.ipi = ipi.calcular(produto.getPrecoBase());
        this.valorTotal = produto.getPrecoBase() + this.icms + this.ipi;
    }

    void exibirDetalhes() {
        System.out.println("Item: " + produto.getNome());
        System.out.println("Preço base: R$" + produto.getPrecoBase());
        System.out.println("IPI: R$" + this.ipi);
        System.out.println("ICMS: R$" + this.icms);
        System.out.println("Valor total: R$" + this.valorTotal);
    }
}


 public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double precoProduto = scanner.nextDouble();

        Produto produto = new Produto(nomeProduto, precoProduto);


        OperacaoComercial operacaoProduto = new OperacaoComercial(produto);

        operacaoProduto.exibirDetalhes();

        scanner.close();
    }
}

