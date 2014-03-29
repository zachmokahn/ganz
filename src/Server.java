import umwelt.Util.CLIParser;
import ganz.GanzServer;

public class Server {
  public static void main(String[] args) throws Exception {
    GanzServer server;
    try {
    int port   = CLIParser.getPort(args);
    String dir = CLIParser.getDIR(args);
    server = new GanzServer(port, dir);
    } catch (IndexOutOfBoundsException e) {
    server = new GanzServer();
    }
    server.start();
  }
}
