/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.lampada;

import br.com.domoticcenter.view.PanelAmbiente;
import javax.swing.JPopupMenu;

/**
 *
 * @author Mauricio
 */
public class JPopupMenuLampada  extends JPopupMenu{
    
    public JPopupMenuLampada(PanelAmbiente panelAmbiente){
        super();
        add(new JMenuItemRenomearLampada("Renomear", panelAmbiente));
        add(new JMenuItemAgendarLampada("Agendar", panelAmbiente));
    }
}
