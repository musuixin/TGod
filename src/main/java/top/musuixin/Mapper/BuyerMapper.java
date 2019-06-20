package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.Pojo.BuyerPojo;

/**
 * @author musuixin
 * @date 2019-06-18 16:42
 */

@Repository
@Mapper
public interface BuyerMapper {
    @Insert("insert into buyer (bPhoneNumber, bPassWord) values (#{bPhoneNumber} ,#{bPassWord} );")
    int registerBuyer(BuyerPojo buyerPojo);
    @Select("select * from buyer where bPhoneNumber=#{bPhoneNumber}  and bPassWord=#{bPassWord} ")
    BuyerPojo loginBuyer(BuyerPojo buyerPojo);
}
