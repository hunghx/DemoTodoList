package ra.demotodolist.service;

import ra.demotodolist.model.Task;
import ra.demotodolist.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskService implements IGenericService<Task,Integer>{
    private final  String  GETALL = "SELECT * from Task";
    private final  String  INSERT = "INSERT INTO Task(image_url,title,content) value (?,?,?)";
    private final  String  UPDATE = "UPDATE Task set image_url=?,title=?,content=?,status=? where id =?";
    private final  String  FINDBYID = "SELECT * from Task where id = ?";
    private final  String  DELETE = "DELETE * from Task where id = ?";
    @Override
    public List<Task> findAll() {
        // Khởi tạo két nối với csdl
        Connection conn= ConnectDB.getConnection();
        List<Task> tasks = new ArrayList<>();
        try {
            CallableStatement callSt = conn.prepareCall(GETALL);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()){
                Task t =new Task();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setContent(rs.getString("content"));
                t.setImageUrl(rs.getString("image_url"));
                t.setStatus(rs.getBoolean("status"));
                tasks.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return tasks;
    }

    @Override
    public void save(Task task) {
        Connection conn= ConnectDB.getConnection();
        CallableStatement callSt =null;
        try {
            if(task.getId()==0){
                // thêm mới
                callSt = conn.prepareCall(INSERT);
                callSt.setString(1,task.getImageUrl());
                callSt.setString(2,task.getTitle());
                callSt.setString(3,task.getContent());
                callSt.executeUpdate();
            }else {
                // cập nhật
                callSt = conn.prepareCall(UPDATE);
                callSt.setString(1,task.getImageUrl());
                callSt.setString(2,task.getTitle());
                callSt.setString(3,task.getContent());
                callSt.setBoolean(4,task.isStatus());
                callSt.setInt(5,task.getId());
                callSt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection conn= ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall(DELETE);
            callSt.setInt(1,id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public Task findById(Integer integer) {
        Connection conn= ConnectDB.getConnection();
        Task t = null;
        try {
            CallableStatement callSt = conn.prepareCall(FINDBYID);
            callSt.setInt(1,integer);
            ResultSet rs = callSt.executeQuery();

            while (rs.next()){
                t = new Task();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setContent(rs.getString("content"));
                t.setImageUrl(rs.getString("image_url"));
                t.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return t;
    }
}
