package week2;

import jdbcTest.ConnectionUtil;
import jdbcTest.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FunctionDao {

    public BigDecimal sum(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs=null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "select sum(salary) from user ";
            rs= statement.executeQuery(sql);
            if(rs.next()){
                BigDecimal sumsalary =rs.getBigDecimal(1);
                return  sumsalary;
            }else{
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement,rs);
        }
        System.out.println("----------");
        return null;
    }

    public BigDecimal sum(int fromId,int toId){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs=null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "select sum(salary) from user where id>="+fromId+" && id<="+toId;
            rs= statement.executeQuery(sql);
            if(rs.next()){
                BigDecimal sumsalary =rs.getBigDecimal(1);
                return  sumsalary;
            }else{
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement,rs);
        }
        System.out.println("----------");
        return null;
    }

    public int countUser(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs=null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "select count(id) from user";
            rs= statement.executeQuery(sql);
            if(rs.next()){

                return  rs.getInt(1);
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement,rs);
        }
        System.out.println("----------");
        return 0;
    }

    public int countUserById(int fromID,int toID){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs=null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "select count(id) from user where id>="+fromID+" && id<="+toID;
            rs= statement.executeQuery(sql);
            if(rs.next()){

                return  rs.getInt(1);
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement,rs);
        }
        System.out.println("----------");
        return 0;
    }

    public int countUserBySalary(double salary){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs=null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "select count(id) from user where salary>="+salary;
            rs= statement.executeQuery(sql);
            if(rs.next()){

                return  rs.getInt(1);
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement,rs);
        }
        System.out.println("----------");
        return 0;
    }

    public double average(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs=null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "select round(AVG(salary),2) from user";
            rs= statement.executeQuery(sql);
            if(rs.next()){

                return  rs.getDouble(1);
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement,rs);
        }
        System.out.println("----------");
        return 0;
    }

    public User maxSalary(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs=null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "select * from user where salary = (select max(salary) from user)";
            rs= statement.executeQuery(sql);
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
                user.setTel(rs.getString(4));
                user.setSalary(rs.getBigDecimal(5));
                return user;
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement,rs);
        }
        System.out.println("----------");
        return null;
    }

    public User minSalary(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs=null;
        try {
            //加载数据驱动
            connection  = ConnectionUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=true&serverTimezone=GMT","root","zzuxq");
            statement = connection.createStatement();
            String sql = "select * from user where salary = (select min(salary) from user)";
            rs= statement.executeQuery(sql);
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
                user.setTel(rs.getString(4));
                user.setSalary(rs.getBigDecimal(5));
                return user;
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(connection,statement,rs);
        }
        System.out.println("----------");
        return null;
    }
}
