
public class Usuario 
{
	//Entidade!!!!
	//Responsável por 'manter os dados'
	//Em um único lugar!!!!!
	//Atributos
	private int id;
	private String nome;
	private String endereco;
	private String email;
	private String escolaridade;
	
	//Método Construtor I
	public Usuario()
	{
		
	}
	
	//Método Construtor II
	public Usuario(int id, String nome, 
		   String endereco, String email, 
		   String escolaridade) 
	{
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.escolaridade = escolaridade;
	}


	//Getters & Setters
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	
}



