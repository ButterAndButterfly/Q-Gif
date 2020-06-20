package nicelee.bilibili;

import java.awt.Color;
import java.awt.Font;
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
		// { {台词数量, 文本加词位置Y坐标}, { gif宽度, gif高度}, {字体类型, 字体颜色类型}, { 台词1起始帧, 台词1结束帧 }, ...
		// }
		// gifConfigs.put("谁赞成谁反对", new int[][] { { num, y }, {0, 0}, { width, height },
		// });
		gifConfigs.put("真香",
				new int[][] { { 4, 165 }, { 298, 184 }, { 0, 0 }, { 0, 8 }, { 12, 23 }, { 25, 34 }, { 37, 47 } });
		gifConfigs.put("谁赞成谁反对", new int[][] { { 3, 150 }, { 300, 168 }, { 0, 0 }, { 4, 16 }, { 18, 35 }, { 37, 44 } });
		gifConfigs.put("元首骂人", new int[][] { { 3, 110 }, { 200, 114 }, { 0, 0 }, { 0, 31 }, { 43, 67 }, { 68, 96 } });
		gifConfigs.put("我卢本伟没有开挂",
				new int[][] { { 3, 210 }, { 300, 225 }, { 1, 0 }, { 0, 12 }, { 14, 20 }, { 21, 33 } });
		gifConfigs.put("充钱就能解决", new int[][] { { 2, 180 }, { 397, 196 }, { 1, 0 }, { 1, 12 }, { 16, 35 } });
		gifConfigs.put("张学友万恶之源", new int[][] { { 1, 200 }, { 335, 218 }, { 1, 0 }, { 0, 20 } });
		gifConfigs.put("金馆长斗图",
				new int[][] { { 3, 160 }, { 300, 170 }, { 2, 0 }, { 1, 61 }, { 85, 107 }, { 137, 175 } });
		gifConfigs.put("你那是馋她身子",
				new int[][] { { 3, 169 }, { 280, 179 }, { 2, 0 }, { 2, 10 }, { 18, 30 }, { 31, 44 } });
	}

	public static void main(String[] a) throws FileNotFoundException {
		String gifType = "你那是馋她身子";
		FileOutputStream output = new FileOutputStream(gifType + ".gif");
		Bot.gen(gifType, output, "你那叫喜欢吗", "你那是馋她的身子", "你下贱");
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
		Font font = TextOption.fonts[gifConfig[2][0]];
		Color color = TextOption.colors[gifConfig[2][1]];
		List<TextOption> options = new ArrayList<TextOption>();
		for (int i = 0; i < gifConfig.length - 3; i++) {
			TextOption option = new TextOption(gifConfig[i + 3][0], gifConfig[i + 3][1], strs[i],
					ImgUtil.offsetXCenter(width, strs[i], font), offsetY, font, color);
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
