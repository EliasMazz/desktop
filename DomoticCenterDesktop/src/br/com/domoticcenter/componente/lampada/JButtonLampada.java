/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.lampada;

import br.com.domoticcenter.entity.Lampada;
import br.com.domoticcenter.view.PanelAmbiente;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Mauricio
 */
public class JButtonLampada extends JButton  implements MouseListener{
    private JPopupMenuLampada jPopupMenuLampada;
    private PanelAmbiente jPanelAmbiente;
    public JButtonLampada (String nome,PanelAmbiente jPanelAmbiente){
        super(nome);
        jPopupMenuLampada = new JPopupMenuLampada(jPanelAmbiente);
        this.jPanelAmbiente = jPanelAmbiente;
         setFont(new java.awt.Font("Dejavu Sans", Font.PLAIN, 19));
         setBackground(Color.BLACK);
         setForeground(Color.white);
         setBorder(null);
         setHorizontalTextPosition(SwingConstants.RIGHT);
         setHorizontalAlignment(SwingConstants.LEFT);
         setOpaque(false);
         setContentAreaFilled(false);       
         addMouseListener(this);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
                    final String posicaoLampada = e.getComponent().getName();
                    final Lampada lampada = jPanelAmbiente.getLampadasComIDSelecionado().get(Integer.parseInt(posicaoLampada));
                    jPanelAmbiente.setLampadaeSelecionada(lampada);
                    System.out.println("POSICLAMPADA " + posicaoLampada);
                    final String id = e.getComponent().getName();
                  
                    jPanelAmbiente.setPosicaoXComponente(e.getX());
                    jPanelAmbiente.setPosicaoYComponente(e.getY());

                    
                    jPopupMenuLampada.show(e.getComponent(), e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
   
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      setForeground(Color.decode("#33b5e5"));
      setBackground(Color.BLACK);
    }

    @Override
    public void mouseExited(MouseEvent e) {
       setForeground(Color.white);
       setBackground(Color.BLACK);
    }
    
}
