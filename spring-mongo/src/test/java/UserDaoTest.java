import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.mongo.demo.dao.UserDao;
import spring.mongo.demo.entity.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserDaoTest.class})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(11L);
        userEntity.setUserName("Chenjf");
        userEntity.setPassWord("admin");
        userDao.saveUser(userEntity);
    }


}
