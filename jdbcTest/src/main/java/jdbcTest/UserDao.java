package jdbcTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * sql编辑层
 */
public class UserDao {
    public int addInfo(User user){
        Connection connection = null;
        Statement statement = null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "insert into user (name, age, tel) values ('"+user.getName()+"',"+user.getAge()+",'"+user.getTel()+"');";
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement);
        }
        System.out.println("----------");
        return 0;
    }

    public int updateInfo(User user){
        Connection connection = null;
        Statement statement = null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "update  user set name = '"+user.getName()+"', age ="+user.getAge()+", tel ='"+user.getTel()+"' where id="+user.getId()+" ;";
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement);
        }
        System.out.println("----------");
        return 0;
    }

    public int deletebyID(int id){
        Connection connection = null;
        Statement statement = null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "delete from user where id="+id+" ;";
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement);
        }
        System.out.println("----------");
        return 0;
    }

    public List<User> findAllUsers(){
        List<User> userList = null;
        Connection connection = null;
        Statement statement = null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "select * from user;";
            ResultSet rs= statement.executeQuery(sql);
            userList = new ArrayList<User>();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
                user.setTel(rs.getString(4));
                userList.add(user);
            }
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement);
        }
        System.out.println("----------");
        return null;
    }

    public User getUserById(int id){
        Connection connection = null;
        Statement statement = null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "select * from user where id = "+id+";";
            ResultSet rs= statement.executeQuery(sql);
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
                user.setTel(rs.getString(4));
                return user;
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement);
        }
        System.out.println("----------");
        return null;
    }
}
