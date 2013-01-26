/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.restservice.util;

/**
 *
 * @author Mauricio
 */
import java.util.*;
import org.omg.PortableServer.THREAD_POLICY_ID;

public class ObservableInternetConnection extends Observable implements Runnable {
	private static final long CHECK_INTERVAL = 10000; // 30 sec
	private InternetConnectionState state;

	public void run() {
		this.state = InternetConnection.isAvailable();

		this.updateConnectionStatus();
                
          
	}

	public void updateConnectionStatus() {
		while(true) {
			InternetConnectionState newState = InternetConnection.isAvailable();
			if(newState.getState() != this.state.getState()) {
				this.state = newState;
				setChanged();
				notifyObservers(this.state);
			}
			try {
				Thread.sleep(ObservableInternetConnection.CHECK_INTERVAL);
			} catch(InterruptedException e) {
			}
		}
	}
        
        
}
