
abstract class Veiculo {
    String categoria;
    double peso;
    double tarifaHora;

    Veiculo(String categoria, double peso) {
        this.categoria = categoria;
        this.peso = peso;
    }

    abstract void calcularTarifa();

    String obterCategoria() {
        return categoria;
    }

    double obterPeso() {
        return peso;
    }

    double obterTarifaHora() {
        return tarifaHora;
    }
}


class Motocicleta extends Veiculo {

    Motocicleta(double peso) {
        super("Motocicleta", peso);
        calcularTarifa();
    }

    void calcularTarifa() {
        if (peso <= 100) {
            tarifaHora = 2.00;
        } else if (peso <= 299.9) {
            tarifaHora = 4.00;
        } else if (peso >= 300) {
            tarifaHora = 10.00;
        } else {
            tarifaHora = 0.00;
        }
    }
}


class CarroPasseio extends Veiculo {

    CarroPasseio(String tipo, double peso) {
        super(tipo, peso);
        calcularTarifa();
    }

    void calcularTarifa() {
        if (peso > 2) {
            tarifaHora = 0.00; // Deve ser classificado como Furgão
        } else {
            switch (categoria) {
                case "Hatchback":
                    tarifaHora = 13.00;
                    break;
                case "Sedan":
                    tarifaHora = 15.00;
                    break;
                case "SUV":
                    tarifaHora = 20.00;
                    break;
                default:
                    tarifaHora = 0.00; // Tipo de carro inválido
            }
        }
    }
}


class Caminhonete extends Veiculo {

    Caminhonete(double peso) {
        super("Caminhonete", peso);
        calcularTarifa();
    }

    void calcularTarifa() {
        if (peso <= 3) {
            tarifaHora = 25.00;
        } else if (peso <= 6) {
            tarifaHora = 50.00;
        } else {
            tarifaHora = 0.00; // Não é aceito no estacionamento
        }
    }
}


class Furgao extends Veiculo {
    double volume;

    Furgao(double peso, double volume) {
        super("Furgão", peso);
        this.volume = volume;
        calcularTarifa();
    }

    void calcularTarifa() {
        if (peso > 6 || volume > 18) {
            tarifaHora = 0.00; // Não é aceito no estacionamento
        } else if (peso <= 3) {
            tarifaHora = 25.00;
        } else if (peso <= 6) {
            tarifaHora = 50.00;
        }
    }
}


class Estacionamento {
    void processarVeiculo(Veiculo veiculo) {
        if (veiculo.obterTarifaHora() == 0.00) {
            System.out.println("O veículo não pode ser aceito no estacionamento.");
        } else {
            System.out.println("Tipo de veículo: " + veiculo.obterCategoria());
            System.out.println("Peso: " + veiculo.obterPeso() + " toneladas");
            System.out.println("Tarifa por hora: R$ " + veiculo.obterTarifaHora());
        }
    }
}





public class Principal {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        java.util.Scanner entrada = new java.util.Scanner(System.in);

        while (true)
        {
            System.out.println("Informe o tipo de veículo (Motocicleta, CarroPasseio, Caminhonete, Furgao) ou 'sair' para encerrar:");
            String tipo = entrada.nextLine();

            if (tipo.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Informe o peso do veículo (em toneladas):");
            double peso = entrada.nextDouble();
            entrada.nextLine(); // Limpa o buffer do scanner

            Veiculo veiculo = null;

            switch (tipo.toLowerCase()) {
                case "motocicleta":
                    veiculo = new Motocicleta(peso);
                    break;
                case "caminhonete":
                    veiculo = new Caminhonete(peso);
                    break;
                case "carropasseio":
                    System.out.println("Informe o subtipo (Hatchback, Sedan, SUV):");
                    String subtipo = entrada.nextLine();
                    veiculo = new CarroPasseio(subtipo, peso);
                    break;
                case "furgao":
                    System.out.println("Informe o volume do furgão (em m3):");
                    double volume = entrada.nextDouble();
                    entrada.nextLine(); // Limpa o buffer do scanner
                    veiculo = new Furgao(peso, volume);
                    break;
                default:
                    System.out.println("Tipo de veículo inválido.");
            }

            if (veiculo != null) {
                estacionamento.processarVeiculo(veiculo);
            }
        }

        entrada.close();
    }
}
