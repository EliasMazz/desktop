/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.lampada;



import br.com.domoticcenter.componente.lampada.DialogEditaObjeto.ReturnCodeDialogEditaObjeto;
import br.com.domoticcenter.restservice.util.PosicaoFrame;
import br.com.domoticcenter.view.PanelAmbiente;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mauricio
 */
public class JMenuItemRenomearLampada  extends JMenuItem implements ActionListener{
    private PanelAmbiente jPanelAmbiente;
    public JMenuItemRenomearLampada (String nome, PanelAmbiente panelAmbiente){
        super(nome);
        setFont(new Font("Dejavu Sans", Font.PLAIN, 12));
        addActionListener(this);
        this.jPanelAmbiente = panelAmbiente;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        DialogEditaObjeto editaObjeto = new DialogEditaObjeto(null, jPanelAmbiente.getLampadaeSelecionada());
                        editaObjeto.setLocation( (PosicaoFrame.posicaoFrameX + 330), (PosicaoFrame.posicaoFrameY + 130));
                        editaObjeto.setVisible(true);
                         ReturnCodeDialogEditaObjeto res = editaObjeto.getResult();

                        if (res.toString().equals("SALVAR")) {
                                jPanelAmbiente.carregaLampadas();

                        }

                    }
                });
    }
    
}
