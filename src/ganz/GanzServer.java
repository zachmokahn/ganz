package ganz;

import java.io.File;

import ganz.Controllers.FileController;

import umwelt.UmweltServer;
import umwelt.Responses.UmweltFactory;

public class GanzServer extends UmweltServer {
  public GanzServer(int port, String dir) throws Exception {
    super(port);
    if (validDir(dir)) changeDir(dir);
    addDependencies();
  }

  public GanzServer(int port) throws Exception {
    super(port);
    addDependencies();
  }

  public GanzServer(String dir) throws Exception {
    super(5000);
    if (validDir(dir)) changeDir(dir);
    addDependencies();
  }

  public GanzServer() throws Exception {
    super(5000);
    addDependencies();
  }

  private void addDependencies() {
    addController(new FileController(DIR));
    addResponseFactory(new UmweltFactory(DIR));
  }

  private boolean validDir(String dir) {
    return new File(dir).isDirectory();
  }
}
