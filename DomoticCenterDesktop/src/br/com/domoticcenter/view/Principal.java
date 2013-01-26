/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.view;

/**
 *
 * @author mauricio.mazzocco
 */
import br.com.domoticcenter.componente.JMenuBarDomoticCenter;
import br.com.domoticcenter.componente.TabbedPaneAmbiente;
import br.com.domoticcenter.entity.Ambiente;
import br.com.domoticcenter.restservice.util.ResidenciaCompletaMemory;
import br.com.domoticcenter.restservice.util.PosicaoFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.Painter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.plaf.ColorUIResource;
//import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Demonstrates basic usage of the PreferencesPanel.
 */
@SuppressWarnings("serial")
public class Principal extends JFrame  {


    private List<Ambiente> ambientes;
    private static TabbedPaneAmbiente jTp;

    public static TabbedPaneAmbiente getjTp() {
        return jTp;
    }
    private final String iconPatch = "/br/com/domoticcenter/imagens/";
    private int ultimaTabClicada = 0;
    private PanelAmbiente panelAmbinete;
     private static PanelAgendamento panelAgendamento;

    public static PanelAgendamento getPanelAgendamento() {
        return panelAgendamento;
    }


    public Principal() {
       
    }
    
    private void yoyoMama(Object object) {
    if (object instanceof Container) {
        Container c = (Container) object;
        Component[] components = c.getComponents();
        for (Component component : components) {
            yoyoMama(component);
            // put extra "wild" stuff here
            component.setBackground(Color.BLACK);
        }
    } else {
        if (object instanceof Component) {
            Component component = (Component) object;
            // put extra "wild" stuff here
            component.setBackground(Color.BLACK);
        }
    }
}

    public Principal(String login, String senha) {
        super("DomoticCenter");
      
        yoyoMama(Principal.this);
        setResizable(false);
        URL imageURLiconPrincipal = this.getClass().getClassLoader().getResource("br/com/domoticcenter/imagens/icone_principal.png");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(imageURLiconPrincipal);
        
        setIconImage(img);
  
        JMenuBarDomoticCenter jmenuBar = new JMenuBarDomoticCenter();
        JMenu jmenu = new JMenu(" ");
        jmenuBar.add(jmenu);
        setJMenuBar(jmenuBar);
                
      
        
        panelAmbinete = new PanelAmbiente(login, senha);
        panelAgendamento = new PanelAgendamento(login, senha);
        
        panelAmbinete.setBackground(Color.BLACK);
        jTp = new TabbedPaneAmbiente(panelAmbinete);
        jTp.addTab("Ambientes", new ImageIcon(getClass().getResource(iconPatch + "ambientes.png")), panelAmbinete);
      
        jTp.addTab("Agendamento", new ImageIcon(getClass().getResource(iconPatch + "agendamentoMenor.png")), panelAgendamento);
        //jTp.addTab("Macro", new ImageIcon(getClass().getResource(iconPatch + "macroMenor.png")), new JLabel("Printer"));

     
        // JSeparator jSeparator1 = new JSeparator(SwingConstants.HORIZONTAL);
        //  jSeparator1.setSize(550,3);  
        //   add(jSeparator1);
        //  pp.setTabReorderByDraggingEnabled(false);
 
        add(jTp);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(635, 500);
        setLocationRelativeTo(null);


        
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                PosicaoFrame.setPosicaoFrameX(evt.getComponent().getX());
                PosicaoFrame.setPosicaoFrameY(evt.getComponent().getY());
            }
        });

        setVisible(true);


    }

    /**
     * Static main method for application startup.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                       new Principal("a", "b");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
