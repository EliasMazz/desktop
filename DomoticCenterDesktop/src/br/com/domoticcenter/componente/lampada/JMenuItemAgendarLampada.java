/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.lampada;

import br.com.domoticcenter.entity.Lampada;
import br.com.domoticcenter.view.PanelAmbiente;
import br.com.domoticcenter.view.Principal;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Mauricio
 */
public class JMenuItemAgendarLampada  extends JMenuItem implements ActionListener{
    private PanelAmbiente jPanelAmbiente;
    public JMenuItemAgendarLampada(String nome, PanelAmbiente panelAmbiente){
        super(nome);
        setFont(new Font("Dejavu Sans", Font.PLAIN, 12));
        addActionListener(this);
        this.jPanelAmbiente = panelAmbiente;
        
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         
      Principal.getjTp().setSelectedIndex(1);
      
      int posicaoLampada = 0;
      for(int i=0; i< jPanelAmbiente.getLampadasComIDSelecionado().size(); i++ ){ 
          if(jPanelAmbiente.getLampadasComIDSelecionado().get(i).equals(jPanelAmbiente.getLampadaeSelecionada())){
             posicaoLampada = i;
          }
      }
      
         jPanelAmbiente.setExecutarThreadLamapdas(false);
      Principal.getPanelAgendamento().carregaConfiguracaoAgendamento(jPanelAmbiente.getLampadaeSelecionada(),jPanelAmbiente.getListAmbientes().getSelectedIndex(),posicaoLampada );
       
      
    }
}
    
