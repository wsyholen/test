package multithreading;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/2/14 10:12
 * 联系方式: 317776764
 * </pre>
 */
public class LetOneStop implements Animal.Calltoback {

    /**
     * 动物对象
     */
    Animal an;

    /**
     * 获取动物对象，可以传入兔子或乌龟的实例
     * @param an
     */
    public LetOneStop(Animal an) {
        this.an = an;
    }

    /**
     * 让动物的线程停止
     */
    @Override
    public void win() {
        // 线程停止
        an.stop();
    }
}
