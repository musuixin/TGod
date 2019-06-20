package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Pojo.UserPojo;
import top.musuixin.Service.Imple.UserServiceImple;
import top.musuixin.Service.UserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-06-13 11:26
 */
@RestController
@RequestMapping("/api")
public class LoginRegister {
    @Autowired
    UserService userServiceImple;


    @PostMapping("/register")
    public HashMap<String, Object> register(@RequestBody UserPojo userPojo) {
        return userServiceImple.register(userPojo);
    }

    @PostMapping("/login")
    public HashMap<String, Object> login(@RequestBody UserPojo userPojo, HttpSession session) {

        return userServiceImple.login(userPojo,session);
    }
}
