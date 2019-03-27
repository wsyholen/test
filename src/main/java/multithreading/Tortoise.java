package multithreading;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/2/14 10:16
 * 联系方式: 317776764
 * </pre>
 */
public class Tortoise extends Animal {

    public Tortoise() {
        // Thread的方法，给线程赋值名字
        setName("乌龟");
        int a = 1;
        int b = 2;
        a = -b;
    }

    /**
     * 重写running方法，编写乌龟的奔跑操作
     */
    @Override
    public void runing() {
        // 乌龟速度
        int dis = 2;
        length -= dis;
        System.out.println("乌龟跑了" + dis + "米，距离终点还有" + length + "米");
        if (length <= 0) {
            length = 0;
            System.out.println("乌龟获得了胜利");
            // 让兔子不要在跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }
        try {
            //每0.1秒跑2米
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
