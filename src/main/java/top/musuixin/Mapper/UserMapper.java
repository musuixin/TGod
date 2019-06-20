package top.musuixin.Mapper;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Repository;
//import top.musuixin.Pojo.User;
import top.musuixin.Pojo.UserPojo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-06-12 15:01
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user")
    LinkedList<UserPojo> getList();

    @Insert("insert into  user (user_name, account, password, user_phone, creat_time, update_time) values (#{user_name} ,#{account} ,#{password} ,#{user_phone} ,#{creat_time} ,#{update_time} );")
    int register(UserPojo userPojo);

    @Select("select * from  user where user_name=#{user_name} and password=#{password}")
    UserPojo Login(UserPojo userPojo);

    @Select("select * from  user where user_name=#{user_name}")
    UserPojo username(UserPojo userPojo);

    @Select("select * from  user where account=#{account}")
    UserPojo account(UserPojo userPojo);

    @Select("select * from  user WHERE user_name=#{username} ")
    UserPojo loadUserByUsername(String username);

}
