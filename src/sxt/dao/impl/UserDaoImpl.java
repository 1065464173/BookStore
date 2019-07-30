package sxt.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import sxt.Util.ConnectionPool;
import sxt.Util.MD5;
import sxt.dao.UserDao;
import sxt.entity.User;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) throws SQLException {
        QueryRunner QueryRunner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        //默认用户为"user" 激活状态为state=0
        String sql = "insert into users values(null,?,?,?,?,'user','0',?,null)";
        Object[] objs = {user.getName(), MD5.md5(user.getPassword()),
                user.getNickname(), user.getEmail(), user.getActivecode()};
        QueryRunner.update(sql, new ArrayListHandler(), objs);

    }

    @Override
    public User findUserBuActiveCode(String activecode) throws SQLException {
        QueryRunner QueryRunner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "select * from user where activecode = ?";
        return QueryRunner.query(sql, new BeanHandler<User>(User.class), activecode);
    }

    @Override
    public void activeUserByActivecode(String activecode) throws SQLException {
        QueryRunner QueryRunner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql = "update users set state=1 where activecode=?";
        QueryRunner.update(sql, activecode);
    }

    @Override
    public User findUserByUserNameAndPassword(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(ConnectionPool.getDataSourceByC3P0ByXML());
        String sql="select * from users where username=? and password=?";
        String pass = MD5.md5(password);
        Object[] objs={username,pass};
        return   runner.query(sql, new BeanHandler<User>(User.class), objs);
    }
}
