/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server;

/**
 *
 * @author G1745 IRON
 */
public class GetSetEstado {
    private int barra1;
    private int barra2;
    private int posX;
    private int posY;

    public void setaPosicoes(int bara1, int bara2, int poX, int poY){
        this.barra1 = bara1;
        this.barra2 = bara2;
        this.posX = poX;
        this.posY = poY;
    }
    
    public int getBarra1() {
        return barra1;
    }
    public int getBarra2() {
        return barra2;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    
}
