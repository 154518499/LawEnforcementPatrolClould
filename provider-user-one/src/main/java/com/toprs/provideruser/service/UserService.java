package com.toprs.provideruser.service;

import com.toprs.provideruser.entity.User;
import com.toprs.provideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: scp
 * @Date: 2018/12/4 11:43
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Long userId) {
        return userRepository.findByUserId(userId);
    }
}
