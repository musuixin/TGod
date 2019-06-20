package top.musuixin.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-06-14 14:48
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class FIleController {
    @PostMapping("/file")
    public HashMap<String,Object> file(MultipartFile file){
        System.out.println(file.getOriginalFilename());
//        File file1=new File("F:\\upfile\\"+file.getName());
//        try {
//            file.transferTo(file1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(file);
        return null;
    }
}
