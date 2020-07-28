package com.vans;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;



/**
 * 1.获取网页源码
 *
 */
public class Spider {


    //	有网址就可以下载图片到桌面
    public static void main(String[] args) {
        String url = "https://image.baidu.com/search/index?tn=baiduimage&word=美女";
        String regex = "thumbURL\":\"(.+?)\",";
        String result = GetSource.getSource(url);
        List<String> imgs = PatternAndMatcher.getImoocPage(result, regex);
        String directory = "C:\\Users\\vans\\Desktop\\图片";
        for (int i = 0; i < imgs.size(); i++) {
            try {
                URL img = new URL(imgs.get(i));
                BufferedImage image = ImageIO.read(img);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", stream);
                byte[] bytes = stream.toByteArray();
                stream.close();
                Files.write(Paths.get(directory, i + ".jpg"), bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}





