package cc.vince.utils;
/*
 * @describe:反射机制得到类并记录日志
 * 
 */
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GenericsUtils {

	private static final Log log=LogFactory.getLog(GenericsUtils.class);
	
	public static String getGenricName(Class<?> clazz){
		return clazz.getSimpleName();
	}
	   
	public static Class<?> getGenricType(Class<?> clazz){
		return getGenricType(clazz,0);
	}
	
	public static Class<?> getGenricType(Class<?> clazz,int index){
		
		Type genType=clazz.getGenericSuperclass();
		
		if(!(genType instanceof ParameterizedType)){
			log.warn(clazz.getSimpleName()+"'s superclass not ParameterizedType");
			return Object.class;
		}
		
		Type[] params=((ParameterizedType)genType).getActualTypeArguments();
		
		if((index>=params.length) || (index<0)){
			log.warn("Index: "+index+",Size of "+clazz.getSimpleName()+"'s Parameterized Type:"+params.length);
			return Object.class;
		}
		
		if(!(params[index] instanceof Class)){
			log.warn(clazz.getSimpleName()+" not set the actual class on superclass generic parameter");
			return Object.class;
		}
		
		return ((Class<?>) params[index]);
	}
}
