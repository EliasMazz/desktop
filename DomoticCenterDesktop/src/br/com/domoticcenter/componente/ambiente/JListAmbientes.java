/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.ambiente;

import br.com.domoticcenter.entity.Ambiente;
import br.com.domoticcenter.restservice.util.ResidenciaCompletaMemory;
import br.com.domoticcenter.view.PanelAmbiente;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mauricio
 */
public class JListAmbientes extends JList implements MouseListener {
    private JPopupMenuAmbiente jPoupEditarAmbiente;
    private PanelAmbiente PanelAmbiente;
    private int posicaoListaAmbienteAntigo= -1;

    public JListAmbientes(PanelAmbiente jPanelAmbiente){  
        super();
        jPoupEditarAmbiente = new JPopupMenuAmbiente(jPanelAmbiente);
        PanelAmbiente = jPanelAmbiente;
        setFont(new Font("Dejavu Sans", Font.PLAIN, 19));
        setForeground(Color.WHITE);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        requestFocus();
        setFixedCellHeight(50);
        setFixedCellWidth(150);
        carregaListaAmbiente();
    }
    
    public void carregaListaAmbiente(){
        
        DefaultListModel listModel = new DefaultListModel();
        for (Ambiente amb : ResidenciaCompletaMemory.getResidenciaCompleta().getAmbientes()) {
            listModel.addElement(amb.getNome());

        }
          setModel(listModel);
          addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
           final boolean botaoDireito = (SwingUtilities.isRightMouseButton(e));
          
                if (botaoDireito) {
                    
                    PanelAmbiente.setPosicaoXComponente(e.getX());
                    PanelAmbiente.setPosicaoYComponente(e.getY());
                    setSelectedIndex(this.locationToIndex(e.getPoint()));
                    PanelAmbiente.setIndiceAmbienteNaLista(getSelectedIndex());

                    jPoupEditarAmbiente.show(e.getComponent(), e.getX(), e.getY());
                    PanelAmbiente.setAmbienteSelecionado(ResidenciaCompletaMemory.getResidenciaCompleta().getAmbientes().get(getSelectedIndex()));
                }

                if (posicaoListaAmbienteAntigo != getSelectedIndex()) {

               
                    PanelAmbiente.carregaLampadas();
                    PanelAmbiente.getjPanel2().setVisible(false);
                    PanelAmbiente.getjPanel2().setVisible(true);
                    // PanelAmbiente.jPanel2.setVisible(false);
                   // PanelAmbiente.jPanel2.setVisible(true);
                }


                posicaoListaAmbienteAntigo = getSelectedIndex();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
     
    }
}
