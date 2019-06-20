package top.musuixin.Service.Imple;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.jersey.api.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.GoodsMapper;
import top.musuixin.Pojo.GoodsPojo;
import top.musuixin.Service.GoodsService;
import top.musuixin.Util.ImgSy;
import top.musuixin.Util.ImgSyGoods;
import top.musuixin.Util.Upload;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-06-17 09:20
 */
@Service
@PropertySource("classpath:config.properties")
public class GoodsServiceImple implements GoodsService {
    @Value(value = "${ueditor}")    //后台图片保存地址
    private String ueditor;
    @Value(value = "${uploadHost}")
    private String uploadHost;    //项目host路径
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    HashMap<String, Object> hashMap;
    @Autowired
    ImgSyGoods imgSy;

    @Override
    public HashMap<String, Object> getGoodsList(int num) {
        PageHelper.startPage(num, 10);
        List<GoodsPojo> goodsList = goodsMapper.getGoodsList();
        PageInfo pageInfo = new PageInfo(goodsList);
        hashMap.put("status", 200);
        hashMap.put("msg", "获取成功");
        hashMap.put("data", pageInfo);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> addGoods(GoodsPojo goodsPojo) {
        Client client = new Client();
        try {
            String uploadInfo = Upload.upload(client, goodsPojo.getImgFile(), uploadHost, ueditor);
            String[] infoList = uploadInfo.split(";");
            goodsPojo.setImages(infoList[2]);
        } catch (Exception e) {
            System.out.println(e);
        }
        int i = goodsMapper.addGoods(goodsPojo);
        if (i == 1) {
            hashMap.put("data", null);
            hashMap.put("status", "200");
            hashMap.put("msg", "增加成功");
            return hashMap;
        }
        hashMap.put("data", null);
        hashMap.put("status", "400");
        hashMap.put("msg", "增加失败");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> deleteGoods(GoodsPojo goodsPojo) {
        int i = goodsMapper.deleteGoods(goodsPojo);
        if (i == 1) {
            hashMap.put("data", null);
            hashMap.put("msg", "删除成功");
            hashMap.put("status", "200");
        }
        return hashMap;
    }

    @Override
    public HashMap<String, Object> getImgFile(GoodsPojo goodsPojo) {
        String img = goodsMapper.getImg(goodsPojo);
        hashMap.put("data", img);
        hashMap.put("msg", "获取成功");
        hashMap.put("status", 200);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> updateGoods(GoodsPojo goodsPojo) {
        int i = goodsMapper.updateGood(goodsPojo);
        if (i == 1) {
            hashMap.put("data", null);
            hashMap.put("status", "200");
            hashMap.put("msg", "修改成功");
            return hashMap;
        }
        hashMap.put("data", null);
        hashMap.put("status", "400");
        hashMap.put("msg", "修改失败");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> upImg(GoodsPojo goodsPojo) {
        Client client = new Client();
        try {
            String uploadInfo = Upload.upload(client, goodsPojo.getImgFile(), uploadHost, ueditor);
            String[] infoList = uploadInfo.split(";");
            goodsPojo.setImages(infoList[2]);
        } catch (Exception e) {
            System.out.println(e);
        }
//        String fileName = IdUtil.randomUUID() + goodsPojo.getImgFile().getOriginalFilename();
//        File file1 = new File("F:\\java 后端学习\\项目实训\\hidemo1\\target\\classes\\static\\img\\" + fileName);
//        imgSy.imgSy(goodsPojo, file1);
//        new Thread(imgSy).start();
//        goodsPojo.setImages("http://localhost:8080/TGod/img/" + fileName);
        int i = goodsMapper.upImg(goodsPojo);
        if (i == 1) {
            hashMap.put("data", null);
            hashMap.put("status", "200");
            hashMap.put("msg", "修改成功");
            return hashMap;
        }
        hashMap.put("data", null);
        hashMap.put("status", "400");
        hashMap.put("msg", "修改失败");
        return hashMap;
    }
}
