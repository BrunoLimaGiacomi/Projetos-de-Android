package DAO;

import java.util.ArrayList;
import java.util.List;

import Entity.Cliente;

public class ClienteDAO 
{
	/*    DAO
	 *    <<>>
	 *    DATA
	 *    ACCESS
	 *    OBJECT
	 *    
	 *    Classe Responsavel por 
	 *    inserir todos os objetos, 
	 *    de uma só vez no banco de 
	 *    dados!!!   
	 */
	
	//Metodo para inserir no DB
	public void adcionaCliente(Cliente cl)
	{
		String sql = "INSERT INTO "
				+ "cliente(nome,email,endereco)"
				+ "VALUES("+cl.getNome()
				          +cl.getEmail()
				          +cl.getEndereco()+")";
	}
}


