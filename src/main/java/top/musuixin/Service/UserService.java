package top.musuixin.Service;

import top.musuixin.Pojo.UserPojo;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-06-12 15:05
 */
public interface UserService {

    HashMap<String, Object> register(UserPojo userPojo);

    HashMap<String, Object> login(UserPojo userPojo, HttpSession session);
}
