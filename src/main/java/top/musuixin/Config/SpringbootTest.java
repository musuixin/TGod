package top.musuixin.Config;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import top.musuixin.Mapper.BuyerMapper;
import top.musuixin.Mapper.GoodsMapper;
import top.musuixin.Pojo.BuyerPojo;
import top.musuixin.Pojo.ProjectPojo;
import top.musuixin.Pojo.UserPojo;
import top.musuixin.Service.GoodsService;
import top.musuixin.Service.Imple.ProjectServiceImple;
import top.musuixin.Service.Imple.UserServiceImple;
import top.musuixin.Service.ProjectService;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * @author musuixin
 * @date 2019-03-30 19:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest {
@Autowired
  BuyerMapper buyerMapper;
  @Autowired
  BuyerPojo buyerPojo;
    @Test
    public void test1() {
//        buyerPojo.setBPassWord("323");
//        buyerPojo.setBPhoneNumber("eew");
//        BuyerPojo buyerPojo = buyerMapper.loginBuyer(this.buyerPojo);
    }
}
