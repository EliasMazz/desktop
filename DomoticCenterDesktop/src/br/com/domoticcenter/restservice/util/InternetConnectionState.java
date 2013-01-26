/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.restservice.util;

/**
 *
 * @author Mauricio
 */

public class InternetConnectionState {
	private boolean state = false;

	public InternetConnectionState(boolean state) {
		this.state = state;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
