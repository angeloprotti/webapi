package com.protti.webapi.ws.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String header = req.getHeader("Authorization");

        if(header==null || !header.startsWith("Bearer ")){
            throw new ServletException("Invalid Token");
        }

        //Removing "BEARER " to use only the Token
        String token = header.substring(7);

        try {
            Jwts.parser().setSigningKey("states").parseClaimsJws(token).getBody();
        } catch (SignatureException se) {
            throw new ServletException("Invalid Token");
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
