package jdbcTest;

import java.util.List;

public class JDBCClient {
    public static void main(String[] args) {
        User user = new User();
        user.setId(7);
        user.setAge(20);
        user.setName("吴旭旭");
        user.setTel("18235484457");
        UserDao jdbcTest = new UserDao();
//        if(jdbcTest.addInfo(user)==1){
//            System.out.println("添加成功！！！");
//        }else{
//            System.out.println("添加失败！！！");
//        }
//        if(jdbcTest.updateInfo(user)==1){
//            System.out.println("更新成功！！");
//        }else {
//            System.out.println("更新失败！！");
//        }
//        if(jdbcTest.deletebyID(5)==1){
//            System.out.println("删除成功！！");
//        }else {
//            System.out.println("删除失败！！");
//        }
        List<User> userList = jdbcTest.findAllUsers();
        System.out.println(userList.toString());
        User user1 = jdbcTest.getUserById(1);
        if(user1!=null){
            System.out.println(user1);
        }
    }
}
