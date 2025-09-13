import java.net.*;

public class RFC_865_Server {
    final static int PORT = 17;
    final static String QUOTE = "This is a sample.";
    public static void main(String[] args) {
        DatagramSocket socket;
        try{
            //Open up socket at well-known port
            socket = new DatagramSocket(PORT);
            while (true){
                try{
                    //buffer to store request
                    byte[] buffer = new byte[512];
                    //listen for request
                    DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                    socket.receive(request);
                    
                    //client IP & client Port
                    InetAddress clientIP = request.getAddress();
                    int clientPort = request.getPort();

                    //send UDP reply to client
                    byte[] quoteBytes = QUOTE.getBytes();
                    DatagramPacket reply = new DatagramPacket(
                                            quoteBytes, quoteBytes.length,  
                                            clientIP, clientPort);
                    socket.send(reply);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }catch(SocketException e){
            e.printStackTrace();
        }
    } 
}
