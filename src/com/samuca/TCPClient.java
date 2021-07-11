package com.samuca;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{

        //tenta criar uma conexão com o host remoto "127.0.0.1" na porta 9000
        //socket terá uma porta designada pelo SO entre 1024 - 65535
        Socket s = new Socket("127.0.8.1", 9000);

        //cria a cadeia de saída (escrita) de informações do socket
        OutputStream os = s.getOutputStream();
        DataOutputStream writer = new DataOutputStream(os);

        //cria cadeia de entrada (leitura) de informações de socket
        InputStreamReader is = new InputStreamReader(s.getInputStream());
        BufferedReader reader = new BufferedReader(is);

        //cria um buffer que le infos do teclado
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        String texto = inFromUser.readLine();

        //escrita de infos ao host remoto
        writer.writeBytes(texto + "\n");//blocking até q capture infos do teclado

        //leitura do socket (recebimento de infos do socket remoto)
        String response = reader.readLine();//blocking também
        System.out.println("Do Servidor: " + response);

        //fechamento do canal socket
        s.close();
    }
}
