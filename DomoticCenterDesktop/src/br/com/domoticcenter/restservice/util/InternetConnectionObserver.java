/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.restservice.util;

/**
 *
 * @author Mauricio
 */

import br.com.domoticcenter.view.TranslucentWindowDemo;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InternetConnectionObserver implements Observer {
    private boolean estadoConexao;
   private JDialogSemConexao dialogSemConexao;

    public boolean isEstadoConexao() {
        return estadoConexao;
    }

    public void setEstadoConexao(boolean estadoConexao) {
        this.estadoConexao = estadoConexao;
    }
	public InternetConnectionObserver(ObservableInternetConnection internetConnection) {
		internetConnection.addObserver(this);
             
		new Thread(internetConnection).start();
               
	}

	public void update(Observable internetConnection, Object state) {
            
                  
		InternetConnectionState connectionState = (InternetConnectionState)state;
                estadoConexao = connectionState.getState();
		if(connectionState.getState() == true) {
                        if(dialogSemConexao != null)
                             dialogSemConexao.dispose();
			System.err.println("active internet connection detected");
		} else {
                  
                 
                        dialogSemConexao = new JDialogSemConexao();
                        dialogSemConexao.setAlwaysOnTop(true);
                       
                        dialogSemConexao.setLocation(PosicaoFrame.getPosicaoFrameX()+100, PosicaoFrame.getPosicaoFrameY()+50);
              
			System.err.println("lost internet connection");
		}
	}
        
        
        
        
}
