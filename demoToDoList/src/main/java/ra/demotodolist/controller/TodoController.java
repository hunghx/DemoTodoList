package ra.demotodolist.controller;

import ra.demotodolist.model.Task;
import ra.demotodolist.service.TaskService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@WebServlet(name = "TodoController", value = "/TodoController")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class TodoController extends HttpServlet {
    protected TaskService taskService;

    @Override
    public void init() throws ServletException {
        taskService = new TaskService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action ==null){

        }else {
            switch (action){
                case "GETALL":
                    List<Task> tasks = taskService.findAll();
                    request.setAttribute("tasks",tasks);
                    request.getRequestDispatcher("/view/todoList.jsp").forward(request,response);
                    break;
                case "ADD":
                    request.getRequestDispatcher("/view/add.jsp").forward(request,response);
                    break;

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action ==null){

        }else {
            switch (action){
                case "ADD" :
                    String title = request.getParameter("title");
                    String content = request.getParameter("content");
                    Part part = request.getPart("image");// lấy ra file upload theo tên
                    // đường dẫn đến vị trí cần upload ảnh
                    String uploadPath = "C:\\Users\\hung1\\OneDrive\\Desktop\\demoToDoList\\src\\main\\webapp\\upload";
                    // lấy ra tên file lưu vào database
                    String imageUrl = part.getSubmittedFileName();
                    // upload và đặt tên file
                    part.write(uploadPath+ File.separator+part.getSubmittedFileName());
                    Task task = new Task(imageUrl,title,content);
                    taskService.save(task);
                    response.sendRedirect("/");
                    break;


            }
        }
    }
}