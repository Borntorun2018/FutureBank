package com.smartbank.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartbank.model.Response;
import com.smartbank.model.Error;
/**
 * Utility class for Spring Security.
 */
public final class SecurityUtils {

  private SecurityUtils() {}

  private static final ObjectMapper mapper = new ObjectMapper();
  
  public static void sendError(HttpServletResponse response, Exception exception, int status, String message) throws IOException {
      response.setContentType("application/json;charset=UTF-8");
      response.setStatus(status);
      PrintWriter writer = response.getWriter();
      Error error = new Error("authError", exception.getMessage());
      writer.write(mapper.writeValueAsString(new Response(String.valueOf(status), message, error)));
      writer.flush();
      writer.close();
  }
}
