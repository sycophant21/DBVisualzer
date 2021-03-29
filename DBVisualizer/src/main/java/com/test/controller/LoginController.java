package com.test.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.test.domain.User;
import com.test.handler.QueryHandler;
import com.test.helper.TableHeaders;
import org.eclipse.jetty.server.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    private QueryHandler queryHandler;
    @Autowired
    private TableHeaders tableHeaders;

    @GetMapping()
    public String getLoginPage() {
        return "login";
    }

    @PostMapping()
    public ModelAndView validateUser(ServletRequest request, ServletResponse response, User user) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String existingToken = httpServletRequest.getHeader("Cookie");
        String securityKey = "";
        Algorithm algorithm = Algorithm.HMAC256(securityKey);
        int sessionTimeoutTime = 1;
        String token = JWT.create().withClaim("emailId", user.getEmailId()).withExpiresAt(Date.from(Instant.now().plusSeconds(sessionTimeoutTime))).sign(algorithm);
        String cookieName = "";
        if (existingToken != null) {
            Iterator<Cookie> cookieIterator = Arrays.stream(((Request) request).getCookies()).iterator();
            while (cookieIterator.hasNext()) {
                Cookie cookie = cookieIterator.next();
                if (cookie.getName().equalsIgnoreCase(cookieName)) {
                    cookie.setMaxAge(0);
                }
            }
        }
        httpServletResponse.addCookie(new Cookie(cookieName, token));
        tableHeaders.setAccessibleTables(queryHandler.getTableNames(user.getEmailId()));
        if (queryHandler.verifyUser(user.getEmailId(), user.getPass())) {
            tableHeaders.setUserId(user.getEmailId());
            return new ModelAndView("redirect:/home");
        } else {
            return new ModelAndView("redirect:/login");
        }

    }
}