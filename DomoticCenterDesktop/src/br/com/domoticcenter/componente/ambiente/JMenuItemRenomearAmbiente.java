/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.ambiente;



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
public class JMenuItemRenomearAmbiente extends JMenuItem implements ActionListener{
    private PanelAmbiente jPanelAmbiente;
    public JMenuItemRenomearAmbiente (String nome, PanelAmbiente panelAmbiente){
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
                        DialogEditaObjeto editaObjeto = new DialogEditaObjeto(null, jPanelAmbiente.getAmbienteSelecionado());
                        editaObjeto.setLocation(PosicaoFrame.posicaoFrameX + jPanelAmbiente.getPosicaoXComponente() + 40, PosicaoFrame.posicaoFrameY + 130 + jPanelAmbiente.getPosicaoYComponente());
                        editaObjeto.setVisible(true);
                        DialogEditaObjeto.ReturnCodeDialogEditaObjeto res = editaObjeto.getResult();

                        if (res.toString().equals("SALVAR")) {
                           jPanelAmbiente.carregaAmbiente();
                           jPanelAmbiente.getListAmbientes().setSelectedIndex(jPanelAmbiente.getIndiceAmbienteNaLista());
                           jPanelAmbiente.getjPanel1().setVisible(false);
                           jPanelAmbiente.getjPanel1().setVisible(true);
                        }

              }
     });
  }
    
}
