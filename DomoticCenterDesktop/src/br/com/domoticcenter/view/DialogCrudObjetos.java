/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.view;

import br.com.domoticcenter.entity.Lampada;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

/**
 *
 * @author Mauricio
 */
    public class DialogCrudObjetos extends JDialog {  
  
    enum ReturnCodeCrudObjetos { CANCELAR,EDITAR,AGENDAR}  
      
    private ReturnCodeCrudObjetos result = ReturnCodeCrudObjetos.CANCELAR;  
     private final ClassLoader cldr = this.getClass().getClassLoader();  
    public DialogCrudObjetos(JFrame owner,Object objeto) {  
        super(owner, true);  
        setLayout(new GridLayout(3, 1));  
        setUndecorated(true);
        this.setModal(true);  
        
        
        URL imageURLiconCancela = cldr.getResource("br/com/domoticcenter/imagens/cancelaOpcao.png");
        ImageIcon iconeCancela = new ImageIcon(imageURLiconCancela);
        
        URL imageURLiconEdita = cldr.getResource("br/com/domoticcenter/imagens/editaOpcao.png");
        ImageIcon iconeEdita= new ImageIcon(imageURLiconEdita);
        
        URL imageURLiconAgenda = cldr.getResource("br/com/domoticcenter/imagens/agendamentoOpcao.png");
        ImageIcon iconeAgendamento= new ImageIcon(imageURLiconAgenda);
        
        JButton agendar  = new JButton("Agendar");
        agendar.setIcon(iconeAgendamento);
        agendar.setHorizontalTextPosition(SwingConstants.RIGHT);
        agendar.setHorizontalAlignment(SwingConstants.LEFT);
        agendar.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                result = ReturnCodeCrudObjetos.AGENDAR;  
                dispose();  
            }  
        });  
        if (objeto != null && objeto.getClass().isInstance(new Lampada())){
            add(agendar); 
        }
        
        
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



}
