import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8189);) {
            int clientCounter = 0;
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected clients: " + clientCounter);
                Runnable runnable = new ThreadEchoHendler(socket);
                Thread thread = new Thread(runnable);
                thread.start();
                clientCounter++;
            }
        }
    }
}
