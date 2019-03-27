package com.holen.controller;

import com.mchange.v2.util.PropertiesUtils;

import java.io.*;
import java.net.URLEncoder;

/**
 * <pre>
 * 说    明: io流测试
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/1/14 09:27
 * 联系方式: 317776764
 * </pre>
 */
public class IoTest {

    public static void main(String[] args) {
        IoTest ioTest = new IoTest();
        //电脑d盘中的abc.txt 文档
        String filePath = "D:/test.txt";
        String content = "hello";
        ioTest.writeFile(filePath, content);
//        String reslut = ioTest.readFile(filePath);
//        System.out.println(reslut);
    }

    /**
     * <pre>
     * 说    明: 读取指定文件内容
     * 涉及版本: V1.0.0
     * 创 建 者: Holen
     * 日    期: 2019/1/14 9:30
     * 联系方式: 317776764
     * </pre>
     */
    public String readFile(String filePath) {
        FileInputStream fis = null;
        String result = "";
        try {
            //根据path路径实例化一个输入流的对象
            fis = new FileInputStream(filePath);
            //返回这个输入流中可以被读的剩下的bytes字节的估计值；
            int size = fis.available();
            //根据输入流中的字节数创建byte数组；
            byte[] array = new byte[size];
            //把数据读取到数组中；
            fis.read(array);
            //根据获取到的Byte数组新建一个字符串，然后输出；
            result = new String(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * <pre>
     * 说    明: 根据文件路径创建输出流
     * 涉及版本: V1.0.0
     * 创 建 者: Holen
     * 日    期: 2019/1/14 9:38
     * 联系方式: 317776764
     * </pre>
     */
    public void writeFile(String filePath, String content) {
        FileOutputStream fos = null;
        try {
            //根据文件路径创建输出流
            fos = new FileOutputStream(filePath);
            //把string转换为byte数组；
            byte[] array = content.getBytes();
            //把byte数组输出；
            fos.write(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}