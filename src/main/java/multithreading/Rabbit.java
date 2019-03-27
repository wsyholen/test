package multithreading;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/2/14 10:15
 * 联系方式: 317776764
 * </pre>
 */
public class Rabbit extends Animal {

    public Rabbit() {
        setName("兔子");
    }

    @Override
    public void runing() {
        //兔子速度
        int dis = 5;
        length -= dis;

        System.out.println("兔子跑了" + dis + "米，距离终点还有" + length + "米");
        if (length <= 0) {
            length = 0;
            System.out.println("兔子获得了胜利");
            // 给回调对象赋值，让乌龟不要再跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }

        try {
            // 每20米休息一次,休息时间是1秒
            if ((2000 - length) % 20 == 0) {
                sleep(1000);
            } else {
                //每0.1秒跑5米
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
