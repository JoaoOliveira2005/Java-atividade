import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstoqueTest {
    private Estoque estoque;

    @BeforeEach
    public void setUp() {
        estoque = new Estoque();
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto("Produto A", 10.0);
        assertTrue(estoque.adicionarProduto(produto));
        assertFalse(estoque.adicionarProduto(produtoProduplito ));
    }

    @Test
    public void testRemoverProduto() {
        Produto produto = new Produto("Produto A", 10.0);
        estoque.adicionarProduto(produto);
        assertTrue(estoque.removerProduto("Produto A"));
        assertFalse(estoque.removerProduto("Produto A")); 
    }

    @Test
    public void testBuscarProduto() {
        Produto produto = new Produto("Produto A", 10.0);
        estoque.adicionarProduto(produto);
        assertNotNull(estoque.buscarProduto("Produto A"));
        assertNull(estoque.buscarProduto("Produto B"));
    }
}
