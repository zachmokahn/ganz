package ganz.Responses;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;

import umwelt.Responses.UmweltResponse;

public class DirectoryResponse extends UmweltResponse {
  private String DIR;

  public DirectoryResponse(String DIR) {
    this.DIR = DIR;
    setStatus("200", "OK");
    setVersion("HTTP/1.1");
    setHeader("Content-Type", "text/html");
  }

  public String convertToDirURL(String route) {
    return (directoryURL(route)) ? route : route + "/";
  }

  private boolean directoryURL(String route) {
    return route.substring(route.length() - 1).equals("/");
  }

  @Override
  public iResponse proccess(iRequest request) {
    String route = request.uri();
    setContent(HTMLGenerator.directory(DIR, convertToDirURL(route)));
    return this;
  }
}
