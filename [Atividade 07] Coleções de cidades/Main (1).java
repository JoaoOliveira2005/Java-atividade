import java.util.*;


public class Main {
    public static void main(String[] args) {


        List<Cidade> cidades = Arrays.asList(
                new Cidade("GO", "Anápolis"),
                new Cidade("GO", "Goiânia"),
                new Cidade("SP", "Ribeirão Preto"),
                new Cidade("SP", "Campinas"),
                new Cidade("MG", "Belo Horizonte"),
                new Cidade("MG", "Uberlândia"),
                new Cidade("MG", "Montes Claros"),
                new Cidade("MG", "Unaí"),
                new Cidade("TO", "Palmas"),
                new Cidade("TO", "Araguarí"),
                new Cidade("MT", "Cuiabá"),
                new Cidade("MS", "Dourados"),
                new Cidade("MS", "Campo Grande"),
                new Cidade("MS", "Corumbá"),
                new Cidade("MT", "Barra do Garças"),
                new Cidade("MT", "Araguaiana"),
                new Cidade("RO", "Porto Velho"),
                new Cidade("RO", "Costa Marques")
        );


        Map<String, TreeSet<String>> cidadesPorUf = new TreeMap<>();


        for (Cidade cidade : cidades) {
            cidadesPorUf

                    .computeIfAbsent(  cidade.getUf(), k ->  new TreeSet<>() )

                    .add(cidade.getNome());
        }



        for (Map.Entry<String, TreeSet<String>> entry : cidadesPorUf.entrySet()) {
            
            System.out.println("UF: " + entry.getKey());
            
            for (String cidade : entry.getValue()) {
                
                System.out.println("  - " + cidade);
                
            }
        }
    }
}
