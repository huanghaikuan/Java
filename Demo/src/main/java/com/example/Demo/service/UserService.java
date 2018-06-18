package com.example.Demo.service;

import com.example.Demo.entity.UserPO;
import com.example.Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void transfer(long inId, long outId, double money){
        UserPO inUser = userRepository.findOne(inId);
        UserPO outUser = userRepository.findOne(outId);

        inUser.setMoney(inUser.getMoney() - money);
        outUser.setMoney(outUser.getMoney() - money);

        userRepository.save(inUser);
        userRepository.save(outUser);

        // ConcurrentHashMap
        // 高并发下使用 - 原理是分段锁

        // juc package
        // 常用：
        // HashMap - 不是线程安全的
        // HashTable - 线程安全的
    }

    // cas 无锁, java程序处理 concurrent hash map
    // 解决高并发： cas + volatitl
}
