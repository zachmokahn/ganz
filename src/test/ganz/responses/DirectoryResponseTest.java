package test.ganz.responses;

import ganz.Responses.DirectoryResponse;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectoryResponseTest {
  @Test public void convertsNonDirectoyTypeStringsToDirectoryTypeStrings() {
    DirectoryResponse response = new DirectoryResponse("_");
    assertEquals("test/", response.convertToDirURL("test/"));
    assertEquals("test/", response.convertToDirURL("test"));
  }
}
