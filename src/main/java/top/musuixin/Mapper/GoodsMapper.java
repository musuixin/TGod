package top.musuixin.Mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.musuixin.Pojo.GoodsPojo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-06-17 09:17
 */
@Mapper
@Repository
public interface GoodsMapper {
    @Select("select * from goods")
    List<GoodsPojo> getGoodsList();

    @Insert("insert into goods (title, oldMoney, Money, goodNumber, goodIntroduction, images) values (#{title} ,#{oldMoney} ,#{money} ,#{goodNumber} ,#{goodIntroduction} ,#{images} );")
    int addGoods(GoodsPojo goodsPojo);

    @Delete("delete from  goods where id=#{id} ")
    int deleteGoods(GoodsPojo goodsPojo);

    @Select("select images from goods where id=#{id} ")
    String getImg(GoodsPojo goodsPojo);

    @Update("update goods set title =#{title} ,oldMoney=#{oldMoney} ,money =#{money} ,goodIntroduction=#{goodIntroduction},goodNumber=#{goodNumber}    where id=#{id}  ;")
    int updateGood(GoodsPojo goodsPojo);

    @Update("update goods set images  =#{images}   where id=#{id}  ;")
    int upImg(GoodsPojo goodsPojo);

    /*
以下用于app数据反馈
 */
    @Select("select * from goods order by id desc ")
    List<GoodsPojo> getListApp();

    @Select("select * from goods where id=#{id} ")
    GoodsPojo getGoodinfo(GoodsPojo goodsPojo);
}
