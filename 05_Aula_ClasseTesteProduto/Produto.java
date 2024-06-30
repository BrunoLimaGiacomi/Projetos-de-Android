
public class Produto 
{
	//Atributos
	private String nome;
	private double preco;
	
	//Método Construtor
	public Produto(String nome, double preco)
	{
		super();
		this.nome = nome;
		this.preco = preco;
	}

	//Get Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	

	
	

	
	
}
