package com.samuca;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerConcorrente {
    public static void main(String[] args) throws Exception{

        System.out.println("executando servidor...");
        //criar mecanismo para escutar e atender conexões pela porta 9000
        ServerSocket serverSocket = new ServerSocket(9000);
        while(true){
            //método bloqueante que cria um novo socket com o nó
            //socket terá uma porta determinada pelo SO entre 1024 - 65535
            Socket no = serverSocket.accept(); //fica travado até que alguém se comunique com o servidor
            //ler algo do socket

            //thread para atender o novo no (escrever para o no)
            ThreadAtendimento thread = new ThreadAtendimento(no);
            thread.start();
        }
    }
}
