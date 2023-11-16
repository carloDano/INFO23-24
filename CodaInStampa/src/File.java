import java.io.*;

public class File {
    private String nomeFile;
    private FileWriter scrittura;
    private PrintWriter bfw;
    private FileReader lettura;
    private BufferedReader bfr;

    public File(String nomeFile) {
        this.nomeFile = nomeFile;
    }
    public void createFile() throws IOException {
        scrittura = new FileWriter(nomeFile);
        bfw = new PrintWriter(scrittura);
    }

    public void println(String riga){
        bfw.println(riga);
    }

    public void openFile() throws IOException{
        lettura = new FileReader(nomeFile);
        bfr = new BufferedReader(lettura);
    }

    public String readln() throws IOException{
        String riga = bfr.readLine();
        return riga;
    }

    public void flush(){
        bfw.flush();
    }

    public void closeW() throws IOException{
        bfw.close();
        scrittura.close();
    }

    public void closeR() throws IOException{
        bfr.close();
        lettura.close();
    }

}
