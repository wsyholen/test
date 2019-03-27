package com.holen.controller;

import javax.servlet.http.HttpServletRequest;

import com.holen.model.UploadStatus;
import com.holen.model.User;
import com.holen.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mchange.v2.util.PropertiesUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2018/12/4 11:14
 * 联系方式: 317776764
 * </pre>
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }


    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {

        //用来检测程序运行时间
        long startTime = System.currentTimeMillis();
        System.out.println("fileName：" + file.getOriginalFilename());

        try {
            //获取输出流
            OutputStream os = new FileOutputStream("E:/" + new Date().getTime() + file.getOriginalFilename());
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is = file.getInputStream();
            byte[] bts = new byte[1024];
            //一个一个字节的读取并写入
            while (is.read(bts) != -1) {
                os.write(bts);
            }
            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法一的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "/success";
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("fileUpload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("fileName：" + file.getOriginalFilename());
        String path = "E:/" + new Date().getTime() + file.getOriginalFilename();

        File newFile = new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long endTime = System.currentTimeMillis();
        System.out.println("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "/success";
    }

    /*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping("springUpload")
    public String springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver;
        multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {

                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String path = "E:/springUpload" + file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "/success";
    }

    @RequestMapping("/fileUpload3.do")
    public String fileUpload3(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpSession session, User user) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println(files.length);
        System.out.println(user.getUsername() + "====" + user.getPassword());
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                //最慢
                //FileUtils.writeByteArrayToFile(new File("E:\\"+file.getOriginalFilename()), file.getBytes());
                //最快
                //file.transferTo(new File("E:\\" + file.getOriginalFilename()));
                //其次
                OutputStream os=new FileOutputStream("E:/"+file.getOriginalFilename());
                 //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
                 InputStream is=file.getInputStream();
                 byte[] bts = new byte[2048];
                 //一个一个字节的读取并写入
                 while(is.read(bts)!=-1) {
                     os.write(bts);
                 }
                os.flush();
                os.close();
                is.close();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法四的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "upload";
    }

    /**
     * 获取上传文件状态信息的访问接口
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("getStatus.do")
    public UploadStatus getStatus(HttpSession session) {
        return (UploadStatus) session.getAttribute("upload_status");
    }


}