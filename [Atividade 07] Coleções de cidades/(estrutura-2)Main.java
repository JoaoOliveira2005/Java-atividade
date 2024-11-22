import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        List<Cidade> cidades = Arrays.asList(
            new Cidade("GO", "Anápolis", false),
            new Cidade("GO", "Goiânia", true),
            new Cidade("SP", "Ribeirão Preto", false),
            new Cidade("SP", "Campinas", false),
            new Cidade("MG", "Belo Horizonte", true),
            new Cidade("MG", "Uberlândia", false),
            new Cidade("MG", "Montes Claros", false),
            new Cidade("MG", "Unaí", false),
            new Cidade("TO", "Palmas", true),
            new Cidade("TO", "Araguarí", false),
            new Cidade("MT", "Cuiabá", true),
            new Cidade("MS", "Dourados", false),
            new Cidade("MS", "Campo Grande", true),
            new Cidade("MS", "Corumbá", false),
            new Cidade("MT", "Barra do Garças", false),
            new Cidade("MT", "Araguaiana", false),
            new Cidade("RO", "Porto Velho", true),
            new Cidade("RO", "Costa Marques", false)
        );

        Map<String, List<Cidade>> cidadesPorUf = new TreeMap<>();



        for (Cidade cidade : cidades) {
            cidadesPorUf
            
                .computeIfAbsent(cidade.getUf(), k -> new ArrayList<>())
                
                .add(cidade);
        }

        for (Map.Entry<String, List<Cidade>> entry : cidadesPorUf.entrySet()) {
            
            System.out.println("UF: " + entry.getKey());

            List<Cidade> cidadesDaUf = entry.getValue();
            
            cidadesDaUf.sort((c1, c2) -> {
                
                if (c1.isCapital() && !c2.isCapital()) return -1;
                
                if (!c1.isCapital() && c2.isCapital()) return 1;
                
                
                return c1.getNome().compareTo(c2.getNome()); 
            });


            for (Cidade cidade : cidadesDaUf) {
                System.out.println((cidade.isCapital() ? "  * " : "    ") + cidade.getNome());
            }
        }
    }
}
