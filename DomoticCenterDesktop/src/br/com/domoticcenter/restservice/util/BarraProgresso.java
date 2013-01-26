package br.com.domoticcenter.restservice.util;

import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;


public abstract class BarraProgresso extends JFrame{
   public JProgressBar progressBar;
        public BarraProgresso() {

                this.setTitle("Progresso");
                this.setSize(300, 100);
                this.setVisible(true);
                this.setLocationRelativeTo(null);
                
             

                Container content = this.getContentPane();

                progressBar = new JProgressBar();
                progressBar.setIndeterminate(true);
                progressBar.setBorder(BorderFactory.createTitledBorder("Executando..."));

                content.add(progressBar);
                  
                new SwingWorker() {
                        @Override
                        protected Object doInBackground() throws Exception {
                               executar();
                               done();
                               return null;
                        }
                        @Override
                        protected void done() {
                               super.done();
                               setVisible(false);
                        }
                }.execute();

        }

        public abstract void executar();

}
