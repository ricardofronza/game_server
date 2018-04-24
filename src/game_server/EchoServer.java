package game_server;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcondes Maçaneiro
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(12345);
        } catch (IOException e) {e.printStackTrace();}

        Socket clientSocket = null;
        Socket clientSocket2 = null;
        System.out.println("Waiting for connection.....");

        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {e.printStackTrace();}

        System.out.println("Connection successful");
        
        try {
            clientSocket2 = serverSocket.accept();
        } catch (IOException e) {e.printStackTrace();}
        
        System.out.println("Waiting for input.....");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(),true);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));

        Object[] options = {"Sim","Não"};
        int ret = JOptionPane.showOptionDialog( null, "Você quer iniciar o jogo?","Iniciar Jogo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
        if(ret==0){
            GetSetEstado estado = new GetSetEstado();
            while (clientSocket.isConnected() && clientSocket2.isConnected()) {
                String recebido1[] = in.readLine().split("/");
                String recebido2[] = in2.readLine().split("/");
                
                estado.setaPosicoes(Integer.parseInt(recebido1[0]), Integer.parseInt(recebido2[1]), Integer.parseInt(recebido1[2]), Integer.parseInt(recebido1[3]));
                
                out.println(estado.getBarra1()+"/"+estado.getBarra2()+"/"+estado.getPosX()+"/"+estado.getPosY());  
                out2.println(estado.getBarra1()+"/"+estado.getBarra2()+"/"+estado.getPosX()+"/"+estado.getPosY());       
            }

            out.close();
            in.close();
            out2.close();
            in2.close();
            clientSocket.close();
            clientSocket2.close();
            serverSocket.close();
        }
    }
}
