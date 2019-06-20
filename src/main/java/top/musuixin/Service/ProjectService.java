package top.musuixin.Service;

import top.musuixin.Pojo.ProjectPojo;

import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-06-13 23:17
 */


public interface ProjectService {
    HashMap<String, Object> getProjectList(int num);

    HashMap<String, Object> deleteProject(Long id);

    HashMap<String, Object> updateProject(ProjectPojo projectPojo);

    HashMap<String, Object> insertProject(ProjectPojo projectPojo);

    HashMap<String,Object> getProject_img(ProjectPojo projectPojo);
}
