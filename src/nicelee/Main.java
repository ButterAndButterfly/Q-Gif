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

			if (gif.contains("真香")) {
				FileOutputStream zhenxiang = new FileOutputStream("result.gif");
				Bot.zhenxiang(zhenxiang, talks.toArray(params));
			} else if (gif.contains("谁赞成谁反对")) {
				FileOutputStream shuizancheng = new FileOutputStream("result.gif");
				Bot.shuizancheng(shuizancheng, talks.toArray(params));
			} else {
				reader.close();
				throw new Exception("没有找到类型: " + gif);
			}
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
