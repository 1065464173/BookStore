package sxt.dao;

import sxt.entity.User;

import java.sql.SQLException;

public interface UserDao {
    //添加用户
    public void addUser(User user) throws SQLException;
    //查找激活状态的用户
    public User findUserBuActiveCode(String activecode) throws SQLException;
    //激活用户
    public void activeUserByActivecode(String activecode) throws SQLException;
    //查找用户-账号密码
    public  User findUserByUserNameAndPassword(String username, String password) throws SQLException;
}
