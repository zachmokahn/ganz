package dasBoot.Responses;

import dasBoot.Requests.iRequest;

public interface iFactory {
  public iResponse get(iRequest request) throws Exception;
  public iResponse FileNotFound() throws Exception;
  public iResponse MethodNotAllowed() throws Exception;
}
