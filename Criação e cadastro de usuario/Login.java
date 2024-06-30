public class Login 
{
    public boolean ValidarLogin(Usuario user)
    {
        // Simulando validacao
        if (user.login.isEmpty() || user.chave.isEmpty()) // Substituído "senha" por "chave"
        {
            return false; 
        }
        else if (user.login.equals("admin") || user.chave.equals("admin")) // Substituído "senha" por "chave"
        {
            return true;
        }
        else
        {
            return false; 
        }
    }
    
    public String TentativaLogin(Usuario user) 
    {
        String codigoTemporario = "";
        String Msg = "";
        
        if (ValidarLogin(user) == false) 
        {
            codigoTemporario = gerarCodigoTemporario();
            // Simulando mandar-lo por email
        }
        else if (codigoTemporario.equals("123456")) 
        {
            return Msg = "Código temporario correto"; // Corrigido caracteres especiais no código
        }
        else 
        {
            return Msg = "Código incorreto, seu login não pôde ser verificado"; // Corrigido caracteres especiais no código
        } 
        return Msg;
    }
    
    public static String gerarCodigoTemporario() 
    {
        return "123456";  
    }
    
    public static boolean verificarDispositivo()
    {
        return true;
    }
}
