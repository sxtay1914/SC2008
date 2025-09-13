import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class RFC_865_Client {
    final static int PORT = 17;
    final static String server = "127.0.0.1";
    public static void main(String[] args) {
        //Open socket
        DatagramSocket socket;
        try{
            socket = new DatagramSocket();
            try {
                //IP address of server
                InetAddress serverIP = InetAddress.getByName(server);

                //Send UDP request to server
                byte[] buffer = new byte[1];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length, serverIP, PORT);
                socket.send(request);

                //Receive UDP reply from server
                byte[] receiveBuffer = new byte[512];
                DatagramPacket reply = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(reply);

                //Printing out reply 
                String msg = new String(reply.getData());
                System.out.println(msg);

                //close socket
                socket.close();
    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(SocketException e){
            e.printStackTrace();
        }
    }
}
