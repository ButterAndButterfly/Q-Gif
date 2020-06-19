package nicelee.bilibili;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import nicelee.bilibili.gif.GifUtil;
import nicelee.bilibili.gif.ImgUtil;
import nicelee.bilibili.gif.bean.TextOption;

public class Bot {

	public static void main(String[] a) throws FileNotFoundException {
		FileOutputStream zhenxiang = new FileOutputStream("pics/真香.gif");
		Bot.真香(zhenxiang, "我就是饿死", "死外边，从这里跳下去", "不会吃你们一点东西", "真香");

//		FileOutputStream shuizancheng = new FileOutputStream("pics/谁赞成谁反对.gif");
//		Bot.shuizancheng(shuizancheng, "我话讲完了", "谁赞成  谁反对", "我反对");
	}

	private static void run(String method, FileOutputStream fout, List<TextOption> options) {
		try {
			File gif = new File("pics/" + method + "/notext.gif");
			int frameRate = GifUtil.getAssumingFrameRate(gif, 1);
			FileInputStream source = new FileInputStream(gif);
			GifUtil.addText(source, fout, options, frameRate);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 给真香.gif 自定义对白
	 * 
	 * @param fout gif文件输出
	 * @param strs 4句对白
	 */
	public static void 真香(FileOutputStream fout, String... strs) {
		if (strs.length < 4)
			return;
		List<TextOption> options = new ArrayList<TextOption>();
		TextOption option1 = new TextOption(0, 8, strs[0], ImgUtil.offsetXCenter(298, strs[0], TextOption.defaultFont),
				165);
		TextOption option2 = new TextOption(12, 23, strs[1],
				ImgUtil.offsetXCenter(298, strs[1], TextOption.defaultFont), 165);
		TextOption option3 = new TextOption(25, 34, strs[2],
				ImgUtil.offsetXCenter(298, strs[2], TextOption.defaultFont), 165);
		TextOption option4 = new TextOption(37, 47, strs[3],
				ImgUtil.offsetXCenter(298, strs[3], TextOption.defaultFont), 165);
		options.add(option1);
		options.add(option2);
		options.add(option3);
		options.add(option4);
		run(Thread.currentThread().getStackTrace()[1].getMethodName(), fout, options);
	}

	/**
	 * 给谁赞成 谁反对.gif 自定义对白
	 * 
	 * @param fout gif文件输出
	 * @param strs 3句对白
	 */
	public static void 谁赞成谁反对(FileOutputStream fout, String... strs) {
		if (strs.length < 3)
			return;
		List<TextOption> options = new ArrayList<TextOption>();
		TextOption option1 = new TextOption(4, 16, strs[0], ImgUtil.offsetXCenter(300, strs[0], TextOption.defaultFont), 150);
		TextOption option2 = new TextOption(18, 35, strs[1], ImgUtil.offsetXCenter(300, strs[1], TextOption.defaultFont), 150);
		TextOption option3 = new TextOption(37, 44, strs[2], ImgUtil.offsetXCenter(300, strs[2], TextOption.defaultFont), 150);
		options.add(option1);
		options.add(option2);
		options.add(option3);
		run(Thread.currentThread().getStackTrace()[1].getMethodName(), fout, options);
	}
}
