package top.musuixin.Service.Imple;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.UserMapper;
import top.musuixin.Pojo.UserPojo;
import top.musuixin.Service.UserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-06-12 15:06
 */
@Service
public class UserServiceImple implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    HashMap<String, Object> hashMap;
//    @Autowired
//    BCryptPasswordEncoder bcryptPasswordEncoder;

    @Override
    public HashMap<String, Object> register(UserPojo userPojo) {
        UserPojo username = userMapper.username(userPojo);
        if (username != null) {
            hashMap.put("data", null);
            hashMap.put("status", "400");
            hashMap.put("msg", "用户名重复");
            return hashMap;
        }
        UserPojo account = userMapper.account(userPojo);
        if (account != null) {
            hashMap.put("data", null);
            hashMap.put("status", "400");
            hashMap.put("msg", "账户重复");
            return hashMap;
        }
        userPojo.setCreat_time(DateUtil.date());
        BCryptPasswordEncoder bcryptPasswordEncoder =new BCryptPasswordEncoder();
      userPojo.setPassword( bcryptPasswordEncoder.encode(userPojo.getPassword()));
        userMapper.register(userPojo);
        hashMap.put("data", null);
        hashMap.put("status", "200");
        hashMap.put("msg", "注册成功");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> login(UserPojo userPojo, HttpSession session) {
        UserPojo login = userMapper.Login(userPojo);
        if (login != null) {
            session.setAttribute("userName",userPojo.getUser_name());
            hashMap.put("data", null);
            hashMap.put("status", "200");
            hashMap.put("msg", "登陆成功");
            return hashMap;
        }
        hashMap.put("data", null);
        hashMap.put("status", "400");
        hashMap.put("msg", "用户名或密码错误");
        return hashMap;
    }
}
