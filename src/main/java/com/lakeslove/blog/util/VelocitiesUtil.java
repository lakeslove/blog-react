package com.lakeslove.blog.util;

import java.util.Map;
import org.apache.velocity.app.VelocityEngine;

public class VelocitiesUtil {
	private static VelocityEngine velocityEngine = SpringBeanUtil.getBean(VelocityEngine.class, "velocityEngine");

	/**
	 * 获取Velocity模板转换成的字符串
	 * @param templateLocation
	 * @param velocityContext
	 * @return
	 */
	public static String getVelocityText(String templateLocation, Map<String, Object> velocityContext) {
//		String velocityText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateLocation, "utf-8",
//				velocityContext);
//		return velocityText;
		return "邮件内容：" + velocityContext.values();
	}
}
