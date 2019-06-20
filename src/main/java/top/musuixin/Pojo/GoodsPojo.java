package top.musuixin.Pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;

/**
 * @author musuixin
 * @date 2019-06-17 09:14
 */
@Data
public class GoodsPojo {
    Integer id;
    String title;
    Double oldMoney;
    Double money;
    Integer goodNumber;
    String goodIntroduction;
    Integer sellNumber;
    String images;
    MultipartFile imgFile;
}
