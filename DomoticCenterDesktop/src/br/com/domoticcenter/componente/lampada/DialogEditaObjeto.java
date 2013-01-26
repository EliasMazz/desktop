/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.lampada;

import br.com.domoticcenter.componente.ButtonDomoticCenter;
import br.com.domoticcenter.componente.ambiente.*;
import br.com.domoticcenter.view.*;
import br.com.domoticcenter.entity.Ambiente;
import br.com.domoticcenter.entity.Lampada;
import br.com.domoticcenter.restservice.AmbienteRestWebService;
import br.com.domoticcenter.servicedao.AmbienteServiceDAO;
import br.com.domoticcenter.servicedao.LampadaServiceDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Mauricio
 */
    public class DialogEditaObjeto extends JDialog {  
    enum ReturnCodeDialogEditaObjeto { CANCELA, SALVAR }  
      
    private DialogEditaObjeto.ReturnCodeDialogEditaObjeto result = DialogEditaObjeto.ReturnCodeDialogEditaObjeto.CANCELA; 
      private final ClassLoader cldr = this.getClass().getClassLoader();  
      private  GridBagConstraints gbConstraints;
      private Ambiente ambiente = null;
       private Lampada lampada= null;
    public DialogEditaObjeto(JFrame owner, Object objeto) {  
        super(owner, true);  
       
       // this.setModal(true); 
         this.setTitle("Renomear");
         this.setResizable(false);
       //  this.setUndecorated(true);
         
         
          
            URL imageURLiconPrincipal = cldr.getResource("br/com/domoticcenter/imagens/editaOpcao.png");
       
         Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(imageURLiconPrincipal);
        setIconImage(img);
      this.setLayout(new GridBagLayout());  
        gbConstraints= new GridBagConstraints();
        
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
      
        
         
        if(objeto.getClass().isInstance(new Lampada())){
                lampada = (Lampada)objeto;
           
        }else if(objeto.getClass().isInstance(new Ambiente()) ){
             ambiente = (Ambiente)objeto;
            
        }
         
        JLabel nome = new JLabel("Nome:");
      
        gbConstraints.gridx=0;
        gbConstraints.gridy=0;
        gbConstraints.insets = new Insets(2, 2, 2, 2);
        
        add(nome,gbConstraints); 
        
        final JTextField editNome = new JTextField();
        editNome.setText(ambiente !=null?ambiente.getNome():lampada.getNome()); 
        editNome.setFocusable(true);
         nome.setFont(new java.awt.Font("Dejavu Sans", Font.PLAIN, 14));
        nome.setForeground(Color.WHITE);
        gbConstraints.gridx=2;
        gbConstraints.gridy=0;
        gbConstraints.gridwidth=2;
        
         add(editNome,gbConstraints); 
           
        
        JButton salvar  = new ButtonDomoticCenter("Salvar");
      
        salvar.setHorizontalTextPosition(SwingConstants.RIGHT);
        salvar.setHorizontalAlignment(SwingConstants.LEFT);
        salvar.addActionListener(new ActionListener() {  
        
            public void actionPerformed(ActionEvent e) {  
                System.out.println("SALVANDO");
                result = ReturnCodeDialogEditaObjeto.SALVAR;
                if(ambiente!= null){
                    ambiente.setNome(editNome.getText());
                   boolean salvou = AmbienteServiceDAO.updateAmbiente(ambiente);
                    System.out.println(salvou);
                }else if(lampada != null){
                     lampada.setNome(editNome.getText());
                      boolean salvou = LampadaServiceDAO.updateLampada(lampada);
                        System.out.println(salvou);
                }
                dispose();  
               
            }  
        });  
        gbConstraints.gridx=1;
        gbConstraints.gridy=1;
        gbConstraints.gridwidth=2;
        add(salvar,gbConstraints);
        
        JButton cancelar  = new ButtonDomoticCenter("Cancelar");
       
        
        cancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
        cancelar.setHorizontalAlignment(SwingConstants.LEFT);
        cancelar.addActionListener(new ActionListener() {  
        
            public void actionPerformed(ActionEvent e) {  
                result = ReturnCodeDialogEditaObjeto.CANCELA;
                dispose();  
                
            }  
        });  
       
       
         gbConstraints.gridx=3;
         gbConstraints.gridy=1;
       
           gbConstraints.gridwidth= 1;
           add(cancelar,gbConstraints); 
             
       addFocusListener(new FocusListener(){  
  
        public void focusGained(FocusEvent arg0) {  
             editNome.requestFocus();
        }  

        public void focusLost(FocusEvent arg0){               
         
        }  
         });
         
           pack();  
             
             
    }
       public ReturnCodeDialogEditaObjeto getResult() {  
        return result;  
    } 
          /*
        URL imageURLiconCancela = cldr.getResource("br/com/domoticcenter/imagens/cancelaOpcao.png");
        ImageIcon iconeCancela = new ImageIcon(imageURLiconCancela);
        
        URL imageURLiconEdita = cldr.getResource("br/com/domoticcenter/imagens/editaOpcao.png");
        ImageIcon iconeEdita= new ImageIcon(imageURLiconEdita);
        
        JButton editar  = new JButton("Editar");  
        editar.setIcon(iconeEdita);
        editar.setHorizontalTextPosition(SwingConstants.RIGHT);
        editar.setHorizontalAlignment(SwingConstants.LEFT);
        editar.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                result = ReturnCodeCrudObjetos.EDITAR;  
                dispose();  
            }  

        });  
        add(editar);  
         
        
        JButton cancel  = new JButton("Cancelar");
        cancel.setIcon(iconeCancela);
        cancel.setHorizontalTextPosition(SwingConstants.RIGHT);
        cancel.setHorizontalAlignment(SwingConstants.LEFT);
        cancel.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                result = ReturnCodeCrudObjetos.CANCELAR;  
                dispose();  
            }  
        });  
        add(cancel); 
        pack();  
    }  
      
    public ReturnCodeCrudObjetos getResult() {  
        return result;  
    } 

* */

}
