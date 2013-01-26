/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.componente.lampada;

import br.com.domoticcenter.restservice.util.ConversaComArduino;
import br.com.domoticcenter.restservice.util.ResidenciaCompletaMemory;
import br.com.domoticcenter.view.PanelAmbiente;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JToggleButton;
import org.json.JSONObject;

/**
 *
 * @author Mauricio
 */
public class JToggleButtonLampada extends JToggleButton implements MouseListener{
    private PanelAmbiente jPanelAmbiente;
    public JToggleButtonLampada (String nome, PanelAmbiente jPanelAmbinete){
         super();
         setName(nome);
         this.jPanelAmbiente = jPanelAmbinete;
         setFocusable(false);
         setBorder(null);
         setBorderPainted(false);
         setMargin(new Insets(0, 0, 0, 0));
         setContentAreaFilled(false);
         setForeground(Color.BLACK);
         setFont(new java.awt.Font("Dejavu Sans", Font.PLAIN, 15));
         hide();
         addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
       final String posicaoLampada = e.getComponent().getName();
                    if (!jPanelAmbiente.isEstaCarregando()) {
                        final JToggleButtonLampada jtb = (JToggleButtonLampada) e.getComponent();
                        jPanelAmbiente.setStopRefresh(true);
                        jtb.hide();
                        jPanelAmbiente.getProgressToggleButton().get(Integer.parseInt(posicaoLampada)).show();

                        Thread queryThread = new Thread() {
                            public void run() {
                                jPanelAmbiente.setStopRefresh(true);

                                String status = "";
                                String out = "";
                                JSONObject resultadoArduino = null;
                                String http = "";

                                if (jtb.isSelected()) {
                                    // http = "http://" + "192.168.1.46" + "/out=" + list.getSelectedIndex() + "&status=" + "des" + posicaoLampada;
                                    http = "http://" + ResidenciaCompletaMemory.getIpDomoticCenter() + "/out=" + jPanelAmbiente.getListAmbientes().getSelectedIndex() + "&status=" + "des" + posicaoLampada;
                                } else {
                                    // http = "http://" + "192.168.1.46" + "/out=" + list.getSelectedIndex() + "&status=" + "lig" + posicaoLampada;
                                    http = "http://" + ResidenciaCompletaMemory.getIpDomoticCenter() + "/out=" + jPanelAmbiente.getListAmbientes().getSelectedIndex() + "&status=" + "lig" + posicaoLampada;
                                }
                                jPanelAmbiente.setStopRefresh(true);

                                try {
                                    resultadoArduino = ConversaComArduino.comandoHTTP(http);
                                } catch (Exception ex) {
                                } finally {
                                    jPanelAmbiente.setStopRefresh(true);
                                    if (resultadoArduino == null) {
                                        System.out.println("Arduino request erro");
                                    } else {
                                        System.out.println(resultadoArduino);
                                        status = resultadoArduino.optString("status");
                                        out = resultadoArduino.optString("out");
                                    }
                                    if (status.equals("lig") || status.equals("des")) {

                                        System.out.println("Enviado com sucesso");
                                    }
                                    jPanelAmbiente.setStopRefresh(false);
                                }
                            }
                        };
                        queryThread.start();

                    }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      //
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      //
    }

    @Override
    public void mouseExited(MouseEvent e) {
       //
    }
    
}
