package multithreading;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/2/14 10:10
 * 联系方式: 317776764
 * </pre>
 */
public abstract class Animal extends Thread {

    // 比赛长度
    public int length = 100;

    public abstract void runing();

    @Override
    public void run() {
        super.run();
        while (length > 0) {
            runing();
        }
    }

    /**
     * 在需要回调数据的地方（两个子类需要），声明一个接口
     */
    public static interface Calltoback {
        public void win();
    }

    /**
     * 创建接口对象
     */
    public Calltoback calltoback;
}
