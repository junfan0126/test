package com.cs533.Service;

import com.cs533.Entity.File;
import com.cs533.Entity.User;
import com.cs533.dao.FileDao;
import com.cs533.dao.UserDao;
import com.cs533.dao.UserDao;

/**
 * UserService
 *
 * @version 1.0
 */
public class UserService {

    private UserDao userDao;
    private static FileDao dao = new FileDao();

    public UserService() {
        userDao = new UserDao();
    }



    /**
     * 根据username查询用户信息
     * @param
     * @return
     */
    public User getUserByusername(String username) {
        return userDao.getUserByusername(username);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }




}

