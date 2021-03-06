/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.view;

import br.com.domoticcenter.componente.ButtonDomoticCenter;
import br.com.domoticcenter.entity.ResidenciaCompleta;
import br.com.domoticcenter.restservice.util.InternetConnectionObserver;
import br.com.domoticcenter.restservice.util.ManipulaArquivoLogin;
import br.com.domoticcenter.restservice.util.ObservableInternetConnection;
import br.com.domoticcenter.restservice.util.PosicaoFrame;
import br.com.domoticcenter.restservice.util.ResidenciaCompletaMemory;
import br.com.domoticcenter.servicedao.PessoaServiceDAO;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Painter;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;


/**
 *
 * @author Mauricio
 */
public class Login extends javax.swing.JFrame {
private ResidenciaCompleta residenciaCompleta;

private Timer threadImagem; 
private  final ClassLoader cldr ;
private  ManipulaArquivoLogin manipulaArquivoLogin;
    /**
     * Creates new form Login
     */
    public Login() {
 
        initComponents();
           manipulaArquivoLogin = new ManipulaArquivoLogin();
            if( manipulaArquivoLogin.verificaSeUsuarioPossuiLogin()){
              jPfSenha.setText("***************");
            
              jTxtLogin.setText(manipulaArquivoLogin.getLogin());
            }
        jButtonEntrar.setEnabled(false);

       
        cldr = this.getClass().getClassLoader();
        BufferedImage wp = null;
        this.setLocationRelativeTo(null);
        URL imageURLiconPrincipal = cldr.getResource("br/com/domoticcenter/imagens/icone_principal.png");
        URL imageURLiconLogin = cldr.getResource("br/com/domoticcenter/imagens/loginT.png");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(imageURLiconPrincipal);
        setIconImage(img);
     
        
        try {
             wp = ImageIO.read(cldr.getResource("br/com/domoticcenter/imagens/logo_principal.png"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         jLabelImage.setIcon(new ImageIcon(cldr.getResource("br/com/domoticcenter/imagens/carregando.gif")));
          jPanelImagem.add(jLabelImage);
           
             threadImagem = new Timer();
              threadImagem.scheduleAtFixedRate(new TimerTask() {
                  @Override
                    public synchronized void run() {

                  
                  }
                }, 0 , 5000);

           threadImagem.cancel();

    }
    
    
     
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTxtLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPfSenha = new javax.swing.JPasswordField();
        jButtonEntrar = new ButtonDomoticCenter("Entrar");
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanelImagem = new javax.swing.JPanel();
        jLabelImage = new javax.swing.JLabel();
        jPanelLogo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DomoticCenter");
        setForeground(java.awt.Color.black);
        setPreferredSize(new java.awt.Dimension(635, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelLogin.setBackground(new java.awt.Color(0, 0, 0));
        jPanelLogin.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ENTRAR");

        jTxtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtLoginActionPerformed(evt);
            }
        });
        jTxtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtLoginKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuário: ");

        jPfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPfSenhaKeyPressed(evt);
            }
        });

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEntrarMouseClicked(evt);
            }
        });
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha:");

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtLogin)
                    .addComponent(jLabel3)
                    .addComponent(jPfSenha)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(106, 106, 106))
                    .addComponent(jLabel2)
                    .addComponent(jButtonEntrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButtonEntrar)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        jPanelImagem.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanelImagemLayout = new javax.swing.GroupLayout(jPanelImagem);
        jPanelImagem.setLayout(jPanelImagemLayout);
        jPanelImagemLayout.setHorizontalGroup(
            jPanelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        jPanelImagemLayout.setVerticalGroup(
            jPanelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelLogo.setBackground(new java.awt.Color(0, 0, 0));
        jPanelLogo.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed


    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jTxtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtLoginActionPerformed
       
            
    }//GEN-LAST:event_jTxtLoginActionPerformed

    private void jPfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPfSenhaKeyPressed
 if(!this.jTxtLogin.getText().equals("") && !this.jPfSenha.getText().equals("")){
            jButtonEntrar.setEnabled(true);
        }else{        // TODO add your handling code here:
       jButtonEntrar.setEnabled(false);
 }
    }//GEN-LAST:event_jPfSenhaKeyPressed

    private void jTxtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtLoginKeyPressed
 if(!this.jTxtLogin.getText().equals("") && !this.jPfSenha.getText().equals("")){
            jButtonEntrar.setEnabled(true);
        }else{        // TODO add your handling code here:
       jButtonEntrar.setEnabled(false);
 }
    }//GEN-LAST:event_jTxtLoginKeyPressed

    private void jButtonEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEntrarMouseClicked
     
        
     String senha =  jPfSenha.getText();
     String login = jTxtLogin.getText();
     if( jButtonEntrar.isEnabled()){
        jLabel4.setFont(new Font("Dejavu Sans", Font.PLAIN, 12));
           try {
               jLabel4.setText("Carregando..");
               jLabel4.setForeground(Color.WHITE);
               jLabel4.setIcon(new ImageIcon(cldr.getResource("br/com/domoticcenter/imagens/carregando.gif")));

               residenciaCompleta = PessoaServiceDAO.autenticaPessoaNoServidor(login, senha);
               if( residenciaCompleta == null){
                 jLabel4.setText("Login ou Senha incorreto!");
                 jLabel4.setForeground(Color.red);
                 jLabel4.setIcon(new ImageIcon(cldr.getResource("br/com/domoticcenter/imagens/erroLogin.png")));
               }
           } catch (Exception ex) {
               //toastError();

           }
               if(residenciaCompleta != null){
                  // manipulaArquivoLogin = new ManipulaArquivoLogin(); 
                   manipulaArquivoLogin.criaArquivoLogin(login, senha);
                   ResidenciaCompletaMemory.setIpDomoticCenter(residenciaCompleta.getIpDomoticCenter());
                   ResidenciaCompletaMemory.setResidenciaCompleta(residenciaCompleta);
                   Principal p = new Principal( jTxtLogin.getText(),   jPfSenha.getText());
                   p.setVisible(true);
                   this.dispose();


           }

     }

    }//GEN-LAST:event_jButtonEntrarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
     
        
           
          
    }//GEN-LAST:event_formWindowOpened

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */


        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
            /*
        try {
        
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
         
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    */
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Login().setVisible(true);
                
            }
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JPanel jPanelImagem;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelLogo;
    private javax.swing.JPasswordField jPfSenha;
    private javax.swing.JTextField jTxtLogin;
    // End of variables declaration//GEN-END:variables

    
}
