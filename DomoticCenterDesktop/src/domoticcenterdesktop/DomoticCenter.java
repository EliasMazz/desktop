/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domoticcenterdesktop;

import br.com.domoticcenter.entity.ResidenciaCompleta;
import br.com.domoticcenter.restservice.util.InternetConnectionObserver;
import br.com.domoticcenter.restservice.util.ManipulaArquivoLogin;
import br.com.domoticcenter.restservice.util.ObservableInternetConnection;
import br.com.domoticcenter.restservice.util.ResidenciaCompletaMemory;
import br.com.domoticcenter.servicedao.PessoaServiceDAO;
import br.com.domoticcenter.view.Login;
import br.com.domoticcenter.view.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.UIDefaults;
import javax.swing.UIManager;




/**
 *
 * @author Mauricio
 */
public class DomoticCenter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        
         UIDefaults defaults = UIManager.getLookAndFeelDefaults();
   
            UIManager.put("TabbedPane.selected", Color.BLACK);
            UIManager.put("TabbedPane.selectHighlight", Color.BLACK);
            UIManager.put("TabbedPane.borderHightlightColor", Color.BLACK);
            UIManager.put("TabbedPane.darkShadow", Color.BLACK);
            UIManager.put("TabbedPane.tabsOverlapBorder", true);
            UIManager.put("TabbedPane.borderHightlightColor", Color.BLACK);
            UIManager.put("TabbedPane.darkShadow", Color.BLACK);
            UIManager.put("TabbedPane.highlight", Color.BLACK);
            UIManager.put("TabbedPane.light", Color.BLACK);
            UIManager.put("TabbedPane.shadow", Color.BLUE);
            UIManager.put("TabbedPane.selectedTabPadInsets", new Insets(0, 0, 0, 0));
            UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
            UIManager.put("TabbedPane.selectionFollowsFocus", false); 
            UIManager.put("List.background", Color.black);
            UIManager.put("List.selectionForeground", Color.WHITE);
            UIManager.put("List.selectionBackground",  Color.decode("#33b5e5"));
            UIManager.put("Button.darkShadow", Color.black);
            UIManager.put("Button.light", Color.black);
            UIManager.put("Button.highlight", Color.black);
            UIManager.put("Button.focus", Color.black);
            UIManager.put("MenuItem.selectionBackground",  Color.decode("#33b5e5"));
            UIManager.put("Panel.background",  Color.BLACK);
            UIManager.put("Button.background",  Color.BLACK);
            UIManager.put("Button.select",  Color.decode("#33b5e5"));
            UIManager.put("Button.foreground",  Color.WHITE);
            UIManager.put("Button.highlight",  Color.decode("#33b5e5"));
            UIManager.put("Button.toolBarBorderBackground",  Color.BLACK);
            UIManager.put("Button.shadow",  Color.BLACK);
            UIManager.put("Button.rollover", false);
            
            
     ObservableInternetConnection observableInternetConnection = new ObservableInternetConnection();
     InternetConnectionObserver internetConnectionObserver = new InternetConnectionObserver(observableInternetConnection);
      
     ManipulaArquivoLogin manipulaArquivoLogin = new ManipulaArquivoLogin();
     ResidenciaCompleta residenciaCompleta = null;
          if( manipulaArquivoLogin.verificaSeUsuarioPossuiLogin()){
            
           try {
           
               residenciaCompleta = PessoaServiceDAO.autenticaPessoaNoServidor(manipulaArquivoLogin.getLogin(), manipulaArquivoLogin.getSenha());
           }catch(Exception ex){
               
           }finally{
              ResidenciaCompletaMemory.setIpDomoticCenter(residenciaCompleta.getIpDomoticCenter());
              ResidenciaCompletaMemory.setResidenciaCompleta(residenciaCompleta);
              Principal p = new Principal( manipulaArquivoLogin.getLogin() , manipulaArquivoLogin.getSenha());
              p.setVisible(true);
           }
          }else{
            Login login = new Login();
            login.setVisible(true);
          }
    }
}

