package com.holen.controller;

import Utils.Station;
import multithreading.LetOneStop;
import multithreading.Rabbit;
import multithreading.Tortoise;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/2/14 09:34
 * 联系方式: 317776764
 * </pre>
 */
public class MultithreadingTest {

    /**
     * java多线程同步锁的使用
     * 示例：三个售票窗口同时出售10张票
     */
    public void ticket() {
        //实例化站台对象，并为每一个站台取名字
        Station station1 = new Station("窗口1");
        Station station2 = new Station("窗口2");
        Station station3 = new Station("窗口3");
        // 让每一个站台对象各自开始工作
        station1.start();
        station2.start();
        station3.start();
    }

    public static void main(String[] args) {
        // 实例化乌龟和兔子
        Tortoise tortoise = new Tortoise();
        Rabbit rabbit = new Rabbit();
        // 回调方法的使用，谁先调用calltoback方法，另一个就不跑了
        LetOneStop letOneStop1 = new LetOneStop(tortoise);
        // 让兔子的回调方法里面存在乌龟对象的值，可以把乌龟stop
        rabbit.calltoback = letOneStop1;
        LetOneStop letOneStop2 = new LetOneStop(rabbit);
        // 让乌龟的回调方法里面存在兔子对象的值，可以把兔子stop
        tortoise.calltoback = letOneStop2;
        // 开始跑
        tortoise.start();
        rabbit.start();
    }

}
