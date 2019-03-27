package Utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/3/6 17:10
 * 联系方式: 317776764
 * </pre>
 */

public class FlightTrainTask {

    WebSocketUtil webSocketUtil = new WebSocketUtil();

//    @Scheduled(cron = "0/5 * * * * ? ") // 间隔5秒执行
//    public void taskCycle() {
//       // webSocketUtil.onMessage("使用SpringMVC框架配置定时任务");
//        System.out.println("使用SpringMVC框架配置定时任务");
//    }

}
