package com.yayangchun.traditionalchinesemedicinemuseum.controller.other;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 作者：崖洋春
 * 时间：2023/1/15 15:48
 **/
@Controller
@RequestMapping("/res")
public class UpdateController extends  BaseController{

    @PostMapping("/upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam MultipartFile file){
        Map<String,Object> map = new HashMap<>();
        if(!file.isEmpty()){
            String uploadPath = "C:\\Users\\ASUS\\Desktop\\Traditional-Chinese-Medicine-Museum\\Traditional-Chinese-Medicine-Museum\\src\\main\\resources\\static\\articleImg";
            // 如果目录不存在则创建
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                String realPath = uploadDir.getCanonicalPath(); // 获取真实路径
                String OriginalFilename = file.getOriginalFilename();//获取原文件名
                String suffixName = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));//获取文件后缀名
                //重新随机生成名字
                String filename = UUID.randomUUID().toString() +suffixName;
                File localFile = new File(uploadPath+"\\"+filename);
                file.transferTo(localFile); //把上传的文件保存至本地
                /**
                 * 这里应该把filename保存到数据库,供前端访问时使用
                 */

                map.put("msg","/goodsImages/"+filename);
                return map;//上传成功，返回保存的文件地址
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("上传失败");
                map.put("msg","上传失败");
                return map;
            }
        }else{
            System.out.println("文件为空");
            map.put("msg","文件为空");
            return map;
        }
    }


    /**
     * 上传新闻
     * @param file
     * @return
     */
    @PostMapping("/uploadByInformation")
    @ResponseBody
    public Map<String,Object> uploadByInfor(@RequestParam MultipartFile file){
        Map<String,Object> map = new HashMap<>();
        if(!file.isEmpty()){
            String uploadPath = "C:\\Users\\ASUS\\Desktop\\Traditional-Chinese-Medicine-Museum\\Traditional-Chinese-Medicine-Museum\\src\\main\\resources\\static\\articleImg";
            // 如果目录不存在则创建
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                String realPath = uploadDir.getCanonicalPath(); // 获取真实路径
                String OriginalFilename = file.getOriginalFilename();//获取原文件名
                String suffixName = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));//获取文件后缀名
                //重新随机生成名字
                String filename = UUID.randomUUID().toString() +suffixName;
                File localFile = new File(uploadPath+"\\"+filename);
                file.transferTo(localFile); //把上传的文件保存至本地
                /**
                 * 这里应该把filename保存到数据库,供前端访问时使用
                 */

                map.put("msg","/articleImg/"+filename);
                return map;//上传成功，返回保存的文件地址
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("上传失败");
                map.put("msg","上传失败");
                return map;
            }
        }else{
            System.out.println("文件为空");
            map.put("msg","文件为空");
            return map;
        }
    }



    @PostMapping("/uploadByDrugs")
    @ResponseBody
    public Map<String,Object> uploadByDrugs(@RequestParam MultipartFile file){
        Map<String,Object> map = new HashMap<>();
        if(!file.isEmpty()){
            String uploadPath = "C:\\Users\\ASUS\\Desktop\\Traditional-Chinese-Medicine-Museum\\Traditional-Chinese-Medicine-Museum\\src\\main\\resources\\static\\drugsImg";
            // 如果目录不存在则创建
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                String realPath = uploadDir.getCanonicalPath(); // 获取真实路径
                String OriginalFilename = file.getOriginalFilename();//获取原文件名
                String suffixName = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));//获取文件后缀名
                //重新随机生成名字
                String filename = UUID.randomUUID().toString() +suffixName;
                File localFile = new File(uploadPath+"\\"+filename);
                file.transferTo(localFile); //把上传的文件保存至本地
                /**
                 * 这里应该把filename保存到数据库,供前端访问时使用
                 */

                map.put("msg","/drugsImg/"+filename);
                return map;//上传成功，返回保存的文件地址
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("上传失败");
                map.put("msg","上传失败");
                return map;
            }
        }else{
            System.out.println("文件为空");
            map.put("msg","文件为空");
            return map;
        }
    }
}
