package nicelee;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import nicelee.bilibili.Bot;

public class Main {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("config.txt"));
			String gif = reader.readLine().trim();
			System.out.printf("|%s|\n", gif);

			List<String> talks = new ArrayList<>();
			String talk = reader.readLine();
			while (talk != null) {
				System.out.println(talk);
				talks.add(talk);
				talk = reader.readLine();
			}
			String[] params = new String[talks.size()];
			String gifType = gif.replace("Gif-", "").replaceAll("[^ 0-9a-zA-Z\\-\\u4e00-\\u9fbb]+", "").trim();
			System.out.printf("gifType: %s\n", gifType);
			
			int[][] gifConfig = Bot.getGifConfig(gifType);
			if (gifConfig == null) {
				System.err.println("当前gifType类型不支持！");
				System.exit(-1);
			}
			FileOutputStream output = new FileOutputStream("result.gif");
//			FileOutputStream output = new FileOutputStream(gifType + ".gif");
			Bot.gen(gifType, gifConfig, output, talks.toArray(params));
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
