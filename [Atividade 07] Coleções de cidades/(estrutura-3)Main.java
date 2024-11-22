import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Set<Cidade> conjuntoCidades = new TreeSet<>(
            (c1, c2) -> c2.getNome().compareTo(c1.getNome()) 
        );



        conjuntoCidades.add(new Cidade("GO", "Anápolis", false));
        conjuntoCidades.add(new Cidade("GO", "Goiânia", true));
        conjuntoCidades.add(new Cidade("SP", "Ribeirão Preto", false));
        conjuntoCidades.add(new Cidade("SP", "Campinas", false));
        conjuntoCidades.add(new Cidade("MG", "Belo Horizonte", true));
        conjuntoCidades.add(new Cidade("MG", "Uberlândia", false));
        conjuntoCidades.add(new Cidade("MG", "Montes Claros", false));
        conjuntoCidades.add(new Cidade("MG", "Unaí", false));
        conjuntoCidades.add(new Cidade("TO", "Palmas", true));
        conjuntoCidades.add(new Cidade("TO", "Araguarí", false));
        conjuntoCidades.add(new Cidade("MT", "Cuiabá", true));
        conjuntoCidades.add(new Cidade("MS", "Dourados", false));
        conjuntoCidades.add(new Cidade("MS", "Campo Grande", true));
        conjuntoCidades.add(new Cidade("MS", "Corumbá", false));
        conjuntoCidades.add(new Cidade("MT", "Barra do Garças", false));
        conjuntoCidades.add(new Cidade("MT", "Araguaiana", false));
        conjuntoCidades.add(new Cidade("RO", "Porto Velho", true));
        conjuntoCidades.add(new Cidade("RO", "Costa Marques", false));




        for (Cidade cidade : conjuntoCidades) {
            System.out.println(cidade.getNome() + " - " + cidade.getUf());
        }
    }
}
