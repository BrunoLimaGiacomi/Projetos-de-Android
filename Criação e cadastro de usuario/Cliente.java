
public class Cliente {
	String codigo;
	 String nome;
	 String cidade;
	 String endereco;
	 String uf;
	 String bairo;
	 String fone;
	 
	 public Cliente(String codigo, String nome, String cidade, String endereco, String uf, String
	bairo, String fone) 
	{
	 this.codigo = codigo;
	 this.nome = nome;
	 this.cidade = cidade;
	 this.endereco = endereco;
	 this.uf = uf;
	 this.bairo = bairo;
	 this.fone = fone;
	 }
	 
	 public String getCodigo() 
	 {
		 return codigo;
		 }
	 
		 public void setCodigo(String codigo) 
		 {
		 this.codigo = codigo;
		 }
		 
		 public String getNome() 
		 {
		 return nome;
		 }
		 
		 public void setNome(String nome) 
		 {
		 this.nome = nome;
		 }
		 
		 public String getCidade() 
		 {
		 return cidade;
		 }
		 
		 public void setCidade(String cidade) 
		 {
		 this.cidade = cidade;
		 }
		 
		 public String getEndereco() 
		 {
		 return endereco;
		 }
		 
		 public void setEndereco(String endereco) 
		 {
		 this.endereco = endereco;
		 }
		 
		 public String getUf() 
		 {
		 return uf;
		 }
		 
		 public void setUf(String uf) 
		 {
		 this.uf = uf;
		 }
		 
		 public String getBairo() 
		 {
		 return bairo;
		 }
		 
		 public void setBairo(String bairo) 
		 {
			 this.bairo = bairo;
			 }
		 
		 public String getFone() 
		 {
			 return fone;
			 }
		 
		public void setFone(String fone) 
		{
		this.fone = fone;
		}
			 
}