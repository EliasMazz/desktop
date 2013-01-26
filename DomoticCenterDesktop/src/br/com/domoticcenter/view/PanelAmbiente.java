/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.view;

import br.com.domoticcenter.componente.ambiente.JListAmbientes;
import br.com.domoticcenter.componente.lampada.JToggleButtonLampada;
import br.com.domoticcenter.componente.lampada.JButtonLampada;
import br.com.domoticcenter.entity.Ambiente;
import br.com.domoticcenter.entity.Lampada;
import br.com.domoticcenter.manager.ParseJSON;
import br.com.domoticcenter.restservice.util.ResidenciaCompletaMemory;
import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.json.JSONObject;

/**
 *
 * @author mauricio.mazzocco
 */
public class PanelAmbiente extends javax.swing.JPanel {

    private JList listAmbientes;
    private Timer threadLampadas;
    private Ambiente ambienteSelecionado;
    private Lampada lampadaeSelecionada;
    private int indiceAmbienteNaLista = 0;
    private List<JToggleButtonLampada> toggleButtonList;
    private List<Lampada> lampadasComIDSelecionado;

    public List<Lampada> getLampadasComIDSelecionado() {
        return lampadasComIDSelecionado;
    }
    private final String iconPatch = "/br/com/domoticcenter/imagens/";
    private boolean executarThreadLamapdas = false;

    public JPanel getjPanel1() {
        return jPanel1;
    }
  public JPanel getjPanel2() {
        return jPanel2;
    }

    private boolean stopRefresh = false;
    private boolean estaCarregando;

    public boolean isEstaCarregando() {
        return estaCarregando;
    }

    public void setEstaCarregando(boolean estaCarregando) {
        this.estaCarregando = estaCarregando;
    }
    private ImageIcon loader = new ImageIcon(getClass().getResource(iconPatch + "carregando.gif"));
    private ImageIcon toggleButtonOff = new ImageIcon(getClass().getResource(iconPatch + "toggleButtonOff.png"));
    private ImageIcon toggleButtonOn = new ImageIcon(getClass().getResource(iconPatch + "toggleButtonOn.png"));
    private ImageIcon separator = new ImageIcon(getClass().getResource(iconPatch + "separator.png"));

    public ArrayList<JLabel> getProgressToggleButton() {
        return progressToggleButton;
    }

    public void setProgressToggleButton(ArrayList<JLabel> progressToggleButton) {
        this.progressToggleButton = progressToggleButton;
    }
    private ArrayList<JLabel> progressToggleButton = new ArrayList();
 
    public JList getListAmbientes() {
        return listAmbientes;
    }

    public void setListAmbientes(JList listAmbientes) {
        this.listAmbientes = listAmbientes;
    }
    public boolean isExecutarThreadLamapdas() {
        return executarThreadLamapdas;
    }

    public void setExecutarThreadLamapdas(boolean executarThreadLamapdas) {
        this.executarThreadLamapdas = executarThreadLamapdas;
    }

    public Ambiente getAmbienteSelecionado() {
        return ambienteSelecionado;
    }

    public void setAmbienteSelecionado(Ambiente ambienteSelecionado) {
        this.ambienteSelecionado = ambienteSelecionado;
    }

    public int getPosicaoYComponente() {
        return posicaoYComponente;
    }

    public void setPosicaoYComponente(int posicaoYComponente) {
        this.posicaoYComponente = posicaoYComponente;
    }

    public int getPosicaoXComponente() {
        return posicaoXComponente;
    }

    public void setPosicaoXComponente(int posicaoXComponente) {
        this.posicaoXComponente = posicaoXComponente;
    }
    private int posicaoYComponente;
    private int posicaoXComponente;
    
        public Lampada getLampadaeSelecionada() {
        return lampadaeSelecionada;
    }

    public void setLampadaeSelecionada(Lampada lampadaeSelecionada) {
        this.lampadaeSelecionada = lampadaeSelecionada;
    }


    public int getIndiceAmbienteNaLista() {
        return indiceAmbienteNaLista;
    }

    public void setIndiceAmbienteNaLista(int indiceAmbienteNaLista) {
        this.indiceAmbienteNaLista = indiceAmbienteNaLista;
    }

    /**
     * Creates new form PanelTeste
     */
    public PanelAmbiente() {
        initComponents();
    }

    public PanelAmbiente(String login, String senha) {
        initComponents();

        final Icon tabLine = new ImageIcon(getClass().getResource(iconPatch + "tab_line.png"));
        JLabel jLabeLine = new JLabel(tabLine);
        jLabeLine.setBounds(0, 0, 610, 10);
        jPanel3.add(jLabeLine);

        final Icon listLine = new ImageIcon(getClass().getResource(iconPatch + "line.png"));
        JLabel jLabeListLine = new JLabel(listLine);
        jLabeListLine.setBounds(0, 0, 8, 360);
        jPanel4.add(jLabeListLine);

        carregaAmbiente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(300, 350));
        setRequestFocusEnabled(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(160, 150));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents


    public void carregaAmbiente() {

        jPanel1.removeAll();
        jPanel1.setLayout(new GridLayout(1, 0));        
        listAmbientes = new JListAmbientes(this);
        jPanel1.add(listAmbientes);
   
    }

    public void carregaLampadas() {
        jPanel2.removeAll();
        
        progressToggleButton.clear();
        Ambiente amb = ResidenciaCompletaMemory.getResidenciaCompleta().getAmbientes().get(listAmbientes.getSelectedIndex());
        estaCarregando = true;

        System.out.println("Tamanho " + ResidenciaCompletaMemory.getResidenciaCompleta().getLampadas().size());
        toggleButtonList = new ArrayList<JToggleButtonLampada>();
        
        lampadasComIDSelecionado = new ArrayList<Lampada>();
        final Icon iconeLampda = new ImageIcon(getClass().getResource(iconPatch + "iluminacao.png"));
        JLabel jLabelIluminacao = new JLabel(iconeLampda, JLabel.CENTER);
        jLabelIluminacao.setBounds(50, 0, 280, 70);
        jPanel2.add(jLabelIluminacao);

        for (Lampada lampada : ResidenciaCompletaMemory.getResidenciaCompleta().getLampadas()) {
            if (lampada.getAmbienteID() == amb.getAmbienteID()) {
                lampadasComIDSelecionado.add(lampada);
            }
        }

        JToggleButtonLampada[] jToggleStatusLampada = new JToggleButtonLampada[lampadasComIDSelecionado.size()];
        JButtonLampada[] buttonLampada = new JButtonLampada[lampadasComIDSelecionado.size()];


        int y = 70;
        for (int i = 0; i < lampadasComIDSelecionado.size(); i++) {
            System.out.println(lampadasComIDSelecionado.get(i).getNome());

            progressToggleButton.add(new javax.swing.JLabel(loader));
            progressToggleButton.get(i).setBounds(265, y, 70, 60);

            buttonLampada[i] = new JButtonLampada(lampadasComIDSelecionado.get(i).getNome(),this);
            buttonLampada[i].setBounds(50, y, 180, 60);
            buttonLampada[i].setName(String.valueOf(i));

            jToggleStatusLampada[i] = new JToggleButtonLampada(""+i,this);
          
            jToggleStatusLampada[i].setBounds(265, y, 70, 60);
           
            JLabel jLabelSeparator = new JLabel(separator);
            jLabelSeparator.setBounds(67, y - 5, 230, 5);
            jPanel2.add(jLabelSeparator);

       
            //  buttons[i].setFont(new java.awt.Font("Tahoma", 1, 13));
            // buttons[i].setForeground(new java.awt.Color(0, 51, 255));
          
            y += 70;

            toggleButtonList.add(jToggleStatusLampada[i]);

            jPanel2.add(buttonLampada[i]);
            jPanel2.add(progressToggleButton.get(i));
            jPanel2.add(jToggleStatusLampada[i]);

            

        }
        executarThreadLamapdas = true;
        executaThreadLampada();



    }

    public JSONObject conversaComArduino(String http) {
        //System.out.println("Posicao ambiente " + posicAmbiente);
        System.out.println(http);
        ParseJSON arduinoRequest = new ParseJSON();
        return arduinoRequest.doRequestToArduino(http);
    }

    private void executaThreadLampada() {

        if (threadLampadas != null) {
            cancelaThreadLampada();
        }
        if (stopRefresh == false) {
            threadLampadas = new Timer();
            threadLampadas.scheduleAtFixedRate(
                    new TimerTask() {
                        public void run() {
                            String status = "";
                            String out = "";
                            JSONObject resultadoArduino = null;
                            if (executarThreadLamapdas) {
                                if (stopRefresh == false) {
                                    try {
                                        String http = "http://" + ResidenciaCompletaMemory.getResidenciaCompleta().getIpDomoticCenter() + "/out=" + listAmbientes.getSelectedIndex() + "&status=" + "est";
                                        // String http = "http://" + "192.168.1.46" + "/out=" + list.getSelectedIndex() + "&status=" + "est";
                                        resultadoArduino = conversaComArduino(http);
                                    } catch (Exception ex) {
                                    } finally {
                                        if (resultadoArduino != null) {
                                            status = resultadoArduino.optString("status");
                                            out = resultadoArduino.optString("out");
                                            refreshUiToggleButons(out);
                                        } else {
                                            System.out.println("Arduino request erro");
                                        }
                                    }
                                }
                            }
                        }
                    }, 0, 3500);
        }
    }

    public synchronized void refreshUiToggleButons(final String out) {


        System.out.println("refreshUiToggleButons" + out);
        estaCarregando = false;
        if (stopRefresh == false) {

            if (SwingUtilities.isEventDispatchThread()) {
                if (stopRefresh == false) {
                    char[] charArray = out.toCharArray();
                    for (int i = 0; i < toggleButtonList.size(); i++) {

                        toggleButtonList.get(i).show();
                        progressToggleButton.get(i).hide();
                        if (charArray[i] == '1') {
                            toggleButtonList.get(i).setSelected(true);
                            toggleButtonList.get(i).setIcon(toggleButtonOn);
                        } else if (charArray[i] == '0') {
                            toggleButtonList.get(i).setSelected(false);
                            toggleButtonList.get(i).setIcon(toggleButtonOff);
                        }
                    }
                }


            } else {
                try {

                    SwingUtilities.invokeAndWait(new Runnable() {
                        public void run() {

                            if (stopRefresh == false) {
                                char[] charArray = out.toCharArray();
                                for (int i = 0; i < toggleButtonList.size(); i++) {

                                    toggleButtonList.get(i).show();
                                    progressToggleButton.get(i).hide();
                                    if (charArray[i] == '1') {
                                        toggleButtonList.get(i).setSelected(true);
                                        toggleButtonList.get(i).setIcon(toggleButtonOn);
                                    } else if (charArray[i] == '0') {
                                        toggleButtonList.get(i).setSelected(false);
                                        toggleButtonList.get(i).setIcon(toggleButtonOff);
                                    }
                                }
                            }

                        }
                    });

                } catch (InterruptedException ie) {
                } catch (InvocationTargetException ite) {
                }
            }

        }





    }

    public List<JToggleButtonLampada> getToggleButtonList() {
        return toggleButtonList;
    }

    public void setToggleButtonList(List<JToggleButtonLampada> toggleButtonList) {
        this.toggleButtonList = toggleButtonList;
    }

    public boolean isStopRefresh() {
        return stopRefresh;
    }

    public void setStopRefresh(boolean stopRefresh) {
        this.stopRefresh = stopRefresh;
    }

    private void cancelaThreadLampada() {

        threadLampadas.cancel();
        threadLampadas.purge();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
