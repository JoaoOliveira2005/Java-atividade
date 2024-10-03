public class CadastroPessoas {
    
    Pessoa[] pessoas;
    
    int qtdAtual;

    public CadastroPessoas(int tamanho) {
        pessoas = new Pessoa[tamanho];
        qtdAtual = 0;
    }

    public void cadastraPessoa(Pessoa pess) 
    {
        if (qtdAtual < pessoas.length) 
        {
            pessoas[qtdAtual] = pess;
            qtdAtual++;
        } 
        else {
            System.out.println("cadastro cheio");
            
        }
        
        
    }


    public void imprimeCadastro() 
    {
        for (int i = 0; i < qtdAtual; i++) {
            pessoas[i].imprimeDados();
        }
    }

    public void acessaPessoaPorIndice(int indice) {
        try {
            Pessoa pessoa = pessoas[indice];
            pessoa.imprimeDados();
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Índice fora do limite do array.");
            
        } 
        catch (NullPointerException e) {
            System.out.println("Erro: Nenhuma pessoa cadastrada neste indice.");
        }
    }
}
