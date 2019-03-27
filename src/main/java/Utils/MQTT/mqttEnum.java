package Utils.MQTT;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/2/26 13:49
 * 联系方式: 317776764
 * </pre>
 */
public enum mqttEnum {

    HOST("HOST", "tcp://118.178.255.64:1883"),

    TOPIC("TOPIC", "mtopic"),

    CLIENTID("CLIENTID","client11"),

    USERNAME("USERNAME","smartshoes"),

    PASSWORD("PASSWORD","shoes123456");

    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private mqttEnum(String key,String value) {
        this.key = key;
        this.value = value;

    }
}
