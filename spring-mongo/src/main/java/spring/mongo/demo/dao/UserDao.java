package spring.mongo.demo.dao;

import spring.mongo.demo.entity.UserEntity;

public interface UserDao {

    public void saveUser(UserEntity userEntity);

    public UserEntity findUserByUserName(String userName);

    public void updateUser(UserEntity userEntity);

    public void deleteUserById(Long id);
}
