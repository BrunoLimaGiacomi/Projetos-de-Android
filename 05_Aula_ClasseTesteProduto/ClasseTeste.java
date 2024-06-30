import junit.framework.TestCase;

public class ClasseTeste extends TestCase 
{
	//Instanciando a classe de cálculo do desconto
	DescontoProduto dc = new DescontoProduto();
	
	public void testProdutoBaratoNaoTemDesconto()
	{
		//1) Criando um produto para teste
		Produto caneta = new Produto("Caneta", 2.50);
		
		//Chama o método e recupera o valor de retorno
		double desconto = dc.ValorDesconto(caneta);
		
		// 3) Verificando assertividade do método
		//   assertEquals(ValorQueEspero, ValorQueEuRecebo)
		assertEquals(0.0 , desconto);
	}
	
	public void testProdutoIgual1000ReaisNaoTemDesconto()
	{
		//1) Criando um produto para teste
		Produto caneta = new Produto("Caneta", 1000.00);
		
		//Chama o método e recupera o valor de retorno
		double desconto = dc.ValorDesconto(caneta);
		
		// 3) Verificando assertividade do método
		//   assertEquals(ValorQueEspero, ValorQueEuRecebo)
		assertEquals(0.0 , desconto);
	}
	
	public void testProdutoMaiorQueMilReaisDeveTerDesconto()
	{
		//1) Criando um produto para teste
		Produto caneta = new Produto("Caneta", 10000.00);
		
		//Chama o método e recupera o valor de retorno
		double desconto = dc.ValorDesconto(caneta);
		
		// 3) Verificando assertividade do método
		//   assertEquals(ValorQueEspero, ValorQueEuRecebo)
		assertEquals(1000.0 , desconto);		
	}
	

}
