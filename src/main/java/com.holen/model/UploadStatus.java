package com.holen.model;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/1/24 14:34
 * 联系方式: 317776764
 * </pre>
 */
public class UploadStatus {

    /**
     * 已读数据
     */
    private long bytesRead;

    /**
     * 文件总数据
     */
    private long contentLength;

    /**
     * 第几个文件
     */
    private long items;

    /**
     * 开始时间
     */
    private long startTime = System.currentTimeMillis();

    /**
     * 已用时间
     */
    private long useTime = System.currentTimeMillis();

    /**
     * 完成百分比
     */
    private int percent = 10;

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public long getItems() {
        return items;
    }

    public void setItems(long items) {
        this.items = items;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getUseTime() {
        return useTime;
    }

    public void setUseTime(long useTime) {
        this.useTime = useTime;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "UploadStatus [percent=" + percent + ", items=" + items + "]";
    }

}
