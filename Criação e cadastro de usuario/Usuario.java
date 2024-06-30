public class Usuario 
{
    // Atributos
    String login;
    String chave; 
    
    // Construtores
    public Usuario(String login, String chave)
    {
        this.login = login;
        this.chave = chave;
    }
    
    public Usuario()
    {
    }
    
    // Getters e Setters
    public String getLogin() 
    {
        return login;
    }
    
    public void setLogin(String login) 
    {
        this.login = login;
    }
    
    public String getChave() 
    {
        return chave;
    }
    
    public void setChave(String chave) 
    {
        this.chave = chave;
    }
}