package com.test.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

@Component
@Order(1)
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = ((Request) request).getServletPath();
        if (!path.equals("/login") && !path.equals("/signup")) {
            Iterator<Cookie> cookieIterator = Arrays.stream(((Request) request).getCookies()).iterator();
            while (cookieIterator.hasNext()) {
                Cookie cookie = cookieIterator.next();
                String cookieName = "";
                if (cookie.getName().equalsIgnoreCase(cookieName)) {
                    String token = cookie.getValue();
                    try {
                        String securityKey = "";
                        JWT.require(Algorithm.HMAC256(securityKey)).build().verify(token);
                        chain.doFilter(request, response);
                    } catch (Exception e) {
                        cookie.setMaxAge(0);

                        ((Response) response).sendRedirect("/login");
                    }
                    break;
                }
            }
        } else {
            chain.doFilter(request, response);
        }
    }
}
