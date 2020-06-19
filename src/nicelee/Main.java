package nicelee;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Method;
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
			// 通过反射调用
			Method method = Bot.class.getDeclaredMethod(gifType, FileOutputStream.class, String[].class);
//			FileOutputStream output = new FileOutputStream("result.gif");
			FileOutputStream output = new FileOutputStream("pics/" + gifType + ".gif");
			method.invoke(null, output, talks.toArray(params));
			reader.close();
		}catch (NoSuchMethodException e) {
			System.err.println("当前gifType类型不支持！");
			System.exit(-1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
