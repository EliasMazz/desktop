/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente;

import br.com.domoticcenter.view.PanelAmbiente;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Mauricio
 */
public class TabbedPaneAmbiente extends JTabbedPane {
     private int ultimaTabClicada = 0;
    public TabbedPaneAmbiente(final PanelAmbiente panel){
        super();
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBorder(null);
        setFocusable(false);
        setFont(new java.awt.Font("Dejavu Sans", Font.BOLD, 16));
      
        addMouseListener(new MouseAdapter() {
           
            public void mouseClicked(MouseEvent e) {
                if (ultimaTabClicada != getSelectedIndex()) {
                    System.out.println("b");
                    if ( getSelectedIndex() > 0) {
                        panel.setExecutarThreadLamapdas(false);
                    } else {
                        panel.setExecutarThreadLamapdas(true);
                    }
                }
                ultimaTabClicada = getSelectedIndex();
            }
        });
    }
}
