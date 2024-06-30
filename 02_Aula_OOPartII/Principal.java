import javax.swing.JOptionPane;

public class Principal 
{

	public static void main(String[] args) 
	{

		//Mensagem pro usuario
		JOptionPane.showMessageDialog(null,
				"Bem-vindo querido usu�rio!!!");
		
		//Menu de opcoes para o user
		String op = JOptionPane
				.showInputDialog(
				"Escolha uma das op��es:"
				+ "\n [S] - Saque"
				+ "\n [D] - Dep�sito"
				+ "\n [M] - Mostrar Saldo"
				+ "\n [X] - Sair"); 
		
		
		//Instanciando a classe Caixa
		Caixa cx = new Caixa();
		
		
		//Verificando a escolha do usuario
		switch (op) 
		{
		case "S":
			cx.retirar();
			break;
			
		case "D":
			cx.entrar();
			break;
		
		case "M":
			cx.mostrarSaldo();
			break;
			
		case "X":
			 System.exit(0);
			break;
			
		default:
			JOptionPane.showMessageDialog(null,
					"Digitar algum valor v�lido!!!");
			break;
		}
		
	

	}

}
