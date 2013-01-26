/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.ambiente;

import br.com.domoticcenter.view.PanelAmbiente;
import javax.swing.JPopupMenu;

/**
 *
 * @author Mauricio
 */
public class JPopupMenuAmbiente extends JPopupMenu{
    
    public JPopupMenuAmbiente (PanelAmbiente jPanelAmbiente){
        super();
        add(new JMenuItemRenomearAmbiente("Renomear",jPanelAmbiente));
    }
}
