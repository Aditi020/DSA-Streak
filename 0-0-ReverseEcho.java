package reverseecho;

import java.net.*;
import java.io.*;

public class ReverseEcho extends Thread {
    Socket stk; // The socket connected to a specific client

    public ReverseEcho(Socket st) {
        stk = st; // Save the client's socket for communication
    }

    public void run() {
        try {
            // Create a BufferedReader to read data from the client
            BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));

            // Create a PrintStream to send data to the client
            PrintStream ps = new PrintStream(stk.getOutputStream());

            String msg;
            StringBuilder sb;

            do {
                // Read a line from the client
                msg = br.readLine();

                // Reverse the message
                sb = new StringBuilder(msg);
                sb.reverse();
                msg = sb.toString();

                // Send the reversed message back to the client
                ps.println(msg);

            } while (!msg.equals("dne")); // Stop if the reversed message is "dne" (i.e., "end" from client)

            stk.close(); // Close the socket after communication ends
        } catch (Exception e) {
            // Exception handling (could log this in real apps)
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(2000); // Create a server socket on port 2000
        int count = 1;
        Socket stk;
        ReverseEcho re;

        do {
            stk = ss.accept(); // Accept a new client connection
            System.out.println("Client Connected :" + count++);
            re = new ReverseEcho(stk); // Create a new thread for the client
            re.start(); // Start handling the client in a separate thread

        } while (true); // Keep accepting new clients
    }
}

// ---------- CLIENT SIDE ----------
class Client {
    public static void main(String[] args) throws Exception {
        // Connect to the server using its IP and port
        Socket stk = new Socket("192.168.0.103", 2000);

        // Read user input from the keyboard
        BufferedReader keyb = new BufferedReader(new InputStreamReader(System.in));

        // Read server responses
        BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));

        // Send data to the server
        PrintStream ps = new PrintStream(stk.getOutputStream());

        String msg;

        do {
            msg = keyb.readLine();   // Read user input
            ps.println(msg);        // Send it to the server

            msg = br.readLine();    // Read reversed response from server
            System.out.println("From Server" + msg); // Print it

        } while (!msg.equals("dne")); // Stop if response is "dne"
        
        stk.close(); // Close connection
    }
}
