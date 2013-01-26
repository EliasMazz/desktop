/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.agendamento;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author Mauricio
 */
public class jCheckBoxAgendamentoDiasDaSemana extends JCheckBox implements MouseListener{

    public jCheckBoxAgendamentoDiasDaSemana(String nome){
        super(nome);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
          Icon selected = new MyCheckBoxIcon();
          setPressedIcon(new ImageIcon(this.getClass().getClassLoader().getResource("br/com/domoticcenter/imagens/select.png")));
          

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
     
        if(isSelected()){
           
       }else{
       
       }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
     
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
     
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
      
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
   
    }

    
    
    public class MyCheckBoxIcon implements Icon {
   private int width,height;
    
    public MyCheckBoxIcon(){
        Icon icon = UIManager.getIcon("CheckBox.icon");
        width = icon.getIconWidth();
        height = icon.getIconHeight();
    }
   @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
      return width;
    }

    @Override
    public int getIconHeight() {
      return height;
    }
   }
    
    
    
   
}
