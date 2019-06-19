package com.lyebook.book.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/druid/*",
initParams = {
        @WebInitParam(name="loginUsername",value = "admin"),
        @WebInitParam(name = "loginPassword",value = "admin"),
        @WebInitParam(name = "resetEnable",value = "false")
})
public class DruidServlet extends StatViewServlet {
    private static final long serialVersionUID = 1L;
}
