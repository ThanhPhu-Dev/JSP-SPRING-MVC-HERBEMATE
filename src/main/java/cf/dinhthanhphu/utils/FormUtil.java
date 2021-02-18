package cf.dinhthanhphu.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;



public class FormUtil {


		//dùng beanutil để để mapping các thuộc tính trong form- parameter sang object
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static <T> T toModel(Class<T> tClass, HttpServletRequest req) {
		T ob= null;
		try {
			ob = tClass.newInstance();
			BeanUtils.populate(ob, req.getParameterMap());
		} catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
			System.out.println(e.getMessage());
		} 
		return ob;
	}
}
