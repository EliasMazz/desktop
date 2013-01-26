/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author Mauricio
 */
public class ButtonDomoticCenter extends JButton implements MouseListener{
    
    public ButtonDomoticCenter (String nome){
        super(nome);
        setFocusable(false);
        addMouseListener(this);
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.decode("#33b5e5"));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.WHITE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
             // setForeground(Color.decode("#33b5e5"));
           setForeground(Color.WHITE);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    setForeground(Color.WHITE);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     
    }
}
