/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.restservice.util;

import java.io.File;
import sun.tools.jar.Main;

/**
 *
 * @author Mauricio
 */
public class ManipulaArquivoLogin {
    
    private String login;

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    private String senha;
    private final String path = System.getProperty("user.dir")+"/login.txt";
    
    
    public void criaArquivoLogin(String login,String senha){
      
        
        IniFile arquivoIni = new IniFile(path);  
  
         // alterar conteúdo do arquivo  
        arquivoIni.setProperty("USUARIO", "LOGIN", login);  
        arquivoIni.setProperty("USUARIO", "SENHA", senha);  
      
        arquivoIni.save();  
    }
    
    public boolean verificaSeUsuarioPossuiLogin(){
                 
       File arquivo= new File(path);  
       
       if(arquivo.exists()){
        IniFile arquivoIni = new IniFile(arquivo);  
        String senha = null;
        String login = null;
       try{
            senha = arquivoIni.getProperty("USUARIO","SENHA", null);
            login = arquivoIni.getProperty("USUARIO","LOGIN", null);
           
       }catch(Exception ex){
            ex.printStackTrace();
           
       }finally{
            if(senha != null && login !=null){
                this.senha = senha;
                this.login = login;
                return true;
           }
           return false;
       }
     }else{
           return false;
       }     
   }
    
    
  
    
    
    
    
    
    
    
    
}
