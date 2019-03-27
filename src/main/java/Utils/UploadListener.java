package Utils;

import com.holen.model.UploadStatus;
import org.apache.commons.fileupload.ProgressListener;

import javax.servlet.http.HttpSession;

/**
 * <pre>
 * 说    明: 监听上传信息的监听器
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/1/24 14:38
 * 联系方式: 317776764
 * </pre>
 */
public class UploadListener implements ProgressListener {

    private HttpSession session;

    public UploadListener(HttpSession session){
        super();
        this.session = session;
        UploadStatus uploadStatus = new UploadStatus();
        session.setAttribute("upload_status", uploadStatus);
    }

    @Override
    public void update(long bytesRead, long contentLength, int items) {
        UploadStatus uploadStatus = (UploadStatus) session.getAttribute("upload_status");
        uploadStatus.setBytesRead(bytesRead);
        uploadStatus.setContentLength(contentLength);
        uploadStatus.setItems(items);
        uploadStatus.setUseTime(System.currentTimeMillis()-uploadStatus.getStartTime());
        uploadStatus.setPercent((int)(100*bytesRead/contentLength));
        session.setAttribute("upload_status", uploadStatus);
    }
}
