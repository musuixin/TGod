package top.musuixin.Controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.musuixin.Pojo.GoodsPojo;
import top.musuixin.Pojo.ProjectPojo;
import top.musuixin.Service.GoodsService;

import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-06-17 09:23
 */
@RestController
@RequestMapping("/api")
public class GoodsController {
    @Autowired
    GoodsService goodsService;


    @GetMapping("/goods")
    public HashMap<String, Object> getGoods(int num) {
        return goodsService.getGoodsList(num);
    }

    @PostMapping("/goods")
    public HashMap<String, Object> pootGoods(GoodsPojo goodsPojo) {

        return goodsService.addGoods(goodsPojo);
    }

    @DeleteMapping("/goods")
    public HashMap<String, Object> deleteGoods(GoodsPojo goodsPojo) {

        return goodsService.deleteGoods(goodsPojo);
    }

    @PutMapping("/goods")
    public HashMap<String, Object> putGoods(@RequestBody GoodsPojo goodsPojo) {
        System.out.println(goodsPojo);
//        return null;
        return goodsService.updateGoods(goodsPojo);
    }

    @GetMapping("/goodstImg")
    HashMap<String, Object> getImg(GoodsPojo goodsPojo) {

        return goodsService.getImgFile(goodsPojo);
    }

    @PostMapping("/upImg")
    public HashMap<String, Object> upImg(MultipartFile file, GoodsPojo goodsPojo) {
        goodsPojo.setImgFile(file);
        return goodsService.upImg(goodsPojo);
    }
}
