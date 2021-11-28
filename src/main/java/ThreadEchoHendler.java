import java.io.*;
import java.net.Socket;

public class ThreadEchoHendler implements Runnable{
    private Socket socket;

    public ThreadEchoHendler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        ){
            while (true){
                String inputContent = bufferedReader.readLine();
                String outputContent = "Echo: " + inputContent;
                printWriter.println(outputContent);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
