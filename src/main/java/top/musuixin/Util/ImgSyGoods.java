package top.musuixin.Util;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.musuixin.Pojo.GoodsPojo;
import top.musuixin.Pojo.ProjectPojo;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author musuixin
 * @date 2019-06-16 14:39
 */
@Component
public class ImgSyGoods implements Runnable {
    private GoodsPojo goodsPojo;
    private File file;

    public void imgSy(GoodsPojo goodsPojo, File file) {
        this.goodsPojo = goodsPojo;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            goodsPojo.getImgFile().transferTo(file);
            ImgUtil.pressText(//
                    FileUtil.file(file), //
                    FileUtil.file(file), //
                    "天狗商城", Color.WHITE, //文字
                    new Font("黑体", Font.BOLD, 70), //字体
                    +0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
                    +0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
                    //透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
                    0.5f
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
