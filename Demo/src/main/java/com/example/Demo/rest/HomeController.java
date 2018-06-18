package com.example.Demo.rest;

import com.example.Demo.entity.UserPO;
import com.example.Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/user")
    @ResponseBody
    public String home(@RequestParam String user, @RequestParam String pass){
        return user + "---" + pass;
    }

    @RequestMapping("/user/add")
    @ResponseBody
    public long addUser(@RequestParam int age, @RequestParam String name){
        UserPO userPO = new UserPO();
        userPO.setAge(age);
        userPO.setName(name);
        userRepository.save(userPO);

        return userPO.getId();
    }

    @RequestMapping("/user/get")
    @ResponseBody
    public String getUser(@RequestParam long id){
        UserPO user = userRepository.getOne(id);

        return "id= " + user.getId() + ";age= " + user.getAge() + "; name= " + user.getName();
     }

    @RequestMapping("/user/get/name")
    @ResponseBody
    public String getUserByName(@RequestParam String name){
        List<UserPO> users  = userRepository.findUserByName(name);

        if (users.size() > 0){
            UserPO user = users.get(0);
            return "id= " + user.getId() + ";age= " + user.getAge() + "; name= " + user.getName();
        }else{
            return  "Not found";
        }

    }

}

