package utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils2 {

	public WebUtils2() {
		// TODO Auto-generated constructor stub
	}
	public static <T> T copyToBean(HttpServletRequest request, Class<T> clazz) {
		try {
			// 创建对象
						T t = clazz.newInstance();
						
						// 获取所有的表单元素的名称
						Enumeration<String> enums = request.getParameterNames();
						// 遍历
						while (enums.hasMoreElements()) {
							String name = enums.nextElement();  // pwd
							String value = request.getParameter(name);
							BeanUtils.copyProperty(t, name, value);
					
						}
						
						return t;
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
}
