/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.agendamento;

import br.com.domoticcenter.entity.Agendamento;
import br.com.domoticcenter.restservice.util.ResidenciaCompletaMemory;
import br.com.domoticcenter.servicedao.AgendamentoServiceDAO;
import br.com.domoticcenter.servicedao.AmbienteServiceDAO;
import br.com.domoticcenter.view.PanelAgendamento;
import br.com.domoticcenter.view.PanelAmbiente;
import br.com.domoticcenter.view.Principal;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 *
 * @author Mauricio
 */
public class JMenuItemExcluiAgendamento extends JMenuItem implements ActionListener{
    private JListAgendamentos listaDeAgendamentos;
    private PanelAgendamento panelAgendamento;
    
    public JMenuItemExcluiAgendamento(String nome,JListAgendamentos listaDeAgendamentos,PanelAgendamento PanelAgendamento){
        super(nome);
        setFont(new Font("Dejavu Sans", Font.PLAIN, 12));
        addActionListener(this);
        this.listaDeAgendamentos = listaDeAgendamentos;
        this.panelAgendamento = PanelAgendamento;
        
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
        JLabel selected = (JLabel) listaDeAgendamentos.getSelectedValue();
        System.out.println(selected.getName());
        System.out.println(selected.getIcon());   
        Agendamento agendamentoParaExcluir = listaDeAgendamentos.getAgendamentoSelecionado();
       
        AgendamentoServiceDAO.deletaAgendamento(agendamentoParaExcluir);
            
        ResidenciaCompletaMemory.getResidenciaCompleta().setAgendamentos(AgendamentoServiceDAO.listaTodosAgendamentosPorIPDomotic(ResidenciaCompletaMemory.getIpDomoticCenter()));
        listaDeAgendamentos.carregaAgendamentos();
      
        if(listaDeAgendamentos.getModel().getSize() >0 ){
            listaDeAgendamentos.setSelectedIndex(0);
             panelAgendamento.carregaConfiguracaoAgendamento(listaDeAgendamentos.getAgendamentos().get(0));
        }else{
            panelAgendamento.getjPanel2().setVisible(false);
        }
        
    }
}
    
