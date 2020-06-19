package nicelee.bilibili;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import nicelee.bilibili.gif.GifUtil;
import nicelee.bilibili.gif.ImgUtil;
import nicelee.bilibili.gif.bean.TextOption;

public class Train {

	public static void main(String[] a) {
		{
			// 获取素材
			File source = new File("pics/我卢本伟没有开挂/text.gif");
			File dstFolder = new File("pics/我卢本伟没有开挂/text");
			GifUtil.split(source, dstFolder);
		}

//		{
//			// 获取素材
//			File source = new File("pics/真香/notext.gif");
//			File dstFolder = new File("pics/真香/notext");
//			GifUtil.split(source, dstFolder);
//		}

		// 调试 "我就是饿死" 等（需要调试多次，对比图片看效果）
		// TextOption需要设置的地方：	
		//			文字的offsetY坐标
		// 		 	图片宽度
		// 			文字从第几张图片出现，直到第几张图片
		// TextOption option1 = new TextOption(0, 8, text, ImgUtil.offsetXCenter(298, text, font), 165);
//		try {
//			BufferedImage img = (BufferedImage) ImageIO.read(new File("pics/真香/notext/000.jpg"));
//			Font font = new Font("", Font.BOLD, 12);
//			Color color = Color.white;
//			img = ImgUtil.addText(img, "我就是饿死", 90, 165, font, color);
//			ImageIO.write(img, "jpg", new File("我就是饿死.jpg"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		// 设置默认属性
//		Font font = new Font("", Font.BOLD, 12);
//		Color color = Color.white;
//		TextOption.setDefault(font, color);
//
//		try {
//			FileInputStream source = new FileInputStream("pics/真香/notext.gif");
//			File dest = new File("text.gif");
//			List<TextOption> options = new ArrayList<TextOption>();
//			String text = "我就是饿死";
//			TextOption option1 = new TextOption(0, 8, text, ImgUtil.offsetXCenter(298, text, font), 165);
//			text = "死外边，从这里跳下去";
//			TextOption option2 = new TextOption(12, 23, text, ImgUtil.offsetXCenter(298, text, font), 165);
//			text = "不会吃你们一点东西";
//			TextOption option3 = new TextOption(25, 34, text, ImgUtil.offsetXCenter(298, text, font), 165);
//			text = "真香";
//			TextOption option4 = new TextOption(37, 47, text, ImgUtil.offsetXCenter(298, text, font), 165);
//			options.add(option1);
//			options.add(option2);
//			options.add(option3);
//			options.add(option4);
//			GifUtil.addText(source, dest, options, 10);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		

	}
}
