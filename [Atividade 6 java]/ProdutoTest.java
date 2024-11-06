import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void testCriacaoProduto() {
        Produto produto = new Produto("Produto A", 10.0);
        assertEquals("Produto A", produto.getNome());
        assertEquals(10.0, produto.getPreco());
    }

    @Test
    public void testIgualdadeProdutos() {
        Produto produto1 = new Produto("Produto A", 10.0);
        Produto produto2 = new Produto("Produto A", 15.0); 
        assertEquals(produto1, produto2);
    }

    @Test
    public void testComparacaoPrecos() {
        Produto produto1 = new Produto("Produto A", 10.0);
        Produto produto2 = new Produto("Produto B", 15.0);
        assertTrue(produto1.compareTo(produto2) < 0); 
        assertTrue(produto2.compareTo(produto1) > 0); 
    }
}
