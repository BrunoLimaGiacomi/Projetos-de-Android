package Main;

import DAO.ClienteDAO;
import Entity.Cliente;

public class Main {

	public static void main(String[] args) 
	{
		//Montando a classe cliente
		Cliente  cli = new Cliente(22,"Bruna",
								"bruninha@hotmail.com",
								  "Califórnia - LA");
		
		// Como a classe cliente esta MONTANDA...	
		//Podemos inserir de uma unica vez no DB!!!!
		ClienteDAO cliDAO = new ClienteDAO();
		cliDAO.adcionaCliente(cli);
		

	}

}
