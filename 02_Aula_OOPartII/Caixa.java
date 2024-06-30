import javax.swing.JOptionPane;

public class Caixa 
{
	//Atributo Saldo
	private double saldo = 1000;
	
	//Metodo Saque
	public double saque(double valor) 
	{
		// 1)Retirar valor de saque do saldo
		this.saldo  = this.saldo - valor;	
		
		// 2) Retornando o valor do saldo
		return this.saldo;
	}
	
	//Metodo Deposito
	public double deposito(double valor) 
	{
	   	return this.saldo += valor;		
	}
	
	
	public String mostrarSaldoAtual()
	{
		return "Saldo atual:" +this.saldo;
	} 
	
	
	
	
	
    
}
