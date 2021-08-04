package CompLAN.Server;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Handler {
    private static int clientCounter = 0;
    private int clientNumber;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Server server;

    public Handler(Socket socket, Server server) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Handler created");
            this.clientNumber = ++clientCounter;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle() {
        Thread handlerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted() && socket.isConnected()) {
                try {
                    String message = in.readUTF();
                    System.out.printf("Client #%d: %s\n", this.clientNumber, message);
                    message = "Client #" + clientNumber + ": " + message;
                    server.msgFromServer(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        handlerThread.start();
    }

    public void send(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

