package top.musuixin.Controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Pojo.ProjectPojo;
import top.musuixin.Service.Imple.ProjectServiceImple;
import top.musuixin.Service.ProjectService;
import top.musuixin.Util.ImgSy;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-06-13 23:36
 */
@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    ProjectService projectServiceImple;
    @Autowired
    ImgSy imgSy;

    @GetMapping("/project")
    HashMap<String, Object> getProject(int num) {
        return projectServiceImple.getProjectList(num);


    }

    @DeleteMapping("/project")
    HashMap<String, Object> deleteProject(Long id) {
        return projectServiceImple.deleteProject(id);
    }

    @PutMapping("/project")
    HashMap<String, Object> putProject(@RequestBody ProjectPojo projectPojo) {

        return projectServiceImple.updateProject(projectPojo);

    }

    @PostMapping("/project")
    HashMap<String, Object> postProject(ProjectPojo projectPojo) {

        return projectServiceImple.insertProject(projectPojo);
    }

    @GetMapping("/getProjectImg")
    HashMap<String, Object> getImg(ProjectPojo projectPojo) {

        return projectServiceImple.getProject_img(projectPojo);
    }
}
