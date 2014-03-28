package ganz.Responses;

import java.io.File;

public class HTMLGenerator {
  static String responseString;

  public static String directory(String directory, String route) {
    GenerateResponseString();
    addStandardHeader();
    addDirectoryBody(directory, route);
    closeHTML();
    return responseString;
  }

  public static void GenerateResponseString() {
    responseString = new String();
  }

  public static void addDirectoryBody(String path, String route) {
    openBody();
    generateLinks(route, new File(path + route));
    closeBody();
  }

  private static void openBody() {
    responseString += "<body>\n";
  }

  private static void closeBody() {
    responseString += "</body>\n";
  }

  private static void generateLinks(String route, File directory) {
    for(File file : directory.listFiles()) {
      boolean directoryIndicator = file.isDirectory();
      generateLink(route, file.getName(), directoryIndicator);
    }
  }

  private static void generateLink(String route, String file, boolean indicator) {
      startLink(route + file);
      endLink(file, indicator);
  }

  private static void startLink(String link) {
    responseString += "<a href='" + link + "'>";
  }

  private static void endLink(String filename, boolean indicator) {
    String suffix = indicator ? "/" : "";
    responseString += filename + suffix + "</a>\n<br>";
  }

  public static void addStandardHeader() {
     responseString += "<!DOCTYPE html>\n" +
                       "<html lang='en'>\n" +
                       "<head>\n" +
                       "<meta charset='utf-8' />\n" +
                       "<title>Velcome to see Intanet</title>\n" +
                       "</head>\n";
  }

  public static void closeHTML() {
    responseString += "</html>";
  }
}
