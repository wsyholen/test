package Utils;

import java.io.IOException;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/3/7 15:17
 * 联系方式: 317776764
 * </pre>
 */
public class Test implements Runnable {

    @Override
    public void run() {
        WebSocketUtil webSocketUtil = new WebSocketUtil();
        Thread.currentThread().setName("Runable 实现");
        Boolean b = true;
        int i = 0;
        while (b){
            try {
                webSocketUtil.sendMessage(Thread.currentThread().getName() + "-->" + i++);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
            try {
                Thread.sleep(2000);; //暂停，每一秒输出一次
            }catch (InterruptedException e) {
                return;
            }
        }
    }
}
