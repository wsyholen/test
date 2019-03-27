package Utils.MQTT;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/2/26 13:16
 * 联系方式: 317776764
 * </pre>
 */
public class ServerMQTT {
    /**
     * Created by StoneGeek on 2018/6/5.
     * 博客地址：http://www.cnblogs.com/sxkgeek
     * 服务器向多个客户端推送主题，即不同客户端可向服务端订阅相同的主题
     */

    //tcp://MQTT安装的服务器地址:MQTT定义的端口号
    public static final String HOST = mqttEnum.HOST.getValue();
    //定义一个主题
    public static final String TOPIC = mqttEnum.TOPIC.getValue();
    //定义MQTT的ID，可以在MQTT服务配置中指定
    private static final String CLIENTID = mqttEnum.CLIENTID.getValue();

    private MqttClient client;
    private MqttTopic topic11;
    private String userName = mqttEnum.USERNAME.getValue();
    private String passWord = mqttEnum.PASSWORD.getValue();

    private MqttMessage message;

    /**
     * 构造函数
     *
     * @throws MqttException
     */
    public ServerMQTT() throws MqttException {
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        client = new MqttClient(HOST, CLIENTID, new MemoryPersistence());
        connect();
    }

    /**
     * 用来连接服务器
     */
    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            client.setCallback(new PushCallback());
            client.connect(options);

            topic11 = client.getTopic(TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param topic
     * @param message
     * @throws MqttPersistenceException
     * @throws MqttException
     */
    public void publish(MqttTopic topic, MqttMessage message) throws MqttPersistenceException,
            MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! "
                + token.isComplete());
    }

    /**
     * 启动入口
     *
     * @param args
     * @throws MqttException
     */
    public static void main(String[] args) throws MqttException {
        ServerMQTT server = new ServerMQTT();

        server.message = new MqttMessage();
        server.message.setQos(1);
        server.message.setRetained(true);
        server.message.setPayload("hello,topic22".getBytes());
        server.publish(server.topic11, server.message);
        System.out.println(server.message.isRetained() + "------ratained状态");
    }
}

