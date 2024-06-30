import java.util.ArrayList;
import java.util.List;

public class cadastroCliente 
{
	
	public boolean ValidarCliente (Cliente client) 
	{
		if(client.nome.isEmpty() || client.cidade.isEmpty() || client.endereco.isEmpty() ||
				client.uf.isEmpty() || client.bairo.isEmpty() || client.fone.isEmpty()) 
		{
			return false; 
		}
		else 
		{
			return true; 
		}
		
	}
	
	public boolean ValidarDados (Cliente client) 
	{
		
		boolean clienteExiste = verificarNoBanco(client);
		
		if(clienteExiste) 
		{
			return false; 
		}
		else 
		{
			return true; 
		}
		
	}
	
	private boolean verificarNoBanco(Cliente client) 
	{
		List <Cliente> listaClientes = obterClienteBD();
		
		if (listaClientes.equals(listaClientes)) 
		{
			return true; 
		}
		else 
		{
			return false; 
		}
	}

	private List<Cliente> obterClienteBD() 
	{
		List<Cliente> listaClientes = new ArrayList<>();
				
		return listaClientes;
	}
}
