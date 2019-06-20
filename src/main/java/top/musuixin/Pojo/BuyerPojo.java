package top.musuixin.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-06-18 16:41
 */
@Data
@Component
public class BuyerPojo {
    private Integer id;
    private String bPhoneNumber;
    private String bPassWord;
}
