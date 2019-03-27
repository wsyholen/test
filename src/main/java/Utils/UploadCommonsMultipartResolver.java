package Utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2019/1/24 15:04
 * 联系方式: 317776764
 * </pre>
 */
public class UploadCommonsMultipartResolver extends CommonsMultipartResolver {

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request)
            throws MultipartException {
        HttpSession session = request.getSession();
        String encoding = "utf-8";
        FileUpload fileUpload = prepareFileUpload(encoding);
        UploadListener uploadListener = new UploadListener(session);
        fileUpload.setProgressListener(uploadListener);

        try {
            List<FileItem> fileItem = ((ServletFileUpload)fileUpload).parseRequest(request);
            return parseFileItems(fileItem, encoding);
        } catch (FileUploadBase.SizeLimitExceededException ex) {
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);
        }catch (FileUploadException ex) {
            throw new MultipartException("Could not parse multipart servlet request",ex);
        }
    }

}
