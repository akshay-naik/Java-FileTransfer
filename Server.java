import java.util.*;
import java.io.*;
import java.net.*;
class Server
{
	public static void main(String ar[])throws Exception
	{
	    int filesize = 1024;
        int bytesRead;
        int currentTot = 0;
        byte[] bytearray = new byte[filesize];
	   String username;
	   ServerSocket serverSocket=new ServerSocket(5232);
	   while(true)
	   {
		 Socket socket = serverSocket.accept();
            System.out.println("Accepted connection : " + socket);
            InputStream is = socket.getInputStream();
            username=socket.getInetAddress().getHostName();
		 FileOutputStream fos = new FileOutputStream(new File( username+".zip"));
            BufferedOutputStream bos = new BufferedOutputStream(fos);
      
			int i=0;
            while((i=is.read(bytearray))>-1) {
                bos.write(bytearray,0,i);
            } 
           
            bos.flush();
            bos.close();
            socket.close();
			}
	}
}

