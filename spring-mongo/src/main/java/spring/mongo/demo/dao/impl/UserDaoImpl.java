package spring.mongo.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import spring.mongo.demo.dao.UserDao;
import spring.mongo.demo.entity.UserEntity;

@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void saveUser(UserEntity userEntity) {
        mongoTemplate.save(userEntity);
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        UserEntity user = mongoTemplate.findOne(query,UserEntity.class);
        return user;
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        Query query = new Query(Criteria.where("id").is(userEntity.getId()));
        Update update = new Update().set("userName",userEntity.getUserName()).set("passWord",userEntity.getPassWord());
        mongoTemplate.updateFirst(query,update,UserEntity.class);
    }

    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }
}
