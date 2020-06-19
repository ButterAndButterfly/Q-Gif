package nicelee.bilibili.gif.bean;

import java.awt.Color;
import java.awt.Font;

/**
 * 从第begin - end帧，添加文字content
 */
public class TextOption {

	public static Font defaultFont;
	public static Color defaultColor;
	public static Font[] fonts;
	public static Color[] colors;
	
	static {
		fonts = new Font[2];
		fonts[0] = new Font("", Font.BOLD, 12);
		fonts[1] = new Font("黑体", Font.BOLD, 24);
		colors = new Color[1];
		colors[0] = Color.white;
		defaultFont = fonts[0];
		defaultColor = colors[0];
		//TextOption.setDefault(defaultFont, defaultColor);
	}
	
	public static void setDefault(Font defaultFont, Color defaultColor) {
		TextOption.defaultFont = defaultFont;
		TextOption.defaultColor = defaultColor;
	}

	int begin;
	int end;
	String content;
	int offsetX;
	int offsetY;
	Font font;
	Color color;
	
	
	public TextOption(int begin, int end, String content, int offsetX, int offsetY) {
		this(begin, end, content, offsetX, offsetY, defaultFont, defaultColor);
	}
	
	public TextOption(int begin, int end, String content, int offsetX, int offsetY, Font font, Color color) {
		this.begin = begin;
		this.end = end;
		this.content = content;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.font = font;
		this.color = color;
	}
	
	public TextOption clone() {
		TextOption option = new TextOption(begin, end, content, offsetX, offsetY, defaultFont, color);
		return option;
	}
	
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getOffsetX() {
		return offsetX;
	}
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}
	public int getOffsetY() {
		return offsetY;
	}
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
