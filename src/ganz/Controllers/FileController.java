package ganz.Controllers;

import ganz.Responses.DirectoryResponse;

import java.io.File;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;

import umwelt.Controllers.UmweltController;

public class FileController extends UmweltController {
  public FileController(String dir) {
    DIR = dir;
  }

  @Override
  public boolean valid(iRequest request) {
    return new File(DIR + request.uri()).exists();
  }

  @Override
  public iResponse handle(iRequest request) throws Exception {
    newFactory();
    if (!request.method().equals("GET")) {
      return factory.MethodNotAllowed();
    } else {
      return directoryResponse(request).proccess(request);
    }
  }

  private iResponse directoryResponse(iRequest request) throws Exception {
    String uri = request.uri();
    File file = new File(DIR + uri);
    return file.isDirectory() ? makeDirectory(uri) : factory.get(request);
  }

  private DirectoryResponse makeDirectory(String uri) {
    return new DirectoryResponse(DIR);
  }
}
