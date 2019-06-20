package top.musuixin.Service;

import org.springframework.stereotype.Service;
import top.musuixin.Pojo.GoodsPojo;

import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-06-17 09:19
 */
public interface GoodsService {
    HashMap<String, Object> getGoodsList(int num);

    HashMap<String, Object> addGoods(GoodsPojo goodsPojo);

    HashMap<String, Object> deleteGoods(GoodsPojo goodsPojo);

    HashMap<String, Object> getImgFile(GoodsPojo goodsPojo);
    HashMap<String, Object> updateGoods(GoodsPojo goodsPojo);
    HashMap<String,Object> upImg(GoodsPojo goodsPojo);

}
