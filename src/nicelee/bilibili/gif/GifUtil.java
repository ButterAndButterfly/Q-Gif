package nicelee.bilibili.gif;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import nicelee.bilibili.gif.bean.TextOption;
import nicelee.bilibili.gif.encoder.GIFEncoder;

public class GifUtil {

	/**
	 * 按帧提取将gif所有图片，并保存到dstfolder文件夹
	 * 
	 * @param gif       gif文件
	 * @param dstfolder 目标文件夹
	 * @return 裁剪后的图片
	 */
	public static boolean split(File gif, File dstfolder) {
		if (!dstfolder.exists())
			dstfolder.mkdirs();
		try {
			ImageReader reader = (ImageReader) ImageIO.getImageReadersByFormatName("gif").next();
			ImageInputStream ciis = ImageIO.createImageInputStream(new FileInputStream(gif));
			reader.setInput(ciis, true);
			try {
				for (int i = 0;; i++) {
					BufferedImage image = reader.read(i);
					ImageIO.write(image, "jpg", new File(dstfolder, String.format("%03d.jpg", i)));
				}
			} catch (IndexOutOfBoundsException e) {
			}
			ciis.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 将静态图片列表以恒定帧率的方式合成gif
	 * 
	 * @param imgs      图片列表
	 * @param gif       gif保存路径
	 * @param frameRate 帧率
	 */
	public static void merge(List<BufferedImage> imgs, String gif, int frameRate) {
		GIFEncoder encoder = new GIFEncoder();
		encoder.init(imgs.get(0));
		encoder.setFrameRate(frameRate);
		encoder.start(gif);
		for (int i = 1; i < imgs.size(); i++) {
			encoder.addFrame(imgs.get(i));
		}
		encoder.finish();
	}

	/**
	 * 给gif添加文字
	 * 
	 * @param source
	 * @param dest
	 * @param options
	 */
	public static void addText(InputStream source, File dest, List<TextOption> options, int frameRate) {
		try {
			ImageReader reader = (ImageReader) ImageIO.getImageReadersByFormatName("gif").next();
			ImageInputStream ciis = ImageIO.createImageInputStream(source);
			reader.setInput(ciis, true);
			GIFEncoder encoder = new GIFEncoder();
			String gifDst = dest.getAbsolutePath();
			try {
				for (int i = 0;; i++) {
					BufferedImage image = reader.read(i);
					for (TextOption option : options) {
						if (i >= option.getBegin() && i <= option.getEnd()) {
							image = ImgUtil.addText(image, option.getContent(), option.getOffsetX(),
									option.getOffsetY(), option.getFont(), option.getColor());
						}
					}
					if (i == 0) {
						encoder.init(image);
						encoder.setFrameRate(frameRate);
						encoder.start(gifDst);
					} else {
						encoder.addFrame(image);
					}
				}
			} catch (IndexOutOfBoundsException e) {
			}
			ciis.close();
			encoder.finish();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
