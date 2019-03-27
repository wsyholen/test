package Utils;

import com.aliyuncs.utils.StringUtils;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.*;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2018/12/21 09:39
 * 联系方式: 317776764
 * </pre>
 */
public class BarcodeUtil {

    /**
     * <pre>
     * 说    明: 生成文件
     * 涉及版本: V1.0.0
     * 创 建 者: Holen
     * 日    期: 2018/12/21 9:40
     * 联系方式: 317776764
     * </pre>
     */
    public static File generateFile(String msg, String path) {
        File file = new File(path);
        try {
            generate(msg, new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    /**
     * <pre>
     * 说    明: 生成字节
     * 涉及版本: V1.0.0
     * 创 建 者: Holen
     * 日    期: 2018/12/21 9:40
     * 联系方式: 317776764
     * </pre>
     */
    public static byte[] generate(String msg) {
        ByteArrayOutputStream ous = new ByteArrayOutputStream();
        generate(msg, ous);
        return ous.toByteArray();
    }

    /**
     * <pre>
     * 说    明: 生成到流
     * 涉及版本: V1.0.0
     * 创 建 者: Holen
     * 日    期: 2018/12/21 9:41
     * 联系方式: 317776764
     * </pre>
     */
    public static void generate(String msg, OutputStream ous) {
        if (StringUtils.isEmpty(msg) || ous == null) {
            return;
        }

        Code39Bean bean = new Code39Bean();

        // 精细度
        final int dpi = 200;
        // module宽度
        final double moduleWidth = UnitConv.in2mm(1.5f / dpi);

        // 配置对象
        bean.setModuleWidth(moduleWidth);
        bean.setWideFactor(6);
        bean.doQuietZone(false);

        String format = "image/png";
        try {

            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format, dpi,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);

            // 生成条形码
            bean.generateBarcode(canvas, msg);

            // 结束绘制
            canvas.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String msg = "SMYN00002018";
        String path = "D:/barcode.png";
        generateFile(msg, path);
    }

}
