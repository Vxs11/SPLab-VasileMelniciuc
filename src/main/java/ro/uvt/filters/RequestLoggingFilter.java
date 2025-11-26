package ro.uvt.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest http = (HttpServletRequest) request;
        System.out.println("Incoming request: " + http.getMethod() + " " + http.getRequestURI());

        chain.doFilter(request, response);

        System.out.println("Outgoing response for: " + http.getMethod() + " " + http.getRequestURI());
    }
}
