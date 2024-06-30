
public class DescontoProduto 
{
	//Atributos
	private double milReais = 1000.00;
	private double dezPorCento = 0.1;
	
	//M�todo para calcular o desconto
	// Se Valor do produto > 1000 ent�o retorna 
	// o valor com 10% de desconto
	public double ValorDesconto(Produto prod)
	{
		//Recuperar valor do produto
		double precoProduto = prod.getPreco();
		
		//Verificando se > 1000.00 
		if(precoProduto >= 1000.00) 
		{
			return precoProduto * dezPorCento;
		}
	
		//Caso n�o entre no if retorna 0.0
		return 0.0;
	}
}
