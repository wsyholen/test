package com.holen.service;

import com.holen.model.User;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2018/12/4 11:18
 * 联系方式: 317776764
 * </pre>
 */
public interface IUserService {

    public User selectUser(long userId);

}
