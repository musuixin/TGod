package top.musuixin.Service.Imple;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.ProjectMapper;
import top.musuixin.Pojo.ProjectPojo;
import top.musuixin.Service.ProjectService;
import top.musuixin.Util.ImgSy;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author musuixin
 * @date 2019-06-13 23:21
 */
@Service
public class ProjectServiceImple implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    HashMap<String, Object> hashMap;
    @Autowired
    ImgSy imgSy;

    @Override
    public HashMap<String, Object> getProjectList(int num) {
        PageHelper.startPage(num, 10);
        List<ProjectPojo> projectList = projectMapper.getProjectList();
        PageInfo pageInfo = new PageInfo(projectList);
        Long pages = pageInfo.getTotal();
        hashMap.put("status", "200");
        hashMap.put("msg", "数据获取成功");
        hashMap.put("data", pageInfo);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> deleteProject(Long id) {
        int i = projectMapper.deleteProject(id);
        hashMap.put("data", null);
        hashMap.put("msg", "删除成功");
        hashMap.put("status", "200");
        return hashMap;
    }

    @Override
    public HashMap<String, Object> updateProject(ProjectPojo projectPojo) {
        int i = projectMapper.updateProject(projectPojo);
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
    public HashMap<String, Object> insertProject(ProjectPojo projectPojo) {
        String fileName = IdUtil.randomUUID() + projectPojo.getImg().getOriginalFilename();
        File file1 = new File("F:\\java 后端学习\\项目实训\\hidemo1\\target\\classes\\static\\img\\" + fileName);
        imgSy.imgSy(projectPojo, file1);
        new Thread(imgSy).start();
        projectPojo.setProject_img("img\\" + fileName);
        int i = projectMapper.insertProject(projectPojo);
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
    public HashMap<String, Object> getProject_img(ProjectPojo projectPojo) {
        String img = projectMapper.getImg(projectPojo);
        hashMap.put("data", img);
        hashMap.put("msg", "获取成功");
        hashMap.put("status", 200);
        return hashMap;
    }
}
