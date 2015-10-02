
import java.util.*;
import java.io.*;
import java.net.*;

class Client {

    public static void main(String ar[]) {
        try {

            String serverIP = "127.0.0.1";
            String fileName = "ab.zip";
            Socket socket = new Socket(serverIP, 5232);
            File transferFile = new File(fileName);

            byte[] bytearray = new byte[1024];

            FileInputStream fin = new FileInputStream(transferFile);
            BufferedInputStream bin = new BufferedInputStream(fin);
            OutputStream os = socket.getOutputStream();
            int i = 0;
            while ((i = bin.read(bytearray)) > -1) {

                System.out.println("Sending Files...");
                os.write(bytearray, 0, i);
            }
            os.flush();
            socket.close();
            System.out.println("File transfer complete");
            transferFile.delete();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
