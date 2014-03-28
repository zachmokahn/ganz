package ganz;

import java.io.File;

import ganz.Controllers.FileController;

import umwelt.UmweltServer;

public class GanzServer extends UmweltServer {
  public GanzServer(int port, String dir) throws Exception {
    super(port);
    if (validDir(dir)) changeDir(dir);
    addController(new FileController(DIR));
  }

  public GanzServer(int port) throws Exception {
    super(port);
    addController(new FileController(DIR));
  }

  public GanzServer(String dir) throws Exception {
    super(5000);
    if (validDir(dir)) changeDir(dir);
    addController(new FileController(DIR));
  }

  public GanzServer() throws Exception {
    super(5000);
    addController(new FileController(DIR));
  }

  private boolean validDir(String dir) {
    return new File(dir).isDirectory();
  }
}
