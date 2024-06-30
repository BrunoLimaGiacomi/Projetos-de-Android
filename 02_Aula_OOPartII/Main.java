import javax.swing.JOptionPane;

public class Main {

	//Primeiro metodo a ser rodado
	public static void main(String[] args) 
	{
		//Chamando classe acessando metodos!!!
		Caixa objCx = new Caixa();
		
		//Recebendo valor double
		double vlSaque = Double.parseDouble(
				JOptionPane.showInputDialog(
					"Valor de Saque:"));
		
		//Chamando metodo e passando o valor
		objCx.saque(vlSaque);
		
	}

}
