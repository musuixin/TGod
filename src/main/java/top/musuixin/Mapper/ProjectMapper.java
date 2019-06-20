package top.musuixin.Mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import top.musuixin.Pojo.ProjectPojo;

import java.util.List;

/**
 * @author musuixin
 * @date 2019-06-13 23:13
 */
@Mapper
@Repository
public interface ProjectMapper {
    @Select("select * from project")
    List<ProjectPojo> getProjectList();

    @Delete("delete from  project where project_id=#{id} ")
    int deleteProject(Long id);

    @Update("update project set project_name  = #{project_name} , project_desc=#{project_desc} , project_status=#{project_status} , project_type=#{project_type} where project_id=#{project_id}  ;")
    int updateProject(ProjectPojo projectPojo);

    @Insert("insert into project (project_name, project_type, project_desc, project_status,project_img) values (#{project_name} ,#{project_type} ,#{project_desc} ,#{project_status} ,#{project_img} );")
    int insertProject(ProjectPojo projectPojo);

    @Select("SELECT project_img from project where project_id=#{project_id} ")
    String getImg(ProjectPojo projectPojo);
}
