package com.elm.framework;

import com.elm.controller.FoodController;
import com.elm.controller.UserController;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Requirement:
 * All requests from the client need to be handed over to the Servlet for processing.
 */

//block all requests, give to Servlet
@WebServlet("/")
public class DispatcherServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //process Chinese coding
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        //Get request path from the client
        String path = request.getServletPath();

        //Parse the component className and methodName according to the request path
        String className = path.substring(1, path.lastIndexOf("/"));
        String methodName = path.substring(path.lastIndexOf("/")+1);

        PrintWriter out = null;


        try {
            //Get info of controller class from Class.forname
            Class describe_class = Class.forName("com.elm.controller." + className);
            //Create controller object
            Object controller = describe_class.newInstance();
            //Get method of controller class
            Method method = describe_class.getMethod(methodName, new Class[]{HttpServletRequest.class});
            //call the method in controller
            Object result = method.invoke(controller,new Object[]{request});

            //translate Java obj to Json obj
            out = response.getWriter();
            ObjectMapper om = new ObjectMapper();
            out.print(om.writeValueAsString(result));

        } catch(Exception e){
            e.printStackTrace();
            System.out.println("DispatcherServlet信息：请求url："+path);
            System.out.println("DispatcherServlet信息：类名："+className+"\t方法名："+methodName);
        }
        finally {
            out.close();
        }


    }


}
