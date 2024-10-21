package com.sd.app;

public class Main {

    
    public static void main(String[] args)
    {
        try
        {
            AudioStreamServer server = new AudioStreamServer();
            System.out.println("Servidor de Áudio RabbitMQ iniciado...");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
