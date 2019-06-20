package top.musuixin.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Mapper.BuyerMapper;
import top.musuixin.Mapper.GoodsMapper;
import top.musuixin.Pojo.BuyerPojo;
import top.musuixin.Pojo.GoodsPojo;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-06-17 14:58
 */
@RestController
@CrossOrigin
@RequestMapping("/app")
public class AppController {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    HashMap<String, Object> hashMap;
    @Autowired
    BuyerMapper buyerMapper;

    @GetMapping("/getGoodsList")
    public HashMap<String, Object> getGoodsList(Integer num) {
        PageHelper.startPage(num, 10);
        List<GoodsPojo> goodlist = goodsMapper.getListApp();
        Collections.sort(goodlist, (GoodsPojo good1, GoodsPojo good2) -> (good2.getId() - good1.getId()));
        PageInfo pageInfo = new PageInfo(goodlist);
        hashMap.put("data", pageInfo);
        hashMap.put("msg", "获取成功");
        hashMap.put("status", 200);
        return hashMap;
    }

    @GetMapping("/getProductInformation")
    public HashMap<String, Object> getProductInformation(GoodsPojo goodsPojo) {
        GoodsPojo goodinfo = goodsMapper.getGoodinfo(goodsPojo);
        hashMap.put("msg", "获取商品详细信息成功");
        hashMap.put("status", 200);
        hashMap.put("data", goodinfo);
        return hashMap;
    }

    @PostMapping("/registerBuyer")
    public HashMap<String, Object> registerBuyer(BuyerPojo buyerPojo) {
        System.out.println(buyerPojo);
        int i = buyerMapper.registerBuyer(buyerPojo);
        hashMap.put("msg", "注册成功");
        hashMap.put("status", 200);
        hashMap.put("data", null);
        return hashMap;
    }

    @PostMapping("/loginBuyer")
    public HashMap<String, Object> loginBuyer(BuyerPojo buyerPojo) {
        System.out.println(buyerPojo);
        BuyerPojo buyerPojo1 = buyerMapper.loginBuyer(buyerPojo);
        if (buyerPojo1 != null) {
            hashMap.put("msg", "登陆成功");
            hashMap.put("status", 200);
            hashMap.put("data", null);
            return hashMap;
        }
        hashMap.put("msg", "登陆失败");
        hashMap.put("status", 400);
        hashMap.put("data", null);
        return hashMap;
    }


}
