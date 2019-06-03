package com.lakeslove.blog.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.ui.Model;

public class StringEscapeUtils {

	/**
	 * 转换一个字符串里的特殊字符
	 * 这个方法有待改善
	 * @param string
	 * @return
	 */
	public static String escapeHtml(String string) {
		//TODO 此方法待改进
		if (string != null) {
			string = string.replaceAll("&", "&amp;");
			string = string.replaceAll(" ", "&nbsp;");
			string = string.replaceAll("<", "&lt;");
			string = string.replaceAll(">", "&gt;");
			string = string.replaceAll("\"", "&quot;");
			string = string.replaceAll("\\\\", "&#92;");
			string = string.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		}
		return string;
	}
}
