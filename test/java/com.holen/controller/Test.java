package com.holen.controller;

import Utils.DesensitizeUtil;
import Utils.WebSocketUtil;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/2/15 09:32
 * 联系方式: 317776764
 * </pre>
 */
public class Test {

    public static void main(String []args) throws IOException {
        System.out.println(System.currentTimeMillis());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(new Date().getTime());
    }

}
