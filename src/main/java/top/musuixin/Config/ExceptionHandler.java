package top.musuixin.Config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author musuixin
 * @date 2019-06-13 15:03
 */
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public void Handler(Exception e, HttpServletResponse response) throws Exception{
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        JSONObject jsonObject=new JSONObject();
        if(e instanceof org.springframework.dao.DuplicateKeyException){
            jsonObject.put("status","400");
            jsonObject.put("msg","手机号重复");
            writer.write(jsonObject.toString());
            writer.flush();
            writer.close();
            return;
        }

        jsonObject.put("status","400");
        jsonObject.put("msg","发生系统错误");
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();
    }
}
