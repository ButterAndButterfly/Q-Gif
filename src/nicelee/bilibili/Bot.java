package nicelee.bilibili;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import nicelee.bilibili.gif.GifUtil;
import nicelee.bilibili.gif.ImgUtil;
import nicelee.bilibili.gif.bean.TextOption;

public class Bot {

	public static void main(String[] a) {
		Bot.zhenxiang("我就是饿死", "死外边，从这里跳下去", "不会吃你们一点东西", "真香");
		Bot.shuizancheng("我话讲完了", "谁赞成  谁反对", "我反对");
	}
	
	/**
	 * 给真香.gif 自定义对白
	 * 
	 * @param strs 4句对白
	 */
	public static void zhenxiang(String... strs) {
		if(strs.length < 4)
			return;
		Font font = new Font("", Font.BOLD, 12);
		Color color = Color.white;
		TextOption.setDefault(font, color);
		
		try {
			FileInputStream source = new FileInputStream("pics/真香/notext.gif");
			File dest = new File("pics/真香.gif");
			List<TextOption> options = new ArrayList<TextOption>();
			TextOption option1 = new TextOption(0, 8, strs[0], ImgUtil.offsetXCenter(298, strs[0], font), 165);
			TextOption option2 = new TextOption(12, 23, strs[1], ImgUtil.offsetXCenter(298, strs[1], font), 165);
			TextOption option3 = new TextOption(25, 34, strs[2], ImgUtil.offsetXCenter(298, strs[2], font), 165);
			TextOption option4 = new TextOption(37, 47, strs[3], ImgUtil.offsetXCenter(298, strs[3], font), 165);
			options.add(option1);
			options.add(option2);
			options.add(option3);
			options.add(option4);
			GifUtil.addText(source, dest, options, 10);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 给谁赞成 谁反对.gif 自定义对白
	 * 
	 * @param strs 3句对白
	 */
	public static void shuizancheng(String... strs) {
		if(strs.length < 3)
			return;
		Font font = new Font("", Font.BOLD, 12);
		Color color = Color.white;
		TextOption.setDefault(font, color);
		
		try {
			FileInputStream source = new FileInputStream("pics/谁赞成谁反对/notext.gif");
			File dest = new File("pics/谁赞成谁反对.gif");
			List<TextOption> options = new ArrayList<TextOption>();
			TextOption option1 = new TextOption(4, 16, strs[0], ImgUtil.offsetXCenter(300, strs[0], font), 150);
			TextOption option2 = new TextOption(18, 35, strs[1], ImgUtil.offsetXCenter(300, strs[1], font), 150);
			TextOption option3 = new TextOption(37, 44, strs[2], ImgUtil.offsetXCenter(300, strs[2], font), 150);
			options.add(option1);
			options.add(option2);
			options.add(option3);
			GifUtil.addText(source, dest, options, 10);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
