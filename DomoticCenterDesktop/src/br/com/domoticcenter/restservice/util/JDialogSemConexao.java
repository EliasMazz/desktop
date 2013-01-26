/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.restservice.util;

import br.com.domoticcenter.componente.ButtonDomoticCenter;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mauricio
 */
public class JDialogSemConexao extends JDialog {
    public JDialogSemConexao() {
        super();
          final  URL imageURLiconPrincipal = this.getClass().getClassLoader().getResource("br/com/domoticcenter/imagens/conexao.png");
          ImageIcon imageIcon  = new ImageIcon(imageURLiconPrincipal);
          this.setResizable(false);
          setLayout(null);
          
          getContentPane().setBackground(Color.decode("#282828"));
         JLabel l = new JLabel(imageIcon);
         l.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
          getContentPane().add(l);
          ButtonDomoticCenter b = new  ButtonDomoticCenter("Sair");
           b.setBackground(Color.decode("#282828"));
          b.addMouseListener(new MouseAdapter() {
              @Override
          public void mouseClicked(MouseEvent e) {
               System.exit(0);
          }

          });
          b.setBounds(170, 239, 80, 50);
          getContentPane().add(b);
          this.setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight()+100);        
           setVisible(true);
    } 
}
