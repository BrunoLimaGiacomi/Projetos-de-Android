import javax.swing.JOptionPane;

public class Operacoes 
{
	//Classe para executar as a�oes 
	//da entidade Usuario
	public void cadastarUsuario(Usuario user)
	{
		//"Cadastrar" a @#$&# do usu�rio!!!
		JOptionPane.showMessageDialog(null, 
				"ID"+ user.getId()+
				"\n Nome:"+user.getNome()+
				"\n End.:"+user.getEndereco()+
				"\n Email:"+user.getEmail()+
				"\n Esc:"+user.getEscolaridade());
	}
	

}
