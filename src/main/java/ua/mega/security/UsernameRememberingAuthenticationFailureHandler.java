package ua.mega.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsernameRememberingAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private UsernamePasswordAuthenticationFilter filter;
    private String redirectTarget;

    public void setRedirectTarget(String redirectTarget) {
        this.redirectTarget = redirectTarget;
    }

    public void setFilter(UsernamePasswordAuthenticationFilter filter) {
        this.filter = filter;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException
    {
        // find out what the username was
        String usernameProperty = filter.getUsernameParameter();
        String username = request.getParameter(usernameProperty);

        // redirect, to the url <context-root>/login?error&username=
        response.sendRedirect(request.getContextPath() + redirectTarget + "?error&username="+username);
    }
}
