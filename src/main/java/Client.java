import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 8189);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            while (true){
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                printWriter.println(message);
                printWriter.flush();

                String inputMessage = bufferedReader.readLine();
                System.out.println(inputMessage);
            }
        }
    }
}
