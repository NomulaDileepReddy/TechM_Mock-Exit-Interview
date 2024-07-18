package com.example.taskmanager.servlet;

import com.example.taskmanager.model.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateTaskServlet")
public class CreateTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dueDate = request.getParameter("dueDate");
        String priority = request.getParameter("priority");

        String proxyUri = System.getenv("VSCODE_PROXY_URI");
        if (proxyUri == null || proxyUri.isEmpty()) {
            proxyUri = "http://localhost:8080";
        }

        if (title != null && !title.isEmpty() && 
            description != null && !description.isEmpty() &&
            dueDate != null && !dueDate.isEmpty() &&
            priority != null && !priority.isEmpty()) {
            
            Task task = new Task(title, description, dueDate, priority);
            request.setAttribute("task", task);
            response.sendRedirect(proxyUri + "/success.jsp");
        } else {
            response.sendRedirect(proxyUri + "/error.jsp");
        }
    }
}
