package test.ganz.controllers;

import java.util.Hashtable;

import ganz.Controllers.FileController;
import ganz.Responses.DirectoryResponse;

import org.junit.Before;
import org.junit.Test;

import dasBoot.Responses.iResponse;

import test.helpers.FileHelper;
import test.mocks._Request;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FileControllerTest {
  _Request request;
  FileController controller;

  @Before public void init() {
    request = new _Request();
    controller = new FileController(System.getProperty("user.dir"));
  }

  @Test public void VALID_returnsTrueIfFileExistsOnDIR() throws Exception {
    FileHelper.createFile("test.txt");
    request.stubURI("/test.txt");
    assertTrue(controller.valid(request));
    FileHelper.destroyFile("test.txt");
  }

  @Test public void VALID_returnsFalseIfFileDoesntExistsOnDIR() {
    request.stubURI("/test.txt");
    assertFalse(controller.valid(request));
  }

  @Test public void HANDLE_returnsMethodNotAllowedIfNotGet() throws Exception {
    request.stubMethod("POST");
    iResponse response = controller.handle(request);
    Hashtable<String, String> status = response.getResponseLine();
    assertEquals("405", status.get("code"));
  }

  @Test public void HANDLE_returnsFileIfNotDirectory() throws Exception {
    FileHelper.createFile("test.txt");
    request.stubMethod("GET");
    request.stubURI("/test.txt");
    iResponse response = controller.handle(request);
    Hashtable<String, String> status = response.getResponseLine();
    assertEquals("200", status.get("code"));
    assertThat(response, not(instanceOf(DirectoryResponse.class)));
    FileHelper.destroyFile("test.txt");
  }

  @Test public void HANDLE_returnsDirectoryIfNotDirectory() throws Exception {
    FileHelper.createDirectory("test");
    request.stubMethod("GET");
    request.stubURI("/test");
    iResponse response = controller.handle(request);
    Hashtable<String, String> status = response.getResponseLine();
    assertEquals("200", status.get("code"));
    assertThat(response, instanceOf(DirectoryResponse.class));
    FileHelper.destroyFile("test/");
  }
}
