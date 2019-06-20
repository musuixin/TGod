package top.musuixin.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author musuixin
 * @date 2019-06-13 18:36
 */
@Data
@Component
public class ProjectPojo {
    private Long project_id;
    private String project_name;
    private String project_type;
    private String project_desc;
    private String project_status;
    private MultipartFile img;
    private String project_img;
}
