import java.net.*;
import java.io.*;
 
public class Client
{
    private Socket socket;
    private BufferedReader  input;
    private DataOutputStream out;

    public Client(String address, int port)
    {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
 
           
            input  = new BufferedReader(new InputStreamReader(System.in));
 
 
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        String line = "";
 
        while (!line.equals("Over"))
        {
            try
            {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
 
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
 
    public static void main(String args[])
    {
        Client client = new Client("192.168.101.192", 8000);
    }
}