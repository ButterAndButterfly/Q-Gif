package nicelee.bilibili;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nicelee.bilibili.gif.GifUtil;
import nicelee.bilibili.gif.ImgUtil;
import nicelee.bilibili.gif.bean.TextOption;

public class Bot {

	private static HashMap<String, int[][]> gifConfigs;
	static {
		gifConfigs = new HashMap<>(20, 0.9f);
		// { {台词数量, 文本加词位置Y坐标}, { gif宽度, gif高度}, { 台词1起始帧, 台词1结束帧 }, ... }
		gifConfigs.put("真香", new int[][] { { 4, 165 }, { 298, 184 }, { 0, 8 }, { 12, 23 }, { 25, 34 }, { 37, 47 } });
		gifConfigs.put("谁赞成谁反对", new int[][] { { 3, 150 }, { 300, 168 }, { 4, 16 }, { 18, 35 }, { 37, 44 } });
	}

	public static void main(String[] a) throws FileNotFoundException {
		FileOutputStream zhenxiang = new FileOutputStream("pics/真香.gif");
		Bot.gen("真香", zhenxiang, "我就是饿死", "死外边，从这里跳下去", "不会吃你们一点东西", "真香");
	}

	/**
	 * 给Gif添加台词
	 * 
	 * @param gifType
	 * @param fout    gif输出流
	 * @param strs    台词
	 */
	public static void gen(String gifType, OutputStream fout, String... strs) {
		int[][] gifConfig = gifConfigs.get(gifType);
		if (gifConfig == null) {
			System.err.println("不存在当前gifType：" + gifType);
			return;
		}
		gen(gifType, gifConfig, fout, strs);
	}

	/**
	 * 给Gif添加台词
	 * 
	 * @param gifType
	 * @param gifConfig 可以调用getGifConfig获得
	 * @param fout      gif输出流
	 * @param strs      台词
	 */
	public static void gen(String gifType, int[][] gifConfig, OutputStream fout, String... strs) {
		int num = gifConfig[0][0];
		if (strs.length < num) {
			System.err.println("台词数量不够");
			return;
		}
		int offsetY = gifConfig[0][1];
		int width = gifConfig[1][0];
		List<TextOption> options = new ArrayList<TextOption>();
		for (int i = 0; i < gifConfig.length - 2; i++) {
			TextOption option = new TextOption(gifConfig[i + 2][0], gifConfig[i + 2][1], strs[i],
					ImgUtil.offsetXCenter(width, strs[i], TextOption.defaultFont), offsetY);
			options.add(option);
		}
		run(gifType, fout, options);
	}

	private static void run(String gifType, OutputStream fout, List<TextOption> options) {
		try {
			File gif = new File("pics/" + gifType + "/notext.gif");
			int frameRate = GifUtil.getAssumingFrameRate(gif, 1);
			FileInputStream source = new FileInputStream(gif);
			GifUtil.addText(source, fout, options, frameRate);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int[][] getGifConfig(String gifType) {
		return gifConfigs.get(gifType);
	}
}
