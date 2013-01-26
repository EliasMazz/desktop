/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.restservice.util;

import br.com.domoticcenter.manager.ParseJSON;
import org.json.JSONObject;

/**
 *
 * @author Mauricio
 */
public class ConversaComArduino {
    public static JSONObject comandoHTTP(String http) {

        System.out.println(http);
        ParseJSON arduinoRequest = new ParseJSON();
        return arduinoRequest.doRequestToArduino(http);
    }

}
