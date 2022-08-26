package com.tju.elm.framework;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

// 所有的都交给它处理，拦截所有的请求
// 这个类是前端控制器
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 中文编码处理
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        // 获取客户端请求路径
        String path = request.getServletPath();
        System.out.println(path);

        // 根据请求路径，将controller组件类名与方法名解析出来
        String className = path.substring(1, path.lastIndexOf("/"));
        String methodName = path.substring(path.lastIndexOf("/") + 1);
        System.out.println(methodName);

        PrintWriter out = null;

        try {
            // 通过这个获取controller的信息
            Class<?> clazz = Class.forName("com.tju.elm.controller." + className);
            // 创建对象
            Object controller = clazz.newInstance();
            // 获取controller方法
            Method method = clazz.getMethod(methodName, HttpServletRequest.class);
            // 调用controller中的方法，并接受返回值
            Object result = method.invoke(controller, request);

            out = response.getWriter(); // 获取相应的输出流
            ObjectMapper om = new ObjectMapper();
            out.print(om.writeValueAsString(result));

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DispatcherServlet信息：Servlet请求url路径：" + path);
            System.out.println("DispatcherServlet信息：类名：" + className + "\t方法名：" + methodName);
        } finally {
            if(out != null) {
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
