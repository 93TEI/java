import java.net.Socket;

public class clientSocket {
    public static void main(String args[]){
        Socket socket = null;

        try {
            socket = new Socket("서버ip",포트);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOututStream();

            String str = "This is Tei's Client";
            out.write(str.getBytes());
            byte arr[] = new byte[100];
            in.read(arr);
            System.out.println(new String(arr));
        } catch (Exception e) {
            //TODO: handle exception
            String massage = e.getMessage();
            System.out.println(massage);
        }finally{
            try{
                socket.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
