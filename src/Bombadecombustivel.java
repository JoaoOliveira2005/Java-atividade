class BombadeCombustivel {
    String tipoCombustivel;
    double valorLitro;
    double quantidadeCombustivel;
    double totalAbastecido;

    public BombadeCombustivel(String tipoCombustivel, double valorLitro, double quantidadeCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
        this.valorLitro = valorLitro;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.totalAbastecido = 0;
    }

    public void abastecerPorValor(double valor) {

        double litros = valor / valorLitro;

        if (litros <= quantidadeCombustivel) {
            quantidadeCombustivel -= litros;
            totalAbastecido += valor;
            System.out.println("abastecido: " + litros + " litros.");
        } else {
            System.out.println("quantidade de combustível insuficiente.");
        }
    }

    public void abastecerPorLitro(double litros) {
        if (litros <= quantidadeCombustivel) {
            double valor = litros * valorLitro;
            quantidadeCombustivel -= litros;
            totalAbastecido += valor;
            System.out.println("valor a ser pago: R$ " + valor);
        } else {
            System.out.println("quantidade de combustível insuficiente");
        }
    }

    public void alterarValor(double novoValor) {
        valorLitro = novoValor;
        System.out.println("novo valor do litro: R$ " + novoValor);
    }

    public void alterarCombustivel(String novoTipo) {
        tipoCombustivel = novoTipo;
        System.out.println("novo tipo de combustível: " + novoTipo);
    }

    public void alterarQuantidadeCombustivel(double novaQuantidade) {
        quantidadeCombustivel = novaQuantidade;
        System.out.println("nova quantidade de combustível: " + novaQuantidade + " litros.");
    }

}

