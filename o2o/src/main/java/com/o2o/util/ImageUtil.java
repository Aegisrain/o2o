package com.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Auther: yzy
 * @Date: 2018/10/11 13:14
 * @Description:图片处理类
 */
public class ImageUtil {

    //获取classpath的绝对路径
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    //时间格式
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    //随机数
    private static final Random r = new Random();

    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
        //得到随机文件名
        String realFileName = getRandomFileName();
        //得到扩展名
        String extension = getFileExtension(thumbnail);
        //创建目标目录
        makeDirPath(targetAddr);
        //得到相对路径
        String relativeAddr = targetAddr + realFileName + extension;
        //最终文件路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(400, 400)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.3f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        //获取绝对路径
        String realFileName = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileName);
        //如果目标路径不存在则创建
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     *
     * @param cFile
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile cFile) {
        //获取原始文件的文件名
        String originalFileName = cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     *
     * @return
     */
    private static String getRandomFileName() {
        //获取随机的五位数,即10000~99999
        int randomNum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + randomNum;
    }
}