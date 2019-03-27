package com.holen.service.impl;

import com.holen.dao.IUserDao;
import com.holen.model.User;
import com.holen.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2018/12/4 11:19
 * 联系方式: 317776764
 * </pre>
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

        @Resource
        private IUserDao userDao;

        @Override
        public User selectUser(long userId) {
            return this.userDao.selectUser(userId);
        }



}
