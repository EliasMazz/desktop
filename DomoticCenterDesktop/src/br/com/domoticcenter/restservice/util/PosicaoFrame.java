/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domoticcenter.restservice.util;

/**
 *
 * @author Mauricio
 */
public class PosicaoFrame {

    public static int getPosicaoFrameX() {
        return posicaoFrameX;
    }

    public static void setPosicaoFrameX(int posicaoFrameX) {
        PosicaoFrame.posicaoFrameX = posicaoFrameX;
    }

    public static int getPosicaoFrameY() {
        return posicaoFrameY;
    }

    public static void setPosicaoFrameY(int posicaoFrameY) {
        PosicaoFrame.posicaoFrameY = posicaoFrameY;
    }
    public static int posicaoFrameX;
    public static int posicaoFrameY;
}
