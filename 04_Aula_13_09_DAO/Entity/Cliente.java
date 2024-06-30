package Entity;

public class Cliente 
{
	//Atributos
	private int id;
	private String nome;
	private String email;
	private String endereco;

	// Metodo Construtor I
	public Cliente() 
	{
		super();
	}
	
	// Metodo Construtor II
	public Cliente(int id, String nome, String email, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	

	
	

    
	
}
