/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.agendamento;

import br.com.domoticcenter.componente.ambiente.*;
import br.com.domoticcenter.componente.lampada.JMenuItemAgendarLampada;
import br.com.domoticcenter.entity.Agendamento;
import br.com.domoticcenter.entity.Ambiente;
import br.com.domoticcenter.restservice.util.ResidenciaCompletaMemory;
import br.com.domoticcenter.view.PanelAgendamento;
import br.com.domoticcenter.view.PanelAmbiente;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mauricio
 */
public class JListAgendamentos extends JList implements MouseListener {
   private final DefaultListModel listModel  = new DefaultListModel(); ;
    private PanelAgendamento PanelAgendamento;
    private Agendamento agendamentoSelecionado;
    private List<Agendamento> agendamentos;

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentoSelecionado(Agendamento agendamentoSelecionado) {
        this.agendamentoSelecionado = agendamentoSelecionado;
    }

    public Agendamento getAgendamentoSelecionado() {
        return agendamentoSelecionado;
    }
    private int posicaoListaAgendamentoAntigo= -1;
 
    JPopupMenu jPopupMenuAgendamento;
    public JListAgendamentos(PanelAgendamento jPanelAgendamento){  
        super();
    
    //    jPoupEditarAmbiente = new JPopupMenuAmbiente(jPanelAmbiente);
      
        PanelAgendamento = jPanelAgendamento;
        setFont(new Font("Dejavu Sans", Font.PLAIN, 19));
        setForeground(Color.WHITE);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        requestFocus();
        setFixedCellHeight(50);
        setFixedCellWidth(150);
        setCellRenderer(new jLabelRender());
       
        carregaAgendamentos();
        
   
        
    }
    
    public void carregaAgendamentos(){
        agendamentos = new ArrayList<Agendamento>();
       
        listModel.removeAllElements();
        for (Agendamento agendamento : ResidenciaCompletaMemory.getResidenciaCompleta().getAgendamentos()) {
            agendamentos.add(agendamento);
            JLabel jLabelAgendamento = new JLabel(agendamento.getNome());
           if(agendamento.isAtivo()){
                jLabelAgendamento.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("br/com/domoticcenter/imagens/status_on.png")));
           }else{
                jLabelAgendamento.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("br/com/domoticcenter/imagens/status_off.png")));
           }
               jLabelAgendamento.setName(""+agendamento.getAgendamentoID());
                listModel.addElement(jLabelAgendamento);

        }
          setModel(listModel);
          addMouseListener(this);
          
          
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
           final boolean botaoDireito = (SwingUtilities.isRightMouseButton(e));
        if(listModel.getSize() > 0){
        setSelectedIndex(this.locationToIndex(e.getPoint()));
       
       
        Agendamento agendamento = agendamentos.get(getSelectedIndex());
        setAgendamentoSelecionado(agendamento);
       
         jPopupMenuAgendamento = new JPopupMenu();
         String nome = agendamento.isAtivo()?"Desativar":"Ativar";
         jPopupMenuAgendamento.add(new JMenuItemAtivaDesativaAgendamento(nome,this));
         jPopupMenuAgendamento.add(new JMenuItemExcluiAgendamento("Excluir",this,PanelAgendamento));
         setAgendamentoSelecionado(agendamentos.get(getSelectedIndex()));
  
      
      
          if (botaoDireito) {
            jPopupMenuAgendamento.show(e.getComponent(), e.getX(), e.getY());
                    
          }else{
             PanelAgendamento.carregaConfiguracaoAgendamento(agendamento);
                           
          }
                
         posicaoListaAgendamentoAntigo = getSelectedIndex();
        }
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
    
   public class jLabelRender extends DefaultListCellRenderer
{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,boolean isSelected, boolean cellHasFocus) 
    {
        if(value instanceof JLabel)
        {
            this.setText(((JLabel)value).getText());
            this.setIcon(((JLabel)value).getIcon());
            this.setName(((JLabel)value).getName());
         
            this.setFont(new Font("Dejavu Sans", Font.BOLD, 15));
            this.setHorizontalAlignment(SwingConstants.LEFT);
           
           if (isSelected)
        {
            this.setBackground(Color.decode("#33b5e5"));
            this.setForeground(Color.WHITE);
        }
        else
        {
            this.setBackground(Color.BLACK);
            this.setForeground(Color.WHITE);
        }
        }
     
        return this;
    }
  }
}
