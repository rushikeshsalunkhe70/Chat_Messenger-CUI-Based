import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class ChatServerX {
    public static void main(String A[]) throws Exception {
        
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String logFileName = "LogFile" + timestamp + ".txt";


        FileWriter fwobj = new FileWriter(logFileName, true);

        ServerSocket ssobj = new ServerSocket(5100);
        System.out.println("Marvellous is waiting at port number 5100");

        Socket sobj = ssobj.accept();
        System.out.println("Marvellous Server is successfully connected with the client");

        PrintStream pobj = new PrintStream(sobj.getOutputStream()); 
        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream())); 
        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in)); 

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Marvellous Chat Messenger is ready to use");
        System.out.println("----------------------------------------------------------------------------------------------------");

        String str1 = null, str2 = null;

        while ((str1 = bobj1.readLine()) != null) {
            System.out.println("Client Says : " + str1);
            fwobj.write("Client says: " + str1 + "\n");

            System.out.println("Enter the message for client : ");
            str2 = bobj2.readLine();
            pobj.println(str2);
            fwobj.write("Server says: " + str2 + "\n");

            fwobj.flush(); 
        }

       
        fwobj.close();
        pobj.close();
        bobj1.close();
        bobj2.close();
        sobj.close();
        ssobj.close();
    }
}
