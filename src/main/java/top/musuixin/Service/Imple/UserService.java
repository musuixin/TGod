package top.musuixin.Service.Imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.UserMapper;
import top.musuixin.Pojo.UserPojo;

/**
 * @author musuixin
 * @date 2019-06-13 10:00
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserPojo user = userMapper.loadUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在");
        }
        user.setRoles("ROLE_admin");
        return user;
    }
}