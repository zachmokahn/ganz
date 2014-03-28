
import umwelt.Util.CLIParser;
import ganz.GanzServer;

public class Server {
  public static void main(String[] args) throws Exception {
    int port   = CLIParser.getPort(args);
    String dir = CLIParser.getDIR(args);
    GanzServer server = new GanzServer(port, dir);
    server.start();
  }
}
