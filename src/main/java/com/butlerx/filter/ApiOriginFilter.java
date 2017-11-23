/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2017. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.butlerx.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ApiOriginFilter implements javax.servlet.Filter {

    private final static Logger LOGGER = Logger.getLogger(ApiOriginFilter.class);

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException,
        ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        res.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        res.addHeader("Pragma", "no-cache");
        res.addHeader("Expires", "0");
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        if (requestURI.indexOf("/api/") > -1 && ((HttpServletRequest) request).getMethod().equalsIgnoreCase("POST")) {
            String remoteIp = request.getRemoteAddr();
            StringBuilder paramListStr = new StringBuilder();
            Enumeration<String> paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                paramListStr.append(paramName + " : " + request.getParameter(paramName) + "\n");
            }
            ApiOriginFilter.LOGGER.info("Calling from [" + remoteIp + "]" + requestURI + "\n" + paramListStr.toString());
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {}
}