package spring.mongo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.mongo.demo.dao.UserDao;
import spring.mongo.demo.entity.UserEntity;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "saveUser",method = RequestMethod.GET)
    public void saveUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(11L);
        userEntity.setUserName("Chenjf");
        userEntity.setPassWord("admin");
        userDao.saveUser(userEntity);
    }
}
